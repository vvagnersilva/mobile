package classeInterna;

/*
 * Uma classe interna comum eh declarada dentro das chaves
 * de outra classe, mas fora de qualquer metodo ou outro
 * bloco de codigo.
 *
 * A classe interna eh um membro individual da classe
 * encapsuladora (externa), portanto, pode ser marcada
 * com qualquer modificador de acesso, final ou abstract.
 *
 * A classe interna tem acesso a todos os membros da
 * classe externa, ate os privados.
 */
public class classeInternaComum
{
	private int x = 10;
	/**
	 * A classe interna comum eh um membro da classe externa,
	 * exatamente como metodos e variaveis de instancia, portanto
	 * os modificadores a seguir podem ser aplicados a classe interna
	 * final, abstract, public, private, protected static e strictfp.
	 */
	class Soma
	{
		public void teste()
		{
			System.out.println("Valor de x = "+ x);
		}
	}
	
	public static void main(String[] args) 
	{
		classeInternaComum.Soma x = new classeInternaComum().new Soma();
		x.teste();
	}
}
