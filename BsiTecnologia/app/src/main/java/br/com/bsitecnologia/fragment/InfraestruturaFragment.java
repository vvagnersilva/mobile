package br.com.bsitecnologia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

import br.com.bsitecnologia.MainActivity;
import br.com.bsitecnologia.R;
import br.com.bsitecnologia.enums.TipoSedeEnum;
import br.com.bsitecnologia.mapas.LocalizacaoActivity;

public class InfraestruturaFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private static final String TAG = "Bsi Tecnologia";

    private String mTipo;
    private Double latitude;
    private Double longitude;

    private TipoSedeEnum tpSedeEnum;

    private Spinner spFiliais;

    public static InfraestruturaFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);

        InfraestruturaFragment f = new InfraestruturaFragment();
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
                R.string.infraestrutura);

        View view = inflater.inflate(R.layout.infraestrutura_fragment, container, false);

        TextView htmlTextView1 = (TextView) view.findViewById(R.id.txInfra);
        htmlTextView1.setText(Html.fromHtml(getString(R.string.txInfra)));

        spFiliais = (Spinner) view.findViewById(R.id.spFiliais);

        spFiliais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemSelected");

                if (position != 0) {
                    if (position == 1) {
                        tpSedeEnum = TipoSedeEnum.MATRIZ;
                        latitude = -23.5489881;
                        longitude = -46.63753;
                    } else if (position == 2) {
                        tpSedeEnum = TipoSedeEnum.ALPHAVILLE;
                        latitude = -23.4846585;
                        longitude = -46.8574703;
                    } else if (position == 3) {
                        tpSedeEnum = TipoSedeEnum.RIO_JANEIRO;
                        latitude = -22.9019265;
                        longitude = -43.1820116;
                    } else if (position == 4) {
                        tpSedeEnum = TipoSedeEnum.BRASILIA;
                        latitude = -15.8261489;
                        longitude = -47.9569127;
                    }

                    Intent it = new Intent(getContext(), LocalizacaoActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("latitude", latitude);
                    bundle.putSerializable("longitude", longitude);
                    bundle.putParcelable("sede", tpSedeEnum);

                    it.putExtras(bundle);

                    startActivity(it);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return view;
    }
}