/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Account;

/**
 *
 * @author os_hoangpn
 */
public interface AccountDAO extends BaseDAO<Account> {

    Account checkAccount(Account t);

    boolean checkUsernameExist(String username);
}
