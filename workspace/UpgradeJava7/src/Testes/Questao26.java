package Testes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Questao26 {

	public static void main(String[] args) {

	}

	public static void processFile() throws IOException, ClassNotFoundException 
	{ 		 

		try
		{
			FileReader fr = new FileReader("logfilesrc.txt"); 
			FileWriter fw = new FileWriter("logfiledest.txt") 
			{ 
				Class c = Class.forName ("java.lang.JString"); 
			}; 

			fw.close();

		}catch(IOException e)
		{
		}
	} 
}
