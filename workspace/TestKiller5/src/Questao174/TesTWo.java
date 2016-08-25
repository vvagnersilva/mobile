package Questao174;

public class TesTWo extends Thread
{	
	public void run()
	{
		System.out.println("Run ");
	}
	
	public void doIt()
	{
		System.out.println("doIt ");
	}
	
	public static void main(String[] args) throws InterruptedException // Ok, lanca excecao
	{
		TesTWo t = new TesTWo();
		
		t.start();
		t.join();
		t.run();
		t.doIt();
	}
}

