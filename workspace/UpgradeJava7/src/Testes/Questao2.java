package Testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.NoSuchFileException;

public class Questao2 {
	public static void main(String[] args) {
	}

	@SuppressWarnings("unused")
	private static void copyContents(File source, File target) throws NoSuchFileException {

		InputStream fis = null;
		
		try {
			fis = new FileInputStream(source);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		OutputStream fos = null;
		
		try {
			fos = new FileOutputStream(target);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		byte[] buf = new byte[8192];

		int i;

		try {
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		//E.
		//} catch (InvalidPathException | IOException e) 
		//{ System.out.println(e); 
		//} 

		System.out.println("Successfully copied");
	}
}
