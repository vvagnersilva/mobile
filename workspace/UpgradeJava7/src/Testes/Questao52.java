package Testes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Questao52 {

	public static void main(String[] args) 
	{
		try 
		{
			processFile();
		} catch (Exception e) {
			Throwable[] t = e.getSuppressed();
		}
	}

	public static void processFile() throws IOException 
	{ 
			FileReader fr = new FileReader("logfilesrc.txt");		
			FileWriter fw = new FileWriter("logfiledest.txt");
			
			java.util.zip.ZipFile zf = new java.util.zip.ZipFile("alllogs.zip");
			
			System.out.println("Created files for logs"); 
	}
}
