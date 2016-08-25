package Questao10;

public class CertKiller  
{
	/*
	 * Prioridade: Ampliacao, Boxing e varargs.
	 * */
	public static void go (Short n)
	{
		System.out.println("Short");
	}

	public static void go (short n)
	{
		System.out.println("SHORT");
	}

	public static void go (Long n)
	{
		System.out.println("LONG");
	}

	public static void main(String[] args) 
	{
		Short y = 6;
		int z = 7;
		long l = 3;
		
		go(y);
		go(l);
		//go(z);
	}
}
