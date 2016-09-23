package br.ufgd.adipometro.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoMedidaEnum.
 * <p>
 * Inicialmente vamos ter somente Cordeiro Macho, mas a intenção é expandir as categorias.
 */
public enum TipoCategoriaAnimalEnum {

    CORDEIRO_MACHO("1", "Cordeiro Mach"),
    CORDEIRO_FEMEA("2", "Cordeiro Fêmea");

    private final String codigo;
    private final String descricao;

    TipoCategoriaAnimalEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o valor do enum
     *
     * @param codigo
     * @return CondicaoAmostraEnum
     */
    public static TipoCategoriaAnimalEnum valueOf(int codigo) {
        TipoCategoriaAnimalEnum value = null;
        for (TipoCategoriaAnimalEnum element : TipoCategoriaAnimalEnum.values()) {
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
    public static List<TipoCategoriaAnimalEnum> getLista() {
        List<TipoCategoriaAnimalEnum> listaCategoria = new ArrayList<TipoCategoriaAnimalEnum>();
        for (TipoCategoriaAnimalEnum element : TipoCategoriaAnimalEnum.values()) {
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
    public static TipoCategoriaAnimalEnum getByCodigo(String codigo) {
        for (TipoCategoriaAnimalEnum element : TipoCategoriaAnimalEnum.values()) {
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
