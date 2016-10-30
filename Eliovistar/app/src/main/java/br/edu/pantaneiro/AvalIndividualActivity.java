package br.edu.pantaneiro;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.edu.pantaneiro.enums.TipoCategoriaOvinaEnum;
import br.edu.pantaneiro.enums.TipoInstituicaoEnum;
import br.edu.pantaneiro.enums.TipoOpcoesEnum;
import br.edu.pantaneiro.enums.TipoRacaEnum;
import br.edu.pantaneiro.enums.TipoSexoEnum;
import br.edu.pantaneiro.model.MediaAritmeticaDesvioPadrao;
import br.edu.pantaneiro.model.Morfometricas;
import br.edu.pantaneiro.service.MorfometricasService;
import br.edu.pantaneiro.utils.Util;

/**
 *
 */
public class AvalIndividualActivity extends AppCompatActivity {

    private static final String TAG = "Pantaneiro";

    private boolean isInstitucional;
    private boolean isParticular;

    private TipoInstituicaoEnum tpInstituicaoEnum;
    private TipoCategoriaOvinaEnum tpCategoriaOvinaEnum;
    private TipoRacaEnum tpRacaEnum;

    private Spinner spInstituicao;
    private Spinner spParticular;
    private Spinner spRacas;
    private Spinner spCategoriaOvina;

    private RadioGroup group;
    private Morfometricas morfometrica = new Morfometricas();
    private MediaAritmeticaDesvioPadrao mediaDesvio = new MediaAritmeticaDesvioPadrao();

    private NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_avaliacao);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.avaliacao);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        group = (RadioGroup) findViewById(R.id.rgOpcoes);

        // Evento do RadioGroup
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                isInstitucional = R.id.radioInstitucional == checkedId;
                isParticular = R.id.radioParticular == checkedId;

                if (isInstitucional) {
                    spInstituicao = (Spinner) findViewById(R.id.spInstituicao);
                    spInstituicao.setVisibility(View.VISIBLE);

                    spParticular = (Spinner) findViewById(R.id.spParticular);
                    spParticular.setVisibility(View.INVISIBLE);

                    Log.i(TAG, "Marcou radio Institucional: " + checkedId);
                } else if (isParticular) {
                    spParticular = (Spinner) findViewById(R.id.spParticular);
                    spParticular.setVisibility(View.VISIBLE);

                    spInstituicao = (Spinner) findViewById(R.id.spInstituicao);
                    spInstituicao.setVisibility(View.INVISIBLE);

                    Log.i(TAG, "Marcou radio do Particular: " + checkedId);
                }
            }
        });

        // Spinner de instituicao
        spInstituicao = (Spinner) findViewById(R.id.spInstituicao);

        spInstituicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    tpInstituicaoEnum = null;
                    Log.i(TAG, "Instituicao nao selecionada");
                } else if (position == 1) {
                    tpInstituicaoEnum = TipoInstituicaoEnum.UFGD;
                    Log.i(TAG, "Raca UFGD");
                } else if (position == 2) {
                    // A implementar
                    tpInstituicaoEnum = TipoInstituicaoEnum.ANHANGUERA;
                    Log.i(TAG, "Raca ANHANGUERA");
                } else if (position == 3) {
                    // A implementar
                    tpInstituicaoEnum = TipoInstituicaoEnum.EMBRAPA_GADO_CORTE;
                    Log.i(TAG, "Raca EMBRAPA_GADO_CORTE");
                } else if (position == 4) {
                    // A implementar
                    tpInstituicaoEnum = TipoInstituicaoEnum.EMBRAPA_PANTANAL;
                    Log.i(TAG, "Raca EMBRAPA_PANTANAL");
                } else if (position == 5) {
                    // A implementar
                    tpInstituicaoEnum = TipoInstituicaoEnum.UNIDERP;
                    Log.i(TAG, "Raca UNIDERP");
                }
                morfometrica.setTpInstituicaoEnum(tpInstituicaoEnum);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Spinner da Raças
        spRacas = (Spinner) findViewById(R.id.spRacas);
        spRacas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    tpRacaEnum = null;
                    Log.i(TAG, "Raça nao selecionada");
                } else if (position == 1) {
                    tpRacaEnum = TipoRacaEnum.PANTANEIRA;
                    Log.i(TAG, "Raca PANTANEIRA");
                } else if (position == 2) {
                    // A implementar
                    tpRacaEnum = TipoRacaEnum.CRIOULA;
                    Log.i(TAG, "Raca CRIOULA");
                } else if (position == 3) {
                    // A implementar
                    tpRacaEnum = TipoRacaEnum.MORADA_NOVA;
                    Log.i(TAG, "Raca MORADA_NOVA");
                } else if (position == 4) {
                    // A implementar
                    tpRacaEnum = TipoRacaEnum.KARAKUL;
                    Log.i(TAG, "Raca KARAKUL");
                }
                morfometrica.setTpRacaEnum(tpRacaEnum);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Spinner de categoria ovina
        spCategoriaOvina = (Spinner) findViewById(R.id.spCategoriaOvina);
        spCategoriaOvina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    tpCategoriaOvinaEnum = null;
                    Log.i(TAG, "Categoria nao selecionada");
                } else if (position == 1) {
                    tpCategoriaOvinaEnum = TipoCategoriaOvinaEnum.CORDEIRO;
                    morfometrica.setTpSexo(TipoSexoEnum.MASCULINO);
                    morfometrica.setIdade(0);

                    Log.i(TAG, "Categoria CORDEIRO");
                } else if (position == 2) {
                    tpCategoriaOvinaEnum = TipoCategoriaOvinaEnum.CORDEIRA;
                    morfometrica.setTpSexo(TipoSexoEnum.FEMININO);
                    morfometrica.setIdade(0);
                    Log.i(TAG, "Categoria CORDEIRA");
                } else if (position == 3) {
                    tpCategoriaOvinaEnum = TipoCategoriaOvinaEnum.BORREGO;
                    morfometrica.setTpSexo(TipoSexoEnum.MASCULINO);
                    morfometrica.setIdade(2);

                    Log.i(TAG, "Categoria BORREGO");
                } else if (position == 4) {
                    tpCategoriaOvinaEnum = TipoCategoriaOvinaEnum.BORREGA;
                    morfometrica.setTpSexo(TipoSexoEnum.FEMININO);
                    morfometrica.setIdade(2);

                    Log.i(TAG, "Categoria BORREGA");
                } else if (position == 5) {
                    tpCategoriaOvinaEnum = TipoCategoriaOvinaEnum.OVELHA;
                    morfometrica.setTpSexo(TipoSexoEnum.FEMININO);
                    morfometrica.setIdade(4);

                    Log.i(TAG, "Categoria OVELHA");
                } else if (position == 6) {
                    tpCategoriaOvinaEnum = TipoCategoriaOvinaEnum.CARNEIRO;
                    morfometrica.setTpSexo(TipoSexoEnum.MASCULINO);
                    morfometrica.setIdade(4);

                    Log.i(TAG, "Categoria CARNEIRO");
                }
                morfometrica.setTpCategoriaOvinaEnum(tpCategoriaOvinaEnum);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button btEmitirRelatorio = (Button) findViewById(R.id.btEmitirRelatorio);

        // Evento onClick do botao emitir relatorio.
        btEmitirRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edScoreCorporal = (EditText) findViewById(R.id.edScoreCorporal);
                morfometrica.setScoreCorporal(Util.converteStringToDouble(edScoreCorporal.getText().length() == 0 ? "0" : edScoreCorporal.getText().toString()));

                EditText edPesoVivo = (EditText) findViewById(R.id.edPesoVivo);
                morfometrica.setPesoVivo(Util.converteStringToDouble(edPesoVivo.getText().length() == 0 ? "0" : edPesoVivo.getText().toString()));

                EditText edCompCabeca = (EditText) findViewById(R.id.edCompCabeca);
                morfometrica.setCompCabeca(Util.converteStringToDouble(edCompCabeca.getText().length() == 0 ? "0" : edCompCabeca.getText().toString()));

                EditText edCompCranio = (EditText) findViewById(R.id.edCompCranio);
                morfometrica.setCompCranio(Util.converteStringToDouble(edCompCranio.getText().length() == 0 ? "0" : edCompCranio.getText().toString()));

                EditText edLargCabeca = (EditText) findViewById(R.id.edLargCabeca);
                morfometrica.setLargCabeca(Util.converteStringToDouble(edLargCabeca.getText().length() == 0 ? "0" : edLargCabeca.getText().toString()));

                EditText edLongRosto = (EditText) findViewById(R.id.edLongRosto);
                morfometrica.setLongRosto(Util.converteStringToDouble(edLongRosto.getText().length() == 0 ? "0" : edLongRosto.getText().toString()));

                EditText edTamOrelhas = (EditText) findViewById(R.id.edTamOrelhas);
                morfometrica.setTamOrelhas(Util.converteStringToDouble(edTamOrelhas.getText().length() == 0 ? "0" : edTamOrelhas.getText().toString()));

                EditText edPerimPescoco = (EditText) findViewById(R.id.edPerimPescoco);
                morfometrica.setPerimPescoco(Util.converteStringToDouble(edPerimPescoco.getText().length() == 0 ? "0" : edPerimPescoco.getText().toString()));

                EditText edCompPescoco = (EditText) findViewById(R.id.edCompPescoco);
                morfometrica.setCompPescoco(Util.converteStringToDouble(edCompPescoco.getText().length() == 0 ? "0" : edCompPescoco.getText().toString()));

                EditText edCompCorporal = (EditText) findViewById(R.id.edCompCorporal);
                morfometrica.setCompCorporal(Util.converteStringToDouble(edCompCorporal.getText().length() == 0 ? "0" : edCompCorporal.getText().toString()));

                EditText edProfundidade = (EditText) findViewById(R.id.edProfundidade);
                morfometrica.setProfundidade(Util.converteStringToDouble(edProfundidade.getText().length() == 0 ? "0" : edProfundidade.getText().toString()));

                EditText edLargOmbros = (EditText) findViewById(R.id.edLargOmbros);
                morfometrica.setLargOmbros(Util.converteStringToDouble(edLargOmbros.getText().length() == 0 ? "0" : edLargOmbros.getText().toString()));

                EditText edPerimToracico = (EditText) findViewById(R.id.edPerimToracico);
                morfometrica.setPerimToracico(Util.converteStringToDouble(edPerimToracico.getText().length() == 0 ? "0" : edPerimToracico.getText().toString()));

                EditText edCompGarupa = (EditText) findViewById(R.id.edCompGarupa);
                morfometrica.setCompGarupa(Util.converteStringToDouble(edCompGarupa.getText().length() == 0 ? "0" : edCompGarupa.getText().toString()));

                EditText edLargEntreIlios = (EditText) findViewById(R.id.edLargEntreIlios);
                morfometrica.setLargEntreIlios(Util.converteStringToDouble(edLargEntreIlios.getText().length() == 0 ? "0" : edLargEntreIlios.getText().toString()));

                EditText edLargEntreIsquios = (EditText) findViewById(R.id.edLargEntreIsquios);
                morfometrica.setLargEntreIsquios(Util.converteStringToDouble(edLargEntreIsquios.getText().length() == 0 ? "0" : edLargEntreIsquios.getText().toString()));

                EditText edAltCernelha = (EditText) findViewById(R.id.edAltCernelha);
                morfometrica.setAltCernelha(Util.converteStringToDouble(edAltCernelha.getText().length() == 0 ? "0" : edAltCernelha.getText().toString()));

                EditText edAltGarupa = (EditText) findViewById(R.id.edAltGarupa);
                morfometrica.setAltGarupa(Util.converteStringToDouble(edAltGarupa.getText().length() == 0 ? "0" : edAltGarupa.getText().toString()));

                EditText edDistanciaVentreSolo = (EditText) findViewById(R.id.edDistanciaVentreSolo);
                morfometrica.setDistEntreVentreSolo(Util.converteStringToDouble(edDistanciaVentreSolo.getText().length() == 0 ? "0" : edDistanciaVentreSolo.getText().toString()));

                EditText edPerimTarso = (EditText) findViewById(R.id.edPerimTarso);
                morfometrica.setPerimTarso(Util.converteStringToDouble(edPerimTarso.getText().length() == 0 ? "0" : edPerimTarso.getText().toString()));

                EditText edPerimMetatarso = (EditText) findViewById(R.id.edPerimMetatarso);
                morfometrica.setPerimMetatarso(Util.converteStringToDouble(edPerimMetatarso.getText().length() == 0 ? "0" : edPerimMetatarso.getText().toString()));

                EditText edPerimCarpo = (EditText) findViewById(R.id.edPerimCarpo);
                morfometrica.setPerimCarpo(Util.converteStringToDouble(edPerimCarpo.getText().length() == 0 ? "0" : edPerimCarpo.getText().toString()));

                EditText edPerimMetaCarpo = (EditText) findViewById(R.id.edPerimMetaCarpo);
                morfometrica.setPerimMetacarpo(Util.converteStringToDouble(edPerimMetaCarpo.getText().length() == 0 ? "0" : edPerimMetaCarpo.getText().toString()));

                EditText edCompPernasAnteriores = (EditText) findViewById(R.id.edCompPernasAnteriores);
                morfometrica.setCompPernasAnteriores(Util.converteStringToDouble(edCompPernasAnteriores.getText().length() == 0 ? "0" : edCompPernasAnteriores.getText().toString()));

                EditText edCompPernasPosteriores = (EditText) findViewById(R.id.edCompPernasPosteriores);
                morfometrica.setCompPernasPosteriores(Util.converteStringToDouble(edCompPernasPosteriores.getText().length() == 0 ? "0" : edCompPernasPosteriores.getText().toString()));

                EditText edCompCauda = (EditText) findViewById(R.id.edCompCauda);
                morfometrica.setCompCauda(Util.converteStringToDouble(edCompCauda.getText().length() == 0 ? "0" : edCompCauda.getText().toString()));

                EditText edPerimBaseCauda = (EditText) findViewById(R.id.edPerimBaseCauda);
                morfometrica.setPerimBaseCauda(Util.converteStringToDouble(edPerimBaseCauda.getText().length() == 0 ? "0" : edPerimBaseCauda.getText().toString()));

                EditText edCompTetos = (EditText) findViewById(R.id.edCompTetos);
                morfometrica.setCompTetos(Util.converteStringToDouble(edCompTetos.getText().length() == 0 ? "0" : edCompTetos.getText().toString()));

                EditText edCircEscroto = (EditText) findViewById(R.id.edCircEscroto);
                morfometrica.setCircEscroto(Util.converteStringToDouble(edCircEscroto.getText().length() == 0 ? "0" : edCircEscroto.getText().toString()));

                // Valida campo Instituicao
                if (validaCampoObrigatorio(TipoOpcoesEnum.PROCEDENCIA) ||
                        validaCampoObrigatorio(TipoOpcoesEnum.RACA) ||
                        validaCampoObrigatorio(TipoOpcoesEnum.CATEGORIA_OVINA) ||
                        validaCampoObrigatorio(TipoOpcoesEnum.SCORE_CORPORAL)) {
                    return;
                } else {
                    new GetMorfometricasTask().execute();
                }
            }
        });
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

    private boolean validaCampoObrigatorio(TipoOpcoesEnum opcao) {
        boolean bValidacao = false;

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);

        alertDialogBuilder.setIcon(R.drawable.ic_alert_white_48dp);

        switch (opcao) {
            case PROCEDENCIA: {
                alertDialogBuilder.setTitle(R.string.instituicao);

                if (isInstitucional) {
                    // Se não for a UFGD, então aviso porque não tem base de dados.
                    if (tpInstituicaoEnum == null) {
                        alertDialogBuilder.setMessage(getString(R.string.obrigatorio_instituicao));
                        bValidacao = true;
                    } else if (!tpInstituicaoEnum.getCodigo().equals(TipoInstituicaoEnum.UFGD.getCodigo())) {
                        alertDialogBuilder.setMessage(getString(R.string.condicao_instituicao));
                        bValidacao = true;
                    }
                } else if (isParticular) {
                    alertDialogBuilder.setMessage(getString(R.string.condicao_particular));
                    bValidacao = true;
                }
                break;
            }
            case RACA: {
                alertDialogBuilder.setTitle(R.string.racas);

                if (tpRacaEnum == null) {
                    alertDialogBuilder.setMessage(getString(R.string.obrigatorio_raca));
                    bValidacao = true;
                } else if (!tpRacaEnum.getCodigo().equals(TipoRacaEnum.PANTANEIRA.getCodigo())) {
                    alertDialogBuilder.setMessage(getString(R.string.condicao_raca));
                    bValidacao = true;
                }
                break;
            }
            case CATEGORIA_OVINA: {
                alertDialogBuilder.setTitle(R.string.categoria);
                if (tpCategoriaOvinaEnum == null) {
                    alertDialogBuilder.setMessage(getString(R.string.obrigatorio_categoria));
                    bValidacao = true;
                }
                break;
            }
            case SCORE_CORPORAL: {
                alertDialogBuilder.setTitle(R.string.score_corporal);

                EditText edScoreCorporal = (EditText) findViewById(R.id.edScoreCorporal);

                double scoreCorporal = Util.converteStringToDouble(edScoreCorporal.getText().length() == 0 ? "0" : edScoreCorporal.getText().toString());

                // Se não tiver no intervalo
                if (!(scoreCorporal >= 1 && scoreCorporal <= 5)) {
                    alertDialogBuilder.setMessage(getString(R.string.condicao_score_corporal));
                    bValidacao = true;
                }
                break;
            }
        }

        if (bValidacao) {
            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();
        }
        return bValidacao;
    }

    // Task para buscar das Morfometricas
    private class GetMorfometricasTask extends AsyncTask<Void, Void, List<Morfometricas>> {

        public GetMorfometricasTask() {
        }

        @Override
        protected List<Morfometricas> doInBackground(Void... params) {
            try {
                // Busca os carros em background (Thread)
                return MorfometricasService.getMorfometricas();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
                return null;
            }
        }

        // Atualiza a interface
        protected void onPostExecute(List<Morfometricas> listMorfo) {
            if (listMorfo != null) {

                calcularMedias(listMorfo);

                calcularDesvioPadrao(listMorfo);

                Log.i(TAG, mediaDesvio.toString());
                Log.i(TAG, morfometrica.toString());

                Intent it = new Intent(AvalIndividualActivity.this, RelIndividualActivity.class);

                it.putExtra("mediaDesvio", mediaDesvio);
                it.putExtra("morfometrica", morfometrica);

                startActivity(it);
            }
        }

        private void calcularMedias(List<Morfometricas> listMorfo) {
            Double mediaPesoVivo = 0D;
            Double mediaCompCabeca = 0D;
            Double mediaCompCranio = 0D;
            Double mediaLargCabeca = 0D;
            Double mediaLongRosto = 0D;
            Double mediaTamOrelhas = 0D;
            Double mediaPerimPescoco = 0D;
            Double mediaCompPescoco = 0D;
            Double mediaCompCorporal = 0D;
            Double mediaProfundidade = 0D;
            Double mediaLargOmbros = 0D;
            Double mediaPerimToracico = 0D;
            Double mediaCompGarupa = 0D;
            Double mediaLargEntreIlios = 0D;
            Double mediaLargEntreIsquios = 0D;
            Double mediaAltCernelha = 0D;
            Double mediaAltGarupa = 0D;
            Double mediaDistEntreVentreSolo = 0D;
            Double mediaPerimTarso = 0D;
            Double mediaPerimMetatarso = 0D;
            Double mediaPerimCarpo = 0D;
            Double mediaperimMetacarpo = 0D;
            Double mediaCompPernasAnteriores = 0D;
            Double mediaCompPernasPosteriores = 0D;
            Double mediaCompCauda = 0D;
            Double mediaPerimBaseCauda = 0D;
            Double mediaCompTetos = 0D;
            Double mediaCircEscroto = 0D;

            for (Morfometricas morfo : listMorfo) {
                mediaPesoVivo += morfo.getPesoVivo();
                mediaCompCabeca += morfo.getCompCabeca();
                mediaCompCranio += morfo.getCompCranio();
                mediaLargCabeca += morfo.getLargCabeca();
                mediaLongRosto += morfo.getLongRosto();
                mediaTamOrelhas += morfo.getTamOrelhas();
                mediaPerimPescoco += morfo.getPerimPescoco();
                mediaCompPescoco += morfo.getCompPescoco();
                mediaCompCorporal += morfo.getCompCorporal();
                mediaProfundidade += morfo.getProfundidade();
                mediaLargOmbros += morfo.getLargOmbros();
                mediaPerimToracico += morfo.getPerimToracico();
                mediaCompGarupa += morfo.getCompGarupa();
                mediaLargEntreIlios += morfo.getLargEntreIlios();
                mediaLargEntreIsquios += morfo.getLargEntreIsquios();
                mediaAltCernelha += morfo.getAltCernelha();
                mediaAltGarupa += morfo.getAltGarupa();
                mediaDistEntreVentreSolo += morfo.getDistEntreVentreSolo();
                mediaPerimTarso += morfo.getPerimTarso();
                mediaPerimMetatarso += morfo.getPerimMetatarso();
                mediaPerimCarpo += morfo.getPerimCarpo();
                mediaperimMetacarpo += morfo.getPerimMetacarpo();
                mediaCompPernasAnteriores += morfo.getCompPernasAnteriores();
                mediaCompPernasPosteriores += morfo.getCompPernasPosteriores();
                mediaCompCauda += morfo.getCompCauda();
                mediaPerimBaseCauda += morfo.getPerimBaseCauda();
                mediaCompTetos += morfo.getCompTetos();
                mediaCircEscroto += morfo.getCircEscroto();
            }

            mediaDesvio.setMediaPesoVivo(Util.converteStringToDouble(nf.format(mediaPesoVivo / listMorfo.size())));
            mediaDesvio.setMediaCompCabeca(Util.converteStringToDouble(nf.format(mediaCompCabeca / listMorfo.size())));
            mediaDesvio.setMediaCompCranio(Util.converteStringToDouble(nf.format(mediaCompCranio / listMorfo.size())));
            mediaDesvio.setMediaLargCabeca(Util.converteStringToDouble(nf.format(mediaLargCabeca / listMorfo.size())));
            mediaDesvio.setMediaLongRosto(Util.converteStringToDouble(nf.format(mediaLongRosto / listMorfo.size())));
            mediaDesvio.setMediaTamOrelhas(Util.converteStringToDouble(nf.format(mediaTamOrelhas / listMorfo.size())));
            mediaDesvio.setMediaPerimPescoco(Util.converteStringToDouble(nf.format(mediaPerimPescoco / listMorfo.size())));
            mediaDesvio.setMediaCompPescoco(Util.converteStringToDouble(nf.format(mediaCompPescoco / listMorfo.size())));
            mediaDesvio.setMediaCompCorporal(Util.converteStringToDouble(nf.format(mediaCompCorporal / listMorfo.size())));
            mediaDesvio.setMediaProfundidade(Util.converteStringToDouble(nf.format(mediaProfundidade / listMorfo.size())));
            mediaDesvio.setMediaLargOmbros(Util.converteStringToDouble(nf.format(mediaLargOmbros / listMorfo.size())));
            mediaDesvio.setDesvioPerimToracico(Util.converteStringToDouble(nf.format(mediaPerimToracico / listMorfo.size())));
            mediaDesvio.setMediaCompGarupa(Util.converteStringToDouble(nf.format(mediaCompGarupa / listMorfo.size())));
            mediaDesvio.setDesvioLargEntreIlios(Util.converteStringToDouble(nf.format(mediaLargEntreIlios / listMorfo.size())));
            mediaDesvio.setDesvioLargEntreIsquios(Util.converteStringToDouble(nf.format(mediaLargEntreIsquios / listMorfo.size())));
            mediaDesvio.setMediaAltCernelha(Util.converteStringToDouble(nf.format(mediaAltCernelha / listMorfo.size())));
            mediaDesvio.setMediaAltGarupa(Util.converteStringToDouble(nf.format(mediaAltGarupa / listMorfo.size())));
            mediaDesvio.setMediaDistEntreVentreSolo(Util.converteStringToDouble(nf.format(mediaDistEntreVentreSolo / listMorfo.size())));
            mediaDesvio.setMediaPerimTarso(Util.converteStringToDouble(nf.format(mediaPerimTarso / listMorfo.size())));
            mediaDesvio.setMediaPerimMetatarso(Util.converteStringToDouble(nf.format(mediaPerimMetatarso / listMorfo.size())));
            mediaDesvio.setMediaPerimCarpo(Util.converteStringToDouble(nf.format(mediaPerimCarpo / listMorfo.size())));
            mediaDesvio.setMediaperimMetacarpo(Util.converteStringToDouble(nf.format(mediaperimMetacarpo / listMorfo.size())));
            mediaDesvio.setMediaCompPernasAnteriores(Util.converteStringToDouble(nf.format(mediaCompPernasAnteriores / listMorfo.size())));
            mediaDesvio.setDesvioCompPernasPosteriores(Util.converteStringToDouble(nf.format(mediaCompPernasPosteriores / listMorfo.size())));
            mediaDesvio.setMediaCompCauda(Util.converteStringToDouble(nf.format(mediaCompCauda / listMorfo.size())));
            mediaDesvio.setMediaPerimBaseCauda(Util.converteStringToDouble(nf.format(mediaPerimBaseCauda / listMorfo.size())));
            mediaDesvio.setMediaCompTetos(Util.converteStringToDouble(nf.format(mediaCompTetos / listMorfo.size())));
            mediaDesvio.setMediaCircEscroto(Util.converteStringToDouble(nf.format(mediaCircEscroto / listMorfo.size())));
        }

        private void calcularDesvioPadrao(List<Morfometricas> listMorfo) {
            Double desvioPesoVivo = 0D;
            Double desvioCompCabeca = 0D;
            Double desvioCompCranio = 0D;
            Double desvioLargCabeca = 0D;
            Double desvioLongRosto = 0D;
            Double desvioTamOrelhas = 0D;
            Double desvioPerimPescoco = 0D;
            Double desvioCompPescoco = 0D;
            Double desvioCompCorporal = 0D;
            Double desvioProfundidade = 0D;
            Double desvioLargOmbros = 0D;
            Double desvioPerimToracico = 0D;
            Double desvioCompGarupa = 0D;
            Double desvioLargEntreIlios = 0D;
            Double desvioLargEntreIsquios = 0D;
            Double desvioAltCernelha = 0D;
            Double desvioAltGarupa = 0D;
            Double desvioDistEntreVentreSolo = 0D;
            Double desvioPerimTarso = 0D;
            Double desvioPerimMetatarso = 0D;
            Double desvioPerimCarpo = 0D;
            Double desvioPerimMetacarpo = 0D;
            Double desvioCompPernasAnteriores = 0D;
            Double desvioCompPernasPosteriores = 0D;
            Double desvioCompCauda = 0D;
            Double desvioPerimBaseCauda = 0D;
            Double desvioCompTetos = 0D;
            Double desvioCircEscroto = 0D;

            for (Morfometricas morfo : listMorfo) {
                desvioPesoVivo += Math.pow(morfo.getPesoVivo() - mediaDesvio.getMediaPesoVivo(), 2);
                desvioCompCabeca += Math.pow(morfo.getCompCabeca() - mediaDesvio.getMediaCompCabeca(), 2);
                desvioCompCranio += Math.pow(morfo.getCompCranio() - mediaDesvio.getMediaCompCranio(), 2);
                desvioLargCabeca += Math.pow(morfo.getLargCabeca() - mediaDesvio.getMediaLargCabeca(), 2);
                desvioLongRosto += Math.pow(morfo.getLongRosto() - mediaDesvio.getMediaLongRosto(), 2);
                desvioTamOrelhas += Math.pow(morfo.getTamOrelhas() - mediaDesvio.getMediaTamOrelhas(), 2);
                desvioPerimPescoco += Math.pow(morfo.getPerimPescoco() - mediaDesvio.getMediaPerimPescoco(), 2);
                desvioCompPescoco += Math.pow(morfo.getCompPescoco() - mediaDesvio.getMediaCompPescoco(), 2);
                desvioCompCorporal += Math.pow(morfo.getCompCorporal() - mediaDesvio.getMediaCompCorporal(), 2);
                desvioProfundidade += Math.pow(morfo.getProfundidade() - mediaDesvio.getMediaProfundidade(), 2);
                desvioLargOmbros += Math.pow(morfo.getLargOmbros() - mediaDesvio.getMediaLargOmbros(), 2);
                desvioPerimToracico += Math.pow(morfo.getPerimToracico() - mediaDesvio.getMediaPerimToracico(), 2);
                desvioCompGarupa += Math.pow(morfo.getCompGarupa() - mediaDesvio.getMediaCompGarupa(), 2);
                desvioLargEntreIlios += Math.pow(morfo.getLargEntreIlios() - mediaDesvio.getMediaLargEntreIlios(), 2);
                desvioLargEntreIsquios += Math.pow(morfo.getLargEntreIsquios() - mediaDesvio.getMediaLargEntreIsquios(), 2);
                desvioAltCernelha += Math.pow(morfo.getAltCernelha() - mediaDesvio.getMediaAltCernelha(), 2);
                desvioAltGarupa += Math.pow(morfo.getAltGarupa() - mediaDesvio.getMediaAltGarupa(), 2);
                desvioDistEntreVentreSolo += Math.pow(morfo.getDistEntreVentreSolo() - mediaDesvio.getMediaDistEntreVentreSolo(), 2);
                desvioPerimTarso += Math.pow(morfo.getPerimTarso() - mediaDesvio.getMediaPerimTarso(), 2);
                desvioPerimMetatarso += Math.pow(morfo.getPerimMetatarso() - mediaDesvio.getMediaPerimMetatarso(), 2);
                desvioPerimCarpo += Math.pow(morfo.getPerimCarpo() - mediaDesvio.getMediaPerimCarpo(), 2);
                desvioPerimMetacarpo += Math.pow(morfo.getPerimMetacarpo() - mediaDesvio.getMediaperimMetacarpo(), 2);
                desvioCompPernasAnteriores += Math.pow(morfo.getCompPernasAnteriores() - mediaDesvio.getMediaCompPernasAnteriores(), 2);
                desvioCompPernasPosteriores += Math.pow(morfo.getCompPernasPosteriores() - mediaDesvio.getMediaCompPernasPosteriores(), 2);
                desvioCompCauda += Math.pow(morfo.getCompCauda() - mediaDesvio.getMediaCompCauda(), 2);
                desvioPerimBaseCauda += Math.pow(morfo.getPerimBaseCauda() - mediaDesvio.getMediaPerimBaseCauda(), 2);
                desvioCompTetos += Math.pow(morfo.getCompTetos() - mediaDesvio.getMediaCompTetos(), 2);
                desvioCircEscroto += Math.pow(morfo.getCircEscroto() - mediaDesvio.getMediaCircEscroto(), 2);
            }

            mediaDesvio.setDesvioPesoVivo(Util.converteStringToDouble(nf.format(Math.sqrt(desvioPesoVivo / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompCabeca(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompCabeca / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompCranio(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompCranio / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioLargCabeca(Util.converteStringToDouble(nf.format(Math.sqrt(desvioLargCabeca / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioLongRosto(Util.converteStringToDouble(nf.format(Math.sqrt(desvioLongRosto / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioTamOrelhas(Util.converteStringToDouble(nf.format(Math.sqrt(desvioTamOrelhas / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioPerimPescoco(Util.converteStringToDouble(nf.format(Math.sqrt(desvioPerimPescoco / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompPescoco(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompPescoco / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompCorporal(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompCorporal / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioProfundidade(Util.converteStringToDouble(nf.format(Math.sqrt(desvioProfundidade / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioLargOmbros(Util.converteStringToDouble(nf.format(Math.sqrt(desvioLargOmbros / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioPerimToracico(Util.converteStringToDouble(nf.format(Math.sqrt(desvioPerimToracico / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompGarupa(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompGarupa / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioLargEntreIlios(Util.converteStringToDouble(nf.format(Math.sqrt(desvioLargEntreIlios / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioLargEntreIsquios(Util.converteStringToDouble(nf.format(Math.sqrt(desvioLargEntreIsquios / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioAltCernelha(Util.converteStringToDouble(nf.format(Math.sqrt(desvioAltCernelha / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioAltGarupa(Util.converteStringToDouble(nf.format(Math.sqrt(desvioAltGarupa / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioDistEntreVentreSolo(Util.converteStringToDouble(nf.format(Math.sqrt(desvioDistEntreVentreSolo / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioPerimTarso(Util.converteStringToDouble(nf.format(Math.sqrt(desvioPerimTarso / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioPerimMetatarso(Util.converteStringToDouble(nf.format(Math.sqrt(desvioPerimMetatarso / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioPerimCarpo(Util.converteStringToDouble(nf.format(Math.sqrt(desvioPerimCarpo / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioPerimMetacarpo(Util.converteStringToDouble(nf.format(Math.sqrt(desvioPerimMetacarpo / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompPernasAnteriores(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompPernasAnteriores / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompPernasPosteriores(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompPernasPosteriores / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompCauda(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompCauda / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioPerimBaseCauda(Util.converteStringToDouble(nf.format(Math.sqrt(desvioPerimBaseCauda / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCompTetos(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCompTetos / (listMorfo.size() - 1)))));
            mediaDesvio.setDesvioCircEscroto(Util.converteStringToDouble(nf.format(Math.sqrt(desvioCircEscroto / (listMorfo.size() - 1)))));
        }
    }
}