package br.ufgd.adipometro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import br.ufgd.adipometro.MainActivity;
import br.ufgd.adipometro.R;
import br.ufgd.adipometro.enums.TipoCategoriaAnimalEnum;
import br.ufgd.adipometro.enums.TipoMedidaEnum;


public class CalculoFragment extends Fragment {
    private static final String TAG = "Adipometro";
    private static final String EXTRA_TIPO = "mTipo";

    // Verificar melhor forma p/ consultar essa variavel.
    private static TipoMedidaEnum tpMedida;
    private Spinner spCategoria;
    private RadioGroup group;

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

        group = (RadioGroup) view.findViewById(R.id.rgOpcoes);

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

        /**
         * Categoria selecionada no combobox:
         * Hoje Set/2016 só tem Cordeiro Macho
         * (FUTURAMENTE VAMOS ACRESCENTAR AS OUTRAS CATEGORIAS, APÓS NOVOS EXPERIMENTOS)
         */
        spCategoria = (Spinner) view.findViewById(R.id.spCategoria);

        spCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // String selectedItem = (String) spCategoria.getItemAtPosition(position);

                if (position == 0) {
                    MainActivity.setTpCategoriaAnimal(null);
                } else if (Integer.parseInt(TipoCategoriaAnimalEnum.CORDEIRO_MACHO.getCodigo()) == position) {
                    MainActivity.setTpCategoriaAnimal(TipoCategoriaAnimalEnum.CORDEIRO_MACHO);
                } else if (TipoCategoriaAnimalEnum.CORDEIRO_MACHO.getCodigo().equals(position)) {
                    // A implementar
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return view;
    }

    public TipoMedidaEnum getTpMedida() {
        return tpMedida;
    }

    public void setTpMedida(TipoMedidaEnum tpMedida) {
        this.tpMedida = tpMedida;
    }

    public Spinner getSpCategoria() {
        return spCategoria;
    }

    public void setSpCategoria(Spinner spCategoria) {
        this.spCategoria = spCategoria;
    }
}