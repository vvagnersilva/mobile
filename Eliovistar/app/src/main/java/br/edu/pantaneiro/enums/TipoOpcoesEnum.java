package br.edu.pantaneiro.enums;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoMedidaEnum.
 */
public enum TipoOpcoesEnum implements Parcelable {

    PROCEDENCIA(1, "Rebanho Institucional ou Particular"),
    RACA(2, "Raça"),
    CATEGORIA_OVINA(3, "Categoria Ovina"),
    SCORE_CORPORAL(4, "Score Corporal");

    private final Integer codigo;
    private final String descricao;

    TipoOpcoesEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    TipoOpcoesEnum(Parcel parcel) {
        this.codigo = parcel.readInt();
        this.descricao = parcel.readString();
    }

    /**
     * Retorna o valor do enum
     *
     * @param codigo
     * @return CondicaoAmostraEnum
     */
    public static TipoOpcoesEnum valueOf(int codigo) {
        TipoOpcoesEnum value = null;
        for (TipoOpcoesEnum element : TipoOpcoesEnum.values()) {
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
     * @return List<CondicaoAmostraEnum>
     */
    public static List<TipoOpcoesEnum> getLista() {
        List<TipoOpcoesEnum> listaCategoria = new ArrayList<TipoOpcoesEnum>();
        for (TipoOpcoesEnum element : TipoOpcoesEnum.values()) {
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
    public static TipoOpcoesEnum getByCodigo(Integer codigo) {
        for (TipoOpcoesEnum element : TipoOpcoesEnum.values()) {
            if (element.getCodigo() == codigo) {
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
    public Integer getCodigo() {
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
        dest.writeInt(codigo);
        dest.writeString(descricao);
    }

    public static final Parcelable.Creator<TipoOpcoesEnum>
            CREATOR = new Parcelable.Creator<TipoOpcoesEnum>() {

        public TipoOpcoesEnum createFromParcel(Parcel in) {
            return TipoOpcoesEnum.values()[in.readInt()];
        }

        public TipoOpcoesEnum[] newArray(int size) {
            return new TipoOpcoesEnum[size];
        }
    };
}
