package Testes;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

public class Questao23 { 

	public static void main (String [] args) { 
		
	PathMatcher matcher = FileSystems.getDefault ().getPathMatcher ("glob:???_*1"); 

	} 
}