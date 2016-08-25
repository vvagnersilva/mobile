package Questao53;

static class B extends A
//class B extends A
{
	void process() { System.out.println("B");}

	public static void main(String[] args)
	{
		A a = new B();
		try {
			a.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
