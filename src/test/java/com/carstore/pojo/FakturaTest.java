/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.pojo;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pawel
 */
public class FakturaTest {
    
    public FakturaTest() {
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

    /**
     * Test of getFakturaId method, of class Faktura.
     */
    @Test
    public void testGetFakturaId() {
        System.out.println("getFakturaId");
        Faktura instance = new Faktura();
        Short expResult = null;
        Short result = instance.getFakturaId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFakturaId method, of class Faktura.
     */
    @Test
    public void testSetFakturaId() {
        System.out.println("setFakturaId");
        Short fakturaId = null;
        Faktura instance = new Faktura();
        instance.setFakturaId(fakturaId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSamochod method, of class Faktura.
     */
    @Test
    public void testGetSamochod() {
        System.out.println("getSamochod");
        Faktura instance = new Faktura();
        Samochod expResult = null;
        Samochod result = instance.getSamochod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSamochod method, of class Faktura.
     */
    @Test
    public void testSetSamochod() {
        System.out.println("setSamochod");
        Samochod samochod = null;
        Faktura instance = new Faktura();
        instance.setSamochod(samochod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKlient method, of class Faktura.
     */
    @Test
    public void testGetKlient() {
        System.out.println("getKlient");
        Faktura instance = new Faktura();
        Klient expResult = null;
        Klient result = instance.getKlient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKlient method, of class Faktura.
     */
    @Test
    public void testSetKlient() {
        System.out.println("setKlient");
        Klient klient = null;
        Faktura instance = new Faktura();
        instance.setKlient(klient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPracownik method, of class Faktura.
     */
    @Test
    public void testGetPracownik() {
        System.out.println("getPracownik");
        Faktura instance = new Faktura();
        Pracownik expResult = null;
        Pracownik result = instance.getPracownik();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPracownik method, of class Faktura.
     */
    @Test
    public void testSetPracownik() {
        System.out.println("setPracownik");
        Pracownik pracownik = null;
        Faktura instance = new Faktura();
        instance.setPracownik(pracownik);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataSprzedazy method, of class Faktura.
     */
    @Test
    public void testGetDataSprzedazy() {
        System.out.println("getDataSprzedazy");
        Faktura instance = new Faktura();
        Date expResult = null;
        Date result = instance.getDataSprzedazy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataSprzedazy method, of class Faktura.
     */
    @Test
    public void testSetDataSprzedazy() {
        System.out.println("setDataSprzedazy");
        Date dataSprzedazy = null;
        Faktura instance = new Faktura();
        instance.setDataSprzedazy(dataSprzedazy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaty method, of class Faktura.
     */
    @Test
    public void testGetRaty() {
        System.out.println("getRaty");
        Faktura instance = new Faktura();
        String expResult = "";
        String result = instance.getRaty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRaty method, of class Faktura.
     */
    @Test
    public void testSetRaty() {
        System.out.println("setRaty");
        String raty = "";
        Faktura instance = new Faktura();
        instance.setRaty(raty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
