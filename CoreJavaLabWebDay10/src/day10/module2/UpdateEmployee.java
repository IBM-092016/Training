package day10.module2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/MyDB");
			Connection conn = null;

			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("UPDATE employees SET name = ?,  age = ? WHERE id = ?");
			pstmt.setString(1, request.getParameter("empname"));
			pstmt.setInt(2, Integer.valueOf(request.getParameter("empage")));
			pstmt.setInt(3, Integer.valueOf(request.getParameter("empid")));
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			request.getRequestDispatcher("content.html").forward(request, response);
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
