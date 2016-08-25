package Testes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class Questao28 {
	public static void main(String[] args) {
		copyContents();
	}

	private static void copyContents() {
		try {

			InputStream fis = new FileInputStream("report1.txt");
			OutputStream fos = new FileOutputStream("consolidate.txt");

			byte[] buf = new byte[8192];

			int i;

			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}

			fis.close();

			fis = new FileInputStream("report2.txt");

			while ((i = fis.read(buf)) != -1) {

				fos.write(buf, 0, i);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
