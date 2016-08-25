package Questao111;

import java.util.ArrayList;
import java.util.List;

public class Test
{
	public void takeList (List<? extends String> list)
	{ 
		list.add("Foo");
		
		list = new ArrayList<String>();
		
		list = new ArrayList<Object>();
		
		String s = list.get(0);
		
		Object o = list;		
	}
	
	public static void main(String[] args)
	{		
	}
}

