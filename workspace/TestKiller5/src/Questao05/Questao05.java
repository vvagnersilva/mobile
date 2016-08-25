package Questao05;

import java.io.File;

public class Questao05  
{
	public boolean doesFileExist(String[] directories, String filename)
	{
		String path = "";
		
		for (String dir : directories)
		{
			path = path + File.separator + dir;
		}
	
		System.out.println(path);
		
		File file = new File (path, filename);
		
		return file.exists();	
	}
	public static void main(String[] args) 
	{
		String [] d = new String[2];
		
 		d[0] = "C:";
		
		new Test().doesFileExist(d, "test");
	}
}
