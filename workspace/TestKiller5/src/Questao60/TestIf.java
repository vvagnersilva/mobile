package Questao60;

public class TestIf
{
	public void testIfA()
	{
		if (testIfB("true"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("Not true");
		}
	}

	public Boolean testIfB(String str)
	{
		return (Boolean.valueOf(str));
	}

	public static void main(String[] args)
	{
		new TestIf().testIfA();
	}
}
