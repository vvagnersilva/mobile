package serintegral.com.br.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import serintegral.com.br.R;

public class SobreFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";

    public static SobreFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        SobreFragment f = new SobreFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sobre_fragment, container, false);

        return view;
    }
}