package br.gov.dprf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import br.gov.dprf.MainActivity;
import br.gov.dprf.R;


public class GruFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;
    private Button btCalcularGru;

    public static GruFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        GruFragment f = new GruFragment();
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
                R.string.gru);

        final View view = inflater.inflate(R.layout.gru_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webGru);
        mWebView.loadUrl("file:///android_asset/gru.html");

        btCalcularGru = (Button) view.findViewById(R.id.btCalcularGru);

        // Evento onClick do botao calcular egs.
        btCalcularGru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgPopupGru = (ImageView) view.findViewById(R.id.imgPopupGru);

                imgPopupGru.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}



