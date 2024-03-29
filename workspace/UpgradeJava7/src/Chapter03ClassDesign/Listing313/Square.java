package Chapter03ClassDesign.Listing313;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
class Square extends Shape {
	private int side; 
	public Square(int a) { side = a; } 
	public double area() { return side * side; } 
	// other declarations
}