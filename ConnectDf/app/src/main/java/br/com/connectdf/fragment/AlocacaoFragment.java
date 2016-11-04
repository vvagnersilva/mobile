package br.com.connectdf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.com.connectdf.MainActivity;
import br.com.connectdf.R;

public class AlocacaoFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private WebView mWebView;

    public static AlocacaoFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        AlocacaoFragment f = new AlocacaoFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Setando o titulo no toolbar.
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(
                R.string.nav_alocacao);

        View view = inflater.inflate(R.layout.alocacao_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webAlocacao);
        mWebView.loadUrl("file:///android_asset/alocacao.html");

        return view;
    }
}

