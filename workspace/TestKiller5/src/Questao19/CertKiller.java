package Questao19;

public class CertKiller  
{ 
	public static void main(String[] args) 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sleep");
	}
}
