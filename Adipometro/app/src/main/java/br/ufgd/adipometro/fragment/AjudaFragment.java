package br.ufgd.adipometro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.ufgd.adipometro.R;

public class AjudaFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";

    public static AjudaFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        AjudaFragment f = new AjudaFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ajuda_fragment, container, false);

        TextView txtAjuda = (TextView) view.findViewById(R.id.txtAjuda);

        final String textoEmHtml =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>\n" +
                        "</head>\n" +
                        "<body lang=\"pt-BR\" text=\"#00000a\" dir=\"ltr\">\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa\"><span style=\"background: #ffffff\">O objetivo\n" +
                        "geral do projeto é predizer a espessura de gordura subcutânea\n" +
                        "(EGS), para se obter um ótimo momento de abate, utilizando o peso\n" +
                        "corporal e medidas de pregas cutâneas.</span></font></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa\"><span style=\"background: #ffffff\">O adipômetro,\n" +
                        "ou plicômetro, é um equipamento que serve para medir a espessura do\n" +
                        "tecido adiposo do corpo. Essas medidas podem ser colocadas em algumas\n" +
                        "equações, e servem para calcular o percentual de espessura de\n" +
                        "gordura subcutânea (EGS).</span></font></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa\"><span style=\"background: #ffffff\">Para resposta\n" +
                        "utilizamos cotes na ordem crescente de acumulo de gordura</span>:</font></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font color=\"#ed7d31\"> <font face=\"Purisa\"><b>LARANJA (&lt; 1 mm)</b></font></font></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa\"><font color=\"#ffff00\"><b>AMARELO ( &gt;= 1 &lt; 2\n" +
                        "mm)</b></font></font></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa\"><font color=\"#00b050\"><b>VERDE (&gt;=2&lt;=3 mm)</b></font></font></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa\"><font color=\"#ff0000\"><b>VERMELHO (&gt;3 mm)</b></font></font></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa\">Lembrando que tais padrões dependem do mercado\n" +
                        "consumidor, estes utilizados baseiam-se no acabamento mínimo\n" +
                        "necessário para uma boa proteção da carcaça durante o\n" +
                        "resfriamento e gordura suficiente na carne para os padrões\n" +
                        "brasileiros.</font></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "</body>\n" +
                        "</html>";

        txtAjuda.setText(Html.fromHtml(textoEmHtml, null, null));

        return view;
    }
}