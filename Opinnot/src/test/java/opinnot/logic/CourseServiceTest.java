package opinnot.logic;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import opinnot.logic.CourseService;
import opinnot.dao.Database;
import opinnot.dao.SQLCourseDao;
import opinnot.dao.SQLUserDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jona
 */
public class CourseServiceTest {

  SQLCourseDao sqlCourseDao;
  SQLUserDao sqlUserDao;

  CourseService courseService;

  public CourseServiceTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() throws ClassNotFoundException {

    Database database = new Database("jdbc:sqlite:opinnot.db");
    SQLUserDao kayttajat = new SQLUserDao(database);
    SQLCourseDao kurssit = new SQLCourseDao(database, null);

    courseService = new CourseService(kurssit, kayttajat);
  }

  @After
  public void tearDown() {
  }

  // TODO add test methods here.
  // The methods must be annotated with annotation @Test. For example:
  //
  @Test
  public void courseServiceObjectCreation() {

    assertEquals(courseService.toString(), "jdbc:sqlite:opinnot.db");
  }
  
  @Test
  public void courseServiceLogin() throws SQLException {

    assertEquals(courseService.login("joona", "jeejee"), true);
  }
  
  @Test
  public void courseServiceLoginWithInvalidData() throws SQLException {

    assertEquals(courseService.login("", "jeejee"), false);
  }
  
  @Test
  public void courseServiceLoginWithNullData() throws SQLException {

    assertEquals(courseService.login(" ", " "), false);
  }
  
  @Test
  public void courseServiceLoggedInUser() throws SQLException {

    courseService.login("joona", "jeejee");
    
    assertEquals(courseService.getLoggedUser().toString(), "Käyttäjätunnus: joona Salasana: jeejee");
  }
  
  @Test
  public void courseServiceLogout() throws SQLException {

    courseService.login("joona", "jeejee");
    courseService.logout();
    
    assertEquals(courseService.getLoggedUser(), null);
  }
  
  @Test
  public void courseServiceCreateUser() throws SQLException {

    int random = courseService.generateUserId();
    assertEquals(courseService.createUser("joona" + random, "jeejee"), true);
  }

  
}
