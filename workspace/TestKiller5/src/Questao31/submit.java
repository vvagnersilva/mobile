package Questao31;

public class submit 
{
	static Foo fooBar (Foo foo)
	{
		foo = new Foo(100);
		return foo;
	}
	public static void main(String[] args) 
	{
		Foo foo = new Foo(300);
		System.out.print(foo.getX() + "-");

		Foo fooFoo = fooBar(foo);
		System.out.print(foo.getX() + "-");
		System.out.print(fooFoo.getX() + "-");

		foo = fooBar(fooFoo);
		System.out.print(foo.getX() + "-");
		System.out.print(fooFoo.getX() + "-");
	}
}
