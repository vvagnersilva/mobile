package br.ufgd.adipometro.utils;

public class Constantes {

	// Plicômetro digital
	public static final String FORMULA1 = "EGS = 91.9384 - 51.3428 × DCA + 7.7725 × DCA^2";
	public static final String FORMULA2 = "EGS = 83.6202 - 42.4223 × DCA + 4.663 × DCA2 + 0.3535 × DCA^3";
	public static final String FORMULA3 = "EGS = 27.1593 - 5.9473 × DCA";

	// Plicômetro digital + Peso ou Condição corporal
	public static final String FORMULA4 = "EGS = 28.8277 + 0.1772 × PESO - 8.0301 × DCA";
	public static final String FORMULA5 = "EGS = 27.3338 - 0.5834 × CC - 5.5342 × DCA";

	// Plicômetro comum
	public static final String FORMULA6 = "EGS = 65.5089 - 19.0182 × CCO + 1.9666 × CCO^2 - 0.0644 × CCO^3";
	public static final String FORMULA7 = "EGS = 30.8028 - 4.8777 × CCO + 0.245 × CCO^2";
	public static final String FORMULA8 = "EGS = 21.875 - 3.5212 × CCA";
	public static final String FORMULA9 = "EGS = 50.6697 - 11.3067 × CPE + 0.9409 × CPE^2 - 0.0244 × CPE^3";
	public static final String FORMULA10 = "EGS = 35.5865 - 5.5942 × CPE + 0.2747 × CPE^2";
	public static final String FORMULA11 = "EGS = 15.6595 - 0.6801 × CPE";
	public static final String FORMULA12 = "EGS = 14.23 - 0.5653 × CCO";

	// Plicômetro comum + Peso ou Condição corporal
	public static final String FORMULA13 = "EGS = 21.0504 + 0.1377 × PESO - 4.2899 × CCA";
	public static final String FORMULA14 = "EGS = 21.9099 - 0.0339 × CC - 3.508 × CCA";
}
