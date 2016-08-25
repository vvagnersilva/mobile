package Questao01;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Forest implements Serializable 
{
	private Tree tree = new Tree();
	
	public static void main(String[] args) 
	{
		try
		{
			Forest f = new Forest();
			FileOutputStream fs = new FileOutputStream("Forest.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(f); // pau aqui...
			os.close();
		}catch (Exception exp){
			exp.printStackTrace();
		}
	}
}

class Tree implements Serializable
{
}