package compareLivro;

import java.util.ArrayList;
import java.util.Collections;

public class TestArray
{

	public static void main(String[] args)
	{
		ArrayList<Livro> list = new ArrayList<Livro>();

		list.add(new Livro(1230, "A Piruca"));
		list.add(new Livro(123, "A Caverna"));
		list.add(new Livro(10, "O Triturado"));
		list.add(new Livro(12, "O Estrangulador"));
		list.add(new Livro(1, "Diga que me ama"));
		list.add(new Livro(1230, "A Piruca"));

		for (Livro o:list)
		{
			System.out.println(o.titulo + "\t" + o.isbn);
		}

		System.out.println("\nChamando funcao de Ordenacao: Sort\n");

		ComparatorLivro functor = new ComparatorLivro();

		Collections.sort(list, functor);

		for (Livro o:list)
		{
			System.out.println(o.titulo + "\t" + o.isbn);
		}
	}
}
