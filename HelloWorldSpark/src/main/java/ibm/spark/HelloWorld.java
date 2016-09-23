/**
 * 
 */
package ibm.spark;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * @author dragos
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		port(8080);
		Gson gson = new Gson();
		get("/hello", (req, res) -> "Hello World");
		get("/employeeList",(res, req) -> getEmployeeList() ,gson::toJson);

	}

	private static ArrayList<EmployeeBean> getEmployeeList() {
		ArrayList<EmployeeBean> result = new ArrayList<EmployeeBean>();

		try {
			// load the driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			// and connect to HSQL database
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/test", "SA", "");
			PreparedStatement pstmt = conn.prepareStatement("SELECT id,name,age FROM employees");
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				EmployeeBean eb = new EmployeeBean();
				eb.setId(rset.getInt(1));
				eb.setName(rset.getString(2));
				eb.setAge(rset.getInt(3));
				result.add(eb);
			}
			rset.close();
			pstmt.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
