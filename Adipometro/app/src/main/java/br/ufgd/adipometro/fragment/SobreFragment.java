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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.sobre_fragment, container,false);

		TextView txtParticipantes = (TextView) view.findViewById(R.id.txtParticipantes);

		final String textoEmHtml =
				"<html><body lang=\"pt-BR\" dir=\"ltr\">\n" +
						"<p style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<font face=\"Purisa\">Adrielly – Bacharel em Zootecnia – Universidade Federal de Grandes Dourados - UFGD</font></p>\n" +
						"<p style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<font face=\"Purisa\">Marcelo Correa da Silva - Mestre e Doutor em\n" +
						"Ciência Animal - Professor Colaborador Voluntário UFGD/FCA/Zootecnia</font></p>\n" +
						"<p style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<font face=\"Purisa\">Wagner Silva – Bacharel em Ciência da\n" +
						"Computação - Universidade Federal de Lavras - UFLA</font></p>\n" +
						"<p style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<br/>\n" +
						"\n" +
						"</p>\n" +
						"<p style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<br/>\n" +
						"\n" +
						"</p>\n" +
						"<p style=\"margin-bottom: 0cm; font-weight: normal; line-height: 100%\">\n" +
						"<br/>\n" +
						"\n" +
						"</p>\n" +
						"</body></html>";

		txtParticipantes.setText(Html.fromHtml(textoEmHtml, null, null));

		return view;
	}
}