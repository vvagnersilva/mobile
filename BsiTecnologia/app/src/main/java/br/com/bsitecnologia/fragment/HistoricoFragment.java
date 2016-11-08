package br.com.bsitecnologia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.com.bsitecnologia.MainActivity;
import br.com.bsitecnologia.R;

public class HistoricoFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private WebView mWebView;

    public static HistoricoFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        HistoricoFragment f = new HistoricoFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Setando o titulo no toolbar.
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(
                R.string.historico);

        View view = inflater.inflate(R.layout.historico_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.historico);
        mWebView.loadUrl("file:///android_asset/historico.html");

        return view;
    }
}

