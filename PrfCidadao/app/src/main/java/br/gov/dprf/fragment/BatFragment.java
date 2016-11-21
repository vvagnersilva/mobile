package br.gov.dprf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import br.gov.dprf.MainActivity;
import br.gov.dprf.R;


public class BatFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;
    private Button btConsultar;
    private ImageView imgListaBat;

    public static BatFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        BatFragment f = new BatFragment();
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
                R.string.txtBat);

        final View view = inflater.inflate(R.layout.bat_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webBat);
        mWebView.loadUrl("file:///android_asset/bat.html");

        btConsultar = (Button) view.findViewById(R.id.btConsultar);

        // Evento onClick do botao calcular egs.
        btConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgListaBat = (ImageView) view.findViewById(R.id.imgListaBat);
                ImageView imgRelBat = (ImageView) view.findViewById(R.id.imgRelBat);

                imgListaBat.setVisibility(View.VISIBLE);
                imgRelBat.setVisibility(View.INVISIBLE);
            }
        });

        imgListaBat = (ImageView) view.findViewById(R.id.imgListaBat);

        imgListaBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView imgRelBat = (ImageView) view.findViewById(R.id.imgRelBat);

                imgRelBat.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}

