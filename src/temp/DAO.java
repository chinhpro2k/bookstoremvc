package temp;



import java.sql.Connection;
import java.io.PrintStream;
import java.sql.CallableStatement;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.Address;
import model.Author;
import model.Book;
import model.CartDetail;
import model.Category;
import model.Item;
import model.Publisher;


public class DAO {
	public static Connection connection;
	public static ResultSet re;

	public DAO() {
		try {
			String connectString = "jdbc:mysql://localhost:3306/bookstore?useSSL=false&allowPublicKeyRetrieval=true";
	        Class.forName("com.mysql.jdbc.Driver");
	        connection = (Connection) DriverManager.getConnection(connectString, "root", "14072000");
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public String[] checkAccount(String username, String password) throws SQLException {
		String sql = "{call CheckAccountForLogin(?,?,?,?,?)}";
		String cartid = UUID.randomUUID().toString();
		CallableStatement cst = connection.prepareCall(sql);
		cst.setString(1, username);
		cst.setString(2, password);
		cst.setString(4, cartid);
		cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		cst.registerOutParameter(4, java.sql.Types.VARCHAR);
		cst.registerOutParameter(5, java.sql.Types.VARCHAR);
		cst.executeUpdate();
		String accountID = cst.getString(3);
		String cartID = cst.getString(4);
		String customerID = cst.getString(5);
		return new String[] {accountID, cartID, customerID};
	}
	
	public List<Item> searchBooks(String keyword) throws Exception{
		List<Item> lb = new ArrayList<Item>();
		String sql = "{call SearchBooks(?)}";
		CallableStatement cst = connection.prepareCall(sql);
		cst.setString(1, keyword);
		re = cst.executeQuery();
		while(re.next()) {
			String id = re.getString(1);
			String name = re.getString(2);
			float price = re.getFloat(3);
			String bookId = re.getString(4);
			Item item = new Item(id, price, name, null, bookId);
			lb.add(item);
		}
		return lb;
	}
	
	public List<Item> getAllBooks() throws Exception{
		return searchBooks("");
	}
	
	public void AddItemToCart(String itemId, String cartID, int quantity) throws Exception{
		String sql = "{call AddItemToCart(?,?,?)}";
		CallableStatement cst = connection.prepareCall(sql);
		cst.setString(1, itemId);
		cst.setString(2, cartID);
		cst.setInt(3, quantity);
		System.out.println(111);
		cst.executeUpdate();
	}
	
	public List<CartDetail> selectCart(String cartID) throws Exception{
		String sql = "{call GetAllItemInCart(?)}";
		List<CartDetail> lb = new ArrayList<CartDetail>();
		CallableStatement cst = connection.prepareCall(sql);
		cst.setString(1, cartID);
		re = cst.executeQuery();
		while(re.next()) {
			 String id = re.getString(1);
			 String name = re.getString(2);
			 float price = re.getFloat(3);
			 int quantity = re.getInt(4);
			 CartDetail cd = new CartDetail(id, new Item(price, name),null, quantity);
			 lb.add(cd);
		}
		return lb;
		
	}
	public String CreateOrder(String cartID, String shoppingAdd, String customerID, String accountID) throws Exception{
		String sql = "{call CreateOrder(?, ?, ?, ? ,?,?)}";
		String orderID = UUID.randomUUID().toString();
		String newcartid = UUID.randomUUID().toString();
		CallableStatement cst = connection.prepareCall(sql);
		
		cst.setString(1, orderID);
		cst.setString(2, cartID);
		cst.setString(3, shoppingAdd);
		cst.setString(4, customerID);
		cst.setString(5, newcartid);
		cst.setString(6, accountID);
		cst.executeUpdate();
		return newcartid;
	}
}
