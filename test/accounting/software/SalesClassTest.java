/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zozge
 */
public class SalesClassTest {
 /*   
    public SalesClassTest() {
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
     * Test of getDescription method, of class Sales.
     */

    /**
     *
     */

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Sales instance = new Sales("Sales of Market", 1, 500.0, "24/11/2016");
        String expResult = "Sales of Market";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Sales.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Gasoline";
        Sales instance = new Sales("Sales of Market", 1, 500.0, "24/11/2016");
        instance.setDescription("Gasoline");
        assertEquals(description, instance.getDescription());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Sales.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Sales instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class Sales.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 0;
        Sales instance = null;
        instance.setID(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Sales.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Sales instance = new Sales("Sales of Market", 1, 500.0, "24/11/2016");
        Double expResult = 0.0;
        Double result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Sales.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 0;
        Sales instance = null;
        instance.setPrice((double)price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
  
}
