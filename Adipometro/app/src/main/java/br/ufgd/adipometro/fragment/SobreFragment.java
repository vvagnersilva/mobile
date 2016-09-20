package br.ufgd.adipometro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.ufgd.adipometro.R;

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

        TextView txtParticipantes = (TextView) view.findViewById(R.id.txtParticipantes);

        final String textoEmHtml =
                "<html><body lang=\"pt-BR\" text=\"#00000a\" dir=\"ltr\">\n" +
                        "<p class=\"western\" style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"Purisa, serif\">ADRIELLY\n" +
                        "LAIS ALVES DA SILVA – Graduanda em Zootecnia pela Universidade\n" +
                        "Federal da Grande Dourados UFGD – Bolsista Iniciação Cientifica.</font></p>\n" +
                        "<p class=\"western\" style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"Purisa, serif\">FERNANDO\n" +
                        "MIRANDA DE VARGAS JUNIOR – Orientador e Professor Doutor da\n" +
                        "Faculdade de Ciências Agrarias da UFGD.</font></p>\n" +
                        "<p class=\"western\" style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"Purisa, serif\">MARCELO\n" +
                        "CORREA DA SILVA – Doutor em ciência animal – Pós doutorando e\n" +
                        "professor voluntário UFGD-FCA-ZOOTECNIA.</font></p>\n" +
                        "<p class=\"western\" style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"Purisa, serif\">WAGNER\n" +
                        "SILVA – Bacharel e Ciência da Computação – Universidade\n" +
                        "federal de lavras UFLA.</font></p>\n" +
                        "</body></html>";

        txtParticipantes.setText(Html.fromHtml(textoEmHtml, null, null));

        return view;
    }
}