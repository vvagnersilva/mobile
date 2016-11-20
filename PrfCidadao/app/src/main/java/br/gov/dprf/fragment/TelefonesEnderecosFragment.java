package br.gov.dprf.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import br.gov.dprf.MainActivity;
import br.gov.dprf.adapter.CustomAdapter;
import br.gov.dprf.R;

public class TelefonesEnderecosFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String EXTRA_TIPO = "mTipo";

    String[] estados = {"Selecione um estado", "Distrito Federal","Pernambuco","São Paulo","Rio de Janeiro",};

    /*
        int flags[] = {R.drawable.ac, R.drawable.al, R.drawable.am, R.drawable.ap, R.drawable.ba, R.drawable.ce, R.drawable.df,
                R.drawable.es, R.drawable.go, R.drawable.ma, R.drawable.mg, R.drawable.ms, R.drawable.mt, R.drawable.pa, R.drawable.pb,
                R.drawable.pe, R.drawable.pi, R.drawable.pr, R.drawable.rj, R.drawable.rn, R.drawable.ro, R.drawable.rr, R.drawable.rs,
                R.drawable.sc, R.drawable.se, R.drawable.sp, R.drawable.to};
    */
    int flags[] = {R.drawable.ic_help_black_18dp, R.drawable.df, R.drawable.pe, R.drawable.sp, R.drawable.rj};

    private View view;

    public static TelefonesEnderecosFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        TelefonesEnderecosFragment f = new TelefonesEnderecosFragment();
        f.setArguments(params);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Setando o titulo no toolbar.
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(
                R.string.contatos);

        view = inflater.inflate(R.layout.contatos_fragment, container, false);

        Spinner spEstados = (Spinner) view.findViewById(R.id.spEstados);
        spEstados.setOnItemSelectedListener(this);

        CustomAdapter customAdapter = new CustomAdapter(getContext(), flags, estados);
        spEstados.setAdapter(customAdapter);

        return view;
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        ImageView imgContatos = (ImageView) view.findViewById(R.id.imgContatos);

        switch (position) {
            case 0:
                imgContatos.setVisibility(view.INVISIBLE);
                break;
            case 1: // DF
                imgContatos.setImageResource(R.drawable.comprovante_df);
                imgContatos.setVisibility(view.VISIBLE);
                break;
            case 2: //PE
                imgContatos.setImageResource(R.drawable.comprovante_pe);
                imgContatos.setVisibility(view.VISIBLE);
                break;
            case 3: // SP
                imgContatos.setImageResource(R.drawable.comprovante_sp);
                imgContatos.setVisibility(view.VISIBLE);
                break;
            case 4: // RJ
                imgContatos.setImageResource(R.drawable.comprovante_rj);
                imgContatos.setVisibility(view.VISIBLE);
                break;
            default:

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}

