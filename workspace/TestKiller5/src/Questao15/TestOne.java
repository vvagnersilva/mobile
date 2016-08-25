package Questao15;

public class TestOne implements Runnable 
{ 
	public static void main(String[] args) 
	{
		Thread t = new Thread(new TestOne());
		
		t.start();
		
		System.out.print("Started");
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("Complete");
	}

	public void run()
	{
		for (int i=0; i < 4; i++)
		{
			System.out.print(i);
		}
	}
}
