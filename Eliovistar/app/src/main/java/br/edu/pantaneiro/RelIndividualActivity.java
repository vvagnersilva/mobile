package br.edu.pantaneiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import br.edu.pantaneiro.enums.TipoSexoEnum;
import br.edu.pantaneiro.model.MediaAritmeticaDesvioPadrao;
import br.edu.pantaneiro.model.Morfometricas;

public class RelIndividualActivity extends AppCompatActivity {

    private static final String TAG = "RelIndividualActivity";
    private Morfometricas morfometrica;
    private MediaAritmeticaDesvioPadrao mediaDesvio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_relatorio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.rel_aval_individual);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        mediaDesvio = intent.getExtras().getParcelable("medias");
        morfometrica = intent.getExtras().getParcelable("morfometricas");

        ImageView imgScoreCorporal = (ImageView) findViewById(R.id.imgScoreCorporal);
        defineCores(imgScoreCorporal, morfometrica.getScoreCorporal(), mediaDesvio.getDesvioScoreCorporal(), mediaDesvio.getMediaScoreCorporal());

        ImageView imgPesoVivo = (ImageView) findViewById(R.id.imgPesoVivo);
        defineCores(imgPesoVivo, morfometrica.getPesoVivo(), mediaDesvio.getDesvioPesoVivo(), mediaDesvio.getMediaPesoVivo());

        ImageView imgCompCabeca = (ImageView) findViewById(R.id.imgCompCabeca);
        defineCores(imgCompCabeca, morfometrica.getCompCabeca(), mediaDesvio.getDesvioCompCabeca(), mediaDesvio.getMediaCompCabeca());

        ImageView imgCompCranio = (ImageView) findViewById(R.id.imgCompCranio);
        defineCores(imgCompCranio, morfometrica.getCompCranio(), mediaDesvio.getDesvioCompCranio(), mediaDesvio.getMediaCompCranio());

        ImageView imgLargCabeca = (ImageView) findViewById(R.id.imgLargCabeca);
        defineCores(imgLargCabeca, morfometrica.getLargCabeca(), mediaDesvio.getDesvioLargCabeca(), mediaDesvio.getMediaLargCabeca());

        ImageView imgLongRosto = (ImageView) findViewById(R.id.imgLongRosto);
        defineCores(imgLongRosto, morfometrica.getLongRosto(), mediaDesvio.getDesvioLongRosto(), mediaDesvio.getMediaLongRosto());

        ImageView imgTamOrelhas = (ImageView) findViewById(R.id.imgTamOrelhas);
        defineCores(imgTamOrelhas, morfometrica.getTamOrelhas(), mediaDesvio.getDesvioTamOrelhas(), mediaDesvio.getMediaTamOrelhas());

        ImageView imgPerimPescoco = (ImageView) findViewById(R.id.imgPerimPescoco);
        defineCores(imgPerimPescoco, morfometrica.getPerimPescoco(), mediaDesvio.getDesvioPerimPescoco(), mediaDesvio.getMediaPerimPescoco());

        ImageView imgCompPescoco = (ImageView) findViewById(R.id.imgCompPescoco);
        defineCores(imgCompPescoco, morfometrica.getCompPescoco(), mediaDesvio.getDesvioCompPescoco(), mediaDesvio.getMediaCompPescoco());

        ImageView imgCompCorporal = (ImageView) findViewById(R.id.imgCompCorporal);
        defineCores(imgCompCorporal, morfometrica.getCompCorporal(), mediaDesvio.getDesvioCompCorporal(), mediaDesvio.getMediaCompCorporal());

        ImageView imgProfundidade = (ImageView) findViewById(R.id.imgProfundidade);
        defineCores(imgProfundidade, morfometrica.getProfundidade(), mediaDesvio.getDesvioProfundidade(), mediaDesvio.getMediaProfundidade());

        ImageView imgLargOmbros = (ImageView) findViewById(R.id.imgLargOmbros);
        defineCores(imgLargOmbros, morfometrica.getLargOmbros(), mediaDesvio.getDesvioLargOmbros(), mediaDesvio.getMediaLargOmbros());

        ImageView imgPerimToracico = (ImageView) findViewById(R.id.imgPerimToracico);
        defineCores(imgPerimToracico, morfometrica.getPerimToracico(), mediaDesvio.getDesvioPerimToracico(), mediaDesvio.getMediaPerimToracico());

        ImageView imgCompGarupa = (ImageView) findViewById(R.id.imgCompGarupa);
        defineCores(imgCompGarupa, morfometrica.getCompGarupa(), mediaDesvio.getDesvioCompGarupa(), mediaDesvio.getMediaCompGarupa());

        ImageView imgLargEntreIlios = (ImageView) findViewById(R.id.imgLargEntreIlios);
        defineCores(imgLargEntreIlios, morfometrica.getLargEntreIlios(), mediaDesvio.getDesvioLargEntreIlios(), mediaDesvio.getMediaLargEntreIlios());

        ImageView imgLargEntreIsquios = (ImageView) findViewById(R.id.imgLargEntreIsquios);
        defineCores(imgLargEntreIsquios, morfometrica.getLargEntreIsquios(), mediaDesvio.getDesvioLargEntreIsquios(), mediaDesvio.getMediaLargEntreIsquios());

        ImageView imgAltCernelha = (ImageView) findViewById(R.id.imgAltCernelha);
        defineCores(imgAltCernelha, morfometrica.getAltCernelha(), mediaDesvio.getDesvioAltCernelha(), mediaDesvio.getMediaAltCernelha());

        ImageView imgAltGarupa = (ImageView) findViewById(R.id.imgAltGarupa);
        defineCores(imgAltGarupa, morfometrica.getAltGarupa(), mediaDesvio.getDesvioAltGarupa(), mediaDesvio.getMediaAltGarupa());

        ImageView imgDistanciaVentreSolo = (ImageView) findViewById(R.id.imgDistanciaVentreSolo);
        defineCores(imgDistanciaVentreSolo, morfometrica.getDistEntreVentreSolo(), mediaDesvio.getDesvioDistEntreVentreSolo(), mediaDesvio.getMediaDistEntreVentreSolo());

        ImageView imgPerimTarso = (ImageView) findViewById(R.id.imgPerimTarso);
        defineCores(imgPerimTarso, morfometrica.getPerimTarso(), mediaDesvio.getDesvioPerimTarso(), mediaDesvio.getMediaPerimTarso());

        ImageView imgPerimMetatarso = (ImageView) findViewById(R.id.imgPerimMetatarso);
        defineCores(imgPerimMetatarso, morfometrica.getPerimMetatarso(), mediaDesvio.getDesvioPerimMetatarso(), mediaDesvio.getMediaPerimMetatarso());

        ImageView imgPerimCarpo = (ImageView) findViewById(R.id.imgPerimCarpo);
        defineCores(imgPerimCarpo, morfometrica.getPerimCarpo(), mediaDesvio.getDesvioPerimCarpo(), mediaDesvio.getMediaPerimCarpo());

        ImageView imgPerimMetaCarpo = (ImageView) findViewById(R.id.imgPerimMetaCarpo);
        defineCores(imgPerimMetaCarpo, morfometrica.getPerimMetacarpo(), mediaDesvio.getDesvioPerimMetacarpo(), mediaDesvio.getMediaperimMetacarpo());

        ImageView imgCompPernasAnteriores = (ImageView) findViewById(R.id.imgCompPernasAnteriores);
        defineCores(imgCompPernasAnteriores, morfometrica.getCompPernasAnteriores(), mediaDesvio.getDesvioCompPernasAnteriores(), mediaDesvio.getMediaCompPernasAnteriores());

        ImageView imgCompPernasPosteriores = (ImageView) findViewById(R.id.imgCompPernasPosteriores);
        defineCores(imgCompPernasPosteriores, morfometrica.getCompPernasPosteriores(), mediaDesvio.getDesvioCompPernasPosteriores(), mediaDesvio.getMediaCompPernasPosteriores());

        ImageView imgCompCauda = (ImageView) findViewById(R.id.imgCompCauda);
        defineCores(imgCompCauda, morfometrica.getCompCauda(), mediaDesvio.getDesvioCompCauda(), mediaDesvio.getMediaCompCauda());

        ImageView imgPerimBaseCauda = (ImageView) findViewById(R.id.imgPerimBaseCauda);
        defineCores(imgPerimBaseCauda, morfometrica.getPerimBaseCauda(), mediaDesvio.getDesvioPerimBaseCauda(), mediaDesvio.getMediaPerimBaseCauda());

        ImageView imgCompTetos = (ImageView) findViewById(R.id.imgCompTetos);
        defineCores(imgCompTetos, morfometrica.getCompTetos(), mediaDesvio.getDesvioCompTetos(), mediaDesvio.getMediaCompTetos());

        if (morfometrica.getCsSexo().equals(TipoSexoEnum.MASCULINO)) {
            ImageView imgCircEscroto = (ImageView) findViewById(R.id.imgCircEscroto);
            defineCores(imgCircEscroto, morfometrica.getCircEscroto(), mediaDesvio.getDesvioCircEscroto(), mediaDesvio.getMediaCircEscroto());
        }

    }

    private void defineCores(ImageView imgRes, Double medidaTela, Double desvio, Double media) {

        if (medidaTela == 0) {
            imgRes.setImageResource(R.drawable.ic_help_white_24dp);
        } else {
            Double lim_inf = media - desvio;
            Double lim_sup = media + desvio;

            if ((medidaTela >= lim_inf) && (medidaTela <= lim_sup)) {
                imgRes.setBackgroundResource(R.drawable.verde);
            } else if (medidaTela <= lim_inf) {
                imgRes.setBackgroundResource(R.drawable.laranja);
            } else if (medidaTela >= lim_sup) {
                imgRes.setBackgroundResource(R.drawable.roxo);
            }
        }
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
