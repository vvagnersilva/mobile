package classeInterna;

/*
 * Uma classe aninhada estatica eh simplesmente aquela que 
 * eh um membro estatico da classe encapsuladora
 * 
 * Uma classe aninhada estatica nao pode acessar membros
 * nao-estaticos da classe externa.
 */
public class ClasseInternaStatica 
{
	public int x;
	public static int y = 20;

	static class InternaStatica
	{
		public void teste()
		{
			//System.out.println(x);// variavel nao static
			System.out.println(y);// variavel static
		}
	}
	public static void main(String[] args) 
	{
		ClasseInternaStatica.InternaStatica obj = new ClasseInternaStatica.InternaStatica();
		obj.teste();
		
		// Na verdade, voce nao precisa de uma instancia da classe externa para
		// instanciar uma classe aninhada estatica.
		InternaStatica in = new InternaStatica();
		in.teste();
	}
}
