package Questao79;

public class Test
{
	public static void test(String str)
	{
		if ( str == null | str.length() == 0)
		{
			System.out.println("String vazia");
		}
		else
		{
			System.out.println("String nao vazia");
		}
	}
	
	public static void main(String[] args)
	{
		test(null);
	}
}

