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
                "<html><body lang=\"pt-BR\" text=\"#00000a\" dir=\"ltr\">\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<span style=\"background: #ffffff\">O objetivo geral do projeto é\n" +
                        "predizer a espessura de gordura subcutânea (EGS), para se obter um\n" +
                        "ótimo momento de abate, utilizando o peso corporal e medidas de\n" +
                        "pregas cutâneas.</span></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<span style=\"background: #ffffff\">O adipômetro, ou plicômetro, é\n" +
                        "um equipamento que serve para medir a espessura do tecido adiposo do\n" +
                        "corpo. Essas medidas podem ser colocadas em algumas equações, e\n" +
                        "servem para calcular o percentual de espessura de gordura subcutânea\n" +
                        "(EGS).</span></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<span style=\"background: #ffffff\">Para resposta utilizamos cotes na\n" +
                        "ordem crescente de acumulo de gordura</span>:</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<span style=\"background: #dddddd\"><font color=\"#ed7d31\"> <b>LARANJA\n" +
                        "(&lt; 1 mm)</b></font></span></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<span style=\"background: #dddddd\"><font color=\"#ffff00\"><b>AMARELO (\n" +
                        "&gt;= 1 &lt; 2 mm)</b></font></span></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<span style=\"background: #dddddd\"><font color=\"#00b050\"><b>VERDE\n" +
                        "(&gt;=2&lt;=3 mm)</b></font></span></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<span style=\"background: #dddddd\"><font color=\"#ff0000\"><b>VERMELHO\n" +
                        "(&gt;3 mm)</b></font></span></p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "Lembrando que tais padrões dependem do mercado consumidor, estes\n" +
                        "utilizados baseiam-se no acabamento mínimo necessário para uma boa\n" +
                        "proteção da carcaça durante o resfriamento e gordura suficiente na\n" +
                        "carne para os padrões brasileiros.</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "</body></html>";

        txtAjuda.setText(Html.fromHtml(textoEmHtml, null, null));

        return view;
    }
}