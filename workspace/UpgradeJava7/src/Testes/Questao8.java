package Testes;

import java.util.Locale;
import java.util.ResourceBundle;

class Questao8 {
	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("es", "ES")); // Set default to Spanish and Spain 
		
		Locale loc1 = Locale.getDefault(); 
		
		ResourceBundle messages = ResourceBundle.getBundle ("messageBundle", loc1); 
		
		System.out.println (messages.getString("menu1")); 

	}
}
