package br.edu.pantaneiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.edu.pantaneiro.model.MediaAritmeticaDesvioPadrao;
import br.edu.pantaneiro.model.Morfometricas;

public class RelIndividualActivity extends AppCompatActivity {

    private static final String TAG = "RelIndividualActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_relatorio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.avaliacao_relatorio);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        MediaAritmeticaDesvioPadrao mediaDesvio = intent.getExtras().getParcelable("mediaDesvio");
        Morfometricas morfometrica = intent.getExtras().getParcelable("morfometrica");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
