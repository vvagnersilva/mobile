package compareLivro;

import java.util.Comparator;

class ComparatorLivro implements Comparator<Livro>
{
	public int compare(Livro l1, Livro l2)
	{
		//return (l1.isbn.compareTo(l2.isbn)); // comparacao pelo isbn
		return (l1.titulo.compareTo(l2.titulo)); // comparacao pelo titulo
	}
}
