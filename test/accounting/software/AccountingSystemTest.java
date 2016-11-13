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

//    /**
//     * Test of getInstance method, of class AccountingSystem.
//     */
//    @Test
//    public void testGetInstance() {
//        System.out.println("getInstance");
//        AccountingSystem expResult = null;
//        AccountingSystem result = AccountingSystem.getInstance();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPerson method, of class AccountingSystem.
//     */
//    @Test
//    public void testGetPerson() {
//        System.out.println("getPerson");
//        int index = 0;
//        AccountingSystem instance = null;
//        Personnel expResult = null;
//        Personnel result = instance.getPerson(index);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersonById method, of class AccountingSystem.
//     */
//    @Test
//    public void testGetPersonById() {
//        System.out.println("getPersonById");
//        int personId = 0;
//        AccountingSystem instance = null;
//        Personnel expResult = null;
//        Personnel result = instance.getPersonById(personId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFuel method, of class AccountingSystem.
//     */
//    @Test
//    public void testGetFuel() {
//        System.out.println("getFuel");
//        int index = 0;
//        AccountingSystem instance = null;
//        Fuel expResult = null;
//        Fuel result = instance.getFuel(index);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersonnelSize method, of class AccountingSystem.
//     */
//    @Test
//    public void testGetPersonnelSize() {
//        System.out.println("getPersonnelSize");
//        AccountingSystem instance = null;
//        int expResult = 0;
//        int result = instance.getPersonnelSize();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFuelSize method, of class AccountingSystem.
//     */
//    @Test
//    public void testGetFuelSize() {
//        System.out.println("getFuelSize");
//        AccountingSystem instance = null;
//        int expResult = 0;
//        int result = instance.getFuelSize();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addPerson method, of class AccountingSystem.
//     */
//    @Test
//    public void testAddPerson() {
//        System.out.println("addPerson");
//        Personnel newPerson = null;
//        AccountingSystem instance = null;
//        instance.addPerson(newPerson);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removePerson method, of class AccountingSystem.
//     */
//    @Test
//    public void testRemovePerson() {
//        System.out.println("removePerson");
//        int id = 0;
//        AccountingSystem instance = null;
//        instance.removePerson(id);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addFuel method, of class AccountingSystem.
//     */
//    @Test
//    public void testAddFuel() {
//        System.out.println("addFuel");
//        Fuel newFuel = null;
//        AccountingSystem instance = null;
//        instance.addFuel(newFuel);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeFuel method, of class AccountingSystem.
//     */
//    @Test
//    public void testRemoveFuel() {
//        System.out.println("removeFuel");
//        String fuelType = "";
//        AccountingSystem instance = null;
//        instance.removeFuel(fuelType);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersonnelPanel method, of class AccountingSystem.
//     */
//    @Test
//    public void testGetPersonnelPanel() {
//        System.out.println("getPersonnelPanel");
//        int index = 0;
//        AccountingSystem instance = null;
//        PersonnelPanel expResult = null;
//        PersonnelPanel result = instance.getPersonnelPanel(index);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addPersonnelPanel method, of class AccountingSystem.
//     */
//    @Test
//    public void testAddPersonnelPanel() {
//        System.out.println("addPersonnelPanel");
//        PersonnelPanel newPersonnelPanel = null;
//        AccountingSystem instance = null;
//        instance.addPersonnelPanel(newPersonnelPanel);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removePersonnelPanel method, of class AccountingSystem.
//     */
//    @Test
//    public void testRemovePersonnelPanel() {
//        System.out.println("removePersonnelPanel");
//        int index = 0;
//        AccountingSystem instance = null;
//        instance.removePersonnelPanel(index);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getJsonObject method, of class AccountingSystem.
//     */
//    @Test
//    public void testGetJsonObject() {
//        System.out.println("getJsonObject");
//        AccountingSystem instance = null;
//        JSONObject expResult = null;
//        JSONObject result = instance.getJsonObject();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of generateJson method, of class AccountingSystem.
     */
    @Test
    public void testGenerateJson() {
        System.out.println("generateJson");
        AccountingSystem acSystem = AccountingSystem.getInstance();
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        Personnel person = new Personnel();
        Personnel person2 = new Personnel();
        Fuel fuel = new Fuel();
        
        person.setId(121044029);
        person.setName("Gurol");
        person.setLastName("CAY");
        person.setJop("çöpçü");
        person.setAddress("kiptas 2.etap");
        person.setPhoneNumber("05422387568");
        person.setSalary(1000);
        person.setSskBonus(300);
        
        person2.setId(121044030);
        person2.setName("Alper");
        person2.setLastName("MULAYIM");
        person2.setJop("pompacı");
        person2.setAddress("yurt");
        person2.setPhoneNumber("05422387569");
        person2.setSalary(1001);
        person2.setSskBonus(301);
        
        fuel.setFuelType("benzin");
        fuel.setFuelCapacity(255.8);
        fuel.setFuelAmount(16.7);
        fuel.setSalePrice(4.5);
        fuel.setTax(121);
        
        
        acSystem.addPerson(person);
        acSystem.addPerson(person2);
        acSystem.addFuel(fuel);
        
        acSystem.generateJson();
        
        System.out.println(acSystem.getJsonObject());
    }
}
