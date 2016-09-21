package day8.module6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayTrouserListServlet
 */
public class DisplayTrouserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		int counter = 0;
		counter = 0;
		PrintWriter out = response.getWriter();
		
		if ("ME".equals(username) && "PASSWD".equals(password)) {
			/* Create a session for the user and store the value of
			username. */
			HttpSession session = request.getSession(true);
			session.setAttribute("user", username);
			
		} else {
			out.println("Sorry! Invalid username and password");
			counter = 1;
		}
		if (counter == 0) {
			/* Display the contents to the user. */
			response.setContentType("text/html");
			out.println("<HTML><BODY>");
			out.println(username + "! Welcome to HappyVisit Online	Shopping.<BR>");
			out.println("<HR>");
			out.println("<FORM ACTION='ChoiceProcessingServlet' METHOD='POST'>");
			out.println("<TABLE WIDTH=500>");
			out.println("<TR><TH>ITEM NO</TH> <TH>Brands of Trousers </TH><TH>BUY</TH></TR> ");
			out.println("<TR><TD> 1 </TD><TD> PeterEngland </TD> <TD> "+
					"<INPUT NAME='c1' TYPE='CHECKBOX' VALUE='PeterEngland'></TD> </TR> ");
			out.println("<TR><TD> 2 </TD><TD> Moustache </TD> <TD> " + 
					"<INPUT NAME='c2' TYPE='CHECKBOX' VALUE='Moustache'></TD></TR> ");
			out.println("<TR><TD> 3 </TD><TD> Allen Solly </TD> <TD> " + 
					" <INPUT NAME ='c3' TYPE='CHECKBOX' VALUE='Allen Solly'></TD> </TR> ");
			out.println("<TR><TD> 4 </TD><TD> Zodiac </TD> <TD> " +
					"<INPUT NAME='c4' TYPE='CHECKBOX' VALUE='Zodiac'></TD> </TR> ");
			out.println("</TABLE>");
			out.println("<INPUT TYPE='SUBMIT' VALUE='SUBMIT'>");
			out.println("</FORM>");	
			out.println("</BODY></HTML>");
			out.close();
		}
	}
}

