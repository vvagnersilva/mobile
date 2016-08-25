package Questao64;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			ArrayList<String> strings = new ArrayList<String>();

			strings.add("aAaA");
			strings.add("AaA");
			strings.add("aAa");
			strings.add("AAaa");
			
			Collections.sort(strings);

			for(String s:strings)
			{
				System.out.println(s + " ");
			}
			
			System.out.format("pi = %f",Math.PI);
			
			Dateformat df = DateFormat.getDate();
			
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException");
		}
	}
}

