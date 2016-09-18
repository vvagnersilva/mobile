package serintegral.com.br.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import serintegral.com.br.R;
import serintegral.com.br.util.currencyedittext.CurrencyEditText;

public class SobreFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";

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

        TextView  txtDesenv = (TextView) view.findViewById(R.id.txtDesenv);

        final String textoEmHtml =
                "<html><body lang=\"pt-BR\" dir=\"ltr\">\n" +
                        "<p align=\"center\" style=\"margin-bottom: 0cm; font-variant: normal; letter-spacing: normal; line-height: 0.53cm; orphans: 2; widows: 2\">\n" +
                        "<font color=\"#000000\"><font face=\"URW Chancery L\"><font size=\"6\" style=\"font-size: 24pt\"><span style=\"font-style: normal\"><span style=\"font-weight: normal\">Desenvolvido\n" +
                        "por:</span></span></font></font></font></p>\n" +
                        "<p align=\"center\" style=\"margin-bottom: 0cm; font-variant: normal; letter-spacing: normal; line-height: 0.53cm; orphans: 2; widows: 2\">\n" +
                        "<font color=\"#000000\"><font face=\"URW Chancery L\"><font size=\"6\" style=\"font-size: 24pt\"><span style=\"font-style: normal\"><span style=\"font-weight: normal\">Wagner\n" +
                        "Silva</span></span></font></font></font></p>\n" +
                        "</body></html>";

        txtDesenv.setText(Html.fromHtml(textoEmHtml, null, null));

        return view;
    }
}