package Testes;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.UserPrincipal;

public class Questao43 {

	public static void main(String[] args) {
		static void addContent () throws Exception { 

			Path path = Paths.get("D:\\company\\report.txt"); 
			
			UserPrincipal owner = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("Bob"); 
			
			Files.setOwner(path, owner); 
			
			// insert code here – Line ** 
				

			BufferedWriter br = Files.newBufferedWriter (path, Charset.forName ("UTF - 8"), new openOption [] {StandardOpenOption.APPEND, StandardOpenOption.DSYNC};
				

			br.write("this is a text message "); 
			 
			} 
			System.out.println("success"); 
			} 
	}

}
