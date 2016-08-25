package Questao59;

import java.util.ArrayList;
import java.util.Collections;

public class CertKiller
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		
		Collections.reverse(list);

		for( Object obj: list)
		{
			System.out.print(obj + " ");
		}
	}
}
