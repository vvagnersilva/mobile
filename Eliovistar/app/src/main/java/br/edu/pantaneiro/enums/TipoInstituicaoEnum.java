package br.edu.pantaneiro.enums;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoMedidaEnum.
 */
public enum TipoInstituicaoEnum {

    UFGD("UF", "Ufgd"),
    ANHANGUERA("AH", "Anhanguera"),
    EMBRAPA_GADO_CORTE("EG", "Embrapa Gado de Corte"),
    EMBRAPA_PANTANAL("EP", "Embrapa Pantanal"),
    UNIDERP("UD", "Uniderp");

    private final String codigo;
    private final String descricao;

    TipoInstituicaoEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna a lista do enum
     *
     * @return List<CondicaoAmostraEnum>
     */
    public static List<TipoInstituicaoEnum> getLista() {
        List<TipoInstituicaoEnum> listaCategoria = new ArrayList<TipoInstituicaoEnum>();
        for (TipoInstituicaoEnum element : TipoInstituicaoEnum.values()) {
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
    public static TipoInstituicaoEnum getByCodigo(String codigo) {
        for (TipoInstituicaoEnum element : TipoInstituicaoEnum.values()) {
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

}
