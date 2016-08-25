package Questao36;

public class CertKiller 
{
	public static void main(String[] str) 
	{
		String myProp1 = System.getProperty("prop.custom");
		String myProp2 = System.getProperties().getProperty("prop.custom");		
	}
}
