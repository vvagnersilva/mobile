package br.marcha.jesus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;

import br.marcha.jesus.R;

public class AgendaFragment extends Fragment {
	private WebView mWebView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.agenda_fragment, container,false);

		mWebView = (WebView) view.findViewById(R.id.webView);
		mWebView.loadUrl("https://www.instagram.com/marchaparajesus");

		// Enable Javascript
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);

		// Force links and redirects to open in the WebView instead of in a browser
		mWebView.setWebViewClient(new WebViewClient());

		return view;
	}
}