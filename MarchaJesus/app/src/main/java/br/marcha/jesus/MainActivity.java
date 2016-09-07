package br.marcha.jesus;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalPaymentDetails;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.marcha.jesus.fragment.AgendaFragment;
import br.marcha.jesus.fragment.ListaAmigosFragment;
import br.marcha.jesus.fragment.PaypalFragment;
import br.marcha.jesus.mapas.LocalizacaoActivity;
import br.marcha.jesus.util.Constantes;
import br.marcha.jesus.youtube.VideoEntry;
import br.marcha.jesus.youtube.VideoListActivity;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiProvider {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mOpcaoSelecionada;

    public static final int REQUEST_SIGN_IN = 0;
    private GoogleApiClient mGoogleApiClient;
    private boolean mIntentInProgress;
    private boolean mSignInClicked;
    private ConnectionResult mConnectionResult;

    ArrayList<VideoEntry> VIDEO_LIST;

    PayPalConfiguration payPalConfig = new PayPalConfiguration()
            .environment(Constantes.PAYPAL_ENV)
            .clientId(Constantes.PAYPAL_CLIENT_ID)
            .languageOrLocale("pt_BR");

    static final int COD_PAGTO = 123;

    // Shared Preferences.
    private static final String PREF_NAME = "LoginActivity";

    // Google Maps.
    LatLng mOrigem;
    Handler mHandler;
    int mTentativas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selecionarOpcaoMenu(menuItem);
                        return true;
                    }
                });

        if (savedInstanceState == null) {
            mOpcaoSelecionada = R.id.action_agenda;
        } else {
            mOpcaoSelecionada = savedInstanceState.getInt("menuItem");
        }
        selecionarOpcaoMenu(mNavigationView.getMenu().findItem(mOpcaoSelecionada));

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                .addScope(Plus.SCOPE_PLUS_PROFILE)
                .build();

        // Thread p/ pesquisa dos links no youtube.
        pesquisarLinks();

        //Thread p/ obter a ultima localizacao.
        //obterLocalizacao();
    }

    // Busca os links no YouTube em uma nova thread
    private void pesquisarLinks() {
        // Cria uma AsyncTask
        LinkYoutubeTask task = new LinkYoutubeTask();

        // Executa a task/thread
        task.execute();
    }

    // Busca a localizacao atual do aparelho.
    private void obterLocalizacao() {
        // Cria uma AsyncTask
        LocalizacaoTask task = new LocalizacaoTask();

        // Executa a task/thread
        task.execute();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("menuItem", mOpcaoSelecionada);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);
        if (requestCode == REQUEST_SIGN_IN) {
            if (responseCode != Activity.RESULT_OK) {
                mSignInClicked = false;
            }

            if (requestCode == COD_PAGTO) {
                if (responseCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "Pagamento realizado com sucesso ...", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(this, "Algum problema com o pagamento verificar sua conta no paypal.", Toast.LENGTH_SHORT).show();
            }

            mIntentInProgress = false;
            if (!mGoogleApiClient.isConnecting()) {
                mGoogleApiClient.connect();
            }
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        mSignInClicked = false;
        mIntentInProgress = false;
        atualizarMenu();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (!mIntentInProgress) {
            mConnectionResult = connectionResult;
            if (mSignInClicked) {
                login();
            }
        }
        atualizarMenu();
    }

    private void selecionarOpcaoMenu(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_sair) {
            // Desconectando o servico do google+
            if (mGoogleApiClient.isConnected()) {
                Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                Plus.AccountApi.revokeAccessAndDisconnect(mGoogleApiClient);
                mGoogleApiClient.disconnect();
                mGoogleApiClient.connect();

                SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putBoolean("login", false);
                editor.commit();

                Log.i("MainActivity", "login : " + prefs.getBoolean("login", false));
            }

            // Finalizar a activity atual (MainActivity)
            finish();

            // Saindo da aplicacao
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        mOpcaoSelecionada = menuItem.getItemId();
        menuItem.setChecked(true);
        mDrawerLayout.closeDrawers();

        String titulo = menuItem.getTitle().toString();
        FragmentManager fm = getSupportFragmentManager();

        Fragment f = null;

        if (fm.findFragmentByTag(titulo) == null) {
            if (menuItem.getItemId() == R.id.action_friends) {
                f = new ListaAmigosFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.conteudo, f, titulo)
                        .commit();
            } else {
                if (menuItem.getItemId() == R.id.action_agenda) {
                    f = AgendaFragment.novaInstancia(titulo);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.conteudo, f, titulo)
                            .commit();
                } else if (menuItem.getItemId() == R.id.action_paypal) {
                    f = PaypalFragment.novaInstancia(titulo);

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.conteudo, f, titulo)
                            .commit();
                } else if (menuItem.getItemId() == R.id.action_videos) {
                    Intent it = new Intent(this, VideoListActivity.class);
                    it.putParcelableArrayListExtra("dados", (ArrayList) VIDEO_LIST);
                    // Iniciamos nossa activity
                    startActivity(it);
                } else if (menuItem.getItemId() == R.id.action_mapa) {
                    Intent it = new Intent(this, LocalizacaoActivity.class);

                    // Iniciamos nossa activity
                    startActivity(it);
                }
            }
        }
    }

    private void login() {
        if (mConnectionResult.hasResolution()) {
            try {
                mIntentInProgress = true;
                mConnectionResult.startResolutionForResult(this, REQUEST_SIGN_IN);
            } catch (IntentSender.SendIntentException e) {
                mIntentInProgress = false;
                mGoogleApiClient.connect();
            }
        }
    }

    private void atualizarMenu() {
        final ImageView imgCapa = (ImageView) findViewById(R.id.imgCapa);
        final ImageView imgFoto = (ImageView) findViewById(R.id.imgFotoPerfil);
        final TextView txtNome = (TextView) findViewById(R.id.txtNome);
        if (mGoogleApiClient.isConnected()) {
            Person person = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
            if (person != null) {
                txtNome.setText(person.getDisplayName());
                if (person.hasImage()) {
                    Target target = new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                            RoundedBitmapDrawable fotoRedonda = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                            fotoRedonda.setCornerRadius(Math.max(bitmap.getWidth(), bitmap.getHeight()) / 2.0f);
                            imgFoto.setImageDrawable(fotoRedonda);
                            imgFoto.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onBitmapFailed(Drawable drawable) {
                        }

                        @Override
                        public void onPrepareLoad(Drawable drawable) {
                        }
                    };
                    Picasso.with(MainActivity.this)
                            .load(person.getImage().getUrl())
                            .into(target);
                }
                if (person.hasCover()) {
                    Picasso.with(MainActivity.this)
                            .load(person.getCover().getCoverPhoto().getUrl())
                            .into(imgCapa);
                }
            }
        } else {
            imgCapa.setImageBitmap(null);
            txtNome.setText(R.string.app_name);
            imgFoto.setImageDrawable(null);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void onClickDoar(View view) {
        executarPagtoPayPal();
    }

    private void executarPagtoPayPal() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        if (spinner.getSelectedItem().toString().length() == 0) {
            Toast.makeText(this, "Entre com o valor da doação!", Toast.LENGTH_SHORT).show();
            return;
        }

        double val = Double.parseDouble(spinner.getSelectedItem().toString());

        PayPalPayment pagto = montarPagtoFinal(val);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfig);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, pagto);

        startActivityForResult(intent, COD_PAGTO);
    }

    private PayPalPayment montarPagtoFinal(Double valor) {
        // Valor da doacao.
        BigDecimal valDoacao = new BigDecimal(valor);

        PayPalPayment payPalPayment =
                new PayPalPayment(valDoacao, Constantes.PAYPAL_CURRENCY, "Doação", Constantes.PAYPAL_INTENT);

        PayPalPaymentDetails detalhes = new PayPalPaymentDetails(BigDecimal.ZERO, valDoacao, BigDecimal.ZERO);

        payPalPayment.custom("Doação - Marcha para Jesus");

        return payPalPayment;
    }

    @Override
    public GoogleApiClient getGoogleApiClient() {
        return mGoogleApiClient;
    }

    private class LinkYoutubeTask extends AsyncTask<Void, Void, List<SearchResult>> {

        final String API_KEY = "AIzaSyA8LVmKQhpvKJ_tBG53Bq8JUUenTNb3qAc";

        final String MARCHA_PARA_JESUS = "marcha para jesus";

        /************* BUSCAS NO YOUTUBE *********************/
        /**
         * Global instance of the HTTP transport.
         */
        final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

        /**
         * Global instance of the JSON factory.
         */
        final JsonFactory JSON_FACTORY = new JacksonFactory();

        /**
         * Global instance of the max number of videos we want returned (50 = upper
         * limit per page).
         */
        final long NUMBER_OF_VIDEOS_RETURNED = 25;

        /**
         * Global instance of Youtube object to make all API requests.
         */
        private YouTube youtube;
        private MainActivity context;


        @Override
        protected List<SearchResult> doInBackground(Void... voids) {

            List<SearchResult> searchResultList = null;

            try {
            /*
             * The YouTube object is used to make all API requests. The last
			 * argument is required, but because we don't need anything
			 * initialized when the HttpRequest is initialized, we override the
			 * interface and provide a no-op function.
			 */
                youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                    public void initialize(HttpRequest request) throws IOException {
                    }
                }).setApplicationName("youtube-cmdline-search-sample").build();

                YouTube.Search.List search = youtube.search().list("id,snippet");

			/*
             * It is important to set your developer key from the Google
			 * Developer Console for non-authenticated requests (found under the
			 * API Access tab at this link: code.google.com/apis/). This is good
			 * practice and increased your quota.
			 */
                search.setKey(API_KEY);
                search.setQ(MARCHA_PARA_JESUS);

			/*
             * We are only searching for videos (not playlists or channels). If
			 * we were searching for more, we would add them as a string like
			 * this: "video,playlist,channel".
			 */
                search.setType("video");

			/*
             * This method reduces the info returned to only the fields we need
			 * and makes calls more efficient.
			 */
                search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
                search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
                SearchListResponse searchResponse = search.execute();

                searchResultList = searchResponse.getItems();
            } catch (GoogleJsonResponseException e) {
                System.err.println(
                        "There was a service error: " + e.getDetails().getCode() + " : " + e.getDetails().getMessage());
            } catch (IOException e) {
                System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
            } catch (Throwable t) {
                t.printStackTrace();
            }
            return searchResultList;
        }

        @Override
        protected void onPostExecute(List<SearchResult> searchResults) {
            super.onPostExecute(searchResults);

            if (searchResults != null) {
                List<VideoEntry> list = new ArrayList<VideoEntry>();

                Iterator<SearchResult> iteratorSearchResults = searchResults.iterator();

                while (iteratorSearchResults.hasNext()) {

                    SearchResult singleVideo = iteratorSearchResults.next();
                    ResourceId rId = singleVideo.getId();

                    // Double checks the kind is video.
                    if (rId.getKind().equals("youtube#video")) {
                        list.add(new VideoEntry(singleVideo.getSnippet().getTitle(), rId.getVideoId()));
                    }
                }
                VIDEO_LIST = new ArrayList<VideoEntry>(Collections.unmodifiableList(list));
            }
        }
    }

    private class LocalizacaoTask extends AsyncTask<Void, Void, LatLng> {

        @Override
        protected LatLng doInBackground(Void... voids) {
            verificarStatusGPS();

            return mOrigem;
        }

        public void verificarStatusGPS() {
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
                    final com.google.android.gms.common.api.Status status = locationSettingsResult.getStatus();
                    switch (status.getStatusCode()) {
                        case LocationSettingsStatusCodes.SUCCESS:
                            obterUltimaLocalizacao();
                            break;
                    }
                }
            });
            Log.d("NGVL", "verificarStatusGPS::END");
        }

        private void obterUltimaLocalizacao() {
            Log.d("NGVL", "obterUltimaLocalizacao::BEGIN");
            Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (location != null) {
                mTentativas = 0;
                mOrigem = new LatLng(location.getLatitude(), location.getLongitude());
            } else if (mTentativas < 10) {  // vamos tentar obter a última localização 10 vezes
                mTentativas++;
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        obterUltimaLocalizacao();
                    }
                }, 1000); // a cada 1 segundos
            }
            Log.d("NGVL", "obterUltimaLocalizacao::END");
        }

        @Override
        protected void onPostExecute(LatLng latLng) {
            super.onPostExecute(latLng);

            if (latLng != null) {
                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                //TextView txtLatitude = (TextView) findViewById(R.id.txtLatitude);

                //txtLatitude.setText(latitude.toString());

                //TextView txtLongitude = (TextView) findViewById(R.id.txtLongitude);

                //txtLongitude.setText(longitude.toString());
            }
        }
    }
}

