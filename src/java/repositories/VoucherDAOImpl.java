/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Voucher;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static repositories.BaseDAO.con;

/**
 *
 * @author os_hoangpn
 */
public class VoucherDAOImpl implements VoucherDAO {

    @Override
    public List<Voucher> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Voucher get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(Voucher t) {
        String sql = "INSERT INTO book_store.voucher (Name, DiscountPercent, DiscountAmount, Description)"
                + "VALUES(?,?,?,?);";
        int key = -1;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getName());
            ps.setDouble(2, t.getDiscountPercent());
            ps.setInt(3, Integer.parseInt(t.getDiscountAmount().toString()));
            ps.setString(4, t.getDescription());

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
    public void update(Voucher t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Voucher t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Voucher v = new Voucher();
        v.setName("1");
        v.setDiscountAmount(new BigInteger("1"));
        v.setDiscountPercent(1);
        v.setDescription("1");
        System.out.println(new VoucherDAOImpl().save(v));
    }
}
