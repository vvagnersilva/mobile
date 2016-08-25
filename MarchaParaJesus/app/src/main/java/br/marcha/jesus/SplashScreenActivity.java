package br.marcha.jesus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    // Timer da splash screen
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Exibe o layout com a imagem...
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);

                // Inicia a MainActivity
                startActivity(i);
                // Fecha a activity da splash
                finish();
            }
        }, SPLASH_TIME_OUT); // delay de 3 segundos
    }
}
