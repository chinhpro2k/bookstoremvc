/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Cart;
import entities.Customer;
import entities.Item;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import static repositories.BaseDAO.con;

/**
 *
 * @author os_hoangpn
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer get(int id) {
        String sql = "SELECT * FROM customer"
                + " WHERE PersonID = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            Customer customer = new Customer();
            rs.first();
            customer.setPersonID(rs.getInt("PersonID"));
            Cart c = new Cart(rs.getInt("CartID"));
            customer.setCartID(c);
            return customer;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int save(Customer t) {
        String sql = "INSERT INTO book_store.customer (PersonID, CartID, BookstorecardID, MembershiptypeID, WishlistID)"
                + "VALUES(?,?,?,?,?);";
        int key = -1;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, t.getPersonID());
            ps.setInt(2, t.getCartID().getId());
            ps.setInt(3, t.getBookStoreCardID().getId());
            ps.setInt(4, t.getMembershipTypeID().getId());
            ps.setInt(5, t.getWishlistID().getId());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    key = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            return key;
        }
        return key;
    }

    @Override
    public void update(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
