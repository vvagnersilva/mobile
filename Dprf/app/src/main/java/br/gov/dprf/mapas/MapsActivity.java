package br.gov.dprf.mapas;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.gov.dprf.R;
import br.gov.dprf.utils.Constantes;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng latllng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Adicionando os marcadores mais proximos.
        latllng = new LatLng(-15.8675751,-48.2364753);
        mMap.addMarker(new MarkerOptions().position(latllng).title(getString(R.string.marker_title)).icon(BitmapDescriptorFactory.fromResource(R.drawable.mini_brasao)))
                .setSnippet(getString(R.string.marker_snippet));

        latllng = new LatLng(-15.7775691,-48.0334159);
        mMap.addMarker(new MarkerOptions().position(latllng).title(getString(R.string.marker_title)).icon(BitmapDescriptorFactory.fromResource(R.drawable.mini_brasao)))
                .setSnippet(getString(R.string.marker_snippet));

        latllng = new LatLng(-15.8151472,-48.0144473);
        mMap.addMarker(new MarkerOptions().position(latllng).title(getString(R.string.marker_title)).icon(BitmapDescriptorFactory.fromResource(R.drawable.mini_brasao)))
                .setSnippet(getString(R.string.marker_snippet));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latllng));
        mMap.animateCamera( CameraUpdateFactory.zoomTo(8.0f)) ;

        Integer nr_postos = 3;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        StringBuilder title = new StringBuilder();

        title.append(nr_postos).append(Constantes.HIFEN_ESPACO).append(getString(R.string.pontos_mapa));

        toolbar.setTitle(title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
