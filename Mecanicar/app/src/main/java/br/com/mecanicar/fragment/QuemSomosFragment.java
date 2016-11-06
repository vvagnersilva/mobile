package br.com.mecanicar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.mecanicar.MainActivity;
import br.com.mecanicar.R;


/**
 * Created by Wagner Silva.
 */
public class QuemSomosFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";

    public static QuemSomosFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        QuemSomosFragment f = new QuemSomosFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Setando o titulo no toolbar.
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(
                R.string.quem_somos);

        View view = inflater.inflate(R.layout.quem_somos_fragment, container, false);

        return view;
    }
}