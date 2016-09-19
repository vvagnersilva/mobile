package prof.milene.edu.br.mapas;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import prof.milene.edu.br.R;
import prof.milene.edu.br.fragment.DialogErrorFragment;

public class LocalizacaoActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        GoogleMap.OnMapLongClickListener {

    private static final int REQUEST_ERRO_PLAY_SERVICES = 1;
    private static final int REQUEST_CHECAR_GPS = 2;
    private static final int REQUEST_PERMISSIONS = 3;

    private static final String EXTRA_DIALOG = "dialog";
    private static final String EXTRA_ROTA = "rota";
    private static final String EXTRA_ORIG = "orig";
    private static final String EXTRA_DEST = "dest";
    private static final String TAG = "map";

    GoogleApiClient mGoogleApiClient;
    GoogleMap mGoogleMap;
    LatLng mOrigem;

    Handler mHandler;
    boolean mDeveExibirDialog;
    int mTentativas;

    DialogFragment mDialogEnderecos;
    TextView mTxtProgresso;
    LinearLayout mLayoutProgresso;
    LoaderManager mLoaderManager;
    LatLng mDestino;

    ArrayList<LatLng> mRota;
    Marker mMarkerLocalAtual;
    private int codigoDoErro;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NGVL", "onCreate::BEGIN");
        setContentView(R.layout.activity_gps);

        mLoaderManager = getSupportLoaderManager();
        mDeveExibirDialog = savedInstanceState == null;
        mHandler = new Handler();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.opcao_mapa);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        verificarStatusGPS();

        Log.d("NGVL", "onCreate::END");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("NGVL", "onResume::BEGIN");
        if (permissoesHabilitadas()) {
            init();
        }
        Log.d("NGVL", "onResume::END");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("NGVL", "onPause::BEGIN");
        if (mDialogEnderecos != null) {
            mDialogEnderecos.dismiss();
        }
        Log.d("NGVL", "onPause::END");
    }

    @Override
    protected void onStop() {
        Log.d("NGVL", "onStop::BEGIN");
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
        mHandler.removeCallbacksAndMessages(null);
        Log.d("NGVL", "onStop::END");
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("NGVL", "onActivityResult::BEGIN");
        if (requestCode == REQUEST_ERRO_PLAY_SERVICES
                && resultCode == RESULT_OK) {
            mGoogleApiClient.connect();
        } else if (requestCode == REQUEST_CHECAR_GPS) {
            if (resultCode == RESULT_OK) {
                mTentativas = 0;
                mHandler.removeCallbacksAndMessages(null);
                obterUltimaLocalizacao();
            } else {
                Toast.makeText(this, R.string.erro_gps, Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        Log.d("NGVL", "onActivityResult::END");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("NGVL", "onSaveInstanceState");
        outState.putBoolean(EXTRA_DIALOG, mDeveExibirDialog);
        outState.putParcelable(EXTRA_ORIG, mOrigem);
        outState.putParcelable(EXTRA_DEST, mDestino);
        outState.putParcelableArrayList(EXTRA_ROTA, mRota);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("NGVL", "onRestoreInstanceState");
        mDeveExibirDialog = savedInstanceState.getBoolean(EXTRA_DIALOG, true);
        mOrigem = savedInstanceState.getParcelable(EXTRA_ORIG);
        mDestino = savedInstanceState.getParcelable(EXTRA_DEST);
        mRota = savedInstanceState.getParcelableArrayList(EXTRA_ROTA);
    }

    @Override
    public void onConnected(Bundle dataBundle) {
        Log.d("NGVL", "onConnected::BEGIN");
        verificarStatusGPS();

        Log.d("NGVL", "onConnected::END");
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d("NGVL", "onConnectionFailed");
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(this, REQUEST_ERRO_PLAY_SERVICES);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        } else {
            exibirMensagemDeErro(this, connectionResult.getErrorCode());
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("NGVL", "onLocationChanged::BEGIN");
        if (mOrigem == null) {
            mOrigem = new LatLng(location.getLatitude(), location.getLongitude());
        }
        mMarkerLocalAtual.setPosition(
                new LatLng(location.getLatitude(), location.getLongitude()));
        Log.d("NGVL", "onLocationChanged::END");
    }

    private void obterUltimaLocalizacao() {
        Log.d("NGVL", "obterUltimaLocalizacao::BEGIN");
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (location != null) {
            mTentativas = 0;
            mOrigem = new LatLng(location.getLatitude(), location.getLongitude());
            atualizarMapa();
        } else if (mTentativas < 10) {  // vamos tentar obter a última localização 10 vezes
            mTentativas++;
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    obterUltimaLocalizacao();
                }
            }, 2000); // a cada 2 segundos
        }
        Log.d("NGVL", "obterUltimaLocalizacao::END");
    }

    private void atualizarMapa() {
        Log.d("NGVL", "atualizarMapa::BEGIN");
        if (mGoogleMap == null) {
            SupportMapFragment fragment = (SupportMapFragment)
                    getSupportFragmentManager().findFragmentByTag(TAG);
            mGoogleMap = fragment.getMap();
            mGoogleMap.setOnMapLongClickListener(LocalizacaoActivity.this);
        }

        mGoogleMap.clear();
        if (mOrigem != null) {
            mGoogleMap.addMarker(new MarkerOptions()
                    .position(mOrigem)
                    .title(getString(R.string.origem2)));
        }
        if (mDestino != null) {
            mGoogleMap.addMarker(new MarkerOptions()
                    .position(mDestino)
                    .title(getString(R.string.destino)));
        }
        if (mOrigem != null) {
            if (mDestino != null) {
                LatLngBounds area = new LatLngBounds.Builder()
                        .include(mOrigem)
                        .include(mDestino)
                        .build();
                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(area, 50));
            } else {
                mGoogleMap.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(mOrigem, 17.0f));
            }
        }

        Log.d("NGVL", "atualizarMapa::END");
    }

    private void exibirMensagemDeErro(FragmentActivity activity, final int codigoDoErro) {
        Log.d("NGVL", "exibirMensagemDeErro");

        final String TAG = "DIALOG_ERRO_PLAY_SERVICES";
        this.codigoDoErro = codigoDoErro;
        this.supportFragmentManager = getSupportFragmentManager();

        DialogErrorFragment errorFragment = new DialogErrorFragment();

        errorFragment.setCodigoDoErro(codigoDoErro);
        errorFragment.setErro_play_service(REQUEST_ERRO_PLAY_SERVICES);

        errorFragment.show(activity.getSupportFragmentManager(), TAG);
    }

    private void verificarStatusGPS() {
        Log.d("NGVL", "verificarStatusGPS::BEGIN");
        final LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder locationSettingsRequest =
                new LocationSettingsRequest.Builder();
        locationSettingsRequest.setAlwaysShow(true);
        locationSettingsRequest.addLocationRequest(locationRequest);

        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings(
                        mGoogleApiClient,
                        locationSettingsRequest.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult locationSettingsResult) {
                final Status status = locationSettingsResult.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        obterUltimaLocalizacao();
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        if (mDeveExibirDialog) {
                            try {
                                status.startResolutionForResult(LocalizacaoActivity.this, REQUEST_CHECAR_GPS);
                                mDeveExibirDialog = false;
                            } catch (IntentSender.SendIntentException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        Log.wtf("NGVL", "Isso não deveria acontecer...");
                        break;
                }
            }
        });
        Log.d("NGVL", "verificarStatusGPS::END");
    }

    private boolean permissoesHabilitadas() {
        Log.d("NGVL", "permissoesHabilitadas::BEGIN");
        List<String> permissoes = new ArrayList<String>();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            permissoes.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            permissoes.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (!permissoes.isEmpty() && mDeveExibirDialog) {
            String[] array = new String[permissoes.size()];
            permissoes.toArray(array);
            ActivityCompat.requestPermissions(this, array, REQUEST_PERMISSIONS);
            mDeveExibirDialog = false;
        }
        Log.d("NGVL", "permissoesHabilitadas::END");
        return permissoes.isEmpty();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("NGVL", "onRequestPermissionsResult::BEGIN");
        boolean success = true;
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                success = false;
                break;
            }
        }
        mDeveExibirDialog = true;
        if (!success) {
            Toast.makeText(this, R.string.erro_local, Toast.LENGTH_SHORT).show();
            finish();
        }
        Log.d("NGVL", "onRequestPermissionsResult::END");
    }

    private void init() {
        Log.d("NGVL", "init::BEGIN");
        SupportMapFragment fragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentByTag(TAG);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.map, fragment, TAG)
                    .commit();
        }
        mGoogleApiClient.connect();
        Log.d("NGVL", "init::END");
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
    }
}

