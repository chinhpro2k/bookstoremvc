/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Item;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ItemDAOImpl implements ItemDAO {

    @Override
    public List<Item> findItemInCart(int customerId) {
        String sql = "SELECT * FROM item, customer, cart, cart_item "
                + "WHERE customer.PersonID = ? "
                + "AND customer.CartID = cart.ID "
                + "AND cart.ID = cart_item.CartID "
                + "AND cart_item.ItemID = item.ID ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();
            List<Item> items = new ArrayList<>();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("item.ID"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setSalePrice(BigInteger.valueOf(rs.getLong("saleprice")));
                item.setUrl(rs.getString("url"));
                items.add(item);
            }
            return items;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Item> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item get(int id) {
        String sql = "SELECT * FROM item WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Item item = new Item();
            while (rs.next()) {
                item.setId(rs.getInt("ID"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setSalePrice(BigInteger.valueOf(rs.getLong("saleprice")));
                item.setUrl("url");
            }
            return item;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int save(Item t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Item t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Item t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> findAll() {
        String sql = "SELECT * FROM item";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<Item> items = new ArrayList<>();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("ID"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setSalePrice(BigInteger.valueOf(rs.getLong("saleprice")));
                item.setUrl(rs.getString("url"));
                items.add(item);
            }
            return items;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Item> getItemByName(String name) {
        List<Item> list = new ArrayList<>();
        String sql = "select * from item where Name like ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name.toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("ID"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setSalePrice(BigInteger.valueOf(rs.getLong("saleprice")));
                item.setUrl(rs.getString("url"));
                list.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new ItemDAOImpl().getItemByName("nuôi"));
    }
}
