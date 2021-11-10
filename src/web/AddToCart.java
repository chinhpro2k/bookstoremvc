package web;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import temp.DAO;

/**
 * Servlet implementation class AddToCart
 */

public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        dao = new DAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/AddToCart":
				addToCart(request, response);
				
				break;
			default:
				addToCart(request, response);
				break;
			}
		} catch (SQLException e) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String  itemID = request.getParameter("itemID");
		String accountID =  request.getParameter("accountID");
		String cartId= request.getParameter("cartID");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		dao.AddItemToCart(itemID, cartId, quantity);
		
		String  prePath = "";
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("prePath"))
					prePath = cookie.getValue();
			}
			
		}
		System.out.println(prePath);
		if(prePath.equals("Home"))
			response.sendRedirect("Home");
		else if(prePath.equals("Cart"))
			response.sendRedirect("Cart");
		
	}

}
