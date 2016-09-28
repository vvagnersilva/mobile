package br.com.connectdf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.com.connectdf.MainActivity;
import br.com.connectdf.R;

public class ClienteFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private String mTipo;
    private WebView mWebView;

    public static ClienteFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        ClienteFragment f = new ClienteFragment();
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
                R.string.nav_clientes);

        View view = inflater.inflate(R.layout.clientes_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webClientes);
        mWebView.loadUrl("file:///android_asset/clientes.html");

        return view;
    }
}

