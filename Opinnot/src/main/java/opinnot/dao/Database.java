/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.dao;

import java.sql.*;

/**
 *
 * @author jona
 */

public class Database {

    private String databaseAddress;

    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
    }

    /**
     * Connects to database
     * @return
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
    
    public boolean getTable(String table) {
        
        try {
            Connection connection = this.getConnection();
            DatabaseMetaData md = connection.getMetaData();
        
            ResultSet res = md.getTables(null, null, table, 
                new String[] {"TABLE"});
                        
            while (res.next()) {
                if (res.getString("TABLE_NAME").equals(table)) {
                    res.close();
                    connection.close();
                    
                    return true;
                }
             }
            
            res.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public String toString() {
        return this.databaseAddress;
    }
}
