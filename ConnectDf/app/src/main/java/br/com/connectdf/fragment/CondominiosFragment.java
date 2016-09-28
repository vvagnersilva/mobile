package br.com.connectdf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.com.connectdf.R;

public class CondominiosFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;

    public static CondominiosFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        CondominiosFragment f = new CondominiosFragment();
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

        View view = inflater.inflate(R.layout.condominios_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webCondominios);
        mWebView.loadUrl("file:///android_asset/condominios.html");

        return view;
    }
}

