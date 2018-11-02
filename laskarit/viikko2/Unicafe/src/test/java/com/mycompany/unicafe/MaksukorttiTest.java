package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOnOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvaattaaSaldoaOikein() {
        kortti.lataaRahaa(5);
        assertEquals("saldo: 0.15", kortti.toString());
    }
    
    @Test
    public void rahaVaheneeSitaKAyttaessa() {
        kortti.otaRahaa(5);
        
        assertEquals("saldo: 0.5", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(11);
        
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanKayttoPalauttaaOikeanTyypin() {
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void saldonKyselyPalauttaaOikeanArvon() {
        assertEquals(10, kortti.saldo());
    }
}
