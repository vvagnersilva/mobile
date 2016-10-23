package br.edu.pantaneiro.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import br.edu.pantaneiro.enums.TipoCategoriaOvinaEnum;
import br.edu.pantaneiro.enums.TipoInstituicaoEnum;
import br.edu.pantaneiro.enums.TipoRacaEnum;

/**
 * ss
 *
 * @author wagner
 */
public class Morfometricas implements Serializable {

    private String sexo;
    private Integer idade;
    private Double scoreCorporal;
    private Double pesoVivo;
    private Double compCabeca;
    private Double compCranio;
    private Double largCabeca;
    private Double longRosto;
    private Double tamOrelhas;
    private Double perimPescoco;
    private Double compPescoco;
    private Double compCorporal;
    private Double profundidade;
    private Double largOmbros;
    private Double perimToracico;
    private Double compGarupa;
    private Double largEntreIlios;
    private Double largEntreIsquios;
    private Double altCernelha;
    private Double altGarupa;
    private Double distEntreVentreSolo;
    private Double perimTarso;
    private Double perimMetatarso;
    private Double perimCarpo;
    private Double perimMetacarpo;
    private Double compPernasAnteriores;
    private Double compPernasPosteriores;
    private Double compCauda;
    private Double perimBaseCauda;
    private Double compTetos;
    private Double circEscroto;
    private TipoInstituicaoEnum tpInstituicaoEnum;
    private TipoRacaEnum tpRacaEnum;
    private TipoCategoriaOvinaEnum tpCategoriaOvinaEnum;

    public Morfometricas() {
    }

    public Morfometricas(Double compCranio, String sexo, Integer idade, Double scoreCorporal, Double pesoVivo, Double compCabeca, Double largCabeca, Double longRosto, Double tamOrelhas, Double perimPescoco, Double compPescoco, Double compCorporal, Double profundidade, Double largOmbros, Double perimToracico, Double compGarupa, Double largEntreIlios, Double largEntreIsquios, Double altCernelha, Double altGarupa, Double distEntreVentreSolo, Double perimTarso, Double perimMetatarso, Double perimCarpo, Double perimMetacarpo, Double compPernasAnteriores, Double compPernasPosteriores, Double compCauda, Double perimBaseCauda, Double compTetos, Double circEscroto, TipoInstituicaoEnum tpInstituicaoEnum, TipoRacaEnum tpRacaEnum, TipoCategoriaOvinaEnum tpCategoriaOvinaEnum) {
        this.compCranio = compCranio;
        this.sexo = sexo;
        this.idade = idade;
        this.scoreCorporal = scoreCorporal;
        this.pesoVivo = pesoVivo;
        this.compCabeca = compCabeca;
        this.largCabeca = largCabeca;
        this.longRosto = longRosto;
        this.tamOrelhas = tamOrelhas;
        this.perimPescoco = perimPescoco;
        this.compPescoco = compPescoco;
        this.compCorporal = compCorporal;
        this.profundidade = profundidade;
        this.largOmbros = largOmbros;
        this.perimToracico = perimToracico;
        this.compGarupa = compGarupa;
        this.largEntreIlios = largEntreIlios;
        this.largEntreIsquios = largEntreIsquios;
        this.altCernelha = altCernelha;
        this.altGarupa = altGarupa;
        this.distEntreVentreSolo = distEntreVentreSolo;
        this.perimTarso = perimTarso;
        this.perimMetatarso = perimMetatarso;
        this.perimCarpo = perimCarpo;
        this.perimMetacarpo = perimMetacarpo;
        this.compPernasAnteriores = compPernasAnteriores;
        this.compPernasPosteriores = compPernasPosteriores;
        this.compCauda = compCauda;
        this.perimBaseCauda = perimBaseCauda;
        this.compTetos = compTetos;
        this.circEscroto = circEscroto;
        this.tpInstituicaoEnum = tpInstituicaoEnum;
        this.tpRacaEnum = tpRacaEnum;
        this.tpCategoriaOvinaEnum = tpCategoriaOvinaEnum;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getScoreCorporal() {
        return scoreCorporal;
    }

    public void setScoreCorporal(Double scoreCorporal) {
        this.scoreCorporal = scoreCorporal;
    }

    public Double getPesoVivo() {
        return pesoVivo;
    }

    public void setPesoVivo(Double pesoVivo) {
        this.pesoVivo = pesoVivo;
    }

    public Double getCompCabeca() {
        return compCabeca;
    }

    public void setCompCabeca(Double compCabeca) {
        this.compCabeca = compCabeca;
    }

    public Double getCompCranio() {
        return compCranio;
    }

    public void setCompCranio(Double compCranio) {
        this.compCranio = compCranio;
    }

    public Double getLargCabeca() {
        return largCabeca;
    }

    public void setLargCabeca(Double largCabeca) {
        this.largCabeca = largCabeca;
    }

    public Double getLongRosto() {
        return longRosto;
    }

    public void setLongRosto(Double longRosto) {
        this.longRosto = longRosto;
    }

    public Double getTamOrelhas() {
        return tamOrelhas;
    }

    public void setTamOrelhas(Double tamOrelhas) {
        this.tamOrelhas = tamOrelhas;
    }

    public Double getPerimPescoco() {
        return perimPescoco;
    }

    public void setPerimPescoco(Double perimPescoco) {
        this.perimPescoco = perimPescoco;
    }

    public Double getCompPescoco() {
        return compPescoco;
    }

    public void setCompPescoco(Double compPescoco) {
        this.compPescoco = compPescoco;
    }

    public Double getCompCorporal() {
        return compCorporal;
    }

    public void setCompCorporal(Double compCorporal) {
        this.compCorporal = compCorporal;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public Double getLargOmbros() {
        return largOmbros;
    }

    public void setLargOmbros(Double largOmbros) {
        this.largOmbros = largOmbros;
    }

    public Double getPerimToracico() {
        return perimToracico;
    }

    public void setPerimToracico(Double perimToracico) {
        this.perimToracico = perimToracico;
    }

    public Double getCompGarupa() {
        return compGarupa;
    }

    public void setCompGarupa(Double compGarupa) {
        this.compGarupa = compGarupa;
    }

    public Double getLargEntreIlios() {
        return largEntreIlios;
    }

    public void setLargEntreIlios(Double largEntreIlios) {
        this.largEntreIlios = largEntreIlios;
    }

    public Double getLargEntreIsquios() {
        return largEntreIsquios;
    }

    public void setLargEntreIsquios(Double largEntreIsquios) {
        this.largEntreIsquios = largEntreIsquios;
    }

    public Double getAltCernelha() {
        return altCernelha;
    }

    public void setAltCernelha(Double altCernelha) {
        this.altCernelha = altCernelha;
    }

    public Double getAltGarupa() {
        return altGarupa;
    }

    public void setAltGarupa(Double altGarupa) {
        this.altGarupa = altGarupa;
    }

    public Double getDistEntreVentreSolo() {
        return distEntreVentreSolo;
    }

    public void setDistEntreVentreSolo(Double distEntreVentreSolo) {
        this.distEntreVentreSolo = distEntreVentreSolo;
    }

    public Double getPerimTarso() {
        return perimTarso;
    }

    public void setPerimTarso(Double perimTarso) {
        this.perimTarso = perimTarso;
    }

    public Double getPerimMetatarso() {
        return perimMetatarso;
    }

    public void setPerimMetatarso(Double perimMetatarso) {
        this.perimMetatarso = perimMetatarso;
    }

    public Double getPerimCarpo() {
        return perimCarpo;
    }

    public void setPerimCarpo(Double perimCarpo) {
        this.perimCarpo = perimCarpo;
    }

    public Double getPerimMetacarpo() {
        return perimMetacarpo;
    }

    public void setPerimMetacarpo(Double perimMetacarpo) {
        this.perimMetacarpo = perimMetacarpo;
    }

    public Double getCompPernasAnteriores() {
        return compPernasAnteriores;
    }

    public void setCompPernasAnteriores(Double compPernasAnteriores) {
        this.compPernasAnteriores = compPernasAnteriores;
    }

    public Double getCompPernasPosteriores() {
        return compPernasPosteriores;
    }

    public void setCompPernasPosteriores(Double compPernasPosteriores) {
        this.compPernasPosteriores = compPernasPosteriores;
    }

    public Double getCompCauda() {
        return compCauda;
    }

    public void setCompCauda(Double compCauda) {
        this.compCauda = compCauda;
    }

    public Double getPerimBaseCauda() {
        return perimBaseCauda;
    }

    public void setPerimBaseCauda(Double perimBaseCauda) {
        this.perimBaseCauda = perimBaseCauda;
    }

    public Double getCompTetos() {
        return compTetos;
    }

    public void setCompTetos(Double compTetos) {
        this.compTetos = compTetos;
    }

    public Double getCircEscroto() {
        return circEscroto;
    }

    public void setCircEscroto(Double circEscroto) {
        this.circEscroto = circEscroto;
    }

    public TipoInstituicaoEnum getTpInstituicaoEnum() {
        return tpInstituicaoEnum;
    }

    public void setTpInstituicaoEnum(TipoInstituicaoEnum tpInstituicaoEnum) {
        this.tpInstituicaoEnum = tpInstituicaoEnum;
    }

    public TipoRacaEnum getTpRacaEnum() {
        return tpRacaEnum;
    }

    public void setTpRacaEnum(TipoRacaEnum tpRacaEnum) {
        this.tpRacaEnum = tpRacaEnum;
    }

    public TipoCategoriaOvinaEnum getTpCategoriaOvinaEnum() {
        return tpCategoriaOvinaEnum;
    }

    public void setTpCategoriaOvinaEnum(TipoCategoriaOvinaEnum tpCategoriaOvinaEnum) {
        this.tpCategoriaOvinaEnum = tpCategoriaOvinaEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Morfometricas that = (Morfometricas) o;

        if (getSexo() != null ? !getSexo().equals(that.getSexo()) : that.getSexo() != null)
            return false;
        if (getIdade() != null ? !getIdade().equals(that.getIdade()) : that.getIdade() != null)
            return false;
        if (getScoreCorporal() != null ? !getScoreCorporal().equals(that.getScoreCorporal()) : that.getScoreCorporal() != null)
            return false;
        if (getPesoVivo() != null ? !getPesoVivo().equals(that.getPesoVivo()) : that.getPesoVivo() != null)
            return false;
        if (getCompCabeca() != null ? !getCompCabeca().equals(that.getCompCabeca()) : that.getCompCabeca() != null)
            return false;
        if (getCompCranio() != null ? !getCompCranio().equals(that.getCompCranio()) : that.getCompCranio() != null)
            return false;
        if (getLargCabeca() != null ? !getLargCabeca().equals(that.getLargCabeca()) : that.getLargCabeca() != null)
            return false;
        if (getLongRosto() != null ? !getLongRosto().equals(that.getLongRosto()) : that.getLongRosto() != null)
            return false;
        if (getTamOrelhas() != null ? !getTamOrelhas().equals(that.getTamOrelhas()) : that.getTamOrelhas() != null)
            return false;
        if (getPerimPescoco() != null ? !getPerimPescoco().equals(that.getPerimPescoco()) : that.getPerimPescoco() != null)
            return false;
        if (getCompPescoco() != null ? !getCompPescoco().equals(that.getCompPescoco()) : that.getCompPescoco() != null)
            return false;
        if (getCompCorporal() != null ? !getCompCorporal().equals(that.getCompCorporal()) : that.getCompCorporal() != null)
            return false;
        if (getProfundidade() != null ? !getProfundidade().equals(that.getProfundidade()) : that.getProfundidade() != null)
            return false;
        if (getLargOmbros() != null ? !getLargOmbros().equals(that.getLargOmbros()) : that.getLargOmbros() != null)
            return false;
        if (getPerimToracico() != null ? !getPerimToracico().equals(that.getPerimToracico()) : that.getPerimToracico() != null)
            return false;
        if (getCompGarupa() != null ? !getCompGarupa().equals(that.getCompGarupa()) : that.getCompGarupa() != null)
            return false;
        if (getLargEntreIlios() != null ? !getLargEntreIlios().equals(that.getLargEntreIlios()) : that.getLargEntreIlios() != null)
            return false;
        if (getLargEntreIsquios() != null ? !getLargEntreIsquios().equals(that.getLargEntreIsquios()) : that.getLargEntreIsquios() != null)
            return false;
        if (getAltCernelha() != null ? !getAltCernelha().equals(that.getAltCernelha()) : that.getAltCernelha() != null)
            return false;
        if (getAltGarupa() != null ? !getAltGarupa().equals(that.getAltGarupa()) : that.getAltGarupa() != null)
            return false;
        if (getDistEntreVentreSolo() != null ? !getDistEntreVentreSolo().equals(that.getDistEntreVentreSolo()) : that.getDistEntreVentreSolo() != null)
            return false;
        if (getPerimTarso() != null ? !getPerimTarso().equals(that.getPerimTarso()) : that.getPerimTarso() != null)
            return false;
        if (getPerimMetatarso() != null ? !getPerimMetatarso().equals(that.getPerimMetatarso()) : that.getPerimMetatarso() != null)
            return false;
        if (getPerimCarpo() != null ? !getPerimCarpo().equals(that.getPerimCarpo()) : that.getPerimCarpo() != null)
            return false;
        if (getPerimMetacarpo() != null ? !getPerimMetacarpo().equals(that.getPerimMetacarpo()) : that.getPerimMetacarpo() != null)
            return false;
        if (getCompPernasAnteriores() != null ? !getCompPernasAnteriores().equals(that.getCompPernasAnteriores()) : that.getCompPernasAnteriores() != null)
            return false;
        if (getCompPernasPosteriores() != null ? !getCompPernasPosteriores().equals(that.getCompPernasPosteriores()) : that.getCompPernasPosteriores() != null)
            return false;
        if (getCompCauda() != null ? !getCompCauda().equals(that.getCompCauda()) : that.getCompCauda() != null)
            return false;
        if (getPerimBaseCauda() != null ? !getPerimBaseCauda().equals(that.getPerimBaseCauda()) : that.getPerimBaseCauda() != null)
            return false;
        if (getCompTetos() != null ? !getCompTetos().equals(that.getCompTetos()) : that.getCompTetos() != null)
            return false;
        if (getCircEscroto() != null ? !getCircEscroto().equals(that.getCircEscroto()) : that.getCircEscroto() != null)
            return false;
        if (getTpInstituicaoEnum() != that.getTpInstituicaoEnum()) return false;
        if (getTpRacaEnum() != that.getTpRacaEnum()) return false;
        return getTpCategoriaOvinaEnum() == that.getTpCategoriaOvinaEnum();

    }

    @Override
    public int hashCode() {
        int result = getSexo() != null ? getSexo().hashCode() : 0;
        result = 31 * result + (getIdade() != null ? getIdade().hashCode() : 0);
        result = 31 * result + (getScoreCorporal() != null ? getScoreCorporal().hashCode() : 0);
        result = 31 * result + (getPesoVivo() != null ? getPesoVivo().hashCode() : 0);
        result = 31 * result + (getCompCabeca() != null ? getCompCabeca().hashCode() : 0);
        result = 31 * result + (getCompCranio() != null ? getCompCranio().hashCode() : 0);
        result = 31 * result + (getLargCabeca() != null ? getLargCabeca().hashCode() : 0);
        result = 31 * result + (getLongRosto() != null ? getLongRosto().hashCode() : 0);
        result = 31 * result + (getTamOrelhas() != null ? getTamOrelhas().hashCode() : 0);
        result = 31 * result + (getPerimPescoco() != null ? getPerimPescoco().hashCode() : 0);
        result = 31 * result + (getCompPescoco() != null ? getCompPescoco().hashCode() : 0);
        result = 31 * result + (getCompCorporal() != null ? getCompCorporal().hashCode() : 0);
        result = 31 * result + (getProfundidade() != null ? getProfundidade().hashCode() : 0);
        result = 31 * result + (getLargOmbros() != null ? getLargOmbros().hashCode() : 0);
        result = 31 * result + (getPerimToracico() != null ? getPerimToracico().hashCode() : 0);
        result = 31 * result + (getCompGarupa() != null ? getCompGarupa().hashCode() : 0);
        result = 31 * result + (getLargEntreIlios() != null ? getLargEntreIlios().hashCode() : 0);
        result = 31 * result + (getLargEntreIsquios() != null ? getLargEntreIsquios().hashCode() : 0);
        result = 31 * result + (getAltCernelha() != null ? getAltCernelha().hashCode() : 0);
        result = 31 * result + (getAltGarupa() != null ? getAltGarupa().hashCode() : 0);
        result = 31 * result + (getDistEntreVentreSolo() != null ? getDistEntreVentreSolo().hashCode() : 0);
        result = 31 * result + (getPerimTarso() != null ? getPerimTarso().hashCode() : 0);
        result = 31 * result + (getPerimMetatarso() != null ? getPerimMetatarso().hashCode() : 0);
        result = 31 * result + (getPerimCarpo() != null ? getPerimCarpo().hashCode() : 0);
        result = 31 * result + (getPerimMetacarpo() != null ? getPerimMetacarpo().hashCode() : 0);
        result = 31 * result + (getCompPernasAnteriores() != null ? getCompPernasAnteriores().hashCode() : 0);
        result = 31 * result + (getCompPernasPosteriores() != null ? getCompPernasPosteriores().hashCode() : 0);
        result = 31 * result + (getCompCauda() != null ? getCompCauda().hashCode() : 0);
        result = 31 * result + (getPerimBaseCauda() != null ? getPerimBaseCauda().hashCode() : 0);
        result = 31 * result + (getCompTetos() != null ? getCompTetos().hashCode() : 0);
        result = 31 * result + (getCircEscroto() != null ? getCircEscroto().hashCode() : 0);
        result = 31 * result + (getTpInstituicaoEnum() != null ? getTpInstituicaoEnum().hashCode() : 0);
        result = 31 * result + (getTpRacaEnum() != null ? getTpRacaEnum().hashCode() : 0);
        result = 31 * result + (getTpCategoriaOvinaEnum() != null ? getTpCategoriaOvinaEnum().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AvaliacaoIndividual{" +
                "sexo='" + sexo + '\'' +
                ", idade=" + idade +
                ", scoreCorporal=" + scoreCorporal +
                ", pesoVivo=" + pesoVivo +
                ", compCabeca=" + compCabeca +
                ", compCranio=" + compCranio +
                ", largCabeca=" + largCabeca +
                ", longRosto=" + longRosto +
                ", tamOrelhas=" + tamOrelhas +
                ", perimPescoco=" + perimPescoco +
                ", compPescoco=" + compPescoco +
                ", compCorporal=" + compCorporal +
                ", profundidade=" + profundidade +
                ", largOmbros=" + largOmbros +
                ", perimToracico=" + perimToracico +
                ", compGarupa=" + compGarupa +
                ", largEntreIlios=" + largEntreIlios +
                ", largEntreIsquios=" + largEntreIsquios +
                ", altCernelha=" + altCernelha +
                ", altGarupa=" + altGarupa +
                ", distEntreVentreSolo=" + distEntreVentreSolo +
                ", perimTarso=" + perimTarso +
                ", perimMetatarso=" + perimMetatarso +
                ", perimCarpo=" + perimCarpo +
                ", perimMetacarpo=" + perimMetacarpo +
                ", compPernasAnteriores=" + compPernasAnteriores +
                ", compPernasPosteriores=" + compPernasPosteriores +
                ", compCauda=" + compCauda +
                ", perimBaseCauda=" + perimBaseCauda +
                ", compTetos=" + compTetos +
                ", circEscroto=" + circEscroto +
                ", tpInstituicaoEnum=" + tpInstituicaoEnum +
                ", tpRacaEnum=" + tpRacaEnum +
                ", tpCategoriaOvinaEnum=" + tpCategoriaOvinaEnum +
                '}';
    }
}
