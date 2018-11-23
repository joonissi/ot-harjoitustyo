/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class UserTest {
    
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void userObjectCreation() {
         User kayttaja = new User(1, "kayttaja", "salasana");
         assertEquals(kayttaja.getUsername(), "kayttaja");
     }
     
     @Test
     public void useridSettingTest() {
         User kayttaja = new User(1, "kayttaja", "salasana");
         kayttaja.setId(999);
         
         assertEquals(kayttaja.getId(), 999);
     }
     
    @Test
    public void userUsernameSettingTest() {
        User kayttaja = new User(1, "kayttaja", "salasana");
        kayttaja.setUsername("qoirh");

        assertEquals(kayttaja.getUsername(), "qoirh");
    }
    
    @Test
    public void userPasswordSettingTest() {
        User kayttaja = new User(1, "kayttaja", "salasana");
        kayttaja.setPassword("passu");

        assertEquals(kayttaja.getPassword(), "passu");
    }
    
    @Test
    public void userToStringTest() {
        User kayttaja = new User(1, "kayttaja", "salasana");

        assertEquals(kayttaja.toString(), "Käyttäjätunnus: kayttaja Salasana: salasana");
    }
}
