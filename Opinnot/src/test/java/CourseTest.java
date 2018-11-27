/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import opinnot.logic.Course;
import opinnot.logic.User;
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
public class CourseTest {
    
    User kayttaja;
    Course kurssi;
    
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        kayttaja = new User(1, "kayttaja", "salasana");
         
        kurssi = new Course(1, "ohjelmointi", 5, false, kayttaja);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void courseObjectCreation() {
              
         assertEquals(kurssi.toString(), "Kurssi: ohjelmointi opintopisteitä: 5");
     }
     
     @Test
     public void courseIdUpdate() {
         kurssi.setId(4);
         
         assertEquals(kurssi.getId(), 4);
     }
     
     @Test
     public void courseNameUpdate() {
         kurssi.setName("tietokantojen perusteet");
         
         assertEquals(kurssi.getName(), "tietokantojen perusteet");
     }
     
     @Test
     public void coursePointsUpdate() {
         kurssi.setPoints(10);
         
         assertEquals(kurssi.getPoints(), 10);
     }
     
     @Test
     public void courseIsDone() {
         kurssi.setDone();
         
         assertEquals(kurssi.getDone(), true);
     }
}
