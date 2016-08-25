package Testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class Questao16 { 
	private static Connection conn;

	public static void main (String [] args) { 

		String query = "SELECT ID FROM Employee";  //Line 1 

		try (
			
				Statement stmt = conn.createStatement()) { // Line 2


			ResultSet rs = stmt.executeQuery(query);  // Line 3 

			stmt.executeQuery ("SELECT ID FROM Customer");  // Line 4 

			while (rs.next()) { 
				//process the results 
				System.out.println ("Employee ID: " + rs.getInt("ID") ); 
			} 
		} catch (Exception e) { 
			System.out.println ("Error"); 
		} 
	} 
}

