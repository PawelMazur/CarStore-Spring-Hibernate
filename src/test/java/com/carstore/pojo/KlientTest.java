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
public class KlientTest {
    
    public KlientTest() {
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
     * Test of getKlientId method, of class Klient.
     */
    @Test
    public void testGetKlientId() {
        System.out.println("getKlientId");
        Klient instance = new Klient();
        Short expResult = null;
        Short result = instance.getKlientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKlientId method, of class Klient.
     */
    @Test
    public void testSetKlientId() {
        System.out.println("setKlientId");
        Short klientId = null;
        Klient instance = new Klient();
        instance.setKlientId(klientId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImie method, of class Klient.
     */
    @Test
    public void testGetImie() {
        System.out.println("getImie");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getImie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImie method, of class Klient.
     */
    @Test
    public void testSetImie() {
        System.out.println("setImie");
        String imie = "";
        Klient instance = new Klient();
        instance.setImie(imie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNazwisko method, of class Klient.
     */
    @Test
    public void testGetNazwisko() {
        System.out.println("getNazwisko");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getNazwisko();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNazwisko method, of class Klient.
     */
    @Test
    public void testSetNazwisko() {
        System.out.println("setNazwisko");
        String nazwisko = "";
        Klient instance = new Klient();
        instance.setNazwisko(nazwisko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPesel method, of class Klient.
     */
    @Test
    public void testGetPesel() {
        System.out.println("getPesel");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getPesel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPesel method, of class Klient.
     */
    @Test
    public void testSetPesel() {
        System.out.println("setPesel");
        String pesel = "";
        Klient instance = new Klient();
        instance.setPesel(pesel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNrDowodu method, of class Klient.
     */
    @Test
    public void testGetNrDowodu() {
        System.out.println("getNrDowodu");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getNrDowodu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNrDowodu method, of class Klient.
     */
    @Test
    public void testSetNrDowodu() {
        System.out.println("setNrDowodu");
        String nrDowodu = "";
        Klient instance = new Klient();
        instance.setNrDowodu(nrDowodu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUlica method, of class Klient.
     */
    @Test
    public void testGetUlica() {
        System.out.println("getUlica");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getUlica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUlica method, of class Klient.
     */
    @Test
    public void testSetUlica() {
        System.out.println("setUlica");
        String ulica = "";
        Klient instance = new Klient();
        instance.setUlica(ulica);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNrTelefonu method, of class Klient.
     */
    @Test
    public void testGetNrTelefonu() {
        System.out.println("getNrTelefonu");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getNrTelefonu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNrTelefonu method, of class Klient.
     */
    @Test
    public void testSetNrTelefonu() {
        System.out.println("setNrTelefonu");
        String nrTelefonu = "";
        Klient instance = new Klient();
        instance.setNrTelefonu(nrTelefonu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFakturas method, of class Klient.
     */
    @Test
    public void testGetFakturas() {
        System.out.println("getFakturas");
        Klient instance = new Klient();
        Set<Faktura> expResult = null;
        Set<Faktura> result = instance.getFakturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFakturas method, of class Klient.
     */
    @Test
    public void testSetFakturas() {
        System.out.println("setFakturas");
        Set<Faktura> fakturas = null;
        Klient instance = new Klient();
        instance.setFakturas(fakturas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
