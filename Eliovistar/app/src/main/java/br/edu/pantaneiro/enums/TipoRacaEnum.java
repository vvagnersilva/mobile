package br.edu.pantaneiro.enums;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoRacaEnum.
 */
public enum TipoRacaEnum implements Parcelable {

    PANTANEIRA("P", "Pantaneira"),
    CRIOULA("C", "Crioula Lanada"),
    MORADA_NOVA("M", "Morada Nova"),
    KARAKUL("K", "Karakul");

    private final String codigo;
    private final String descricao;

    TipoRacaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    TipoRacaEnum(Parcel parcel) {
        this.codigo = parcel.readString();
        this.descricao = parcel.readString();
    }

    /**
     * Retorna a lista do enum
     *
     * @return List<CondicaoAmostraEnum>
     */
    public static List<TipoRacaEnum> getLista() {
        List<TipoRacaEnum> listaCategoria = new ArrayList<TipoRacaEnum>();
        for (TipoRacaEnum element : TipoRacaEnum.values()) {
            listaCategoria.add(element);
        }
        return listaCategoria;
    }

    /**
     * Busca e retorna o enum pelo codigo
     *
     * @param codigo
     * @return CondicaoAmostraEnum
     */
    public static TipoRacaEnum getByCodigo(Integer codigo) {
        for (TipoRacaEnum element : TipoRacaEnum.values()) {
            if (element.getCodigo().equals(codigo)) {
                return element;
            }
        }
        return null;
    }

    /**
     * Recupera codigo.
     *
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Recupera descricao.
     *
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ordinal());
    }

    public static final Parcelable.Creator<TipoRacaEnum>
            CREATOR = new Parcelable.Creator<TipoRacaEnum>() {

        public TipoRacaEnum createFromParcel(Parcel in) {
            return TipoRacaEnum.values()[in.readInt()];
        }

        public TipoRacaEnum[] newArray(int size) {
            return new TipoRacaEnum[size];
        }
    };
}
