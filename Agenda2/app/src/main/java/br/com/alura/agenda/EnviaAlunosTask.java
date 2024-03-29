package br.com.alura.agenda;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.alura.agenda.converter.AlunoConverter;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.modelo.Aluno;

/**
 * Created by renan on 20/01/16.
 *
 * Verificar tipos de parametros na assinatura AsyncTask<Void, Void, String>
 *     1o parametro para passar dados p/ o metodo doInBackground.
 */
public class EnviaAlunosTask extends AsyncTask<Void, Void, String> {
    private Context context;
    private ProgressDialog dialog;

    public EnviaAlunosTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Enviando alunos...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {
        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        AlunoConverter conversor = new AlunoConverter();
        String json = conversor.converteParaJSON(alunos);

        WebClient client = new WebClient();
        String resposta = client.post(json);
        return resposta;
    }

    /**
     * Executado na Thread principal
     *
     * A resposta do metodo doInBackground eh recebida como parametro na funcao onPostExecute.
     */
    @Override
    protected void onPostExecute(String resposta) {
        // Remover o dialog da tela.
        dialog.dismiss();

        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}
