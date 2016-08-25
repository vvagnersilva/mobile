package br.com.alura.agenda.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;

/**
 * Created by renan on 13/01/16.
 */
public class SMSReceiver extends BroadcastReceiver {
    protected static final String TAG = "SMSReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // PDU representa uma mensagem e pode ter varios pdus.
        Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
        byte[] pdu = (byte[]) pdus[0];
        String formato = (String) intent.getSerializableExtra("format");

        SmsMessage sms = SmsMessage.createFromPdu(pdu, formato);

        Log.e(TAG, getClassName() + "\tSMSReceiver chamado 1.");

        String telefone = sms.getDisplayOriginatingAddress();

        Log.e(TAG, getClassName() + "\tSMSReceiver telefone = " + telefone);

        AlunoDAO dao = new AlunoDAO(context);
        if (dao.ehAluno(telefone)) {
            Log.e(TAG, getClassName() + "\tSMSReceiver chamado 2.");
            Toast.makeText(context, "Chegou um SMS de Aluno!", Toast.LENGTH_SHORT).show();
            MediaPlayer mp = MediaPlayer.create(context, R.raw.msg);
            mp.start();
        }
        dao.close();
    }

    public String getClassName() {
        // Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}
