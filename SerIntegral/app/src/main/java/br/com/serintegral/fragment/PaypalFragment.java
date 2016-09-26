package br.com.serintegral.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.serintegral.MainActivity;
import br.com.serintegral.R;
import br.com.serintegral.currencyedittext.CurrencyEditText;

public class PaypalFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private CurrencyEditText edValor;

    public static PaypalFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        PaypalFragment f = new PaypalFragment();
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
                .setActionBarTitle(R.string.opcao_paypal);

        View layout = inflater.inflate(R.layout.paypal_fragment, container, false);

        edValor = (CurrencyEditText) layout.findViewById(R.id.edValor);

        TextView txtProverbio = (TextView) layout.findViewById(R.id.txtProverbio);

        final String textoEmHtml =
                "<html><body lang=\"pt-BR\" dir=\"ltr\">\n" +
                        "<p align=\"left\" style=\"margin-bottom: 0cm; font-variant: normal; letter-spacing: normal; font-style: normal; font-weight: normal; line-height: 0.53cm; orphans: 2; widows: 2\">\n" +
                        "<font color=\"#000000\">“<font face=\"URW Chancery L\"><font size=\"6\" style=\"font-size: 24pt\">E\n" +
                        "quem der, mesmo que seja apenas um copo de água fria a um destes\n" +
                        "pequeninos, por ser este meu discípulo, com toda a certeza vos\n" +
                        "afirmo que de modo algum perderá a sua recompensa”.</font></font></font></p>\n" +
                        "</body></html>";

        txtProverbio.setText(Html.fromHtml(textoEmHtml, null, null));

        return layout;
    }
}

