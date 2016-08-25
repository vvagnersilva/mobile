package Questao48;

public class Certikiller
{
	public int x=12;
	
	public void method (int x) 
	{
		x+=x;
		
		System.out.println(x);
	}

	public static void main(String[] args)
	{
		new Certikiller().method(5);
	}
}
