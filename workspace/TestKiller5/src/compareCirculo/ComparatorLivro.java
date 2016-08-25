package compareCirculo;

import java.util.Comparator;

class ComparatorCirculo implements Comparator<Circulo>
{
	public int compare(Circulo l1, Circulo l2)
	{
		//return (l1.raio.compareTo(l2.raio)); // comparacao raio
		return (l1.x.compareTo(l2.x)); // comparacao x
		//return (l1.y.compareTo(l2.y)); // comparacao y
	}
}
