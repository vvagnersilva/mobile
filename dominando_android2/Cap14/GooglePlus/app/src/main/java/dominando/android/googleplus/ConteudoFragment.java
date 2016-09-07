package dominando.android.googleplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.LinkedHashMap;

public class ConteudoFragment extends Fragment
        implements View.OnClickListener {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;

    private LinkedHashMap<String, Class> mAcoes;

    public static ConteudoFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        ConteudoFragment f = new ConteudoFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAcoes = new LinkedHashMap<String, Class>();
        mAcoes.put(getString(R.string.opcao_aba), TelaAbasActivity.class);
        mAcoes.put(getString(R.string.opcao_spinner), TelaSpinnerActivity.class);
        mAcoes.put(getString(R.string.opcao_pager), TelaPagerActivity.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.agenda_fragment, container, false);

        mWebView = (WebView) layout.findViewById(R.id.webView);
        mWebView.loadUrl("https://www.instagram.com/marchaparajesus");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return layout;
    }

    @Override
    public void onClick(View view) {
        Class classe = mAcoes.get(mTipo);
        startActivity(new Intent(getActivity(), classe));
    }
}

