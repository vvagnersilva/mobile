package br.ufgd.adipometro;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import br.ufgd.adipometro.fragment.AjudaFragment;
import br.ufgd.adipometro.fragment.CalculoFragment;
import br.ufgd.adipometro.fragment.EgsFragment;
import br.ufgd.adipometro.fragment.FaleConoscoFragment;
import br.ufgd.adipometro.fragment.FotosFragment;
import br.ufgd.adipometro.fragment.SobreFragment;
import br.ufgd.adipometro.fragment.WebFragment;
import br.ufgd.adipometro.strategy.Egs;
import br.ufgd.adipometro.strategy.EgsCordeiroMachoCostas;
import br.ufgd.adipometro.strategy.EgsCordeiroMachoPeito;
import br.ufgd.adipometro.utils.TipoAssuntoEnum;
import br.ufgd.adipometro.utils.TipoCategoriaAnimalEnum;
import br.ufgd.adipometro.utils.TipoMedidaEnum;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Adipometro";
    private static TipoCategoriaAnimalEnum tpCategoriaAnimal;
    private static TipoAssuntoEnum tpAssunto;
    private CalculoFragment fragment;

    public static TipoCategoriaAnimalEnum getTpCategoriaAnimal() {
        return tpCategoriaAnimal;
    }

    public static void setTpCategoriaAnimal(TipoCategoriaAnimalEnum tpCategoriaAnimal) {
        MainActivity.tpCategoriaAnimal = tpCategoriaAnimal;
    }

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
            EditText edPeso = (EditText)
                    findViewById(R.id.edPeso);

            EditText edPrega = (EditText) findViewById(R.id.edPrega);

            final Spinner spCategoria = fragment.getSpCategoria();

            // Validar campos obrigatorios.
            if (!validaCamposObrigatorios()) {
                double peso = Double.parseDouble(edPeso.getText().toString());
                double prega = Double.parseDouble(edPrega.getText().toString());

                Egs egs = null;

                TipoMedidaEnum tpMedida = fragment.getTpMedida();

                switch (tpMedida) {
                    case COSTAS:
                        if (TipoCategoriaAnimalEnum.CORDEIRO_MACHO.getCodigo().equals(tpCategoriaAnimal.getCodigo())) {
                            egs = new EgsCordeiroMachoCostas(peso, prega, spCategoria.toString());
                        }
                        // Analise futura, intensão de expandir o aplicativo.
                        if (TipoCategoriaAnimalEnum.CORDEIRO_FEMEA.getCodigo().equals(tpCategoriaAnimal.getCodigo())) {
                            // A implementar
                        }

                        break;

                    case PEITO:
                        if (TipoCategoriaAnimalEnum.CORDEIRO_MACHO.getCodigo().equals(tpCategoriaAnimal.getCodigo())) {
                            egs = new EgsCordeiroMachoPeito(peso, prega, spCategoria.toString());
                        }
                        // Analise futura, intensão de expandir o aplicativo.
                        if (TipoCategoriaAnimalEnum.CORDEIRO_FEMEA.getCodigo().equals(tpCategoriaAnimal.getCodigo())) {
                            // A implementar
                        }
                        break;
                }

                egs.CalcularEgs();

                // Fragment default.
                EgsFragment egsfragment = EgsFragment.novaInstancia(egs);

                getSupportFragmentManager()

                        .

                                beginTransaction()

                        .

                                replace(R.id.conteudo, egsfragment, "egsFragment")

                        .

                                commit();
            }
        } catch (NumberFormatException ex) {
            Log.e(TAG, getClassName() + ex.getStackTrace());
        } catch (Exception ex) {
            Log.e(TAG, getClassName() + ex.getStackTrace());
        }
    }

    private boolean validaCamposObrigatorios() {

        EditText edPeso = (EditText) findViewById(R.id.edPeso);
        EditText edPrega = (EditText) findViewById(R.id.edPrega);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);

        if (tpCategoriaAnimal == null) {
            alertDialogBuilder.setTitle("Informação");
            alertDialogBuilder.setIcon(R.drawable.ic_information);
            alertDialogBuilder.setMessage("Campo categoria animal é de preenchimento obrigatório!");
            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();

            return true;
        }

        if (edPeso.getText().length() == 0) {

            alertDialogBuilder.setTitle("Informação");
            alertDialogBuilder.setIcon(R.drawable.ic_information);
            alertDialogBuilder.setMessage("Campo peso corporal é de preenchimento obrigatório!");
            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();

            return true;
        }

        if (edPrega.getText().length() == 0) {
            alertDialogBuilder.setTitle("Informação");
            alertDialogBuilder.setIcon(R.drawable.ic_information);
            alertDialogBuilder.setMessage("Campo medida das pregas é de preenchimento obrigatório!");
            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();

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
            tpCategoriaAnimal = null;
            frag = CalculoFragment.novaInstancia(titulo);
        } else if (id == R.id.action_ufgd) {
            frag = WebFragment.novaInstancia(titulo);
        } else if (id == R.id.action_fotos) {
            frag = FotosFragment.novaInstancia(titulo);
        } else if (id == R.id.action_fale_conosco) {
            frag = FaleConoscoFragment.novaInstancia(titulo);
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