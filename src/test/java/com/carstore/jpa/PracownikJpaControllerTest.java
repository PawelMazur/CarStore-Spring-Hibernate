/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.jpa;

import com.carstore.pojo.Pracownik;
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
public class PracownikJpaControllerTest {
    
    public PracownikJpaControllerTest() {
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
     * Test of getEntityManager method, of class PracownikJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PracownikJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PracownikJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Pracownik pracownik = null;
        PracownikJpaController instance = null;
        instance.create(pracownik);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PracownikJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Pracownik pracownik = null;
        PracownikJpaController instance = null;
        instance.edit(pracownik);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class PracownikJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Short id = null;
        PracownikJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPracownikEntities method, of class PracownikJpaController.
     */
    @Test
    public void testFindPracownikEntities_0args() {
        System.out.println("findPracownikEntities");
        PracownikJpaController instance = null;
        List<Pracownik> expResult = null;
        List<Pracownik> result = instance.findPracownikEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPracownikEntities method, of class PracownikJpaController.
     */
    @Test
    public void testFindPracownikEntities_int_int() {
        System.out.println("findPracownikEntities");
        int maxResults = 0;
        int firstResult = 0;
        PracownikJpaController instance = null;
        List<Pracownik> expResult = null;
        List<Pracownik> result = instance.findPracownikEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPracownik method, of class PracownikJpaController.
     */
    @Test
    public void testFindPracownik() {
        System.out.println("findPracownik");
        Short id = null;
        PracownikJpaController instance = null;
        Pracownik expResult = null;
        Pracownik result = instance.findPracownik(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPracownikCount method, of class PracownikJpaController.
     */
    @Test
    public void testGetPracownikCount() {
        System.out.println("getPracownikCount");
        PracownikJpaController instance = null;
        int expResult = 0;
        int result = instance.getPracownikCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
