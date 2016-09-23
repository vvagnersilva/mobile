package br.ufgd.adipometro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import br.ufgd.adipometro.R;

public class FotosFragment extends Fragment {
    private static final String TAG = "Adipometro";
    private static final String EXTRA_TIPO = "mTipo";
    private ListView mListView;
    private ProgressBar mProgressBar;

    public static FotosFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        FotosFragment f = new FotosFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_images_fragment, container, false);

        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        mListView = (ListView) view.findViewById(R.id.listView);


        return view;
    }
}