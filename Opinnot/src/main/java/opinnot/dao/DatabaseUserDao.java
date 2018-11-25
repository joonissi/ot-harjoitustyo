/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.dao;

import java.sql.*;
import java.util.ArrayList;
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
        
        List<User> kayttajat = new ArrayList<>();
        
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM User");
       
        while (rs.next()) {
            
            User u = new User(rs.getInt("id"), rs.getString("username"),
                rs.getString("password"));

            kayttajat.add(u);
        }
        
        statement.close();
        rs.close();
        connection.close();
        
        return kayttajat;
    }
    
    @Override
    public User findByUsername(String username) throws SQLException {
        
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();
        
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM User"
            + " WHERE username = ?");
        stmt.setString(1, username);
        
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        
        User u = new User(rs.getInt("id"), rs.getString("username"),
            rs.getString("password"));
        
        stmt.close();
        rs.close();

        connection.close();
        
        return u;
    }
    
    @Override
    public User create(User user) throws SQLException {
                
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();
        
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO User"
            + " (id, username, password)"
            + " VALUES (?, ?, ?)");
        stmt.setInt(1, user.getId());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getPassword());
        
        stmt.executeUpdate();
        stmt.close();
        
        return user;
    }
    
}
