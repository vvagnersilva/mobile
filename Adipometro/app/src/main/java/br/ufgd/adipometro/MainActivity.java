package br.ufgd.adipometro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.ufgd.adipometro.enums.TipoCategoriaAnimalEnum;
import br.ufgd.adipometro.fragment.AjudaFragment;
import br.ufgd.adipometro.fragment.CalculoFragment;
import br.ufgd.adipometro.fragment.FaleConoscoFragment;
import br.ufgd.adipometro.fragment.FotosFragment;
import br.ufgd.adipometro.fragment.SobreFragment;
import br.ufgd.adipometro.fragment.WebFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Adipometro";

    private static TipoCategoriaAnimalEnum tpCategoriaAnimal;
    private CalculoFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        } else if (id == R.id.action_fotos) {
            frag = FotosFragment.novaInstancia(titulo);
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