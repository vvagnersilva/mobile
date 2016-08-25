package Testes;

import java.io.*;

class SampleClass {
	public static void main(String[] args) throws Exception {
		try {
			String dirName = args[0];
			File dir = new File(dirName);
			File.createTempFile("temp", "log", dir);
		} catch (NullPointerException | IOException e) {
			e = new IOException("Error while creating temp file"); // Falha
			throw e;
		}
	}
}
