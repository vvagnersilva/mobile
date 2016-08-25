package Testes;

class Questao17 
{
	public static void main(String[] args)
	{ 
		Questao17 sc = new Questao17(); 

		sc.processCD();
	}

	private void processCD() 
	{
		try {
			CDStream cd = new CDStream();
			cd.open();
			cd.read();
			cd.write("lullaby");
			cd.close();
		} catch (Exception e)
		{ System.out.println("Exception thrown");
		}
	}
}

class CDStream 
{
	String cdContents = null;
	public void open()
	{ 
		cdContents = "CD Contents";
		System.out.println("Opened CD stream");
	}

	public String read() throws Exception {
		throw new Exception("read error");
	}

	public void write(String str)
	{ System.out.println("CD str is: " +
			str);
	}

	public void close() {
		cdContents = null;
	}
}


