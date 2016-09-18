package serintegral.com.br;

import android.app.Activity;
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
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;

import serintegral.com.br.fragment.FacebookFragment;
import serintegral.com.br.fragment.PaypalFragment;
import serintegral.com.br.fragment.SobreFragment;
import serintegral.com.br.mapas.LocalizacaoActivity;
import serintegral.com.br.util.Constantes;
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

        if (requestCode == COD_PAGTO) {
            if (responseCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Pagamento realizado com sucesso ...", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Algum problema com o pagamento verificar sua conta no paypal.", Toast.LENGTH_SHORT).show();
        }
    }

    private void selecionarOpcaoMenu(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_sair) {
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

        Fragment f = null;

        if (menuItem.getItemId() == R.id.action_facebook) {
            f = FacebookFragment.novaInstancia(titulo);
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
        } else if (menuItem.getItemId() == R.id.action_mapa) {
            Intent it = new Intent(this, LocalizacaoActivity.class);

            // Iniciamos nossa activity
            startActivity(it);
        } else if (menuItem.getItemId() == R.id.action_sobre) {
            f = SobreFragment.novaInstancia(titulo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, f, titulo)
                    .commit();
        }
    }

    public void onClickDoar(View view) {
        executarPagtoPayPal();
    }

    private void executarPagtoPayPal() {
        EditText edValor = (EditText) findViewById(R.id.edValor);

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

    public void onClickEnviarEmail(View v) {
        String subject = "[app] - Instituto Ser Integral";

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_CC, new String[]{"vvagner.silva@gmail.com"});
        //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, "");

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}

