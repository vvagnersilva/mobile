package br.ufgd.adipometro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;

import br.ufgd.adipometro.R;
import br.ufgd.adipometro.utils.TipoMedidaEnum;

public class ImagemFragment extends Fragment {
    private static final String TAG = "Adipometro";
    private static final String EXTRA_TIPO = "mTipo";
    private ListView mListView;
    private ProgressBar mProgressBar;

    public static ImagemFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        ImagemFragment f = new ImagemFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_images_fragment, container, false);

        mProgressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        mListView = (ListView)view.findViewById(R.id.listView);


        return view;
    }
}