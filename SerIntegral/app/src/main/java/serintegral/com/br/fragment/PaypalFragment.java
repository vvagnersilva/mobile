package serintegral.com.br.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import serintegral.com.br.MainActivity;
import serintegral.com.br.R;
import serintegral.com.br.currencyedittext.CurrencyEditText;

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
                        "<p align=\"left\" style=\"margin-bottom: 0cm; line-height: 0.53cm; orphans: 2; widows: 2\">\n" +
                        "<font color=\"#ff3333\"><span style=\"font-variant: normal\"><font face=\"URW Chancery L\"><font size=\"6\" style=\"font-size: 24pt\"><span style=\"letter-spacing: normal\"><span style=\"font-style: normal\"><span style=\"font-weight: normal\">E\n" +
                        "quem der, mesmo que seja apenas um copo de água fria a um destes\n" +
                        "pequeninos, por ser este meu discípulo, com toda a certeza vos\n" +
                        "afirmo que de modo algum perderá a sua recompensa”.</span></span></span></font></font></span></font></p>\n" +
                        "</body></html>";

        txtProverbio.setText(Html.fromHtml(textoEmHtml, null, null));

        return layout;
    }
}

