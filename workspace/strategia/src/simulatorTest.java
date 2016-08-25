
public class simulatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double peso = 10;
		double ca = 20;
		double cc = 30;
		boolean checkedTipoPlicometro = false;
		
		Egs egs = new Cauda(peso, ca, cc, checkedTipoPlicometro);
		
		egs.CalcularEgs();
		
	}

}
