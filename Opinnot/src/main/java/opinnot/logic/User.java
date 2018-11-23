/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.logic;

/**
 *
 * @author jona
 */
public class User {
    private int id;
    private String username;
    private String password;
    
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String toString() {
        return "Käyttäjätunnus: " + this.username + " Salasana: " + this.password;
    }
    
}


