package Questao140;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Test
{
	public static Iterator reverse(List<String> list)
	{
		Collections.reverse(list);
		return (Iterator) list.iterator();
	}
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		
		for (Object obj : reverse(list)) 
		{
			
			System.out.println(obj + " ");
		}
	}
}

