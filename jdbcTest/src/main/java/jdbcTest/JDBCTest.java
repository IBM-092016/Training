/**
 * 
 */
package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author dragos
 *
 */
public class JDBCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// load the driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// and connect to HSQL database
			Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/test", "SA", "");

			// Get a list with all Persons from Person table
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(Person.sqlReadStatement);
			if (!rs.next()) {
				System.out.println("No records matched the selection criteria");
			} else {
				// print the result, if any
				 do{
					Person p = new Person(rs);
					System.out.println(p);

				}while (rs.next());
			}
			
			//Create new Person
			PreparedStatement pstm = c.prepareStatement(Person.sqlCreateStatement);
			Person newP = new Person("Sales", "sales@hotmail.com");
			pstm.setString(1, "Sales");
			pstm.setString(2, "sales@hotmail.com");
			int i = pstm.executeUpdate();
			System.out.println(i + " records have beed added to Person table.");
			
			//Update a person
			pstm = c.prepareStatement(Person.sqlUpdateStatement);
			pstm.setString(1, "new data");
			pstm.setString(2, "new@hotmail.com");
			pstm.setInt(3, 8);
			i = pstm.executeUpdate();
			System.out.println(i + " records have beed modified in Person table.");
			
			Person.update("new data", "new@hotmail.com", 8);
			for (Person person : Person.persons) {
				System.out.println(person);
			}
			
			
			//Delete from persons table
			pstm = c.prepareStatement(Person.sqlDeleteStatement);
			pstm.setString(1, "Sales");
			i = pstm.executeUpdate();
			System.out.println(i + " records have beed deleted from Person table.");
			
			
			pstm.close();
			// close all connections and record sets
			rs.close();
			stm.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
