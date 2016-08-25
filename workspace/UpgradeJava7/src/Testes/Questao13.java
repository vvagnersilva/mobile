package Testes;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Questao13 {
	public static void main (String [] args) {
		// A classe Paths é uma fábrica de Path. 
		Path path1 = Paths.get("D:\\sys\\asm\\.\\data\\..\\..\\mfg\\production.log");
		
		System.out.println(path1.normalize());

		System.out.println(path1.getNameCount());
	}
}
