package br.gov.dprf;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import br.gov.dprf.fragment.BatFragment;
import br.gov.dprf.fragment.FaleConoscoFragment;
import br.gov.dprf.fragment.GruFragment;
import br.gov.dprf.fragment.HomeFragment;
import br.gov.dprf.fragment.LocalidadesFragment;
import br.gov.dprf.fragment.MultasFragment;
import br.gov.dprf.fragment.TelefonesEnderecosFragment;
import br.gov.dprf.googleplus.GoogleApiProvider;
import br.gov.dprf.mapas.MapsActivity;
import br.gov.dprf.utils.Connectivity;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiProvider {

    public static final int REQUEST_SIGN_IN = 0;
    private Fragment f = null;
    private GoogleApiClient mGoogleApiClient;
    private boolean mIntentInProgress;
    private boolean mSignInClicked;
    private ConnectionResult mConnectionResult;
    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f = FaleConoscoFragment.novaInstancia("FaleConoscoFragment");

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.conteudo, f, "FaleConoscoFragment")
                        .commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Fragment default.
        f = HomeFragment.novaInstancia("Home");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, f, "Home")
                .commit();

        if (Connectivity.isConnected()) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(Plus.API)
                    .addScope(Plus.SCOPE_PLUS_LOGIN)
                    .addScope(Plus.SCOPE_PLUS_PROFILE)
                    .build();
        }

        //verificaConexaoInternet();
    }

    private void verificaConexaoInternet() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_config) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        String titulo = item.getTitle().toString();

        if (id == R.id.nav_homepage) {
            f = HomeFragment.novaInstancia(titulo);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_multas) {
            f = MultasFragment.novaInstancia(titulo);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_bat) {
            f = BatFragment.novaInstancia(titulo);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_gru) {
            f = GruFragment.novaInstancia(titulo);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_postos_apoio) {

            if (Connectivity.isConnected()) {
                Intent it = new Intent(this, MapsActivity.class);

                // Iniciamos nossa activity
                startActivity(it);
            } else {
                f = LocalidadesFragment.novaInstancia(titulo);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.conteudo, f, titulo)
                        .commit();
            }
        } else if (id == R.id.nav_contatos) {
            f = TelefonesEnderecosFragment.novaInstancia(titulo);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        atualizarMenu();

        return true;
    }


    @Override
    public void onStart() {
        super.onStart();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mGoogleApiClient != null) {
            if (mGoogleApiClient.isConnected()) {
                mGoogleApiClient.disconnect();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);
        if (requestCode == REQUEST_SIGN_IN) {
            if (responseCode != Activity.RESULT_OK) {
                mSignInClicked = false;
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

        // Fragment default.
        f = HomeFragment.novaInstancia("Home");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, f, "Home")
                .commit();

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
            login();
        }
        atualizarMenu();
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

        final ImageView imgFoto = (ImageView) findViewById(R.id.imgFotoPerfil);
        final TextView txtNome = (TextView) findViewById(R.id.txtNome);

        if (Connectivity.isConnected()) {
            if (mGoogleApiClient == null) {
                mGoogleApiClient = new GoogleApiClient.Builder(this)
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .addApi(Plus.API)
                        .addScope(Plus.SCOPE_PLUS_LOGIN)
                        .addScope(Plus.SCOPE_PLUS_PROFILE)
                        .build();
            }

            if (mGoogleApiClient.isConnected()) {

                imgFoto.setVisibility(View.VISIBLE);

                Person person = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);

                if (person != null) {
                    txtNome.setText(person.getDisplayName());
                    txtNome.setVisibility(View.VISIBLE);
                    if (person.hasImage()) {
                        Target target = new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                                RoundedBitmapDrawable fotoRedonda = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                                fotoRedonda.setCornerRadius(Math.max(bitmap.getWidth(), bitmap.getHeight()) / 2.0f);
                                imgFoto.setImageDrawable(fotoRedonda);
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
                }
            }
        } else {
            txtNome.setVisibility(View.INVISIBLE);
            imgFoto.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public GoogleApiClient getGoogleApiClient() {
        return mGoogleApiClient;
    }
}
