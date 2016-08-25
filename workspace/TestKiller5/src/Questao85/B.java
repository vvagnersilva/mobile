package Questao85;

import java.io.IOException;

public class Test
{
	public enum Dogs {collie, harrier, shepherd};
	
	public static void main(String[] args)
	{
		Dogs myDog = Dogs.shepherd;
		
		switch(myDog)
		{
			case collie:
				System.out.println("collie");
			case default:
				System.out.println("retriever");
			case harrier:
				System.out.println("harrier");
		}		
	}
}

