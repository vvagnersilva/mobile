package br.marcha.jesus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.marcha.jesus.R;

public class SobreFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.sobre_fragment, container,false);

		return view;
	}
}