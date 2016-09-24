package br.edu.ufgd.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import br.edu.ufgd.R;
import br.edu.ufgd.enums.TipoCategoriaAnimalEnum;
import br.edu.ufgd.enums.TipoMedidaEnum;
import br.edu.ufgd.strategy.Egs;
import br.edu.ufgd.strategy.EgsCordeiroMachoCostas;
import br.edu.ufgd.strategy.EgsCordeiroMachoPeito;

public class CalculoFragment extends Fragment {
    private static final String TAG = "Adipometro";
    private static final String EXTRA_TIPO = "mTipo";
    private static TipoMedidaEnum tpMedida;
    private TipoCategoriaAnimalEnum tpCategoriaAnimal;
    private Spinner spCategoria;
    private RadioGroup group;
    private EditText edPeso;
    private EditText edPrega;
    private Button btCalcularEgs;

    public static CalculoFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);

        CalculoFragment f = new CalculoFragment();

        f.setArguments(params);

        // Default p/ medida das costas.
        tpMedida = TipoMedidaEnum.COSTAS;

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculo_fragment, container, false);

        /**
         * Categoria selecionada
         *
         * FUTURAMENTE VAMOS ACRESCENTAR AS OUTRAS CATEGORIAS, APÓS NOVOS EXPERIMENTOS
         */
        spCategoria = (Spinner) view.findViewById(R.id.spCategoria);

        edPeso = (EditText) view.findViewById(R.id.edPeso);
        edPrega = (EditText) view.findViewById(R.id.edPrega);

        group = (RadioGroup) view.findViewById(R.id.rgOpcoes);

        // Evento do RadioGroup.
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                boolean isCostas = R.id.radioCostas == checkedId;
                boolean isPeito = R.id.radioPeito == checkedId;

                if (isCostas) {
                    CalculoFragment.this.tpMedida = TipoMedidaEnum.COSTAS;
                    Log.i(TAG, "Marcou radio das Costas: " + checkedId);
                } else if (isPeito) {
                    CalculoFragment.this.tpMedida = TipoMedidaEnum.PEITO;
                    Log.i(TAG, "Marcou radio do Peito: " + checkedId);
                }
            }
        });

        // Evento do Spinner.
        spCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // String selectedItem = (String) spCategoria.getItemAtPosition(position);

                if (position == 0) {
                    tpCategoriaAnimal = null;
                } else if (Integer.parseInt(TipoCategoriaAnimalEnum.CORDEIRO_MACHO.getCodigo()) == position) {
                    tpCategoriaAnimal = TipoCategoriaAnimalEnum.CORDEIRO_MACHO;
                } else if (TipoCategoriaAnimalEnum.CORDEIRO_MACHO.getCodigo().equals(position)) {
                    // A implementar
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btCalcularEgs = (Button) view.findViewById(R.id.btCalcularEgs);

        // Evento onClick do botao calcular egs.
        btCalcularEgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validaCamposObrigatorios()) {
                    double peso = Double.parseDouble(edPeso.getText().toString());
                    double prega = Double.parseDouble(edPrega.getText().toString());

                    Egs egs = null;

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

                    getFragmentManager()

                            .

                                    beginTransaction()

                            .

                                    replace(R.id.conteudo, egsfragment, "egsFragment")

                            .

                                    commit();
                }
            }
        });

        return view;
    }

    private boolean validaCamposObrigatorios() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), R.style.AlertDialogStyle);

        if (tpCategoriaAnimal == null) {
            alertDialogBuilder.setTitle("Informação");
            alertDialogBuilder.setIcon(R.drawable.ic_information);
            alertDialogBuilder.setMessage("Categoria animal é de preenchimento obrigatório!");
            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();

            return true;
        }

        if (edPeso.getText().length() == 0) {
            edPeso.setError("Peso corporal é de preenchimento obrigatório!");
            return true;
        }

        if (edPrega.getText().length() == 0) {
            edPrega.setError("Medida das pregas é de preenchimento obrigatório!");
            return true;
        }

        return false;
    }
}