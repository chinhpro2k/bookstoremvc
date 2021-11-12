/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Person;

/**
 *
 * @author os_hoangpn
 */
public interface PersonDAO extends BaseDAO<Person>{
   Person getPersonByAccountID(int id);
}
