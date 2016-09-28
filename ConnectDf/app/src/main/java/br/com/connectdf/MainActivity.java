package br.com.connectdf;

import android.content.Intent;
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

import br.com.connectdf.fragment.AlocacaoFragment;
import br.com.connectdf.fragment.AudiovisualFragment;
import br.com.connectdf.fragment.ClienteFragment;
import br.com.connectdf.fragment.CondominiosFragment;
import br.com.connectdf.fragment.FacebookFragment;
import br.com.connectdf.fragment.HomeFragment;
import br.com.connectdf.fragment.ParceriasFragment;
import br.com.connectdf.fragment.PortifolioFragment;
import br.com.connectdf.fragment.QuemSomosFragment;
import br.com.connectdf.fragment.TecnologiaInformacaoFragment;
import br.com.connectdf.mapas.LocalizacaoActivity;
import br.com.connectdf.utils.Constantes;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
                String subject = Constantes.ABRE_COLCHETES + "Connect" + Constantes.FECHA_COLCHETES + "\t" + "Fale Conosco";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_CC, new String[]{"agnaldo@connectdf.com.br"});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);

                // need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
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
        Fragment f = HomeFragment.novaInstancia("Home");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, f, "Home")
                .commit();
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
/*
        if (id == R.id.action_settings) {
            return true;
        }
*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        String titulo = item.getTitle().toString();
        Fragment f = null;

        if (id == R.id.nav_quem_somos) {
            f = QuemSomosFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_alocacao) {
            f = AlocacaoFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_audiovisual) {
            f = AudiovisualFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_condominios) {
            f = CondominiosFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_tecnologia) {
            f = TecnologiaInformacaoFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_parcerias) {
            f = ParceriasFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_portifolio) {
            f = PortifolioFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_clientes) {
            f = ClienteFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        } else if (id == R.id.nav_localizacao) {
            Intent it = new Intent(this, LocalizacaoActivity.class);

            // Iniciamos nossa activity
            startActivity(it);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Metodo p/ setar o titulo do toolbar.
     *
     * @param actionBarTitle
     */
    public void setActionBarTitle(int actionBarTitle) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(actionBarTitle);
        setSupportActionBar(toolbar);
    }
}
