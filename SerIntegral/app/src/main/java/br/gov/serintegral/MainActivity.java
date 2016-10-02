package br.gov.serintegral;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.gov.serintegral.fragment.FacebookFragment;
import br.gov.serintegral.fragment.PaypalFragment;
import br.gov.serintegral.fragment.SobreFragment;
import br.gov.serintegral.mapas.LocalizacaoActivity;


public class MainActivity extends AppCompatActivity {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mOpcaoSelecionada;

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

        selecionarOpcaoMenu(mNavigationView.getMenu().findItem(R.id.action_facebook));
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

    private void selecionarOpcaoMenu(MenuItem menuItem) {

        mOpcaoSelecionada = menuItem.getItemId();
        menuItem.setChecked(true);
        mDrawerLayout.closeDrawers();

        String titulo = menuItem.getTitle().toString();

        Fragment f = null;

        switch (mOpcaoSelecionada) {
            case R.id.action_facebook:
                f = FacebookFragment.novaInstancia(titulo);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.conteudo, f, titulo)
                        .commit();
                break;

            case R.id.action_paypal:
                f = PaypalFragment.novaInstancia(titulo);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.conteudo, f, titulo)
                        .commit();

                break;

            case R.id.action_mapa:
                Intent it = new Intent(this, LocalizacaoActivity.class);

                // Iniciamos nossa activity
                startActivity(it);

                break;

            case R.id.action_sobre:
                f = SobreFragment.novaInstancia(titulo);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.conteudo, f, titulo)
                        .commit();
                break;

         /*   case R.id.action_sair:
                // Finalizar a activity atual (MainActivity)
                finish();

                // Saindo da aplicacao
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;*/
        }
    }
}

