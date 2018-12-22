/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private List<Course> loggedInCourses;
    
    public CourseService(SQLUserDao sqlUserDao) {
        this.sqlUserDao = sqlUserDao;
    }
    
    public CourseService(SQLCourseDao sqlCourseDao, SQLUserDao sqlUserDao) {
        this.sqlCourseDao = sqlCourseDao;
        this.sqlUserDao = sqlUserDao;
        this.loggedInCourses = new ArrayList<Course>(); 
    }
    
    /**
     * Method for logging user in. It tries to find username and password
     * match from database and save it as reference in loggedIn attribute
     * 
     * @param username username as String
     * @param password password as String
     * @return true if user is found
     * @throws SQLException 
     */
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
    
    /**
     * Gets instance of logged in user
     * @return User object
     */
    public User getLoggedUser() {
        return loggedIn;
    }
    
    /**
     * Saves current users courses
     * @throws SQLException 
     */
    public void setCourses() throws SQLException {
        List<Course> c = sqlCourseDao.findAllById(loggedIn.getId());
        this.loggedInCourses = c;
    }
    
    /**
     * get list of current users courses
     * @return List of Courses
     * @throws SQLException 
     */
    public List<Course> getCourses() throws SQLException {
        return this.loggedInCourses;
    }
    
    /**
     * Removes User object from loggedIn attribute
     */
    public void logout() {
        loggedIn = null;
    }
    
    /**
     * Creates user with username and password combination
     * @param username username as String
     * @param password password as String
     * @return true if user is created successfully
     * @throws SQLException 
     */
    public boolean createUser(String username, String password) throws SQLException {

        if (sqlUserDao.findByUsername(username) != null) {
            return false;
        }
        
        int id = generateUserId();
        
        User user = new User(id, username, password);
        try {
            sqlUserDao.create(user);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Creates course for current user
     * @param course course Course
     * @return true if course was made successfully
     * @throws SQLException 
     */
    public boolean createCourse(Course course) throws SQLException {
        sqlCourseDao.create(course);
        if (course == null) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Deletes current users course 
     * @param course Course
     * @return true if delete was made successfully
     * @throws SQLException 
     */
    public boolean deleteCourse(Course course) throws SQLException {
        try {
            sqlCourseDao.delete(course.getId());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public String toString() {
        return this.sqlCourseDao.toString();
    }
    
    /**
     * Creates unique id for user
     * @return id int
     */
    public int generateUserId() {
        Random r = new Random();
        int low = 0;
        int high = 100000;
        int id = r.nextInt(high - low) + low;
        
        return id;
    }

}
