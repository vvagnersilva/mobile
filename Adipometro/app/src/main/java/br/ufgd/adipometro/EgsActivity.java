package br.ufgd.adipometro;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EgsActivity extends AppCompatActivity {
    protected static final String TAG = "Adipometro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egs);

        Bundle args = getIntent().getExtras();

        Double egs = args.getDouble("egs");
        String formula = args.getString("formula");

        // Setando os labels na tela.
        TextView txFormula = (TextView) findViewById(R.id.tFormula);
        txFormula.setText(formula);

        TextView txEgs = (TextView) findViewById(R.id.tEgs);
        txEgs.setText("EGS = " + egs.toString());

        setBackground(egs, txFormula, txEgs);

        // Adiciona o botão "up navigation"
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Intervalos da variavel egs setando as cores.
     *
     * @param egs
     * @param txFormula
     * @param txEgs
     */
    public void setBackground(Double egs, TextView txFormula, TextView txEgs) {

        LinearLayout ll = (LinearLayout) findViewById(R.id.llResultado);

        if (egs < 1) {
            txFormula.setTextColor(Color.WHITE);
            txEgs.setTextColor(Color.WHITE);
            ll.setBackgroundResource(R.drawable.background_laranja);
        } else if (egs >= 1 && egs < 2) {
            txFormula.setTextColor(Color.BLACK);
            txEgs.setTextColor(Color.BLACK);
            ll.setBackgroundResource(R.drawable.background_amarelo);
        } else if (egs >=2 && egs < 3) {
            txFormula.setTextColor(Color.BLACK);
            txEgs.setTextColor(Color.BLACK);
            ll.setBackgroundResource(R.drawable.background_verde);
        } else if (egs >= 3) {
            txFormula.setTextColor(Color.WHITE);
            txEgs.setTextColor(Color.WHITE);
            ll.setBackgroundResource(R.drawable.background_vermelho);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, getClassName() + "\tonDestroy chamado.");
    }

    public String getClassName() {
        // Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // O método finish() vai encerrar essa activity
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
