package Questao67;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Questao33.Boochy;

public class Test
{
	public static void main(String[] args)
	{
		Object [] myObjects = { new Integer(12),
								new String("foo"),
								new Integer(5),
								new Boolean(true)
		};
			
		Arrays.sort(myObjects);
			
		for(int i=0; i< myObjects.length; i++)
		{
			System.out.println(myObjects[i].toString());
		}
	}
}

