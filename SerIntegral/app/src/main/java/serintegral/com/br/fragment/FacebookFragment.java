package serintegral.com.br.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import serintegral.com.br.MainActivity;
import serintegral.com.br.R;

public class FacebookFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;

    public static FacebookFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        FacebookFragment f = new FacebookFragment();
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
        ((MainActivity) getActivity())
                .setActionBarTitle(R.string.app_name);

        View layout = inflater.inflate(R.layout.facebook_fragment, container, false);

        mWebView = (WebView) layout.findViewById(R.id.webView);
        mWebView.loadUrl("https://www.facebook.com/Escola-Francisquinho-Ser-Integral-1476389359278801/");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return layout;
    }
}

