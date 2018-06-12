/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.jpa;

import com.carstore.pojo.Klient;
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
public class KlientJpaControllerTest {
    
    public KlientJpaControllerTest() {
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
     * Test of getEntityManager method, of class KlientJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        KlientJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class KlientJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Klient klient = null;
        KlientJpaController instance = null;
        instance.create(klient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class KlientJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Klient klient = null;
        KlientJpaController instance = null;
        instance.edit(klient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class KlientJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Short id = null;
        KlientJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findKlientEntities method, of class KlientJpaController.
     */
    @Test
    public void testFindKlientEntities_0args() {
        System.out.println("findKlientEntities");
        KlientJpaController instance = null;
        List<Klient> expResult = null;
        List<Klient> result = instance.findKlientEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findKlientEntities method, of class KlientJpaController.
     */
    @Test
    public void testFindKlientEntities_int_int() {
        System.out.println("findKlientEntities");
        int maxResults = 0;
        int firstResult = 0;
        KlientJpaController instance = null;
        List<Klient> expResult = null;
        List<Klient> result = instance.findKlientEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findKlient method, of class KlientJpaController.
     */
    @Test
    public void testFindKlient() {
        System.out.println("findKlient");
        Short id = null;
        KlientJpaController instance = null;
        Klient expResult = null;
        Klient result = instance.findKlient(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKlientCount method, of class KlientJpaController.
     */
    @Test
    public void testGetKlientCount() {
        System.out.println("getKlientCount");
        KlientJpaController instance = null;
        int expResult = 0;
        int result = instance.getKlientCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
