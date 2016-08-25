package Questao170;

/**
 * A classe que trata excecao SomeException tem que  
 * herdar de Exception ou Throwable. A classe A 
 * tem que definir a mesma excecao da filha ou a filha tem
 * que definir subexcecoes da classe mae.
 *
 */

//class SomeException extends Exception
class SomeException //extends Throwable
{
}

class A
{
	public void doSmomething()  //throws SomeException  
	{
	}
}

public class B extends A
{
	public void doSmomething()  throws SomeException 
	{
	}
}

