package br.gov.dprf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AberturaActivity extends Activity {
    // Timer da splash screen
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Exibe o layout com a imagem...
        setContentView(R.layout.activity_abertura);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                Intent i = new Intent(AberturaActivity.this, MainActivity.class);

                // Inicia a MainActivity
                startActivity(i);
                // Fecha a activity da splash
                finish();
            }
        }, SPLASH_TIME_OUT); // delay de 3 segundos
    }
}