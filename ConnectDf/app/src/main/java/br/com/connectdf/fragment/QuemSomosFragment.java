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

public class QuemSomosFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;

    public static QuemSomosFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        QuemSomosFragment f = new QuemSomosFragment();
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

        View view = inflater.inflate(R.layout.quem_somos_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webQuemSomos);
        mWebView.loadUrl("file:///android_asset/quem-somos.html");

        return view;
    }
}

