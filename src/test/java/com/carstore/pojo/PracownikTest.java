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
public class PracownikTest {
    
    public PracownikTest() {
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
     * Test of getPracownikId method, of class Pracownik.
     */
    @Test
    public void testGetPracownikId() {
        System.out.println("getPracownikId");
        Pracownik instance = new Pracownik();
        Short expResult = null;
        Short result = instance.getPracownikId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPracownikId method, of class Pracownik.
     */
    @Test
    public void testSetPracownikId() {
        System.out.println("setPracownikId");
        Short pracownikId = null;
        Pracownik instance = new Pracownik();
        instance.setPracownikId(pracownikId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImie method, of class Pracownik.
     */
    @Test
    public void testGetImie() {
        System.out.println("getImie");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getImie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImie method, of class Pracownik.
     */
    @Test
    public void testSetImie() {
        System.out.println("setImie");
        String imie = "";
        Pracownik instance = new Pracownik();
        instance.setImie(imie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNazwisko method, of class Pracownik.
     */
    @Test
    public void testGetNazwisko() {
        System.out.println("getNazwisko");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getNazwisko();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNazwisko method, of class Pracownik.
     */
    @Test
    public void testSetNazwisko() {
        System.out.println("setNazwisko");
        String nazwisko = "";
        Pracownik instance = new Pracownik();
        instance.setNazwisko(nazwisko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMiasto method, of class Pracownik.
     */
    @Test
    public void testGetMiasto() {
        System.out.println("getMiasto");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getMiasto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMiasto method, of class Pracownik.
     */
    @Test
    public void testSetMiasto() {
        System.out.println("setMiasto");
        String miasto = "";
        Pracownik instance = new Pracownik();
        instance.setMiasto(miasto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUlica method, of class Pracownik.
     */
    @Test
    public void testGetUlica() {
        System.out.println("getUlica");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getUlica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUlica method, of class Pracownik.
     */
    @Test
    public void testSetUlica() {
        System.out.println("setUlica");
        String ulica = "";
        Pracownik instance = new Pracownik();
        instance.setUlica(ulica);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKodPocztowy method, of class Pracownik.
     */
    @Test
    public void testGetKodPocztowy() {
        System.out.println("getKodPocztowy");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getKodPocztowy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKodPocztowy method, of class Pracownik.
     */
    @Test
    public void testSetKodPocztowy() {
        System.out.println("setKodPocztowy");
        String kodPocztowy = "";
        Pracownik instance = new Pracownik();
        instance.setKodPocztowy(kodPocztowy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNrTelefonu method, of class Pracownik.
     */
    @Test
    public void testGetNrTelefonu() {
        System.out.println("getNrTelefonu");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getNrTelefonu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNrTelefonu method, of class Pracownik.
     */
    @Test
    public void testSetNrTelefonu() {
        System.out.println("setNrTelefonu");
        String nrTelefonu = "";
        Pracownik instance = new Pracownik();
        instance.setNrTelefonu(nrTelefonu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFakturas method, of class Pracownik.
     */
    @Test
    public void testGetFakturas() {
        System.out.println("getFakturas");
        Pracownik instance = new Pracownik();
        Set<Faktura> expResult = null;
        Set<Faktura> result = instance.getFakturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFakturas method, of class Pracownik.
     */
    @Test
    public void testSetFakturas() {
        System.out.println("setFakturas");
        Set<Faktura> fakturas = null;
        Pracownik instance = new Pracownik();
        instance.setFakturas(fakturas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
