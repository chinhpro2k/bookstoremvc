package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Book;
import model.CartDetail;
import temp.DAO;

/**
 * Servlet implementation class Cart
 */

public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
		dao = new DAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/Cart":
				showCart(request, response);

				break;
			default:
				showCart(request, response);
				break;
			}
		} catch (SQLException e) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void showCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cartID = "";
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cartID"))
					cartID = cookie.getValue();
			}

		}

		System.out.println(cartID);

		List<CartDetail> cart = dao.selectCart(cartID);
		float totalAmount = 0;
		for (CartDetail b : cart) {
			totalAmount += b.getItem().getPrice() * b.getQuantity();
		}
//		
//		Address address = dao.getAddressByID(accountID);
//		
		request.setAttribute("address", "Biệt thự to nhất Hà Đông");
		request.setAttribute("totalAmount", totalAmount);
		request.setAttribute("listItem", cart);
//		System.out.println("\n1232");
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

}
