package br.ufgd.adipometro;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import br.ufgd.adipometro.ufgd.strategy.Egs;
import br.ufgd.adipometro.ufgd.strategy.Cauda;

public class MainActivity extends android.support.v7.app.AppCompatActivity {

    private boolean isCheckedTipoPlicometro;
    private static final String TAG = "Adipometro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Adipômetro");
        actionBar.setIcon(R.drawable.logo_ufgd);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // Cria as tabs (Passa como parâmetro o índice de cada tab: 1,2,3)

        ActionBar.Tab tab1 = actionBar.newTab();

        tab1.setText("Calda").setTabListener(new MyTabListener(this, 1));

        actionBar.addTab(tab1);

        //actionBar.addTab(actionBar.newTab().setText("Tab 2").setTabListener(new MyTabListener(this, 2)));
        //actionBar.addTab(actionBar.newTab().setText("Tab 3").setTabListener(new MyTabListener(this, 3)));

        Switch tipoPlicometro = (Switch) findViewById(R.id.tipoPlicometro);
        tipoPlicometro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                isCheckedTipoPlicometro = isChecked;

                Log.v("Switch State=", "" + isCheckedTipoPlicometro);
            }
        });
    }

    public void onClickCalcularEgs(View view) {
        try {
            TextView tPeso = (TextView)
                    findViewById(R.id.edPeso);

            TextView tCa = (TextView)
                    findViewById(R.id.edCa);

            TextView tCc = (TextView)
                    findViewById(R.id.edCc);

            if (tPeso.getText().length() == 0 && tCa.getText().length() == 0 && tCc.getText().length() == 0) {
                alert("Pelo menos um campo deve ser informado.");
                return;
            }

            double peso = tPeso.getText().length() == 0 ? 0 : Double.parseDouble(tPeso.getText().toString());
            double ca = tCa.getText().length() == 0 ? 0 : Double.parseDouble(tCa.getText().toString());
            double cc = tCc.getText().length() == 0 ? 0 : Double.parseDouble(tCc.getText().toString());

            // Implementar calculos p/ peito e costas.
            Egs egs = new Cauda(peso, ca, cc, isCheckedTipoPlicometro);

            // Navega para a próxima tela
            Intent intent = new Intent(this, EgsActivity.class);
            Bundle params = new Bundle();

            params.putDouble("peso", peso);
            params.putDouble("ca", ca);
            params.putDouble("cc", cc);
            params.putDouble("egs", egs.CalcularEgs());
            params.putString("formula", egs.getStrFormulaUtilizada());

            intent.putExtras(params);

            startActivity(intent);
        } catch (NumberFormatException ex) {
            Log.e(TAG, getClassName() + ex.getStackTrace());
        } catch (Exception ex) {
            Log.e(TAG, getClassName() + ex.getStackTrace());
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botões da action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // SearchView
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(onSearch());

        return true;
    }

    // Intent que define o conteúdo que será compartilhado
    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar");
        return intent;
    }

    private SearchView.OnQueryTextListener onSearch() {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                toast("Buscar o texto: " + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            toast("Clicou no Search!");
            return true;
        } else if (id == R.id.action_refresh) {
            toast("Clicou no Refresh!");
            return true;
        } else if (id == R.id.action_settings) {
            toast("Clicou no Settings!");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public String getClassName() {
        // Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}