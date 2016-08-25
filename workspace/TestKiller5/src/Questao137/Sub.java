package Questao137;

class Super
{
	private int a;
	protected Super(int a) { this.a = a;}
}


public class Sub extends  Super
{
	public Sub(int a) {super(a);}
	
	public Sub() 
	{
		//this(5);
		super(5);
		//this.a = 5;
	}
}
