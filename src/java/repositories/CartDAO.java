/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Cart;

/**
 *
 * @author os_hoangpn
 */
public interface CartDAO extends BaseDAO<Object> {
    Cart findCartByCustomer(String customerId);
    void addNewItemToCart(int ItemID, int CartID);
}
