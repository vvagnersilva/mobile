package Questao70;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

import Questao33.Boochy;

public class PQ
{
	public static void main(String[] args)
	{
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
	
		pq.add("carrot");
		pq.add("apple");
		pq.add("banana");
		
		for (String s : pq)
		{
			System.out.println(s);
		}

		System.out.println(pq.poll() + " : " + pq.peek());
	}
}

