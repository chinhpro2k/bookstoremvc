/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author os_hoangpn
 */
public class AccountDAOImpl implements AccountDAO {

    @Override
    public List<Account> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(Account t) {
        String sql = "INSERT INTO book_store.account (username, password, role)"
                + "VALUES(?,?,?);";
        int key = -1;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getUsername());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getRole());

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
    public void update(Account t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Account t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Account checkAccount(Account t) {
        String sql = "SELECT * FROM book_store.account "
                + "WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getUsername());
            ps.setString(2, t.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                Account account = new Account();
                account.setId(rs.getInt("ID"));
                account.setUsername(rs.getString("username"));
                account.setRole(rs.getString("role"));
                return account;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean checkUsernameExist(String username) {
        String sql = "SELECT * FROM book_store.account "
                + "WHERE username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(new AccountDAOImpl().checkUsernameExist("kh001"));
    }
}
