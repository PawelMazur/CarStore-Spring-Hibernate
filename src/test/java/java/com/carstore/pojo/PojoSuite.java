/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java.com.carstore.pojo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Pawel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.carstore.pojo.FakturaTest.class, com.carstore.pojo.SamochodTest.class, com.carstore.pojo.KlientTest.class, com.carstore.pojo.KategorieTest.class, com.carstore.pojo.PracownikTest.class})
public class PojoSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
