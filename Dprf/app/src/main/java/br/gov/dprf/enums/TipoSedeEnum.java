package br.gov.dprf.enums;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoSedeEnum.
 */
public enum TipoSedeEnum implements Parcelable {

    MATRIZ("M", "Matriz"),
    ALPHAVILLE("A", "Alphaville"),
    RIO_JANEIRO("R", "Rio de Janeiro"),
    BRASILIA("B", "Brasília");

    private final String codigo;
    private final String descricao;

    TipoSedeEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    TipoSedeEnum(Parcel parcel) {
        this.codigo = parcel.readString();
        this.descricao = parcel.readString();
    }
    /**
     * Retorna o valor do enum
     *
     * @param codigo
     * @return CondicaoAmostraEnum
     */
    public static TipoSedeEnum valueOf(int codigo) {
        TipoSedeEnum value = null;
        for (TipoSedeEnum element : TipoSedeEnum.values()) {
            if (element.codigo.equals(codigo)) {
                value = element;
                break;
            }
        }
        if (value == null) {
            throw new IllegalArgumentException(String.valueOf(codigo));
        }
        return value;
    }

    /**
     * Retorna a lista do enum
     *
     * @return List<TipoSedeEnum>
     */
    public static List<TipoSedeEnum> getLista() {
        List<TipoSedeEnum> listaCategoria = new ArrayList<TipoSedeEnum>();
        for (TipoSedeEnum element : TipoSedeEnum.values()) {
            listaCategoria.add(element);
        }
        return listaCategoria;
    }

    /**
     * Busca e retorna o enum pelo codigo
     *
     * @param codigo
     * @return TipoSedeEnum
     */
    public static TipoSedeEnum getByCodigo(String codigo) {
        for (TipoSedeEnum element : TipoSedeEnum.values()) {
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

    public static final Creator<TipoSedeEnum>
            CREATOR = new Creator<TipoSedeEnum>() {

        public TipoSedeEnum createFromParcel(Parcel in) {
            return TipoSedeEnum.values()[in.readInt()];
        }

        public TipoSedeEnum[] newArray(int size) {
            return new TipoSedeEnum[size];
        }
    };
}
