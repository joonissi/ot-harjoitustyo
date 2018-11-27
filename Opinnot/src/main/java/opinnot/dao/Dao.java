/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.dao;

import java.sql.SQLException;
import java.util.List;
import opinnot.logic.User;

/**
 *
 * @author jona
 */
public interface Dao<T, K> {
    
    T create(T object) throws SQLException;
    T findOne(K key) throws SQLException;
    List<T> findAll() throws SQLException;
}
