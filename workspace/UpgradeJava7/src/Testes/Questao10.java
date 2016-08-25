package Testes;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Questao10 
{ 
	public static void main (String [] args) 
	{ 
		List<Person> pList = new CopyOnWriteArrayList<Person>(); //Objetos recuperados da lista são thread-safe.
		
		System.out.println(pList.toString());
	} 
} 
