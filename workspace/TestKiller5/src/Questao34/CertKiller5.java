package Questao34;

public class CertKiller5 
{
	public static void main(String[] yahoo) 
	{
		String [] yahoo2 = {"5", "a", "b", "c"};

		yahoo = yahoo2;

		System.out.println(yahoo.length);			
		
		for (int x = 0; x < yahoo.length; x++)
		{
			System.out.println(yahoo[x] + " ");			
		}
	}
}
