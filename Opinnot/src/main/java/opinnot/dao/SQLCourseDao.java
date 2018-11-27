/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.dao;

import java.sql.*;
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
    
    public SQLCourseDao(Database databse, Dao<User, Integer> SQLUserDao) {
        this.database = database;
        this.SQLUserDao = SQLUserDao;
    }
    
    @Override
    public List<Course> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Course findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Course create(Course course) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
