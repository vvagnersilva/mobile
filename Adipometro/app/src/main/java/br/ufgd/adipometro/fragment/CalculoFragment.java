package br.ufgd.adipometro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;

import br.ufgd.adipometro.R;
import br.ufgd.adipometro.utils.TipoMedidaEnum;

public class CalculoFragment extends Fragment {
    private static final String TAG = "Adipometro";
    private static final String EXTRA_TIPO = "mTipo";

    private TipoMedidaEnum tpMedida;
    private Spinner spCategoria;

    public static CalculoFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        CalculoFragment f = new CalculoFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculo_fragment, container, false);

        final RadioGroup group = (RadioGroup) view.findViewById(R.id.rgOpcoes);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                boolean isCostas = R.id.radioCostas == checkedId;
                boolean isPeito = R.id.radioPeito == checkedId;

                if (isCostas) {
                    tpMedida = TipoMedidaEnum.COSTAS;
                    Log.i(TAG, "Marcou radio das Costas: " + checkedId);
                } else if (isPeito) {
                    tpMedida = TipoMedidaEnum.PEITO;
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