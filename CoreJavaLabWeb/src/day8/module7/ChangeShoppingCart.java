package day8.module7;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeShoppingCart
 */
public class ChangeShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		if(cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		System.out.println(request.getParameterMap());
		
		if(request.getParameterMap().containsKey("btnDisplay")) {
			RequestDispatcher disp = request.getRequestDispatcher("DisplayShoppingCart");
			disp.forward(request, response);
			return;
		}
		if(request.getParameterMap().containsKey("btnAdd1")) {
			cart.addItem("Head first Java");
		}
		if(request.getParameterMap().containsKey("btnAdd2")) {
			cart.addItem("Effective Java");
		}
		if(request.getParameterMap().containsKey("btnAdd3")) {
			cart.addItem("Thinking in Java");
		}
		if(request.getParameterMap().containsKey("btnDel1")) {
			cart.removeItem("Head first Java");
		}
		if(request.getParameterMap().containsKey("btnDel2")) {
			cart.removeItem("Effective Java");
		}
		if(request.getParameterMap().containsKey("btnDel3")) {
			cart.removeItem("Thinking in Java");
		}
		RequestDispatcher disp = request.getRequestDispatcher("ShoppingScreen.html");
		disp.forward(request, response);
	}

}
