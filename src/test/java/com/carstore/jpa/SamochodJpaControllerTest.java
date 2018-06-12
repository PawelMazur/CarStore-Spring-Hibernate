/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.jpa;

import com.carstore.pojo.Samochod;
import java.util.List;
import javax.persistence.EntityManager;
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
public class SamochodJpaControllerTest {
    
    public SamochodJpaControllerTest() {
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
     * Test of getEntityManager method, of class SamochodJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        SamochodJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class SamochodJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Samochod samochod = null;
        SamochodJpaController instance = null;
        instance.create(samochod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class SamochodJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Samochod samochod = null;
        SamochodJpaController instance = null;
        instance.edit(samochod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class SamochodJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Short id = null;
        SamochodJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSamochodEntities method, of class SamochodJpaController.
     */
    @Test
    public void testFindSamochodEntities_0args() {
        System.out.println("findSamochodEntities");
        SamochodJpaController instance = null;
        List<Samochod> expResult = null;
        List<Samochod> result = instance.findSamochodEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSamochodEntities method, of class SamochodJpaController.
     */
    @Test
    public void testFindSamochodEntities_int_int() {
        System.out.println("findSamochodEntities");
        int maxResults = 0;
        int firstResult = 0;
        SamochodJpaController instance = null;
        List<Samochod> expResult = null;
        List<Samochod> result = instance.findSamochodEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSamochod method, of class SamochodJpaController.
     */
    @Test
    public void testFindSamochod() {
        System.out.println("findSamochod");
        Short id = null;
        SamochodJpaController instance = null;
        Samochod expResult = null;
        Samochod result = instance.findSamochod(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSamochodCount method, of class SamochodJpaController.
     */
    @Test
    public void testGetSamochodCount() {
        System.out.println("getSamochodCount");
        SamochodJpaController instance = null;
        int expResult = 0;
        int result = instance.getSamochodCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
