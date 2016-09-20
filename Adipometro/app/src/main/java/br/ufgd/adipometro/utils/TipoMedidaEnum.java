package br.ufgd.adipometro.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoMedidaEnum.
 */
public enum TipoMedidaEnum {

    COSTAS("C", "Costas"),
    PEITO("P", "Peito");

    private final String codigo;
    private final String descricao;

    TipoMedidaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o valor do enum
     *
     * @param codigo
     * @return CondicaoAmostraEnum
     */
    public static TipoMedidaEnum valueOf(int codigo) {
        TipoMedidaEnum value = null;
        for (TipoMedidaEnum element : TipoMedidaEnum.values()) {
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
    public static List<TipoMedidaEnum> getLista() {
        List<TipoMedidaEnum> listaCategoria = new ArrayList<TipoMedidaEnum>();
        for (TipoMedidaEnum element : TipoMedidaEnum.values()) {
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
    public static TipoMedidaEnum getByCodigo(String codigo) {
        for (TipoMedidaEnum element : TipoMedidaEnum.values()) {
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
