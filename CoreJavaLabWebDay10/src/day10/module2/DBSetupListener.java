package day10.module2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Application Lifecycle Listener implementation class DBSetupListener
 *
 */
public class DBSetupListener implements ServletContextListener {
    public DBSetupListener() {
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    	try {
			prepopulateData();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            System.out.println("HSQL DRIVER FOUND");
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }
    
	public static final String DROP_TABLE = "DROP TABLE employees IF EXISTS";
	public static final String CREATE_TABLE = "CREATE TABLE employees(id INTEGER IDENTITY PRIMARY KEY,name CHAR(50),age INTEGER)";
    
    private void prepopulateData() throws NamingException, SQLException {
    	Context initCtx = new InitialContext();
    	Context envCtx = (Context) initCtx.lookup("java:comp/env");
    	DataSource ds = (DataSource)envCtx.lookup("jdbc/MyDB");
    	Connection conn = null;
    	try {
    		conn = ds.getConnection();
    		Statement stmt = conn.createStatement();
    		stmt.execute(DROP_TABLE);
    		stmt.execute(CREATE_TABLE);
    		stmt.close();
    		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees(name,age) VALUES(?,?)");
    		pstmt.setString(1, "Anna");
    		pstmt.setInt(2, 33);
    		pstmt.executeUpdate();
    		pstmt.setString(1, "John");
    		pstmt.setInt(2, 29);
    		pstmt.executeUpdate();
    		pstmt.setString(1, "Maria");
    		pstmt.setInt(2, 44);
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
    	} finally {
    		
    	}
    	
    }
}
