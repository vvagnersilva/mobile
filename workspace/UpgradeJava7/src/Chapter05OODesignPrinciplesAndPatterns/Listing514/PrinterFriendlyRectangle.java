package Chapter05OODesignPrinciplesAndPatterns.Listing514;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/

public class PrinterFriendlyRectangle implements PrinterFriendlyShape {
	public PrinterFriendlyRectangle(int length, int height) {
		this.length = length;
		this.height = height;
		System.out.println("PrinterFriendlyRectangle constructor");
	}
	private int length, height;
	@Override
	public void draw() {
		System.out.println("PrinterFriendlyRectangle draw()");
		// draw() implementation
	}
}