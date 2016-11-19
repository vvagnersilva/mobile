package br.gov.dprf.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.gov.dprf.R;

public class MultasFragment extends Fragment {
    private static final String TAG = "DPRF";
    private static final String EXTRA_TIPO = "mTipo";

    private RadioGroup group;
    private EditText edPlaca;
    private EditText edRenavam;
    private ImageView btConsultar;
    private ImageView btFavoritos;
    private Boolean isVeiculoEstrangeiro;
    private View view;

    public static MultasFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);

        MultasFragment f = new MultasFragment();

        f.setArguments(params);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.multas_fragment, container, false);

        // Indica que este fragment deve preservar o seu estado.
        setRetainInstance(true);

        edPlaca = (EditText) view.findViewById(R.id.edPlaca);
        edRenavam = (EditText) view.findViewById(R.id.edRenavam);

        group = (RadioGroup) view.findViewById(R.id.rgOpcoes);

        // Evento do RadioGroup.
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                isVeiculoEstrangeiro = R.id.radioVeiculoEstrangeiro == checkedId;

            }
        });

        btConsultar = (ImageView) view.findViewById(R.id.btConsultar);

        // Evento onClick do botao calcular egs.
        btConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validaCamposObrigatorios()) {
                    //String placa = edPlaca.getText().toString();
                    //String renavam = edRenavam.getText().toString();

                    ImageView imgMultas = (ImageView) view.findViewById(R.id.imgMultas);

                    imgMultas.setVisibility(View.VISIBLE);

                    imgMultas.setImageResource(R.drawable.comprovante_multa);
                }
            }
        });

        btFavoritos = (ImageView) view.findViewById(R.id.btFavoritos);

        // Evento onClick do botao calcular egs.
        btFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placa = edPlaca.getText().toString();
                String renavam = edRenavam.getText().toString();

                if (placa.length() > 0 && renavam.length() > 0) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setIcon(R.drawable.ic_alert_outline_white_48dp);
                    alertDialogBuilder.setTitle(R.string.favoritos);
                    alertDialogBuilder.setMessage(getString(R.string.msg_favoritos));

                    //define um botão sim.
                    alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(getContext(), "Sim = " + arg1, Toast.LENGTH_SHORT).show();
                        }
                    });

                    //define um botão nao.
                    alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(getContext(), "Não = " + arg1, Toast.LENGTH_SHORT).show();
                        }
                    });

                    alertDialogBuilder.show();

                }
            }
        });


        return view;
    }

    private boolean validaCamposObrigatorios() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), R.style.AlertDialogStyle);

        if (edPlaca.getText().length() == 0) {
            String peso = getString(R.string.obr_placa);
            edPlaca.setError(peso);
            return true;
        }

        if (edRenavam.getText().length() == 0) {
            String pregas = getString(R.string.obr_renavam);
            edRenavam.setError(pregas);
            return true;
        }

        return false;
    }
}