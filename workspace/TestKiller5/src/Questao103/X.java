package Questao103;

import java.util.ArrayList;

public class X
{
	public static void foo(ArrayList<Object> list) {}
	
	public static void main(String[] args)
	{
		ArrayList<String> x1 = new ArrayList<String>();
		//foo(x1);

		//ArrayList<Object> x2 = new ArrayList<String>();
		//foo(x2);
		
		ArrayList<Object> x3 = new ArrayList<Object>();
		foo(x3);
		
		ArrayList x4 = new ArrayList();
		foo(x4);
		
	}
}

