package Testes;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Questao24 { 

	public static void main (String [] args) { 
		
		
		SimpleDateFormat sdf; 
		
		sdf = new SimpleDateFormat ("MM", Locale.UK);
		
		System.out.println ( "Result: " + sdf.format(new Date()));		
	} 
}