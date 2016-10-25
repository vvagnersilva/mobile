package br.edu.pantaneiro.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.edu.pantaneiro.model.Morfometricas;

public class MorfometricasService {
    private static final String TAG = "MorfometricasService";

    // Ambiente local
    //private static final String SERVIDOR = "http://192.168.1.3:8080/pantaneiro/morfometricas";

    // Ambiente da Amazon
    private static final String SERVIDOR = "http://52.67.183.205:8080/pantaneiro/morfometricas";

    private static final String WEBSERVICE_URL = SERVIDOR + "/buscarTodos";

    // Faz a requisição HTTP, cria a lista de carros e salva o JSON em arquivo
    public static List<Morfometricas> getMorfometricas() throws Exception {
        HttpURLConnection conexao = abrirConexao(WEBSERVICE_URL, "GET", false);
        List<Morfometricas> list = new ArrayList<Morfometricas>();

        if (conexao.getResponseCode() == HttpURLConnection.HTTP_OK) {

            String jsonString = streamToString(conexao.getInputStream());

            JSONArray json = new JSONArray(jsonString);

            for (int i = 0; i < json.length(); i++) {
                JSONObject morfoJson = json.getJSONObject(i);
                Morfometricas m = new Morfometricas();

                m.setSexo(morfoJson.getString("sexo"));
                m.setIdade(morfoJson.getInt("idade"));
                m.setScoreCorporal((double) morfoJson.getDouble("scoreCorporal"));
                m.setPesoVivo((double) morfoJson.getDouble("pesoVivo"));
                m.setCompCabeca((double) morfoJson.getDouble("compCabeca"));
                m.setCompCranio((double) morfoJson.getDouble("compCranio"));
                m.setLargCabeca((double) morfoJson.getDouble("largCabeca"));
                m.setLongRosto((double) morfoJson.getDouble("longRosto"));
                m.setTamOrelhas((double) morfoJson.getDouble("tamOrelhas"));
                m.setPerimPescoco((double) morfoJson.getDouble("perimPescoco"));
                m.setCompPescoco((double) morfoJson.getDouble("compPescoco"));
                m.setCompCorporal((double) morfoJson.getDouble("compCorporal"));
                m.setProfundidade((double) morfoJson.getDouble("profundidade"));
                m.setLargOmbros((double) morfoJson.getDouble("largOmbros"));
                m.setPerimToracico((double) morfoJson.getDouble("perimToracico"));
                m.setCompGarupa((double) morfoJson.getDouble("compGarupa"));
                m.setLargEntreIlios((double) morfoJson.getDouble("largEntreIlios"));
                m.setLargEntreIsquios((double) morfoJson.getDouble("largEntreIsquios"));
                m.setAltCernelha((double) morfoJson.getDouble("altCernelha"));
                m.setAltGarupa((double) morfoJson.getDouble("altGarupa"));
                m.setDistEntreVentreSolo((double) morfoJson.getDouble("distEntreVentreSolo"));
                m.setPerimTarso((double) morfoJson.getDouble("perimTarso"));
                m.setPerimMetatarso((double) morfoJson.getDouble("perimMetatarso"));
                m.setPerimCarpo((double) morfoJson.getDouble("perimCarpo"));
                m.setPerimMetacarpo((double) morfoJson.getDouble("perimMetacarpo"));
                m.setCompPernasAnteriores((double) morfoJson.getDouble("compPernasAnteriores"));
                m.setCompPernasPosteriores((double) morfoJson.getDouble("compPernasPosteriores"));
                m.setCompCauda((double) morfoJson.getDouble("compCauda"));
                m.setPerimBaseCauda((double) morfoJson.getDouble("perimBaseCauda"));
                m.setCompTetos((double) morfoJson.getDouble("compTetos"));
                m.setCircEscroto((double) morfoJson.getDouble("circEscroto"));

                list.add(m);
            }
        }
        return list;
    }

    private static HttpURLConnection abrirConexao(String url,
                                                  String metodo, boolean doOutput) throws Exception {
        URL urlCon = new URL(url);
        HttpURLConnection conexao = (HttpURLConnection) urlCon.openConnection();
        conexao.setReadTimeout(150000);
        conexao.setConnectTimeout(150000);
        conexao.setRequestMethod(metodo);
        conexao.setDoInput(true);
        conexao.setDoOutput(doOutput);
        if (doOutput) {
            conexao.addRequestProperty("Content-Type", "application/json");
        }
        conexao.connect();
        return conexao;
    }

    private static String streamToString(InputStream is) throws IOException {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lidos;
        while ((lidos = is.read(bytes)) > 0) {
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }
}