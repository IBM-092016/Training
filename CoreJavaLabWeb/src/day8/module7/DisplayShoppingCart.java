package day8.module7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayShoppingCart
 */
public class DisplayShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		if(cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println(cart.getCartHTML());
		pw.println("</body></html>");
	}
}
