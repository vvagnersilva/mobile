package Testes;

import java.util.concurrent.ThreadLocalRandom;


public class Questao20 { 

	public static void main (String [] args) { 
		
		// Mega sena
		for (int j = 0; j < 6; j++)
		{
			int i = ThreadLocalRandom.current().nextInt (1, 60); 

			System.out.println(i);
		}
	} 
}