package br.ufgd.adipometro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.ufgd.adipometro.R;

public class FaleConoscoFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";

    public static FaleConoscoFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        FaleConoscoFragment f = new FaleConoscoFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fale_conosco, container, false);

        TextView txtAjuda = (TextView) view.findViewById(R.id.txtAjuda);

        return view;
    }
}