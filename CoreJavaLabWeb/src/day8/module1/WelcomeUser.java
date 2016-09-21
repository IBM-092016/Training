package day8.module1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WelcomeUser() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		String firstname = request.getParameter("fname");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome ! <font color='blue'>" + firstname
				+ "</font></h1>");
	}
}
