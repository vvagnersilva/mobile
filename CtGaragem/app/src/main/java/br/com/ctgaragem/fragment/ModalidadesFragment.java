package br.com.ctgaragem.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.ctgaragem.R;

public class ModalidadesFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";

    public static ModalidadesFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        ModalidadesFragment f = new ModalidadesFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.modalidades_fragment, container, false);

        // Indica que este fragment deve preservar o seu estado.
        setRetainInstance(true);

        return layout;
    }
}

