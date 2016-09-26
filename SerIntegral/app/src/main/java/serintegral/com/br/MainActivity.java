package serintegral.com.br;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;

import serintegral.com.br.fragment.FacebookFragment;
import serintegral.com.br.fragment.MapsFragment;
import serintegral.com.br.fragment.PaypalFragment;
import serintegral.com.br.fragment.SobreFragment;
import serintegral.com.br.util.Constantes;
import serintegral.com.br.util.PermissionUtils;
import serintegral.com.br.util.Util;

public class MainActivity extends AppCompatActivity {

    static final int COD_PAGTO = 123;

    PayPalConfiguration payPalConfig = new PayPalConfiguration()
            .environment(Constantes.PAYPAL_ENV)
            .clientId(Constantes.PAYPAL_CLIENT_ID)
            .languageOrLocale("pt_BR");

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mOpcaoSelecionada;
    private EditText edValor;

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
    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);

        alertDialogBuilder.setTitle("Informação");
        alertDialogBuilder.setIcon(R.drawable.ic_information);

        if (requestCode == COD_PAGTO) {
            if (responseCode == Activity.RESULT_OK) {
                alertDialogBuilder.setMessage("Doação realizada com sucesso!");
            } else {
                alertDialogBuilder.setMessage("Algum problema com a doação verificar a sua conta no paypal.");
            }

            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();
        }
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
                // Solicita as permissões
                String[] permissoes = new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                };

                PermissionUtils.validate(this, 0, permissoes);

                f = MapsFragment.novaInstancia(titulo);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.conteudo, f, titulo)
                        .commit();
                break;

            case R.id.action_sobre:
                f = SobreFragment.novaInstancia(titulo);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.conteudo, f, titulo)
                        .commit();
                break;

            case R.id.action_sair:
                // Finalizar a activity atual (MainActivity)
                finish();

                // Saindo da aplicacao
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            default:
        }
    }

    public void onClickDoar(View view) {
        executarPagtoPayPal();
    }

    private void executarPagtoPayPal() {
        edValor = (EditText) findViewById(R.id.edValor);

        // Retirar o simbolo da moeda.
        String valor = edValor.getText().toString().replace("R$", "");

        if (valor.length() == 0) {
            edValor.setError("Campo obrigatório!");
            return;
        }

        // Conversao p/ Double
        Double val = Util.converteStringToDouble(valor);

        PayPalPayment pagto = montarPagtoFinal(val);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfig);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, pagto);

        startActivityForResult(intent, COD_PAGTO);
    }

    private PayPalPayment montarPagtoFinal(Double valor) {

        PayPalPayment payPalPayment =
                new PayPalPayment(new BigDecimal(valor), Constantes.PAYPAL_CURRENCY, "Instituto Ser Integral", Constantes.PAYPAL_INTENT);

        payPalPayment.custom("Doação - Instituto Ser Integral");

        return payPalPayment;
    }
}

