package Testes;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	public static void main (String [] args) {
		
		System.out.println(new Fibonacci(5).compute());
		
	} 

	final int n;

	Fibonacci(int n) {
		this.n = n;
	}

	protected Integer compute() 
	{
		if (n <= 1)
		{
			return n;
		}

		Fibonacci f1 = new Fibonacci(n-1);

		f1.fork();

		Fibonacci f2 = new Fibonacci(n-2);
		
		return f2.compute() + f1.join(); // Line **
		
		//return f2.compute() + f1.join(); // Line **
	}
}
