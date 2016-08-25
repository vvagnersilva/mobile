package Questao142;

import java.util.Scanner;

public class Test
{
	public static void main(String[] args) 
	{
		String csv = "Sue, 5, true, 3";
		
		Scanner scanner = new Scanner(csv);
		
		scanner.useDelimiter(".");
		
		int age = scanner.nextInt();
	}
}
