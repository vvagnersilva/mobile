package Testes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Questao22 { 

	public static void main (String [] args) { 
		
		SimpleDateFormat sdf; 

		sdf = new SimpleDateFormat ("MMMM", Locale.UK); 

		System.out.println ("Result:"+ sdf.format(new Date())); 

	} 
}