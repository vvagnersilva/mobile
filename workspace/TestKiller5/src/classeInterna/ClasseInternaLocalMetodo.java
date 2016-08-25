package classeInterna;

/*
 * Uma classe interna local de metodo eh declarada dentro
 * de um metodo da classe encapsuladora.
 *
 * Para a classe interna ser usada, ela deve ser
 * instanciada dentro do metodo, porem depois de sua
 * definicão.
 *
 * Uma classe interna local de metodo nao pode usar
 * variaveis declaradas dentro do metodo, a menos que essas
 * sejam FINAL.
 *
 *
 */
public class ClasseInternaLocalMetodo 
{
	public void metodoX()
	{
		final int i = 10;// Variavel tem que ser marcada como final
		class InternaAoMetodo
		{
			public void testeInterno()
			{
				System.out.println("Valor de i = "+i);
				
			}
		}
		InternaAoMetodo obj = new InternaAoMetodo();
		obj.testeInterno();
	}
	public static void main(String[] args) 
	{
		ClasseInternaLocalMetodo lm = new ClasseInternaLocalMetodo();
		lm.metodoX();
	}
}
