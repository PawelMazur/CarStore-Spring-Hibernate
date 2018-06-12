/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.jpa;

import com.carstore.pojo.Faktura;
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
public class FakturaJpaControllerTest {
    
    public FakturaJpaControllerTest() {
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
     * Test of getEntityManager method, of class FakturaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        FakturaJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class FakturaJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Faktura faktura = null;
        FakturaJpaController instance = null;
        instance.create(faktura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class FakturaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Faktura faktura = null;
        FakturaJpaController instance = null;
        instance.edit(faktura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class FakturaJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Short id = null;
        FakturaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFakturaEntities method, of class FakturaJpaController.
     */
    @Test
    public void testFindFakturaEntities_0args() {
        System.out.println("findFakturaEntities");
        FakturaJpaController instance = null;
        List<Faktura> expResult = null;
        List<Faktura> result = instance.findFakturaEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFakturaEntities method, of class FakturaJpaController.
     */
    @Test
    public void testFindFakturaEntities_int_int() {
        System.out.println("findFakturaEntities");
        int maxResults = 0;
        int firstResult = 0;
        FakturaJpaController instance = null;
        List<Faktura> expResult = null;
        List<Faktura> result = instance.findFakturaEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFaktura method, of class FakturaJpaController.
     */
    @Test
    public void testFindFaktura() {
        System.out.println("findFaktura");
        Short id = null;
        FakturaJpaController instance = null;
        Faktura expResult = null;
        Faktura result = instance.findFaktura(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFakturaCount method, of class FakturaJpaController.
     */
    @Test
    public void testGetFakturaCount() {
        System.out.println("getFakturaCount");
        FakturaJpaController instance = null;
        int expResult = 0;
        int result = instance.getFakturaCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
