package br.marcha.jesus.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.marcha.jesus.R;

public class VideosFragment extends Fragment {
	private static final String EXTRA_TIPO = "mTipo";

	public static PaypalFragment novaInstancia(String tipo) {
		Bundle params = new Bundle();
		params.putString(EXTRA_TIPO, tipo);
		PaypalFragment f = new PaypalFragment();
		f.setArguments(params);
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.videos_fragment, container,false);
		return view;
	}
}
