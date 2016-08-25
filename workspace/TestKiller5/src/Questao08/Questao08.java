package Questao08;

public class Questao08  
{
	public static void main(String[] args) 
	{
		StringBuffer s = new StringBuffer("123456789");
		
		/* delete - Remove os caracteres de um substring da sequencia. 
		 * A subsequencia comeca no inicio especificado e se estende 
		 * ate o caractere no indice final - 1 ou ate o fim da sequencia
		 * de caracteres como se nao existe. Se o inicio e igual ao final, 
		 * nenhuma alteracao sera feita.
		 */
		
		s.delete(0, 3).replace(1,3,"24").delete(4,6);
		System.out.println(s);

		StringBuffer s2 = new StringBuffer("123456789");

		s2 = s2.delete(0, 3);
		System.out.println(s2);

		s2 = s2.replace(1,3,")");
		System.out.println(s2);

		s2 = s2.delete(2,5);
		System.out.println(s2);

		s2 = s2.insert(1,"24");
	}
}
