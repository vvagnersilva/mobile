package br.gov.dprf.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoMedidaEnum.
 */
public enum TipoAssuntoEnum {

    DUVIDAS("1", "Dúvidas"),
    ELOGIOS("2", "Elogios"),
    SUGESTOES("3", "Sugestões");

    private final String codigo;
    private final String descricao;

    TipoAssuntoEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o valor do enum
     *
     * @param codigo
     * @return CondicaoAmostraEnum
     */
    public static TipoAssuntoEnum valueOf(int codigo) {
        TipoAssuntoEnum value = null;
        for (TipoAssuntoEnum element : TipoAssuntoEnum.values()) {
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
    public static List<TipoAssuntoEnum> getLista() {
        List<TipoAssuntoEnum> listaCategoria = new ArrayList<TipoAssuntoEnum>();
        for (TipoAssuntoEnum element : TipoAssuntoEnum.values()) {
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
    public static TipoAssuntoEnum getByCodigo(String codigo) {
        for (TipoAssuntoEnum element : TipoAssuntoEnum.values()) {
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
