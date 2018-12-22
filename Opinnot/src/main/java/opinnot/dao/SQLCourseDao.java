/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import opinnot.logic.Course;
import opinnot.logic.User;

/**
 *
 * @author jona
 */
public class SQLCourseDao implements Dao<Course, Integer> {
    
    private Database database;
    private Dao<User, Integer> SQLUserDao;
    
    public SQLCourseDao(Database database, Dao<User, Integer> SQLUserDao) {
        this.database = database;
        this.SQLUserDao = SQLUserDao;
    }
    
    public String toString() {
        return this.database.toString();
    }
    
    /**
     * Creates Course table to database
     * @throws SQLException 
     */
    public void createTable() throws SQLException {
        
        Connection connection = database.getConnection();
        //Statement statement = connection.createStatement();
        PreparedStatement stmt = connection.prepareStatement("CREATE TABLE Course ("
                + " id INT PRIMARY KEY,"
                + " name VARCHAR(100),"
                + " points INT,"
                + " done BOOLEAN,"
                + " user_id INT,"
                + " FOREIGN KEY(user_id) REFERENCES User(id)"
                + ")"
        );
        
        stmt.execute();
        stmt.close();
        connection.close();
        
    }
    
    /**
     * Deletes course entry from database via id
     * @param id
     * @throws SQLException 
     */
    public void delete(Integer id) throws SQLException {
        
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM Course WHERE id = ?");
        
        stmt.setInt(1, id);
        stmt.executeUpdate();
        
        stmt.close();
        connection.close();
    }
    
    /**
     * Returns list of current users courses
     * @param id
     * @return List of courses
     * @throws SQLException 
     */
    public List<Course> findAllById(Integer id) throws SQLException {
        
        List<Course> courses = new ArrayList<>();
        
        Connection connection = database.getConnection();
   
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Course WHERE user_id = ?");
        stmt.setObject(1, id);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return courses;
        }
        
        while (rs.next()) {

            User user = SQLUserDao.findOne(rs.getInt("user_id"));
            
            Course c = new Course(rs.getInt("id"), rs.getString("name"),
                rs.getInt("points"), rs.getBoolean("done"), user);

            courses.add(c);
                
        }

        rs.close();
        stmt.close();
        connection.close();

        return courses;
    }
    
    /**
     * Finds all courses from database
     * @return List of all courses
     * @throws SQLException 
     */
    @Override
    public List<Course> findAll() throws SQLException {
        
        List<Course> courses = new ArrayList<>();
        
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Course");
        
        while (rs.next()) {
                        
            User user = SQLUserDao.findOne(rs.getInt("user_id"));
            
            Course c = new Course(rs.getInt("id"), rs.getString("name"),
                rs.getInt("points"), rs.getBoolean("done"), user);
            
            courses.add(c);
                
        }

        rs.close();
        statement.close();
        connection.close();

        return courses;
    }
    
    /**
     * Finds one course from database via id
     * @param id
     * @return Course object
     * @throws SQLException 
     */
    @Override
    public Course findOne(Integer id) throws SQLException {
        
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Course WHERE id = ?");
        stmt.setObject(1, id);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        User u = SQLUserDao.findOne(rs.getInt("user_id"));

        Course c = new Course(id, rs.getString("name"),
            rs.getInt("points"), rs.getBoolean("done"), u);


        rs.close();
        stmt.close();
        connection.close();

        return c;
    }
    
    /**
     * Creates entry of course into to database
     * @param course
     * @return Course object
     * @throws SQLException 
     */
    @Override
    public Course create(Course course) throws SQLException {
        
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Course"
            + " (id, name, points, done, user_id)"
            + " VALUES (?, ?, ?, ?, ?)");
        stmt.setInt(1, course.getId());
        stmt.setString(2, course.getName());
        stmt.setInt(3, course.getPoints());
        stmt.setBoolean(4, course.getDone());
        stmt.setInt(5, course.getUserId());

        stmt.executeUpdate();
        stmt.close();

        return course;
    }
}
