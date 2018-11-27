/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.logic;

import java.sql.SQLException;
import java.util.Random;
import opinnot.dao.SQLCourseDao;
import opinnot.dao.SQLUserDao;

/**
 *
 * @author jona
 */
public class CourseService {
    private SQLCourseDao sqlCourseDao;
    private SQLUserDao sqlUserDao;
    private User loggedIn;
    
    public CourseService(SQLCourseDao sqlCourseDao, SQLUserDao sqlUserDao) {
        this.sqlCourseDao = sqlCourseDao;
        this.sqlUserDao = sqlUserDao;
    }
    
    public boolean login(String username, String password) throws SQLException {
        User user = sqlUserDao.findByUsername(username);
        
        if (user == null) {
            return false;
        }
        
        if (!user.getPassword().equals(password)) {
            return false;
        }
        
        loggedIn = user;
        
        return true;
    }
    
    public User getLoggedUser() {
        return loggedIn;
    }
    
    public void logout() {
        loggedIn = null;
    }
    
    public boolean createUser(String username, String password) throws SQLException {

        if (sqlUserDao.findByUsername(username) != null) {
            return false;
        }
        
        int id = generateUserId();
        
        User user = new User(id, username, password);
        try {
            sqlUserDao.create(user);
        } catch(Exception e) {
            return false;
        }
        
        return true;
    }
    
    private int generateUserId() {
        Random r = new Random();
        int low = 0;
        int high = 100000;
        int id = r.nextInt(high - low) + low;
        
        return id;
    }

}
