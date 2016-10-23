package br.edu.pantaneiro.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ss
 *
 * @author wagner
 */
public class MediaAritmeticaDesvioPadrao implements Parcelable {

    // Media Aritmetica
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

    // Desvio Padrao
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

    public MediaAritmeticaDesvioPadrao() {
    }

    private MediaAritmeticaDesvioPadrao(Parcel p) {
        // Media Aritmetica
        mediaPesoVivo = p.readDouble();
        mediaCompCabeca = p.readDouble();
        mediaCompCranio = p.readDouble();
        mediaLargCabeca = p.readDouble();
        mediaLongRosto = p.readDouble();
        mediaTamOrelhas = p.readDouble();
        mediaPerimPescoco = p.readDouble();
        mediaCompPescoco = p.readDouble();
        mediaCompCorporal = p.readDouble();
        mediaProfundidade = p.readDouble();
        mediaLargOmbros = p.readDouble();
        mediaPerimToracico = p.readDouble();
        mediaCompGarupa = p.readDouble();
        mediaLargEntreIlios = p.readDouble();
        mediaLargEntreIsquios = p.readDouble();
        mediaAltCernelha = p.readDouble();
        mediaAltGarupa = p.readDouble();
        mediaDistEntreVentreSolo = p.readDouble();
        mediaPerimTarso = p.readDouble();
        mediaPerimMetatarso = p.readDouble();
        mediaPerimCarpo = p.readDouble();
        mediaperimMetacarpo = p.readDouble();
        mediaCompPernasAnteriores = p.readDouble();
        mediaCompPernasPosteriores = p.readDouble();
        mediaCompCauda = p.readDouble();
        mediaPerimBaseCauda = p.readDouble();
        mediaCompTetos = p.readDouble();
        mediaCircEscroto = p.readDouble();

        // Desvio Padrao
        desvioPesoVivo = p.readDouble();
        desvioCompCabeca = p.readDouble();
        desvioCompCranio = p.readDouble();
        desvioLargCabeca = p.readDouble();
        desvioLongRosto = p.readDouble();
        desvioTamOrelhas = p.readDouble();
        desvioPerimPescoco = p.readDouble();
        desvioCompPescoco = p.readDouble();
        desvioCompCorporal = p.readDouble();
        desvioProfundidade = p.readDouble();
        desvioLargOmbros = p.readDouble();
        desvioPerimToracico = p.readDouble();
        desvioCompGarupa = p.readDouble();
        desvioLargEntreIlios = p.readDouble();
        desvioLargEntreIsquios = p.readDouble();
        desvioAltCernelha = p.readDouble();
        desvioAltGarupa = p.readDouble();
        desvioDistEntreVentreSolo = p.readDouble();
        desvioPerimTarso = p.readDouble();
        desvioPerimMetatarso = p.readDouble();
        desvioPerimCarpo = p.readDouble();
        desvioPerimMetacarpo = p.readDouble();
        desvioCompPernasAnteriores = p.readDouble();
        desvioCompPernasPosteriores = p.readDouble();
        desvioCompCauda = p.readDouble();
        desvioPerimBaseCauda = p.readDouble();
        desvioCompTetos = p.readDouble();
        desvioCircEscroto = p.readDouble();
    }

    public static final Parcelable.Creator<MediaAritmeticaDesvioPadrao>
            CREATOR = new Parcelable.Creator<MediaAritmeticaDesvioPadrao>() {

        public MediaAritmeticaDesvioPadrao createFromParcel(Parcel in) {
            return new MediaAritmeticaDesvioPadrao(in);
        }

        public MediaAritmeticaDesvioPadrao[] newArray(int size) {
            return new MediaAritmeticaDesvioPadrao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        // Media Aritmetica
        dest.writeDouble(mediaPesoVivo);
        dest.writeDouble(mediaCompCabeca);
        dest.writeDouble(mediaCompCranio);
        dest.writeDouble(mediaLongRosto);
        dest.writeDouble(mediaTamOrelhas);
        dest.writeDouble(mediaPerimPescoco);
        dest.writeDouble(mediaCompPescoco);
        dest.writeDouble(mediaCompCorporal);
        dest.writeDouble(mediaProfundidade);
        dest.writeDouble(mediaLargOmbros);
        dest.writeDouble(mediaPerimToracico);
        dest.writeDouble(mediaCompGarupa);
        dest.writeDouble(mediaLargEntreIlios);
        dest.writeDouble(mediaLargEntreIsquios);
        dest.writeDouble(mediaAltCernelha);
        dest.writeDouble(mediaAltGarupa);
        dest.writeDouble(mediaDistEntreVentreSolo);
        dest.writeDouble(mediaPerimTarso);
        dest.writeDouble(mediaPerimMetatarso);
        dest.writeDouble(mediaPerimCarpo);
        dest.writeDouble(mediaperimMetacarpo);
        dest.writeDouble(mediaCompPernasAnteriores);
        dest.writeDouble(mediaCompPernasPosteriores);
        dest.writeDouble(mediaCompCauda);
        dest.writeDouble(mediaCompTetos);
        dest.writeDouble(mediaCircEscroto);

        // Desvio Padrao
        dest.writeDouble(desvioPesoVivo);
        dest.writeDouble(desvioCompCabeca);
        dest.writeDouble(desvioCompCranio);
        dest.writeDouble(desvioLargCabeca);
        dest.writeDouble(desvioLongRosto);
        dest.writeDouble(desvioTamOrelhas);
        dest.writeDouble(desvioPerimPescoco);
        dest.writeDouble(desvioCompPescoco);
        dest.writeDouble(desvioCompCorporal);
        dest.writeDouble(desvioProfundidade);
        dest.writeDouble(desvioLargOmbros);
        dest.writeDouble(desvioPerimToracico);
        dest.writeDouble(desvioCompGarupa);
        dest.writeDouble(desvioLargEntreIlios);
        dest.writeDouble(desvioLargEntreIsquios);
        dest.writeDouble(desvioAltCernelha);
        dest.writeDouble(desvioAltGarupa);
        dest.writeDouble(desvioDistEntreVentreSolo);
        dest.writeDouble(desvioPerimTarso);
        dest.writeDouble(desvioPerimMetatarso);
        dest.writeDouble(desvioPerimCarpo);
        dest.writeDouble(desvioPerimMetacarpo);
        dest.writeDouble(desvioCompPernasAnteriores);
        dest.writeDouble(desvioCompPernasPosteriores);
        dest.writeDouble(desvioCompCauda);
        dest.writeDouble(desvioPerimBaseCauda);
        dest.writeDouble(desvioCompTetos);
        dest.writeDouble(desvioCircEscroto);
    }

    public Double getMediaPesoVivo() {
        return mediaPesoVivo;
    }

    public void setMediaPesoVivo(Double mediaPesoVivo) {
        this.mediaPesoVivo = mediaPesoVivo;
    }

    public Double getMediaCompCabeca() {
        return mediaCompCabeca;
    }

    public void setMediaCompCabeca(Double mediaCompCabeca) {
        this.mediaCompCabeca = mediaCompCabeca;
    }

    public Double getMediaCompCranio() {
        return mediaCompCranio;
    }

    public void setMediaCompCranio(Double mediaCompCranio) {
        this.mediaCompCranio = mediaCompCranio;
    }

    public Double getMediaLargCabeca() {
        return mediaLargCabeca;
    }

    public void setMediaLargCabeca(Double mediaLargCabeca) {
        this.mediaLargCabeca = mediaLargCabeca;
    }

    public Double getMediaLongRosto() {
        return mediaLongRosto;
    }

    public void setMediaLongRosto(Double mediaLongRosto) {
        this.mediaLongRosto = mediaLongRosto;
    }

    public Double getMediaTamOrelhas() {
        return mediaTamOrelhas;
    }

    public void setMediaTamOrelhas(Double mediaTamOrelhas) {
        this.mediaTamOrelhas = mediaTamOrelhas;
    }

    public Double getMediaPerimPescoco() {
        return mediaPerimPescoco;
    }

    public void setMediaPerimPescoco(Double mediaPerimPescoco) {
        this.mediaPerimPescoco = mediaPerimPescoco;
    }

    public Double getMediaCompPescoco() {
        return mediaCompPescoco;
    }

    public void setMediaCompPescoco(Double mediaCompPescoco) {
        this.mediaCompPescoco = mediaCompPescoco;
    }

    public Double getMediaCompCorporal() {
        return mediaCompCorporal;
    }

    public void setMediaCompCorporal(Double mediaCompCorporal) {
        this.mediaCompCorporal = mediaCompCorporal;
    }

    public Double getMediaProfundidade() {
        return mediaProfundidade;
    }

    public void setMediaProfundidade(Double mediaProfundidade) {
        this.mediaProfundidade = mediaProfundidade;
    }

    public Double getMediaLargOmbros() {
        return mediaLargOmbros;
    }

    public void setMediaLargOmbros(Double mediaLargOmbros) {
        this.mediaLargOmbros = mediaLargOmbros;
    }

    public Double getMediaPerimToracico() {
        return mediaPerimToracico;
    }

    public void setMediaPerimToracico(Double mediaPerimToracico) {
        this.mediaPerimToracico = mediaPerimToracico;
    }

    public Double getMediaCompGarupa() {
        return mediaCompGarupa;
    }

    public void setMediaCompGarupa(Double mediaCompGarupa) {
        this.mediaCompGarupa = mediaCompGarupa;
    }

    public Double getMediaLargEntreIlios() {
        return mediaLargEntreIlios;
    }

    public void setMediaLargEntreIlios(Double mediaLargEntreIlios) {
        this.mediaLargEntreIlios = mediaLargEntreIlios;
    }

    public Double getMediaLargEntreIsquios() {
        return mediaLargEntreIsquios;
    }

    public void setMediaLargEntreIsquios(Double mediaLargEntreIsquios) {
        this.mediaLargEntreIsquios = mediaLargEntreIsquios;
    }

    public Double getMediaAltCernelha() {
        return mediaAltCernelha;
    }

    public void setMediaAltCernelha(Double mediaAltCernelha) {
        this.mediaAltCernelha = mediaAltCernelha;
    }

    public Double getMediaAltGarupa() {
        return mediaAltGarupa;
    }

    public void setMediaAltGarupa(Double mediaAltGarupa) {
        this.mediaAltGarupa = mediaAltGarupa;
    }

    public Double getMediaDistEntreVentreSolo() {
        return mediaDistEntreVentreSolo;
    }

    public void setMediaDistEntreVentreSolo(Double mediaDistEntreVentreSolo) {
        this.mediaDistEntreVentreSolo = mediaDistEntreVentreSolo;
    }

    public Double getMediaPerimTarso() {
        return mediaPerimTarso;
    }

    public void setMediaPerimTarso(Double mediaPerimTarso) {
        this.mediaPerimTarso = mediaPerimTarso;
    }

    public Double getMediaPerimMetatarso() {
        return mediaPerimMetatarso;
    }

    public void setMediaPerimMetatarso(Double mediaPerimMetatarso) {
        this.mediaPerimMetatarso = mediaPerimMetatarso;
    }

    public Double getMediaPerimCarpo() {
        return mediaPerimCarpo;
    }

    public void setMediaPerimCarpo(Double mediaPerimCarpo) {
        this.mediaPerimCarpo = mediaPerimCarpo;
    }

    public Double getMediaperimMetacarpo() {
        return mediaperimMetacarpo;
    }

    public void setMediaperimMetacarpo(Double mediaperimMetacarpo) {
        this.mediaperimMetacarpo = mediaperimMetacarpo;
    }

    public Double getMediaCompPernasAnteriores() {
        return mediaCompPernasAnteriores;
    }

    public void setMediaCompPernasAnteriores(Double mediaCompPernasAnteriores) {
        this.mediaCompPernasAnteriores = mediaCompPernasAnteriores;
    }

    public Double getMediaCompPernasPosteriores() {
        return mediaCompPernasPosteriores;
    }

    public void setMediaCompPernasPosteriores(Double mediaCompPernasPosteriores) {
        this.mediaCompPernasPosteriores = mediaCompPernasPosteriores;
    }

    public Double getMediaCompCauda() {
        return mediaCompCauda;
    }

    public void setMediaCompCauda(Double mediaCompCauda) {
        this.mediaCompCauda = mediaCompCauda;
    }

    public Double getMediaPerimBaseCauda() {
        return mediaPerimBaseCauda;
    }

    public void setMediaPerimBaseCauda(Double mediaPerimBaseCauda) {
        this.mediaPerimBaseCauda = mediaPerimBaseCauda;
    }

    public Double getMediaCompTetos() {
        return mediaCompTetos;
    }

    public void setMediaCompTetos(Double mediaCompTetos) {
        this.mediaCompTetos = mediaCompTetos;
    }

    public Double getMediaCircEscroto() {
        return mediaCircEscroto;
    }

    public void setMediaCircEscroto(Double mediaCircEscroto) {
        this.mediaCircEscroto = mediaCircEscroto;
    }

    public Double getDesvioPesoVivo() {
        return desvioPesoVivo;
    }

    public void setDesvioPesoVivo(Double desvioPesoVivo) {
        this.desvioPesoVivo = desvioPesoVivo;
    }

    public Double getDesvioCompCabeca() {
        return desvioCompCabeca;
    }

    public void setDesvioCompCabeca(Double desvioCompCabeca) {
        this.desvioCompCabeca = desvioCompCabeca;
    }

    public Double getDesvioCompCranio() {
        return desvioCompCranio;
    }

    public void setDesvioCompCranio(Double desvioCompCranio) {
        this.desvioCompCranio = desvioCompCranio;
    }

    public Double getDesvioLargCabeca() {
        return desvioLargCabeca;
    }

    public void setDesvioLargCabeca(Double desvioLargCabeca) {
        this.desvioLargCabeca = desvioLargCabeca;
    }

    public Double getDesvioLongRosto() {
        return desvioLongRosto;
    }

    public void setDesvioLongRosto(Double desvioLongRosto) {
        this.desvioLongRosto = desvioLongRosto;
    }

    public Double getDesvioTamOrelhas() {
        return desvioTamOrelhas;
    }

    public void setDesvioTamOrelhas(Double desvioTamOrelhas) {
        this.desvioTamOrelhas = desvioTamOrelhas;
    }

    public Double getDesvioPerimPescoco() {
        return desvioPerimPescoco;
    }

    public void setDesvioPerimPescoco(Double desvioPerimPescoco) {
        this.desvioPerimPescoco = desvioPerimPescoco;
    }

    public Double getDesvioCompPescoco() {
        return desvioCompPescoco;
    }

    public void setDesvioCompPescoco(Double desvioCompPescoco) {
        this.desvioCompPescoco = desvioCompPescoco;
    }

    public Double getDesvioCompCorporal() {
        return desvioCompCorporal;
    }

    public void setDesvioCompCorporal(Double desvioCompCorporal) {
        this.desvioCompCorporal = desvioCompCorporal;
    }

    public Double getDesvioProfundidade() {
        return desvioProfundidade;
    }

    public void setDesvioProfundidade(Double desvioProfundidade) {
        this.desvioProfundidade = desvioProfundidade;
    }

    public Double getDesvioLargOmbros() {
        return desvioLargOmbros;
    }

    public void setDesvioLargOmbros(Double desvioLargOmbros) {
        this.desvioLargOmbros = desvioLargOmbros;
    }

    public Double getDesvioPerimToracico() {
        return desvioPerimToracico;
    }

    public void setDesvioPerimToracico(Double desvioPerimToracico) {
        this.desvioPerimToracico = desvioPerimToracico;
    }

    public Double getDesvioCompGarupa() {
        return desvioCompGarupa;
    }

    public void setDesvioCompGarupa(Double desvioCompGarupa) {
        this.desvioCompGarupa = desvioCompGarupa;
    }

    public Double getDesvioLargEntreIlios() {
        return desvioLargEntreIlios;
    }

    public void setDesvioLargEntreIlios(Double desvioLargEntreIlios) {
        this.desvioLargEntreIlios = desvioLargEntreIlios;
    }

    public Double getDesvioLargEntreIsquios() {
        return desvioLargEntreIsquios;
    }

    public void setDesvioLargEntreIsquios(Double desvioLargEntreIsquios) {
        this.desvioLargEntreIsquios = desvioLargEntreIsquios;
    }

    public Double getDesvioAltCernelha() {
        return desvioAltCernelha;
    }

    public void setDesvioAltCernelha(Double desvioAltCernelha) {
        this.desvioAltCernelha = desvioAltCernelha;
    }

    public Double getDesvioAltGarupa() {
        return desvioAltGarupa;
    }

    public void setDesvioAltGarupa(Double desvioAltGarupa) {
        this.desvioAltGarupa = desvioAltGarupa;
    }

    public Double getDesvioDistEntreVentreSolo() {
        return desvioDistEntreVentreSolo;
    }

    public void setDesvioDistEntreVentreSolo(Double desvioDistEntreVentreSolo) {
        this.desvioDistEntreVentreSolo = desvioDistEntreVentreSolo;
    }

    public Double getDesvioPerimTarso() {
        return desvioPerimTarso;
    }

    public void setDesvioPerimTarso(Double desvioPerimTarso) {
        this.desvioPerimTarso = desvioPerimTarso;
    }

    public Double getDesvioPerimMetatarso() {
        return desvioPerimMetatarso;
    }

    public void setDesvioPerimMetatarso(Double desvioPerimMetatarso) {
        this.desvioPerimMetatarso = desvioPerimMetatarso;
    }

    public Double getDesvioPerimCarpo() {
        return desvioPerimCarpo;
    }

    public void setDesvioPerimCarpo(Double desvioPerimCarpo) {
        this.desvioPerimCarpo = desvioPerimCarpo;
    }

    public Double getDesvioPerimMetacarpo() {
        return desvioPerimMetacarpo;
    }

    public void setDesvioPerimMetacarpo(Double desvioPerimMetacarpo) {
        this.desvioPerimMetacarpo = desvioPerimMetacarpo;
    }

    public Double getDesvioCompPernasAnteriores() {
        return desvioCompPernasAnteriores;
    }

    public void setDesvioCompPernasAnteriores(Double desvioCompPernasAnteriores) {
        this.desvioCompPernasAnteriores = desvioCompPernasAnteriores;
    }

    public Double getDesvioCompPernasPosteriores() {
        return desvioCompPernasPosteriores;
    }

    public void setDesvioCompPernasPosteriores(Double desvioCompPernasPosteriores) {
        this.desvioCompPernasPosteriores = desvioCompPernasPosteriores;
    }

    public Double getDesvioCompCauda() {
        return desvioCompCauda;
    }

    public void setDesvioCompCauda(Double desvioCompCauda) {
        this.desvioCompCauda = desvioCompCauda;
    }

    public Double getDesvioPerimBaseCauda() {
        return desvioPerimBaseCauda;
    }

    public void setDesvioPerimBaseCauda(Double desvioPerimBaseCauda) {
        this.desvioPerimBaseCauda = desvioPerimBaseCauda;
    }

    public Double getDesvioCompTetos() {
        return desvioCompTetos;
    }

    public void setDesvioCompTetos(Double desvioCompTetos) {
        this.desvioCompTetos = desvioCompTetos;
    }

    public Double getDesvioCircEscroto() {
        return desvioCircEscroto;
    }

    public void setDesvioCircEscroto(Double desvioCircEscroto) {
        this.desvioCircEscroto = desvioCircEscroto;
    }

    @Override
    public String toString() {
        return "MediaDesvioPadrao{" +
                "mediaPesoVivo=" + mediaPesoVivo +
                ", mediaCompCabeca=" + mediaCompCabeca +
                ", mediaCompCranio=" + mediaCompCranio +
                ", mediaLargCabeca=" + mediaLargCabeca +
                ", mediaLongRosto=" + mediaLongRosto +
                ", mediaTamOrelhas=" + mediaTamOrelhas +
                ", mediaPerimPescoco=" + mediaPerimPescoco +
                ", mediaCompPescoco=" + mediaCompPescoco +
                ", mediaCompCorporal=" + mediaCompCorporal +
                ", mediaProfundidade=" + mediaProfundidade +
                ", mediaLargOmbros=" + mediaLargOmbros +
                ", mediaPerimToracico=" + mediaPerimToracico +
                ", mediaCompGarupa=" + mediaCompGarupa +
                ", mediaLargEntreIlios=" + mediaLargEntreIlios +
                ", mediaLargEntreIsquios=" + mediaLargEntreIsquios +
                ", mediaAltCernelha=" + mediaAltCernelha +
                ", mediaAltGarupa=" + mediaAltGarupa +
                ", mediaDistEntreVentreSolo=" + mediaDistEntreVentreSolo +
                ", mediaPerimTarso=" + mediaPerimTarso +
                ", mediaPerimMetatarso=" + mediaPerimMetatarso +
                ", mediaPerimCarpo=" + mediaPerimCarpo +
                ", mediaperimMetacarpo=" + mediaperimMetacarpo +
                ", mediaCompPernasAnteriores=" + mediaCompPernasAnteriores +
                ", mediaCompPernasPosteriores=" + mediaCompPernasPosteriores +
                ", mediaCompCauda=" + mediaCompCauda +
                ", mediaPerimBaseCauda=" + mediaPerimBaseCauda +
                ", mediaCompTetos=" + mediaCompTetos +
                ", mediaCircEscroto=" + mediaCircEscroto +
                ", desvioPesoVivo=" + desvioPesoVivo +
                ", desvioCompCabeca=" + desvioCompCabeca +
                ", desvioCompCranio=" + desvioCompCranio +
                ", desvioLargCabeca=" + desvioLargCabeca +
                ", desvioLongRosto=" + desvioLongRosto +
                ", desvioTamOrelhas=" + desvioTamOrelhas +
                ", desvioPerimPescoco=" + desvioPerimPescoco +
                ", desvioCompPescoco=" + desvioCompPescoco +
                ", desvioCompCorporal=" + desvioCompCorporal +
                ", desvioProfundidade=" + desvioProfundidade +
                ", desvioLargOmbros=" + desvioLargOmbros +
                ", desvioPerimToracico=" + desvioPerimToracico +
                ", desvioCompGarupa=" + desvioCompGarupa +
                ", desvioLargEntreIlios=" + desvioLargEntreIlios +
                ", desvioLargEntreIsquios=" + desvioLargEntreIsquios +
                ", desvioAltCernelha=" + desvioAltCernelha +
                ", desvioAltGarupa=" + desvioAltGarupa +
                ", desvioDistEntreVentreSolo=" + desvioDistEntreVentreSolo +
                ", desvioPerimTarso=" + desvioPerimTarso +
                ", desvioPerimMetatarso=" + desvioPerimMetatarso +
                ", desvioPerimCarpo=" + desvioPerimCarpo +
                ", desvioPerimMetacarpo=" + desvioPerimMetacarpo +
                ", desvioCompPernasAnteriores=" + desvioCompPernasAnteriores +
                ", desvioCompPernasPosteriores=" + desvioCompPernasPosteriores +
                ", desvioCompCauda=" + desvioCompCauda +
                ", desvioPerimBaseCauda=" + desvioPerimBaseCauda +
                ", desvioCompTetos=" + desvioCompTetos +
                ", desvioCircEscroto=" + desvioCircEscroto +
                '}';
    }
}
