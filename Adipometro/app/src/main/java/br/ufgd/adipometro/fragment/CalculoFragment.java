package br.ufgd.adipometro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.ufgd.adipometro.R;

public class CalculoFragment extends Fragment {
	private static final String EXTRA_TIPO = "mTipo";

	public static CalculoFragment novaInstancia(String tipo) {
		Bundle params = new Bundle();
		params.putString(EXTRA_TIPO, tipo);
		CalculoFragment f = new CalculoFragment();
		f.setArguments(params);
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.calculo_fragment, container,false);
		return view;
	}
}