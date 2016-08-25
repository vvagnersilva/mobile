package compareNatural;

import java.util.ArrayList;
import java.util.Collections;

public class TestArray
{
	public static void main(String[] args)
	{
		System.out.println("\nString, Wrapper e Date possui ordenacao Natural.\n");

		ArrayList<Integer> l1 = new ArrayList<Integer>();

		l1.add(122);
		l1.add(233);
		l1.add(1);
		l1.add(5);
		l1.add(2);
		l1.add(3);

		Collections.sort(l1);

		for (Integer o:l1)
		{
			System.out.print(o + " ");
		}

		System.out.println("\n");

		/* Ordenando com String */
		ArrayList<String> l2 = new ArrayList<String>();

		l2.add("O Mestre");
		l2.add("Abracadabra Triturado");
		l2.add("O Estrangulador");
		l2.add("Diga que me ama");
		l2.add("Abraca Caverna");
		l2.add("A Pirulito");

		Collections.sort(l2);

		for (String o:l2)
		{
			System.out.println(o);
		}
	}
}
