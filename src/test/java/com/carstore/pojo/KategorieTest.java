/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.pojo;

import java.util.Set;
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
public class KategorieTest {
    
    public KategorieTest() {
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
     * Test of getKategorieId method, of class Kategorie.
     */
    @Test
    public void testGetKategorieId() {
        System.out.println("getKategorieId");
        Kategorie instance = new Kategorie();
        Short expResult = null;
        Short result = instance.getKategorieId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setKategorieId method, of class Kategorie.
     */
    @Test
    public void testSetKategorieId() {
        System.out.println("setKategorieId");
        Short kategorieId = null;
        Kategorie instance = new Kategorie();
        instance.setKategorieId(kategorieId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNazwaKategorii method, of class Kategorie.
     */
    @Test
    public void testGetNazwaKategorii() {
        System.out.println("getNazwaKategorii");
        Kategorie instance = new Kategorie();
        String expResult = "";
        String result = instance.getNazwaKategorii();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNazwaKategorii method, of class Kategorie.
     */
    @Test
    public void testSetNazwaKategorii() {
        System.out.println("setNazwaKategorii");
        String nazwaKategorii = "";
        Kategorie instance = new Kategorie();
        instance.setNazwaKategorii(nazwaKategorii);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUwagi method, of class Kategorie.
     */
    @Test
    public void testGetUwagi() {
        System.out.println("getUwagi");
        Kategorie instance = new Kategorie();
        String expResult = "";
        String result = instance.getUwagi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUwagi method, of class Kategorie.
     */
    @Test
    public void testSetUwagi() {
        System.out.println("setUwagi");
        String uwagi = "";
        Kategorie instance = new Kategorie();
        instance.setUwagi(uwagi);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSportowy method, of class Kategorie.
     */
    @Test
    public void testGetSportowy() {
        System.out.println("getSportowy");
        Kategorie instance = new Kategorie();
        String expResult = "";
        String result = instance.getSportowy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSportowy method, of class Kategorie.
     */
    @Test
    public void testSetSportowy() {
        System.out.println("setSportowy");
        String sportowy = "";
        Kategorie instance = new Kategorie();
        instance.setSportowy(sportowy);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSamochods method, of class Kategorie.
     */
    @Test
    public void testGetSamochods() {
        System.out.println("getSamochods");
        Kategorie instance = new Kategorie();
        Set<Samochod> expResult = null;
        Set<Samochod> result = instance.getSamochods();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSamochods method, of class Kategorie.
     */
    @Test
    public void testSetSamochods() {
        System.out.println("setSamochods");
        Set<Samochod> samochods = null;
        Kategorie instance = new Kategorie();
        instance.setSamochods(samochods);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
