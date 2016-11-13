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
 * @author gurol
 */
public class AccountingSystemTest {
    
    public AccountingSystemTest() {
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
     * Test of getInstance method, of class AccountingSystem.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        AccountingSystem expResult = null;
        AccountingSystem result = AccountingSystem.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSale method, of class AccountingSystem.
     */
    @Test
    public void testGetSale() {
        System.out.println("getSale");
        int index = 0;
        AccountingSystem instance = null;
        SalesClass expResult = null;
        SalesClass result = instance.getSale(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerson method, of class AccountingSystem.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        int index = 0;
        AccountingSystem instance = null;
        Personnel expResult = null;
        Personnel result = instance.getPerson(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaleById method, of class AccountingSystem.
     */
    @Test
    public void testGetSaleById() {
        System.out.println("getSaleById");
        int saleID = 0;
        AccountingSystem instance = null;
        SalesClass expResult = null;
        SalesClass result = instance.getSaleById(saleID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonById method, of class AccountingSystem.
     */
    @Test
    public void testGetPersonById() {
        System.out.println("getPersonById");
        int personId = 0;
        AccountingSystem instance = null;
        Personnel expResult = null;
        Personnel result = instance.getPersonById(personId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSales method, of class AccountingSystem.
     */
    @Test
    public void testGetSales() {
        System.out.println("getSales");
        int index = 0;
        AccountingSystem instance = null;
        SalesClass expResult = null;
        SalesClass result = instance.getSales(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuel method, of class AccountingSystem.
     */
    @Test
    public void testGetFuel() {
        System.out.println("getFuel");
        int index = 0;
        AccountingSystem instance = null;
        Fuel expResult = null;
        Fuel result = instance.getFuel(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalesListSize method, of class AccountingSystem.
     */
    @Test
    public void testGetSalesListSize() {
        System.out.println("getSalesListSize");
        AccountingSystem instance = null;
        int expResult = 0;
        int result = instance.getSalesListSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonnelSize method, of class AccountingSystem.
     */
    @Test
    public void testGetPersonnelSize() {
        System.out.println("getPersonnelSize");
        AccountingSystem instance = null;
        int expResult = 0;
        int result = instance.getPersonnelSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuelSize method, of class AccountingSystem.
     */
    @Test
    public void testGetFuelSize() {
        System.out.println("getFuelSize");
        AccountingSystem instance = null;
        int expResult = 0;
        int result = instance.getFuelSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSale method, of class AccountingSystem.
     */
    @Test
    public void testAddSale() {
        System.out.println("addSale");
        SalesClass newSale = null;
        AccountingSystem instance = null;
        instance.addSale(newSale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPerson method, of class AccountingSystem.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Personnel newPerson = null;
        AccountingSystem instance = null;
        instance.addPerson(newPerson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSale method, of class AccountingSystem.
     */
    @Test
    public void testRemoveSale() {
        System.out.println("removeSale");
        int id = 0;
        AccountingSystem instance = null;
        instance.removeSale(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePerson method, of class AccountingSystem.
     */
    @Test
    public void testRemovePerson() {
        System.out.println("removePerson");
        int id = 0;
        AccountingSystem instance = null;
        instance.removePerson(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFuel method, of class AccountingSystem.
     */
    @Test
    public void testAddFuel() {
        System.out.println("addFuel");
        Fuel newFuel = null;
        AccountingSystem instance = null;
        instance.addFuel(newFuel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFuel method, of class AccountingSystem.
     */
    @Test
    public void testRemoveFuel() {
        System.out.println("removeFuel");
        String fuelType = "";
        AccountingSystem instance = null;
        instance.removeFuel(fuelType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonnelPanel method, of class AccountingSystem.
     */
    @Test
    public void testGetPersonnelPanel() {
        System.out.println("getPersonnelPanel");
        int index = 0;
        AccountingSystem instance = null;
        PersonnelPanel expResult = null;
        PersonnelPanel result = instance.getPersonnelPanel(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPersonnelPanel method, of class AccountingSystem.
     */
    @Test
    public void testAddPersonnelPanel() {
        System.out.println("addPersonnelPanel");
        PersonnelPanel newPersonnelPanel = null;
        AccountingSystem instance = null;
        instance.addPersonnelPanel(newPersonnelPanel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePersonnelPanel method, of class AccountingSystem.
     */
    @Test
    public void testRemovePersonnelPanel() {
        System.out.println("removePersonnelPanel");
        int index = 0;
        AccountingSystem instance = null;
        instance.removePersonnelPanel(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIncomePanel method, of class AccountingSystem.
     */
    @Test
    public void testGetIncomePanel() {
        System.out.println("getIncomePanel");
        int index = 0;
        AccountingSystem instance = null;
        IncomePanel expResult = null;
        IncomePanel result = instance.getIncomePanel(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addIncomePanel method, of class AccountingSystem.
     */
    @Test
    public void testAddIncomePanel() {
        System.out.println("addIncomePanel");
        IncomePanel newIncomePanel = null;
        AccountingSystem instance = null;
        instance.addIncomePanel(newIncomePanel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeIncomePanel method, of class AccountingSystem.
     */
    @Test
    public void testRemoveIncomePanel() {
        System.out.println("removeIncomePanel");
        int index = 0;
        AccountingSystem instance = null;
        instance.removeIncomePanel(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpensePanel method, of class AccountingSystem.
     */
    @Test
    public void testGetExpensePanel() {
        System.out.println("getExpensePanel");
        int index = 0;
        AccountingSystem instance = null;
        ExpensePanel expResult = null;
        ExpensePanel result = instance.getExpensePanel(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addExpensePanel method, of class AccountingSystem.
     */
    @Test
    public void testAddExpensePanel() {
        System.out.println("addExpensePanel");
        ExpensePanel newExpensePanel = null;
        AccountingSystem instance = null;
        instance.addExpensePanel(newExpensePanel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeExpensePanel method, of class AccountingSystem.
     */
    @Test
    public void testRemoveExpensePanel() {
        System.out.println("removeExpensePanel");
        int index = 0;
        AccountingSystem instance = null;
        instance.removeExpensePanel(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
