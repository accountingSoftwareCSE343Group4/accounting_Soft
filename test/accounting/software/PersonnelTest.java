package accounting.software;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arif
 */
public class PersonnelTest {
    
    public PersonnelTest() {
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
     * Test of getId method, of class Personnel.
     */
   /* @Test
    public void testGetId() {
        System.out.println("getId");
        Personnel instance = new Personnel();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setId method, of class Personnel.
     */
   /* @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Personnel instance = new Personnel();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of getName method, of class Personnel.
     */
    /*@Test
    public void testGetName() {
        System.out.println("getName");
        Personnel instance = new Personnel();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of setName method, of class Personnel.
     */
    /*@Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Personnel instance = new Personnel();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getLastName method, of class Personnel.
     */
    /*@Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Personnel instance = new Personnel();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Personnel.
     */
    /*@Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Personnel instance = new Personnel();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Personnel.
     */
   /* @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Personnel instance = new Personnel();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Personnel.
     */
    /*@Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Personnel instance = new Personnel();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPhoneNumber method, of class Personnel.
     */
    /*@Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Personnel instance = new Personnel();
        String expResult = "";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhoneNumber method, of class Personnel.
     */
    /*@Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "";
        Personnel instance = new Personnel();
        instance.setPhoneNumber(phoneNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class Personnel.
     */
    /*@Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Personnel instance = new Personnel();
        double expResult = 0.0;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalary method, of class Personnel.
     */
    /*@Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = 0.0;
        Personnel instance = new Personnel();
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJop method, of class Personnel.
     */
    /*@Test
    public void testGetJop() {
        System.out.println("getJop");
        Personnel instance = new Personnel();
        String expResult = "";
        String result = instance.getJob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJop method, of class Personnel.
     */
    /*@Test
    public void testSetJop() {
        System.out.println("setJop");
        String jop = "";
        Personnel instance = new Personnel();
        instance.setJob(jop);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSskBonus method, of class Personnel.
     */
    @Test
    public void testGetSskBonus() {
        System.out.println("getSskBonus");
        Personnel instance = new Personnel();
        double expResult = 0.0;
        double result = instance.getSskBonus();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSskBonus method, of class Personnel.
     */
    /*@Test
    public void testSetSskBonus() {
        System.out.println("setSskBonus");
        double sskbonus = 0.0;
        Personnel instance = new Personnel();
        instance.setSskBonus(sskbonus);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getExpense method, of class Personnel.
     */
    @Test
    public void testGetExpense() {
        System.out.println("getExpense");
        Personnel instance = new Personnel();
        Double expResult = 0.0;
        Double result = instance.getExpense();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getDescription method, of class Personnel.
     */
    @Test
    public void testGetDescription() {
        System.out.print("getDescription");
        Personnel instance = new Personnel();
        String expResult = "Employee_Expense";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Personnel.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Personnel instance = new Personnel();
        String expResult = "Personnel{Id=-1, Name= ,Sur Name=}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
