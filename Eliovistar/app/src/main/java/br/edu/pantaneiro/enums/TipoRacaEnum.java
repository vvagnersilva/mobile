package br.edu.pantaneiro.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoRacaEnum.
 */
public enum TipoRacaEnum {

    PANTANEIRA("1", "Pantaneira"),
    CRIOULA("2", "Crioula Lanada"),
    MORADA_NOVA("3", "Morada Nova"),
    KARAKUL("4", "Karakul");

    private final String codigo;
    private final String descricao;

    TipoRacaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

}
