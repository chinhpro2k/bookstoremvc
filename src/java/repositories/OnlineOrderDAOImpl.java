/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Item;
import entities.Onlineorder;
import entities.Shippingaddress;
import entities.Voucher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static repositories.BaseDAO.con;

/**
 *
 * @author os_hoangpn
 */
public class OnlineOrderDAOImpl implements OnlineOrderDAO {

    @Override
    public List<Onlineorder> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Onlineorder get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Onlineorder searchOnlineOrders(int orderId) throws SQLException {
        Onlineorder re = new Onlineorder();
        String sql = "SELECT * FROM book_store.onlineorder WHERE OrderID = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, orderId);
        ResultSet rs = ps.executeQuery();
        rs.first();
        re.setCustomerID(rs.getInt("CustomerID"));
        re.setPaymentmethod(rs.getString("paymentmethod"));
        re.setOrderID(orderId);
        re.setShippingAddressID(new Shippingaddress(rs.getInt("shippingaddressID")));
        re.setState(rs.getString("State"));
        re.setVoucherID(new Voucher(rs.getInt("VoucherID")));
        return re;
    }

    @Override
    public int save(Onlineorder t) {
        System.out.println(t);
        String sql = "INSERT INTO book_store.onlineorder (state, customerID, voucherID, shippingaddressID, paymentmethod)"
                + " VALUES(?,?,?,?,?);";
        int key = -1;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getState());
            ps.setInt(2, t.getCustomerID());
            ps.setInt(3, t.getVoucherID().getId());
            ps.setInt(4, t.getShippingAddressID().getId());
            ps.setString(5, t.getPaymentmethod());

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
    public void update(Onlineorder t) {
        System.out.println(t.toString());
        String sql = "UPDATE  book_store.onlineorder SET State = ?  WHERE OrderID = ? ;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getState());
            ps.setInt(2, t.getOrderID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Onlineorder t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addItemsToOrder(List<Item> items, int orderID) {
        int affectedRows = 0;
        for (Item i : items) {
            String sql = "INSERT INTO book_store.order_item (orderID, itemID)"
                    + "VALUES(?,?);";
            int key = -1;
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, orderID);
                ps.setInt(2, i.getId());

                affectedRows += ps.executeUpdate();

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
            }
        }
        return affectedRows;
    }

}
