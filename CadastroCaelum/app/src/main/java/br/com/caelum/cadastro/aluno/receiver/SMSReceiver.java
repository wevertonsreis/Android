package br.com.caelum.cadastro.aluno.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import br.com.caelum.cadastro.aluno.dao.AlunoDAO;
import br.com.caelum.cadastro.comum.helper.DBHelper;
import br.com.caelum.cadastrocaelum.R;


/**
 * Created by Weverton on 18/02/2016.
 */
public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        Object[] mensagens =(Object[]) bundle.get("pdus");
        byte[] mensagem = (byte[]) mensagens[0];

        SmsMessage smsMessage = SmsMessage.createFromPdu(mensagem);

        DBHelper dbHelper = new DBHelper(context);
        AlunoDAO alunoDAO = new AlunoDAO(dbHelper);

        boolean numeroAluno = alunoDAO.isAluno(smsMessage.getDisplayOriginatingAddress());
        if (numeroAluno){
            Toast.makeText(context,"Mensagem = " + smsMessage.getDisplayMessageBody(), Toast.LENGTH_SHORT).show();
            MediaPlayer mp = MediaPlayer.create(context, R.raw.musica_teste);
            mp.start();
        }
    }
}
