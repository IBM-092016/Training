package day10.module2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ListEmployees
 */
public class ListEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
        	Context initCtx = new InitialContext();
        	Context envCtx = (Context) initCtx.lookup("java:comp/env");
        	DataSource ds = (DataSource)envCtx.lookup("jdbc/MyDB");
        	Connection conn = null;
    		conn = ds.getConnection();
    		PreparedStatement pstmt = conn.prepareStatement("SELECT id,name,age FROM employees");
    		ResultSet rset = pstmt.executeQuery();
    		List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
    		while(rset.next()) {
    			EmployeeBean eb = new EmployeeBean();
    			eb.setId(rset.getInt(1));
    			eb.setName(rset.getString(2));
    			eb.setAge(rset.getInt(3));
    			employees.add(eb);
    		}
    		rset.close();
    		pstmt.close();
    		conn.close();
    		
    		//System.out.println(request.getParameter("action"));
    		
    		request.setAttribute("action",request.getParameter("action").equalsIgnoreCase("delete"));
    		request.setAttribute("employees", employees);
    		request.getRequestDispatcher("showEmployees.jsp").forward(request, response);
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
