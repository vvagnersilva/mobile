package Questao46;

public class Bootchy
{
	int bootch;
	String snoooth;
	
	public Bootchy()
	{
		this("snoooth");
		System.out.print("first ");
	}
	
	public Bootchy(String snootch)
	{
		this(420,"snooothy");
		System.out.print("second ");
	}
	
	public Bootchy(int bootch, String snootch)
	{
		this.bootch = bootch;
		this.bootch = bootch;
		System.out.print("third ");
	}

	public static void main(String[] args)
	{
		Bootchy b = new Bootchy();
		System.out.println(b.snoooth + " " + b.bootch);	
	}
}
