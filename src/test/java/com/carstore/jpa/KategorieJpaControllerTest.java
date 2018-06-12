/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.jpa;

import com.carstore.pojo.Kategorie;
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
public class KategorieJpaControllerTest {
    
    public KategorieJpaControllerTest() {
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
     * Test of getEntityManager method, of class KategorieJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        KategorieJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class KategorieJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Kategorie kategorie = null;
        KategorieJpaController instance = null;
        instance.create(kategorie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class KategorieJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Kategorie kategorie = null;
        KategorieJpaController instance = null;
        instance.edit(kategorie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class KategorieJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Short id = null;
        KategorieJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findKategorieEntities method, of class KategorieJpaController.
     */
    @Test
    public void testFindKategorieEntities_0args() {
        System.out.println("findKategorieEntities");
        KategorieJpaController instance = null;
        List<Kategorie> expResult = null;
        List<Kategorie> result = instance.findKategorieEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findKategorieEntities method, of class KategorieJpaController.
     */
    @Test
    public void testFindKategorieEntities_int_int() {
        System.out.println("findKategorieEntities");
        int maxResults = 0;
        int firstResult = 0;
        KategorieJpaController instance = null;
        List<Kategorie> expResult = null;
        List<Kategorie> result = instance.findKategorieEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findKategorie method, of class KategorieJpaController.
     */
    @Test
    public void testFindKategorie() {
        System.out.println("findKategorie");
        Short id = null;
        KategorieJpaController instance = null;
        Kategorie expResult = null;
        Kategorie result = instance.findKategorie(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKategorieCount method, of class KategorieJpaController.
     */
    @Test
    public void testGetKategorieCount() {
        System.out.println("getKategorieCount");
        KategorieJpaController instance = null;
        int expResult = 0;
        int result = instance.getKategorieCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
