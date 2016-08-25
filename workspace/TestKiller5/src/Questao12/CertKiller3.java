package Questao12;

import java.util.Locale;
public class CertKiller3 implements Runnable  
{
	static Thread t;
	
	public  void   go()
	{
		synchronized(Thread.currentThread())
		{
		t.notify();
		}
	}
	
	public void run()
	{
		System.out.print("running");
		
		go();
	}
	
	public static void main(String[] args) 
	{
		 t = new Thread (new CertKiller3());
		t.run();
		t.run();
		t.start();
	}
}
