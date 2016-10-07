package br.edu.ufgd.fragment;

import android.content.Context;
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

import br.edu.ufgd.R;
import br.edu.ufgd.enums.TipoAssuntoEnum;
import br.edu.ufgd.utils.Constantes;


public class FaleConoscoFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private static final String TAG = "SlaughterPointLambs";
    private Spinner spAssunto;
    private EditText edDescricao;
    private TipoAssuntoEnum tpAssunto;
    private Button btFaleConosco;

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

                // String selectedItem = (String) spCategoria.getItemAtPosition(position);

                if (position == 0) {
                    tpAssunto = null;
                } else if (Integer.parseInt(TipoAssuntoEnum.DUVIDAS.getCodigo()) == position) {
                    tpAssunto = TipoAssuntoEnum.DUVIDAS;
                } else if (Integer.parseInt(TipoAssuntoEnum.ELOGIOS.getCodigo()) == position) {
                    tpAssunto = TipoAssuntoEnum.ELOGIOS;
                } else if (Integer.parseInt(TipoAssuntoEnum.SUGESTOES.getCodigo()) == position) {
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
                    email.putExtra(Intent.EXTRA_CC, new String[]{"ovinotecnia.ufgd@gmail.com"});
                    //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                    email.putExtra(Intent.EXTRA_SUBJECT, subject);
                    email.putExtra(Intent.EXTRA_TEXT, edDescricao.getText().toString());

                    //need this to prompts email client only
                    email.setType("message/rfc822");

                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                }
            }
        });

        return view;
    }

    private boolean validaCamposObrigatorios() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), R.style.AlertDialogStyle);

        alertDialogBuilder.setTitle("Informação");
        alertDialogBuilder.setIcon(R.drawable.ic_information);

        if (tpAssunto == null) {
            alertDialogBuilder.setMessage("Campo assunto é de preenchimento obrigatório!");
            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();

            return true;
        }

        if (edDescricao.getText().length() == 0) {
            edDescricao.setError("Descrição é de preenchimento obrigatório!");
            return true;
        }
        return false;
    }
}