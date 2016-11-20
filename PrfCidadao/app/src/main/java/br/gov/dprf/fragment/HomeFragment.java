package br.gov.dprf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.gov.dprf.MainActivity;
import br.gov.dprf.R;
import br.gov.dprf.utils.Connectivity;


public class HomeFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;

    public static HomeFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        HomeFragment f = new HomeFragment();
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
                R.string.home);

        View view = inflater.inflate(R.layout.home_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webHome);

        if (Connectivity.isConnected()) {
            mWebView.loadUrl("https://www.prf.gov.br/portal");

            // Enable Javascript
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setSupportZoom(false);

            // Force links and redirects to open in the WebView instead of in a browser
            mWebView.setWebViewClient(new WebViewClient());

        } else {
            mWebView.loadUrl("file:///android_asset/home.html");
        }

        return view;
    }
}

