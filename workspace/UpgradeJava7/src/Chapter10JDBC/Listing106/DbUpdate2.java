package Chapter10JDBC.Listing106;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
import java.sql.*;

// To illustrate how we can update a database 
class DbUpdate2 { 
	public static void main(String[] args) throws SQLException {
		try (Connection connection = DbConnector.connectToDb();
			// create a statement from which the created ResultSets 
// are "scroll sensitive" as well as "updatable" 
Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM contact WHERE firstName=\"Michael\"")) { 
			// first fetch the data and display it before the update operation 
			System.out.println("Before the update");
			System.out.println("id \tfName \tlName \temail \t\tphoneNo");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + "\t" 
				+ resultSet.getString("firstName") + "\t" 
				+ resultSet.getString("lastName") + "\t" 
				+ resultSet.getString("email") + "\t" 
				+ resultSet.getString("phoneNo"));
			}
			// now update the resultSet and display the modified data 
			resultSet.absolute(1);
			resultSet.updateString("phoneNo", "+919976543210");
			// reflect those changes back to the database by calling updateRow() method 
			resultSet.updateRow();
			System.out.println("After the update");
			System.out.println("id \tfName \tlName \temail \t\tphoneNo");
			resultSet.beforeFirst();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + "\t" 
				+ resultSet.getString("firstName") + "\t" 
				+ resultSet.getString("lastName") + "\t" 
				+ resultSet.getString("email") + "\t" 
				+ resultSet.getString("phoneNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1); 
		}
	}
}
