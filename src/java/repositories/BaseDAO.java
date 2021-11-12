/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import databaseconfig.ConnectDB;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author os_hoangpn
 */
public interface BaseDAO<T> {
    Connection con = ConnectDB.openConnect();
    List<T> getAll();

    T get(int id);

    int save(T t);

    void update(T t);

    void delete(T t);

}
