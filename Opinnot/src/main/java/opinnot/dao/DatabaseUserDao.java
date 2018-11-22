/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.dao;

import java.sql.*;
import java.util.List;
import opinnot.logic.User;

/**
 *
 * @author jona
 */
public class DatabaseUserDao implements UserDao {
    
    private Database database;

    public DatabaseUserDao(Database database) {
        this.database = database;
    }
    
    @Override
    public List<User> findAll() throws SQLException {
        Connection connection = database.getConnection();
        
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM User");
       
        while(rs.next()) {
                Integer opNro = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                // tulostetaan tiedot
                System.out.println(opNro + "\t" + username + "\t" + password);
        }
        
        statement.close();
        rs.close();
        connection.close();
        
        return null;
    }
    
    @Override
    public User findByUsername(String username) throws SQLException {
        // TODO
        return null;
    }
    
    @Override
    public User create(User user) throws SQLException {
        // TODO
        return null;
    }
    
}
