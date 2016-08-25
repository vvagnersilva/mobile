package classeInterna;

/*
interface Quadrilatero
{
	void delta();
	void alfa();
}
*/

/*
 * OU
 */

class Quadrilatero
{
	protected void delta()
	{
		System.out.println("Método Teste.delta();");
	}

	public void alfa()
	{
		System.out.println("Método Teste.alfa();");
	}
}

public class ClasseInternaAnonima
{
	// A variavel de referencia quad aponta para uma instancia de Quadrilatero, 
	//  mas para a instancia de uma subclasse anonina (nao nomeada) de Quadrilatero.
	Quadrilatero quad = new Quadrilatero() 
	{
		public void delta()
		{
			System.out.println("Método delta() sobrescrito.");
		}

		public void alfa() 
		{
			System.out.println("Método alfa() sobrescrito.;");			
		}
	}; // o ponto-e-virgula eh necessario para finalizar a instrucao!!!

	public static void main(String args[])
	{
		ClasseInternaAnonima eci = new ClasseInternaAnonima();
		eci.quad.delta();
		eci.quad.alfa();
	}
}
