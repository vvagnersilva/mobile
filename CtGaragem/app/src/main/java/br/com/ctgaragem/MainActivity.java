package br.com.ctgaragem;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.ctgaragem.fragment.ContatosFragment;
import br.com.ctgaragem.fragment.DefaultFragment;
import br.com.ctgaragem.fragment.FacebookFragment;
import br.com.ctgaragem.fragment.InstagramFragment;
import br.com.ctgaragem.fragment.ModalidadesFragment;
import br.com.ctgaragem.fragment.PlanosPromocoesFragment;
import br.com.ctgaragem.fragment.SobreFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.titulo_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment;

        if (savedInstanceState == null) {
            // Fragment default.
            fragment = DefaultFragment.novaInstancia("DefaultFragment");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, fragment, "DefaultFragment")
                    .commit();
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;

        if (id == R.id.nav_anaminese) {
            // Handle the camera action
        } else if (id == R.id.nav_clientes) {
        } else if (id == R.id.nav_modalidades) {
            // Fragment default.
            fragment = ModalidadesFragment.novaInstancia("ModalidadesFragment");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, fragment, "ModalidadesFragment")
                    .commit();
        } else if (id == R.id.nav_planos_promocoes) {
            fragment = PlanosPromocoesFragment.novaInstancia("PlanosPromocoesFragment");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, fragment, "PlanosPromocoesFragment")
                    .commit();
        /* else if (id == R.id.nav_localizacao) {
            // Solicita as permissões
            String[] permissoes = new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
            };

            PermissionUtils.validate(this, 0, permissoes);

            Intent it = new Intent(this, LocalizacaoActivity.class);

            // Iniciamos nossa activity
            startActivity(it);*/
        } else if (id == R.id.nav_sobre) {
            fragment = SobreFragment.novaInstancia("SobreFragment");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, fragment, "SobreFragment")
                    .commit();
        } else if (id == R.id.nav_contatos) {
            fragment = ContatosFragment.novaInstancia("ContatosFragment");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, fragment, "ContatosFragment")
                    .commit();
        } else if (id == R.id.nav_facebook) {
            fragment = FacebookFragment.novaInstancia("FacebookFragment");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, fragment, "FacebookFragment")
                    .commit();
        } else if (id == R.id.nav_instagram) {
            fragment = InstagramFragment.novaInstancia("InstagramFragment");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, fragment, "InstagramFragment")
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
