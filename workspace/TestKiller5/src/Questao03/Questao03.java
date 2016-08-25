package Questao03;

public class Questao03
{
	public static void main(String[] args) 
	{
		String test = "This is a test";
		String[] tokens = test.split("\\s");// \s eh espaco em branco
		
		for (String string : tokens)
		{
			System.out.println(string);
		}		
		
		System.out.println(tokens.length);
	}
}
