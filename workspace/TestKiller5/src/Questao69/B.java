package Questao69;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import Questao33.Boochy;

class A {}

public class B extends A
{
	public static void main(String[] args)
	{
		LinkedList<A> listA = new LinkedList<A>();
		
		LinkedList<B> listB = new LinkedList<B>();
		
		LinkedList<Object> listO = new LinkedList<Object>();
		
		m1(listA);
		m1(listB);
		//m1(listO);
		m2(listA);
		//m2(listB);
		//m2(listO);
	}
	
	public static void m1(LinkedList<? extends A> list){}

	public static void m2(LinkedList<A> list){}
	
}

