package day8.module6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChoiceProcessingServlet
 */
public class ChoiceProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String user = null;
		String item = null;
		int i = 1;
		Enumeration e = null;
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		user = (String) session.getAttribute("user");
		/*
		 * Retrieve the name of all the parameters passed by the end user.
		 */
		e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String sname = (String) e.nextElement();
			/* Store the names in the session object. */
			session.setAttribute("c" + i, sname);
			i++;
		}
		/* Store the counter value in the session object. */
		session.setAttribute("counter", i + "");
		RequestDispatcher disp = request.getRequestDispatcher("FinalServlet");
		disp.forward(request, response);
	}

}
