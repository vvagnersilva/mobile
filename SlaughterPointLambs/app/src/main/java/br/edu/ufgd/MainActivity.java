package br.edu.ufgd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ufgd.enums.TipoCategoriaAnimalEnum;
import br.edu.ufgd.fragment.AjudaFragment;
import br.edu.ufgd.fragment.CalculoFragment;
import br.edu.ufgd.fragment.FaleConoscoFragment;
import br.edu.ufgd.fragment.FotosFragment;
import br.edu.ufgd.fragment.SobreFragment;
import br.edu.ufgd.fragment.WebFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SlaughterPointLambs";

    private static TipoCategoriaAnimalEnum tpCategoriaAnimal;
    private CalculoFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_sigla);
        setSupportActionBar(toolbar);

        // Fragment default.
        fragment = CalculoFragment.novaInstancia("CalculoFragment");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, fragment, "CalculoFragment")
                .commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botões da action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String titulo = item.getTitle().toString();
        int id = item.getItemId();
        Fragment frag = null;

        if (id == R.id.action_calculo) {
            tpCategoriaAnimal = null;
            frag = CalculoFragment.novaInstancia(titulo);
        } else if (id == R.id.action_ufgd) {
            frag = WebFragment.novaInstancia(titulo);
        } else if (id == R.id.action_fale_conosco) {
            frag = FaleConoscoFragment.novaInstancia(titulo);
        } else if (id == R.id.action_ajuda) {
            frag = AjudaFragment.novaInstancia(titulo);
        } else if (id == R.id.action_sobre) {
            frag = SobreFragment.novaInstancia(titulo);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteudo, frag, titulo)
                .commit();

        return super.onOptionsItemSelected(item);
    }
}