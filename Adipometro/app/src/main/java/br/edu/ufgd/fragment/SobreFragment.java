package br.edu.ufgd.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edu.ufgd.R;


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
                "<html>\n" +
                        "<font face=\"Purisa, serif\"><b>MEMBROS DA EXECUÇÃO</b></font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Adrielly Lais Alves da Silva</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Fernando Miranda de Vargas Junior</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Marcelo Corrêa da Silva</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Marcus Vinicius Porto dos Santos</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Wagner Silva</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%; page-break-before: always\">\n" +
                        "<font face=\"Purisa, serif\"><b>MEMBROS COLABORADORES</b></font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Adriana Sathie Ozaki Hirata</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Alexandre Rodrigo Mendes Fernandes</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Hélio de Almeida Ricardo</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Ingrid Harumi de Souza Fuzikawa</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Márcio Rodrigues de Souza</font></p>\n" +
                        "</body>\n" +
                        "</html>";

        txtParticipantes.setText(Html.fromHtml(textoEmHtml, null, null));

        return view;
    }
}