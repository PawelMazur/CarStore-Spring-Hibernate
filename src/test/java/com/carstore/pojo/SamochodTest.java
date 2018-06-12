/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.pojo;

import java.util.Date;
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
public class SamochodTest {
    
    public SamochodTest() {
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
     * Test of getSamochodId method, of class Samochod.
     */
    @org.junit.Test
    public void testGetSamochodId() {
        System.out.println("getSamochodId");
        Samochod instance = new Samochod();
        Short expResult = null;
        Short result = instance.getSamochodId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSamochodId method, of class Samochod.
     */
    @org.junit.Test
    public void testSetSamochodId() {
        System.out.println("setSamochodId");
        Short samochodId = null;
        Samochod instance = new Samochod();
        instance.setSamochodId(samochodId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKategorie method, of class Samochod.
     */
    @org.junit.Test
    public void testGetKategorie() {
        System.out.println("getKategorie");
        Samochod instance = new Samochod();
        Kategorie expResult = null;
        Kategorie result = instance.getKategorie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKategorie method, of class Samochod.
     */
    @org.junit.Test
    public void testSetKategorie() {
        System.out.println("setKategorie");
        Kategorie kategorie = null;
        Samochod instance = new Samochod();
        instance.setKategorie(kategorie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCena method, of class Samochod.
     */
    @org.junit.Test
    public void testGetCena() {
        System.out.println("getCena");
        Samochod instance = new Samochod();
        Double expResult = null;
        Double result = instance.getCena();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCena method, of class Samochod.
     */
    @org.junit.Test
    public void testSetCena() {
        System.out.println("setCena");
        Double cena = null;
        Samochod instance = new Samochod();
        instance.setCena(cena);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKolor method, of class Samochod.
     */
    @org.junit.Test
    public void testGetKolor() {
        System.out.println("getKolor");
        Samochod instance = new Samochod();
        String expResult = "";
        String result = instance.getKolor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKolor method, of class Samochod.
     */
    @org.junit.Test
    public void testSetKolor() {
        System.out.println("setKolor");
        String kolor = "";
        Samochod instance = new Samochod();
        instance.setKolor(kolor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarka method, of class Samochod.
     */
    @org.junit.Test
    public void testGetMarka() {
        System.out.println("getMarka");
        Samochod instance = new Samochod();
        String expResult = "";
        String result = instance.getMarka();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarka method, of class Samochod.
     */
    @org.junit.Test
    public void testSetMarka() {
        System.out.println("setMarka");
        String marka = "";
        Samochod instance = new Samochod();
        instance.setMarka(marka);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPojemnoscSilnika method, of class Samochod.
     */
    @org.junit.Test
    public void testGetPojemnoscSilnika() {
        System.out.println("getPojemnoscSilnika");
        Samochod instance = new Samochod();
        Float expResult = null;
        Float result = instance.getPojemnoscSilnika();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPojemnoscSilnika method, of class Samochod.
     */
    @org.junit.Test
    public void testSetPojemnoscSilnika() {
        System.out.println("setPojemnoscSilnika");
        Float pojemnoscSilnika = null;
        Samochod instance = new Samochod();
        instance.setPojemnoscSilnika(pojemnoscSilnika);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducent method, of class Samochod.
     */
    @org.junit.Test
    public void testGetProducent() {
        System.out.println("getProducent");
        Samochod instance = new Samochod();
        String expResult = "";
        String result = instance.getProducent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducent method, of class Samochod.
     */
    @org.junit.Test
    public void testSetProducent() {
        System.out.println("setProducent");
        String producent = "";
        Samochod instance = new Samochod();
        instance.setProducent(producent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRokProdukcji method, of class Samochod.
     */
    @org.junit.Test
    public void testGetRokProdukcji() {
        System.out.println("getRokProdukcji");
        Samochod instance = new Samochod();
        Date expResult = null;
        Date result = instance.getRokProdukcji();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRokProdukcji method, of class Samochod.
     */
    @org.junit.Test
    public void testSetRokProdukcji() {
        System.out.println("setRokProdukcji");
        Date rokProdukcji = null;
        Samochod instance = new Samochod();
        instance.setRokProdukcji(rokProdukcji);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNrSeryjny method, of class Samochod.
     */
    @org.junit.Test
    public void testGetNrSeryjny() {
        System.out.println("getNrSeryjny");
        Samochod instance = new Samochod();
        String expResult = "";
        String result = instance.getNrSeryjny();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNrSeryjny method, of class Samochod.
     */
    @org.junit.Test
    public void testSetNrSeryjny() {
        System.out.println("setNrSeryjny");
        String nrSeryjny = "";
        Samochod instance = new Samochod();
        instance.setNrSeryjny(nrSeryjny);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFakturas method, of class Samochod.
     */
    @org.junit.Test
    public void testGetFakturas() {
        System.out.println("getFakturas");
        Samochod instance = new Samochod();
        Set<Faktura> expResult = null;
        Set<Faktura> result = instance.getFakturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFakturas method, of class Samochod.
     */
    @org.junit.Test
    public void testSetFakturas() {
        System.out.println("setFakturas");
        Set<Faktura> fakturas = null;
        Samochod instance = new Samochod();
        instance.setFakturas(fakturas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
