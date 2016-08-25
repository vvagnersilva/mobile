package Questao152;

public class Ball
{
	public enum Color {RED, GREEN, BLUE};
	public void foo()
	{
		for (Color c: Color.values())
		{
			System.out.println(c);
		}
	}
	
	public static void main(String[] args)
	{
		new Ball().foo();	
	}
}

