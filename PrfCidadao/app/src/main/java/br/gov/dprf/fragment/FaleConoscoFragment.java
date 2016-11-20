package br.gov.dprf.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import br.gov.dprf.R;
import br.gov.dprf.enums.TipoAssuntoEnum;
import br.gov.dprf.utils.Constantes;

public class FaleConoscoFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private static final String TAG = "FaleConoscoFragment";
    private Spinner spAssunto;
    private EditText edDescricao;
    private Button btFaleConosco;
    private TipoAssuntoEnum tpAssunto;

    public static FaleConoscoFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        FaleConoscoFragment f = new FaleConoscoFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fale_conosco, container, false);

        // Indica que este fragment deve preservar o seu estado.
        setRetainInstance(true);

        spAssunto = (Spinner) view.findViewById(R.id.spAssunto);

        spAssunto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    tpAssunto = null;
                } else if (position == 1) {
                    tpAssunto = TipoAssuntoEnum.DUVIDAS;
                } else if (position == 2) {
                    tpAssunto = TipoAssuntoEnum.ELOGIOS;
                } else if (position == 3) {
                    tpAssunto = TipoAssuntoEnum.SUGESTOES;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btFaleConosco = (Button) view.findViewById(R.id.btFaleConosco);

        btFaleConosco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edDescricao = (EditText) getView().findViewById(R.id.edDescricao);

                if (!validaCamposObrigatorios()) {

                    String subject = Constantes.ABRE_COLCHETES + getActivity().getTitle() + Constantes.FECHA_COLCHETES + "\t" + tpAssunto.getDescricao();

                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_CC, new String[]{"ouvidoria@dprf.gov.br"});
                    //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                    email.putExtra(Intent.EXTRA_SUBJECT, subject);
                    email.putExtra(Intent.EXTRA_TEXT, edDescricao.getText().toString());

                    //need this to prompts email client only
                    email.setType("message/rfc822");

                    String msg_email = getString(R.string.msg_email);

                    startActivity(Intent.createChooser(email, msg_email));
                }
            }
        });

        return view;
    }

    private boolean validaCamposObrigatorios() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        alertDialogBuilder.setTitle(R.string.informacao);
        alertDialogBuilder.setIcon(R.drawable.information_outline);

        if (tpAssunto == null) {
            String info = getString(R.string.info_obrigatorio);
            alertDialogBuilder.setMessage(info);
            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();

            return true;
        }

        if (edDescricao.getText().length() == 0) {
            String desc = getString(R.string.desc_obrigatorio);
            edDescricao.setError(desc);
            return true;
        }
        return false;
    }
}