package br.com.connectdf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.com.connectdf.MainActivity;
import br.com.connectdf.R;

public class PortifolioFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;

    public static PortifolioFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        PortifolioFragment f = new PortifolioFragment();
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
                R.string.nav_portifolio);

        View view = inflater.inflate(R.layout.portifolio_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webPortifolio);
        mWebView.loadUrl("file:///android_asset/portifolio.html");

        return view;
    }
}

