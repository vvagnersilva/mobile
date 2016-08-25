package Questao45;

class Alpha
{
	public void bar(int... x) {}
	public void bar(int x) {}
}

public class Beta extends Alpha
{
	public void bar(int x){}
	public int bar(String x){ return 1;}
	public void bar(int x, int y){}
}
