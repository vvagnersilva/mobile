package dominando.android.adapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Carro> carros;
    CarrosAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        listView.setEmptyView(findViewById(android.R.id.empty));

        // 0=VW;1=GM;2=Fiat;3=Ford
        carros = new ArrayList<Carro>();
//        for (int i = 0; i < 10; i++) {
            carros.add(new Carro("Celta", 2010, 1, true, false));
            carros.add(new Carro("Uno", 2012, 2, true, true));
            carros.add(new Carro("Fiesta", 2009, 3, false, true));
            carros.add(new Carro("Gol", 2014, 0, true, true));
//        }
        adapter = new CarrosAdapter(this, carros);


        final int PADDING = 8;
        TextView txtHeader = new TextView(this);
        txtHeader.setBackgroundColor(Color.GRAY);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText(R.string.texto_cabecalho);
        txtHeader.setPadding(PADDING, PADDING, 0, PADDING);
        listView.addHeaderView(txtHeader);
        final TextView txtFooter = new TextView(this);
        txtFooter.setText(getResources().getQuantityString(
                R.plurals.texto_rodape,
                adapter.getCount(),
                adapter.getCount()));
        txtFooter.setBackgroundColor(Color.LTGRAY);
        txtFooter.setGravity(Gravity.RIGHT);
        txtFooter.setPadding(0, PADDING, PADDING, PADDING);
        listView.addFooterView(txtFooter);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                Carro carro = (Carro) adapterView.getItemAtPosition(position);
                if (carro != null) {
                    Toast.makeText(MainActivity.this, carro.modelo + "-" + carro.ano,
                            Toast.LENGTH_SHORT).show();
                    carros.remove(carro);
                    adapter.notifyDataSetChanged();

                    txtFooter.setText(getResources().getQuantityString(
                            R.plurals.texto_rodape,
                            adapter.getCount(),
                            adapter.getCount()));
                }
            }
        });
    }
}

