package Questao02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Foo implements Serializable 
{
	private int x, y;
	
	public Foo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	private void writeObject(ObjectOutputStream s) throws IOException
	{
		s.writeInt(x);
		s.writeInt(y);
	}
	
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
	{
		// inserir codigo aqui
		x = s.readInt();
		y = s.readInt();
	}
}
