package Questao49;

public class Certikiller
{
	public static void main(String[] args)
	{
		Object obj = new int[]{1,2,3};
		int [] someArray = (int[]) obj;
		for(int i : someArray)
		{
			System.out.print(i + " ");
		}
	}
}
