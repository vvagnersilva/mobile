package Questao61;

import java.util.ArrayList;
import java.util.Collections;

public class Test
{
	public void CertKiller1(int x) 
	{
		assert (x  > 0);
		switch (x) {
		case 2:
			x=3;			
			break;
		default:
			assert false;
			break;
		}		
	}

	public void CertKiller2(int y) 
	{
		assert( y < 0);
	}
	
	public void CertKiller4(int y) 
	{
		assert( CertKiller4());
	}
	
	public Boolean CertKiller4() 
	{
		z = 6;
		
		return false;
	}

	public static void main(String[] args)
	{
		int x = 5;
		
		assert(x > 0);
		
		
	}
}
