/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Fullname;
import entities.Item;
import entities.Person;
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
public class PersonDAOImpl implements PersonDAO {

    @Override
    public List<Person> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(Person t) {
        String sql = "INSERT INTO book_store.person (dateofbirth, gender, idcard, accountid, fullnameid, contactinforid)"
                + "VALUES(?,?,?,?,?,?);";
        int key = -1;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getDateOfBirth());
            ps.setString(2, t.getGender());
            ps.setString(3, t.getIdCard());
            ps.setInt(4, t.getAccountID().getId());
            ps.setInt(5, t.getFullNameID().getId());
            ps.setInt(6, t.getContactInforID().getId());

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
    public void update(Person t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Person t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPersonByAccountID(int id) {
        String sql = "SELECT * FROM person, fullname "
                + " WHERE accountid = ? "
                + " AND fullname.id = person.fullnameid";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            Person p = new Person();
            rs.first();
            p.setId(rs.getInt("person.id"));
            Fullname f = new Fullname();
            f.setFirstName(rs.getString("firstname"));
            f.setMiddleName(rs.getString("middlename"));
            f.setLastName(rs.getString("lastname"));            
            p.setFullNameID(f);
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static void main(String[] args) {
        PersonDAOImpl aOImpl = new PersonDAOImpl();
        System.out.println(aOImpl.getPersonByAccountID(26));
    }
}
