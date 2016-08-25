package compareCirculo;

import java.util.ArrayList;

import java.util.Collections;

public class TestCirculo
{

	public static void main(String[] args)
	{
		ArrayList<Circulo> list = new ArrayList<Circulo>();

		list.add(new Circulo(1, 2 , 3) );
		list.add(new Circulo(31, 26 , 453) );
		list.add(new Circulo(41, 22 , 63) );
		list.add(new Circulo(14, 42 , 73) );
		list.add(new Circulo(17, 2 , 3) );
		list.add(new Circulo(16, 232 , 13) );

		for (Circulo o:list)
		{
			System.out.println(o.x + "\t" + o.y + "\t" + o.raio);
		}

		System.out.println("\nChamando funcao de Ordenacao: Sort\n");

		ComparatorCirculo functor = new ComparatorCirculo();

		Collections.sort(list, functor);

		for (Circulo o:list)
		{
			System.out.println(o.x + "\t" + o.y + "\t" + o.raio);
		}
	}
}
