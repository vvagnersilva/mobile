package Questao172;

public class Test
{
	
	public static void main(String[] args)
	{
		for (int i=0; i<=10; i++)
		{
			if (i > 6) break;
		}
		System.out.println(i); // variavel morreu no escopo
	}
}

