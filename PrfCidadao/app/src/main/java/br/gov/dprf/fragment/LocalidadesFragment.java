package br.gov.dprf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.gov.dprf.MainActivity;
import br.gov.dprf.R;


public class LocalidadesFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;

    public static LocalidadesFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        LocalidadesFragment f = new LocalidadesFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Setando o titulo no toolbar.
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(
                R.string.pontos_mapa);

        View view = inflater.inflate(R.layout.localidade_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webLoc);
        mWebView.loadUrl("file:///android_asset/localidade.html");

        return view;
    }
}

