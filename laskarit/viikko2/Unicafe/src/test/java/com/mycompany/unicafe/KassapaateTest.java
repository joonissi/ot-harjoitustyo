/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    
    Kassapaate kassa;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void hello() {}
     
     @Test
     public void kassapaatteenAlustusToimii() {
         assertEquals(100000, kassa.kassassaRahaa());
     }
     
     @Test
     public void syoEdullisestiToimiiRiittavallaMaksulla() {
         kassa.syoEdullisesti(240);
         
         assertEquals(100240, kassa.kassassaRahaa());
     }
     
     @Test
     public void syoEdullisestiToimiiJosRahaaLiianVahan() {
         kassa.syoEdullisesti(230);
         
         assertEquals(100000, kassa.kassassaRahaa());
     }
     
     @Test
     public void syoMaukkaastiToimiiRiittavallaMaksulla() {
         kassa.syoMaukkaasti(400);
         
         assertEquals(100400, kassa.kassassaRahaa());
     }
     
     @Test
     public void syoMaukkaastiToimiiJosRahaaLiianVahan() {
         kassa.syoMaukkaasti(230);
         
         assertEquals(100000, kassa.kassassaRahaa());
     }
     
     @Test
     public void syoEdullisestiToimiiKortilla() {
         Maksukortti kortti = new Maksukortti(240);
         
         assertTrue(kassa.syoEdullisesti(kortti));
         
         assertEquals(0, kortti.saldo());
     }
     
     @Test
     public void syoEdullisestiToimiiJosKortillaLiianVahanRahaa() {
         Maksukortti kortti = new Maksukortti(1);
         
         assertFalse(kassa.syoEdullisesti(kortti));
     }
     
     @Test
     public void syoMaukkaastiToimiiKortilla() {
         Maksukortti kortti = new Maksukortti(400);
         
         assertTrue(kassa.syoMaukkaasti(kortti));
         
         assertEquals(0, kortti.saldo());
     }
     
     @Test
     public void syoMaukkaastiToimiiJosKortillaLiianVahanRahaa() {
         Maksukortti kortti = new Maksukortti(1);
         
         assertFalse(kassa.syoMaukkaasti(kortti));
     }
     
     @Test
     public void rahanLatausKortilleToimii() {
         Maksukortti kortti = new Maksukortti(100);
         
         kassa.lataaRahaaKortille(kortti, 100);
                 
         assertEquals(100100, kassa.kassassaRahaa());
     }
  
     @Test
     public void rahanLatausKortilleEiToimiNegatiivisellaSummalla() {
         Maksukortti kortti = new Maksukortti(100);
         
         kassa.lataaRahaaKortille(kortti, -1);
                 
         assertEquals(100000, kassa.kassassaRahaa());
     }
     
     @Test
     public void montakoEdullistaLounastaMyyty() {
         Maksukortti kortti = new Maksukortti(250);
         
         kassa.syoEdullisesti(kortti);
                 
         assertEquals(1, kassa.edullisiaLounaitaMyyty());
     }
     
     @Test
     public void montakoMaukastaLounastaMyyty() {
         Maksukortti kortti = new Maksukortti(400);
         
         kassa.syoMaukkaasti(kortti);
                 
         assertEquals(1, kassa.maukkaitaLounaitaMyyty());
     }
}
