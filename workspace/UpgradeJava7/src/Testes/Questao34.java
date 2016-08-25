package Testes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Questao34 {
	public static void main(String[] args) {
		Path tempFile = null;

		Path p = Paths.get("c:\\temp");

		try {
			tempFile = Files.createTempFile(p, "report", ".tmp");
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter writer = null;
		try {
			
			writer = Files.newBufferedWriter(tempFile, Charset.forName("UTF8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			writer.write("Java SE 7");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Temporary file write done");
		
		//try {
			//writer.close(); // somente grava se fechar o objeto de escrita.
			//System.out.println(tempFile.toString());

			//Files.delete(tempFile.toAbsolutePath());
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
	}
}
