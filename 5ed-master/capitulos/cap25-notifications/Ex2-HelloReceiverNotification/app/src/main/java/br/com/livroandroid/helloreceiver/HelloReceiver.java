package br.com.livroandroid.helloreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Ricardo Lecheta on 08/03/2015.
 */
public class HelloReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("livroandroid", "HelloReceiver !!!");

        Intent notifIntent = new Intent(context,MainActivity.class);
        String msg = intent.getStringExtra("msg");
        notifIntent.putExtra("msg", msg);

        NotificationUtil.notify(context,1,notifIntent,"Texto digitado",msg);
    }
}
