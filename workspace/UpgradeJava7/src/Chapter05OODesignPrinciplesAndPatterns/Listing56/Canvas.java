package Chapter05OODesignPrinciplesAndPatterns.Listing56;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
import java.util.Observable;
import java.util.Observer;

public class Canvas implements Observer {
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Canvas::update");
		// actual update code elided …  
	}
}