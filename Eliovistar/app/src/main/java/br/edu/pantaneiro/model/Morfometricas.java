package br.edu.pantaneiro.model;

import android.os.Parcel;
import android.os.Parcelable;

import br.edu.pantaneiro.enums.TipoCategoriaOvinaEnum;
import br.edu.pantaneiro.enums.TipoInstituicaoEnum;
import br.edu.pantaneiro.enums.TipoRacaEnum;
import br.edu.pantaneiro.enums.TipoSexoEnum;

/**
 * Classe com os dados das medidas morfometricas.
 *
 * @author wagner
 */
public class Morfometricas implements Parcelable {

    private TipoSexoEnum csSexo;
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
    private TipoInstituicaoEnum csInstituicaoEnum;
    private TipoRacaEnum csRacaEnum;
    private TipoCategoriaOvinaEnum csCategoriaOvinaEnum;

    public Morfometricas() {
    }

    public Morfometricas(Parcel parcel) {

        this.csSexo = (TipoSexoEnum) parcel.readValue(TipoSexoEnum.class.getClassLoader());
        this.idade = parcel.readInt();
        this.scoreCorporal = parcel.readDouble();
        this.pesoVivo = parcel.readDouble();
        this.compCabeca = parcel.readDouble();
        this.compCranio = parcel.readDouble();
        this.largCabeca = parcel.readDouble();
        this.longRosto = parcel.readDouble();
        this.tamOrelhas = parcel.readDouble();
        this.perimPescoco = parcel.readDouble();
        this.compPescoco = parcel.readDouble();
        this.compCorporal = parcel.readDouble();
        this.profundidade = parcel.readDouble();
        this.largOmbros = parcel.readDouble();
        this.perimToracico = parcel.readDouble();
        this.compGarupa = parcel.readDouble();
        this.largEntreIlios = parcel.readDouble();
        this.largEntreIsquios = parcel.readDouble();
        this.altCernelha = parcel.readDouble();
        this.altGarupa = parcel.readDouble();
        this.distEntreVentreSolo = parcel.readDouble();
        this.perimTarso = parcel.readDouble();
        this.perimMetatarso = parcel.readDouble();
        this.perimCarpo = parcel.readDouble();
        this.perimMetacarpo = parcel.readDouble();
        this.compPernasAnteriores = parcel.readDouble();
        this.compPernasPosteriores = parcel.readDouble();
        this.compCauda = parcel.readDouble();
        this.perimBaseCauda = parcel.readDouble();
        this.compTetos = parcel.readDouble();
        this.circEscroto = parcel.readDouble();

        this.csInstituicaoEnum = (TipoInstituicaoEnum) parcel.readValue(TipoInstituicaoEnum.class.getClassLoader());
        this.csRacaEnum = (TipoRacaEnum) parcel.readValue(TipoRacaEnum.class.getClassLoader());
        this.csCategoriaOvinaEnum = (TipoCategoriaOvinaEnum) parcel.readValue(TipoCategoriaOvinaEnum.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeValue(csSexo);
        dest.writeInt(idade);
        dest.writeDouble(scoreCorporal);
        dest.writeDouble(pesoVivo);
        dest.writeDouble(compCabeca);
        dest.writeDouble(compCranio);
        dest.writeDouble(largCabeca);
        dest.writeDouble(longRosto);
        dest.writeDouble(tamOrelhas);
        dest.writeDouble(perimPescoco);
        dest.writeDouble(compPescoco);
        dest.writeDouble(compCorporal);
        dest.writeDouble(profundidade);
        dest.writeDouble(largOmbros);
        dest.writeDouble(perimToracico);
        dest.writeDouble(compGarupa);
        dest.writeDouble(largEntreIlios);
        dest.writeDouble(largEntreIsquios);
        dest.writeDouble(altCernelha);
        dest.writeDouble(altGarupa);
        dest.writeDouble(distEntreVentreSolo);
        dest.writeDouble(perimTarso);
        dest.writeDouble(perimMetatarso);
        dest.writeDouble(perimCarpo);
        dest.writeDouble(perimMetacarpo);
        dest.writeDouble(compPernasAnteriores);
        dest.writeDouble(compPernasPosteriores);
        dest.writeDouble(compCauda);
        dest.writeDouble(perimBaseCauda);
        dest.writeDouble(compTetos);
        dest.writeDouble(circEscroto);

        dest.writeValue(csInstituicaoEnum);
        dest.writeValue(csRacaEnum);
        dest.writeValue(csCategoriaOvinaEnum);
    }

    public static Creator<Morfometricas> getCREATOR() {
        return CREATOR;
    }

    public static final Parcelable.Creator<Morfometricas>
            CREATOR = new Parcelable.Creator<Morfometricas>() {

        public Morfometricas createFromParcel(Parcel in) {
            return new Morfometricas(in);
        }

        public Morfometricas[] newArray(int size) {
            return new Morfometricas[size];
        }
    };

    public TipoSexoEnum getCsSexo() {
        return csSexo;
    }

    public void setCsSexo(TipoSexoEnum csSexo) {
        this.csSexo = csSexo;
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

    public TipoInstituicaoEnum getCsInstituicaoEnum() {
        return csInstituicaoEnum;
    }

    public void setCsInstituicaoEnum(TipoInstituicaoEnum csInstituicaoEnum) {
        this.csInstituicaoEnum = csInstituicaoEnum;
    }

    public TipoRacaEnum getCsRacaEnum() {
        return csRacaEnum;
    }

    public void setCsRacaEnum(TipoRacaEnum csRacaEnum) {
        this.csRacaEnum = csRacaEnum;
    }

    public TipoCategoriaOvinaEnum getCsCategoriaOvinaEnum() {
        return csCategoriaOvinaEnum;
    }

    public void setCsCategoriaOvinaEnum(TipoCategoriaOvinaEnum csCategoriaOvinaEnum) {
        this.csCategoriaOvinaEnum = csCategoriaOvinaEnum;
    }
}
