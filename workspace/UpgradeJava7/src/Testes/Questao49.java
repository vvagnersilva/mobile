package Testes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Questao49 {

	public static void main (String [] args) { 
		
		SimpleDateFormat sdf = new SimpleDateFormat("zzzz",  Locale.US); 
		
		Date today = new Date();
		
		System.out.println ("Result:  " + sdf.format(today)); 
	}
}