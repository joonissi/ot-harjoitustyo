package opinnot.logic;

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
    
    User kayttaja;
    
    
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
        
        kayttaja = new User(1, "kayttaja", "salasana");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void userObjectCreation() {
         assertEquals(kayttaja.getUsername(), "kayttaja");
     }
     
     @Test
     public void useridSettingTest() {
         kayttaja.setId(999);
         
         assertEquals(kayttaja.getId(), 999);
     }
     
    @Test
    public void userUsernameSettingTest() {
        kayttaja.setUsername("qoirh");

        assertEquals(kayttaja.getUsername(), "qoirh");
    }
    
    @Test
    public void userPasswordSettingTest() {
        kayttaja.setPassword("passu");

        assertEquals(kayttaja.getPassword(), "passu");
    }
    
    @Test
    public void userToStringTest() {

        assertEquals(kayttaja.toString(), "Käyttäjätunnus: kayttaja Salasana: salasana");
    }
}
