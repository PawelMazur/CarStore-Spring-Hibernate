/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.dao;

import com.carstore.pojo.Faktura;
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
public class FakturaDaoTest {
    
    public FakturaDaoTest() {
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
     * Test of layDS method, of class FakturaDao.
     */
    @Test
    public void testLayDS() {
        System.out.println("layDS");
        List<Faktura> expResult = null;
        List<Faktura> result = FakturaDao.layDS();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaktura method, of class FakturaDao.
     */
    @Test
    public void testGetFaktura() {
        System.out.println("getFaktura");
        List expResult = null;
        List result = FakturaDao.getFaktura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
