/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import entities.Item;
import entities.Onlineorder;
import java.util.List;

/**
 *
 * @author os_hoangpn
 */
public interface OnlineOrderDAO extends BaseDAO<Onlineorder>{
    int addItemsToOrder(List<Item> items, int orderID);
}
