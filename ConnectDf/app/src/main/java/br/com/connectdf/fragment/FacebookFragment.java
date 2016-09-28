package br.com.connectdf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.com.connectdf.R;

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
        View view = inflater.inflate(R.layout.facebook_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webFacebook);
        mWebView.loadUrl("https://www.facebook.com/connectdf/?fref=ts");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return view;
    }
}

