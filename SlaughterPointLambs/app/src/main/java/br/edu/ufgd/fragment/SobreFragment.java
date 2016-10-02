package br.edu.ufgd.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import br.edu.ufgd.MainActivity;
import br.edu.ufgd.R;


public class SobreFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private WebView mWebView;

    public static SobreFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        SobreFragment f = new SobreFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.sobre_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webSobre);
        mWebView.loadUrl("file:///android_asset/participantes.html");

        return view;
    }
}