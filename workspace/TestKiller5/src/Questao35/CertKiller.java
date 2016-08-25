package Questao35;

public class CertKiller 
{
	public static void main(String[] str) 
	{
		int check =4;
		
		if (check = str.length())
		{
			System.out.println(str.charAt(check -= 1) + " ");
		}
		else
		{
			System.out.println(str.charAt(0) + " ");	
		}
	}
}
