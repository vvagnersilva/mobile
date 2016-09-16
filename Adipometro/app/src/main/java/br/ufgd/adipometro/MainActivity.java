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
import android.widget.TextView;
import android.widget.Toast;

import br.ufgd.adipometro.fragment.AjudaFragment;
import br.ufgd.adipometro.fragment.CalculoFragment;
import br.ufgd.adipometro.fragment.SobreFragment;
import br.ufgd.adipometro.fragment.UfgdFragment;
import br.ufgd.adipometro.strategy.Egs;
import br.ufgd.adipometro.strategy.Cauda;

public class MainActivity extends AppCompatActivity {

    private boolean isCheckedTipoPlicometro;
    private static final String TAG = "Adipometro";
    private String tpMedida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment f = null;

        f = CalculoFragment.novaInstancia("teste");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, f, "teste")
                .commit();

/*
        final RadioGroup group = (RadioGroup) findViewById(R.id.group1);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                boolean isCalda = R.id.radioCalda == checkedId;
                boolean isCostas = R.id.radioCostas == checkedId;
                boolean isPeito = R.id.radioPeito == checkedId;

                if (isCalda) {
                    tpMedida = TipoMedidaEnum.CALDA.getCodigo();
                    Log.i(TAG, "Marcou radio Calda: " + checkedId);
                } else if (isCostas) {
                    tpMedida = TipoMedidaEnum.COSTAS.getCodigo();
                    Log.i(TAG, "Marcou radio Costas: " + checkedId);
                } else if (isPeito) {
                    tpMedida = TipoMedidaEnum.PEITO.getCodigo();
                    Log.i(TAG, "Marcou radio Peito: " + checkedId);
                }
            }
        });

        Switch tipoPlicometro = (Switch) findViewById(R.id.tipoPlicometro);
        tipoPlicometro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedTipoPlicometro = isChecked;
                Log.v("Switch State=", "" + isCheckedTipoPlicometro);
            }
        });
*/
    }

    public void onClickCalcularEgs(View view) {
        try {
            TextView tPeso = (TextView)
                    findViewById(R.id.edPeso);

            TextView tCa = (TextView)
                    findViewById(R.id.edCa);

            TextView tCc = (TextView)
                    findViewById(R.id.edCc);

            if (tPeso.getText().length() == 0 && tCa.getText().length() == 0 && tCc.getText().length() == 0) {
                alert("Pelo menos um campo deve ser informado.");
                return;
            }

            double peso = tPeso.getText().length() == 0 ? 0 : Double.parseDouble(tPeso.getText().toString());
            double ca = tCa.getText().length() == 0 ? 0 : Double.parseDouble(tCa.getText().toString());
            double cc = tCc.getText().length() == 0 ? 0 : Double.parseDouble(tCc.getText().toString());

            // Implementar calculos p/ peito e costas.
            Egs egs = new Cauda(peso, ca, cc, isCheckedTipoPlicometro);

            // Navega para a próxima tela
            Intent intent = new Intent(this, EgsActivity.class);

            Bundle params = new Bundle();

            params.putString("tpMedida", tpMedida);
            params.putDouble("peso", peso);
            params.putDouble("ca", ca);
            params.putDouble("cc", cc);
            params.putDouble("egs", egs.CalcularEgs());
            params.putString("formula", egs.getStrFormulaUtilizada());

            intent.putExtras(params);

            startActivity(intent);
        } catch (NumberFormatException ex) {
            Log.e(TAG, getClassName() + ex.getStackTrace());
        } catch (Exception ex) {
            Log.e(TAG, getClassName() + ex.getStackTrace());
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botões da action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    // Intent que define o conteúdo que será compartilhado
    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar");
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment f = null;
        String titulo = item.getTitle().toString();

        int id = item.getItemId();

        if (id == R.id.action_calculo) {
            f = CalculoFragment.novaInstancia(titulo);
        } else if (id == R.id.action_ufgd) {
            f = UfgdFragment.novaInstancia(titulo);
        } else if (id == R.id.action_ajuda) {
            f = AjudaFragment.novaInstancia(titulo);

        } else if (id == R.id.action_sobre) {
            f = SobreFragment.novaInstancia(titulo);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, f, titulo)
                .commit();

        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public String getClassName() {
        // Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}