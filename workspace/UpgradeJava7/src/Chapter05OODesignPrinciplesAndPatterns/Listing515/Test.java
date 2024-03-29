package Chapter05OODesignPrinciplesAndPatterns.Listing515;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
public class Test {
	public static void main(String[] args) {
		Circle circle = new Circle(10, 10, 20);
		System.out.println(circle);
		CircleTransfer circleTransfer = circle.getCircleTransferObject();
		CircleDAO circleDAO = DAOFactory.getCircleDAO("RDBMS");
		circleDAO.insertCircle(circleTransfer);
	}
}