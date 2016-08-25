package Questao11;

import java.lang.*;
import java.util.Locale;
public class CertKiller  
{
	public static void main(String[] args) 
	{
		 /* Create object of Locale class using contructor 
        Locale(String language, String country) */
		Locale obj1 = new Locale("ENGLISH","Us");
		Locale obj2 = new Locale("CHIENESE","China");
		System.out.println("object obj1 of Locale class is : "+obj1);
		
		System.out.println("object obj2 of Locale class is : "+obj2);
		
		// getDisplayCountry() method call.
		String country = obj1.getDisplayCountry();
		System.out.println("Country name for object obj1 : " + country);
		country = obj2.getDisplayCountry();
		System.out.println("Country name for object obj2 : " + country);
	}
}
