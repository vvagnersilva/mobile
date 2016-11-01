package br.edu.pantaneiro.enums;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoSexoEnum.
 */
public enum TipoSexoEnum implements Parcelable {

    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino");

    private final String codigo;
    private final String descricao;

    TipoSexoEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    TipoSexoEnum(Parcel parcel) {
        this.codigo = parcel.readString();
        this.descricao = parcel.readString();
    }

    /**
     *
     * @param codigo
     * @return
     */
    public static TipoSexoEnum getByCodigo(Integer codigo) {
        for (TipoSexoEnum element : TipoSexoEnum.values()) {
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

    public static final Parcelable.Creator<TipoSexoEnum>
            CREATOR = new Parcelable.Creator<TipoSexoEnum>() {

        public TipoSexoEnum createFromParcel(Parcel in) {
            return TipoSexoEnum.values()[in.readInt()];
        }

        public TipoSexoEnum[] newArray(int size) {
            return new TipoSexoEnum[size];
        }
    };
}
