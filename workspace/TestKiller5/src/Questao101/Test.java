package Questao101;

import java.text.NumberFormat;

public class Test
{
	public static void main(String[] args)
	{
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(4);
		nf.setMinimumFractionDigits(2);
		String a = nf.format(3.1415926);
		String b = nf.format(2);
		
		System.out.println(a);
		System.out.println(b);		
	}
}

