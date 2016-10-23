package br.edu.pantaneiro.enums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe TipoCategoriaAnimalEnum.
 * <p>
 * Inicialmente vamos ter somente Cordeiro Macho, mas a intenção é expandir as categorias.
 */
public enum TipoCategoriaOvinaEnum {

    CORDEIRO("CO", "Cordeiro dente de leite"),
    CORDEIRA("CA", "Cordeira dente de leite"),
    BORREGO("BO", "2 dentes"),
    BORREGA("BA", "2 dentes"),
    OVELHA("OV", "3 ou 4 dentes"),
    CARNEIRO("CA", "3 ou 4 dentes");

    private final String codigo;
    private final String descricao;

    TipoCategoriaOvinaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o valor do enum
     *
     * @param codigo
     * @return CondicaoAmostraEnum
     */
    public static TipoCategoriaOvinaEnum valueOf(int codigo) {
        TipoCategoriaOvinaEnum value = null;
        for (TipoCategoriaOvinaEnum element : TipoCategoriaOvinaEnum.values()) {
            if (element.getCodigo().equals(codigo)) {
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
    public static List<TipoCategoriaOvinaEnum> getLista() {
        List<TipoCategoriaOvinaEnum> listaCategoria = new ArrayList<TipoCategoriaOvinaEnum>();
        for (TipoCategoriaOvinaEnum element : TipoCategoriaOvinaEnum.values()) {
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
    public static TipoCategoriaOvinaEnum getByCodigo(String codigo) {
        for (TipoCategoriaOvinaEnum element : TipoCategoriaOvinaEnum.values()) {
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
