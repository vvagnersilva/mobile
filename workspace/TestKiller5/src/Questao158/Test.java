package Questao158;

public class Test
{
	static final int[] a = {100,200};
	
	static final int[] b;
	
	static {b = new int[2]; a[0] = 100; a[1] = 200; };
	
	static final int[] c = new int[2]{100, 200};
	
	static final int[] d;
	
	static void init()
	{
		d = new int[3];
		d[0] = 100;
		d[1] = 200;
	}
	
	public static void main(String[] args)
	{		
	}
}

