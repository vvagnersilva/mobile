package Questao83;

import java.io.IOException;

class A
{
	public void process() throws IOException
	{
		System.out.println("A");
	}
}
	
public class B extends A
{
	public void process() throws IOException
	{
		super.process();
		
		System.out.println("B");
		
		throw new IOException();
	}
	
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
		try 
		{
			new B().process();
		} 
		catch (IOException e) 
		{
			System.out.println("Exception");
		}
	}
}

