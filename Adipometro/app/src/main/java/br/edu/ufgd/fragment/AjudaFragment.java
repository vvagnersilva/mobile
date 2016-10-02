package br.edu.ufgd.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.edu.ufgd.MainActivity;
import br.edu.ufgd.R;

public class AjudaFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";

    private WebView mWebView;

    public static AjudaFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        AjudaFragment f = new AjudaFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ajuda_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webAjuda);
        mWebView.loadUrl("file:///android_asset/ajuda.html");

        return view;
    }
}