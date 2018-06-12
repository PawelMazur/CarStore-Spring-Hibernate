/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.dao;

import com.carstore.pojo.Faktura;
import com.carstore.pojo.Kategorie;
import java.util.List;
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
public class FakturaHelperDaoTest {
    
    public FakturaHelperDaoTest() {
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
     * Test of getFaktura method, of class FakturaHelperDao.
     */
    @Test
    public void testGetFaktura() {
        System.out.println("getFaktura");
        int startID = 0;
        int endID = 0;
        FakturaHelperDao instance = new FakturaHelperDao();
        List expResult = null;
        List result = instance.getFaktura(startID, endID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPracownikByID method, of class FakturaHelperDao.
     */
    @Test
    public void testGetPracownikByID() {
        System.out.println("getPracownikByID");
        int filmId = 0;
        FakturaHelperDao instance = new FakturaHelperDao();
        List expResult = null;
        List result = instance.getPracownikByID(filmId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryByID method, of class FakturaHelperDao.
     */
    @Test
    public void testGetCategoryByID() {
        System.out.println("getCategoryByID");
        int filmId = 0;
        FakturaHelperDao instance = new FakturaHelperDao();
        Kategorie expResult = null;
        Kategorie result = instance.getCategoryByID(filmId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFakturaByID method, of class FakturaHelperDao.
     */
    @Test
    public void testGetFakturaByID() {
        System.out.println("getFakturaByID");
        int filmId = 0;
        FakturaHelperDao instance = new FakturaHelperDao();
        Faktura expResult = null;
        Faktura result = instance.getFakturaByID(filmId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLangByID method, of class FakturaHelperDao.
     */
    @Test
    public void testGetLangByID() {
        System.out.println("getLangByID");
        int langId = 0;
        FakturaHelperDao instance = new FakturaHelperDao();
        String expResult = "";
        String result = instance.getLangByID(langId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
