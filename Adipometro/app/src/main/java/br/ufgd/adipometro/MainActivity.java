package br.ufgd.adipometro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.ufgd.adipometro.fragment.AjudaFragment;
import br.ufgd.adipometro.fragment.CalculoFragment;
import br.ufgd.adipometro.fragment.EgsFragment;
import br.ufgd.adipometro.fragment.SobreFragment;
import br.ufgd.adipometro.fragment.WebFragment;
import br.ufgd.adipometro.strategy.Costas;
import br.ufgd.adipometro.strategy.Egs;
import br.ufgd.adipometro.strategy.Peito;
import br.ufgd.adipometro.utils.TipoMedidaEnum;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Adipometro";
    private CalculoFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Fragment default.
        fragment = CalculoFragment.novaInstancia("CalculoFragment");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, fragment, "CalculoFragment")
                .commit();
    }

    public void onClickCalcularEgs(View view) {
        try {
            TextView tPeso = (TextView)
                    findViewById(R.id.edPeso);

            TextView tPrega = (TextView) findViewById(R.id.edPrega);

            // Validar campos obrigatorios.
            if (validaCamposObrigatorios(tPeso, tPrega)) return;

            Spinner spCategoria = fragment.getSpCategoria();

            double peso = Double.parseDouble(tPeso.getText().toString());
            double prega = Double.parseDouble(tPrega.getText().toString());

            Egs egs = null;

            TipoMedidaEnum tpMedida = fragment.getTpMedida();

            switch (tpMedida) {
                case COSTAS:
                    egs = new Costas(peso, prega, spCategoria.toString());
                    egs.CalcularEgs();
                    break;
                case PEITO:
                    egs = new Peito(peso, prega, spCategoria.toString());
                    egs.CalcularEgs();
                    break;
            }

            // Fragment default.
            EgsFragment egsfragment = EgsFragment.novaInstancia(egs);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteudo, egsfragment, "egsFragment")
                    .commit();
        } catch (NumberFormatException ex) {
            Log.e(TAG, getClassName() + ex.getStackTrace());
        } catch (Exception ex) {
            Log.e(TAG, getClassName() + ex.getStackTrace());
        }
    }

    private boolean validaCamposObrigatorios(TextView tPeso, TextView tPrega) {
        if (tPeso.getText().length() == 0) {
            alert("Campo peso corporal é obrigatório!");
            return true;
        }

        if (tPrega.getText().length() == 0) {
            alert("Campo medida da prega é obrigatório!");
            return true;
        }
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botões da action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String titulo = item.getTitle().toString();
        int id = item.getItemId();
        Fragment frag = null;

        if (id == R.id.action_calculo) {
            frag = CalculoFragment.novaInstancia(titulo);
        } else if (id == R.id.action_ufgd) {
            frag = WebFragment.novaInstancia(titulo);
        } else if (id == R.id.action_ajuda) {
            frag = AjudaFragment.novaInstancia(titulo);

        } else if (id == R.id.action_sobre) {
            frag = SobreFragment.novaInstancia(titulo);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, frag, titulo)
                .commit();

        return super.onOptionsItemSelected(item);
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * Retorna o nome da classe sem o pacote
     *
     * @return
     */
    public String getClassName() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}