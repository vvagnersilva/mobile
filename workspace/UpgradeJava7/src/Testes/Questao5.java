package Testes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Questao5 {
	public static void main(String[] args) {

		//String source =	"d:\\company\\info.txt";
		//String dest = "d:\\company\\emp\\info.txt";

		String source =	"E:\\teste.txt";
		String dest = "E:\\saida.txt";

		// insert code fragment here Line ** B e D

		//try 
		//{
		//Files.copy(Paths.get(source), Paths.get(dest));
		//Files.delete(Paths.get(source));

		try 
		{
			Files.move(Paths.get(source),Paths.get(dest));		

		} catch (IOException e) {
			System.err.println ("Caught IOException: " + e.getMessage());
		}
	}
}
