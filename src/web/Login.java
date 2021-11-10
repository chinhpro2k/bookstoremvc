package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import temp.DAO;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
    	dao = new DAO();
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		
		try {
			switch (action) {
			
			case "/register":
				//showRegisterPage(request, response);
				break;
			case "/doregister":
				//insertAccount(request, response);
				break;
			case "/login":
				//showLoginPage(request, response);
				break;
			case "/dologin":
				loginAccount(request, response);
				break;
			case "/CreateOrder":
				createOrder(request,response);
				break;
			default:
				showLoginPage(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showLoginPage(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.sendRedirect("LoginPage.jsp");
	}

	private void loginAccount(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, SQLException, ServletException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] re = dao.checkAccount(username, password);
		String accountID = re[0];
		String cartID =re[1];
		String customerID = re[2];
		
		RequestDispatcher dispatcher = null;
		
		if(accountID == "") {
			dispatcher = request.getRequestDispatcher("LoginPage.jsp");
			request.setAttribute("loginFail", "Sai ten dang nhap hoac mat khau!");
			dispatcher.forward(request, response);
		}
		else {
			Cookie loginCookie = new Cookie("accountID",accountID);
			Cookie cartCookie = new Cookie("cartID", cartID);
			Cookie customerCookie = new Cookie("customerID", customerID);
			System.out.println(cartID);
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.addCookie(cartCookie);
			response.addCookie(customerCookie);
			response.sendRedirect("Home");
		}
	
	}
	private void createOrder(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//float price = Integer.parseInt(request.getParameter("totalAmount"));
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		
		String address = request.getParameter("address").toString();
		float totalPrice = Float.parseFloat(request.getParameter("totalAmount"));
		if(type == 1)
			totalPrice += 20000;
		else if(type ==2)
			totalPrice += 10000;
		else
			totalPrice += 5000;
		String cartID = "";
		String accountID = "";
		String customerID = "";
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("customerID"))
					customerID = cookie.getValue();
				if(cookie.getName().equals("cartID"))
					cartID = cookie.getValue();
				if(cookie.getName().equals("accountID"))
					accountID = cookie.getValue();
			}
			
		}
		
		String  newcartID = dao.CreateOrder(cartID, address, customerID, accountID);
		
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("cartID")) {
				cookie.setValue(newcartID);
				response.addCookie(cookie);
				
			}
				
		}
		System.out.println("abc");
		
		response.sendRedirect("Home");
	}


































}
