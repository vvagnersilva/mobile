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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ajuda_fragment, container,false);

		TextView txtAjuda = (TextView) view.findViewById(R.id.txtAjuda);

		final String textoEmHtml =
				"<html><body lang=\"pt-BR\" dir=\"ltr\">\n" +
						"<p align=\"justify\" style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<font face=\"Purisa\"><font size=\"3\" style=\"font-size: 12pt\">O\n" +
						"principal objetivo do projeto é obter um momento ótimo de abate\n" +
						"utilizando medidas do peso do animal, a condição corporal (cc) e a\n" +
						"medida da prega.</font></font></p>\n" +
						"<p align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"Purisa\"><font size=\"3\" style=\"font-size: 12pt\"><span style=\"font-weight: normal\">Para\n" +
						"resposta a intenção é utilizar cores indicando animal pronto para\n" +
						"abate (verde) intermediário (amarelo) animal inadequado para abate\n" +
						"(vermelho) e animal inadequado por excesso (laranja).</span></font></font></p>\n" +
						"<p align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"Purisa\"><font size=\"3\" style=\"font-size: 12pt\"><span style=\"font-weight: normal\">Verde:\n" +
						"entre valor x e y </span></font></font>\n" +
						"</p>\n" +
						"<p align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"Purisa\"><font size=\"3\" style=\"font-size: 12pt\"><span style=\"font-weight: normal\">Amarelo:\n" +
						"intervalo entre x e y </span></font></font>\n" +
						"</p>\n" +
						"<p align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"Purisa\"><font size=\"3\" style=\"font-size: 12pt\"><span style=\"font-weight: normal\">Laranja\n" +
						"entre y e z</span></font></font></p>\n" +
						"<p style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<br/>\n" +
						"\n" +
						"</p>\n" +
						"<p style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<br/>\n" +
						"\n" +
						"</p>\n" +
						"</body></html>";

		txtAjuda.setText(Html.fromHtml(textoEmHtml, null, null));

		return view;
	}
}