package br.marcha.jesus;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class InternetActivity extends AppCompatActivity {

    // Timer da splash screen
    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Exibe o layout com a imagem...
        setContentView(R.layout.activity_internet_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Fecha a activity da splash
                finish();
            }
        }, SPLASH_TIME_OUT); // delay de 2 segundos
    }
}
