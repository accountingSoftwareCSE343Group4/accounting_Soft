/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
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
public class MyJsonParserTest {
    
    public MyJsonParserTest() {
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
     * Test of JSONDecode method, of class MyJsonParser.
     */
    @Test
    public void testJSONDecode() {
        System.out.println("JSONDecode");
        MyJsonParser instance = new MyJsonParser();
        instance.JSONDecode();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of JSONEncode method, of class MyJsonParser.
     */
    @Test
    public void testJSONEncode() {
        System.out.println("JSONEncode");
        Personnel person = new Personnel();
        List personnelList = new ArrayList<Personnel>();
        MyJsonParser jsonParser = new MyJsonParser();
        
        jsonParser.JSONEncode(personnelList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJsonObject method, of class MyJsonParser.
     */
    @Test
    public void testGetJsonObject() {
        System.out.println("getJsonObject");
        MyJsonParser instance = new MyJsonParser();
        JSONObject expResult = null;
        JSONObject result = instance.getJsonObject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJsonObject method, of class MyJsonParser.
     */
    @Test
    public void testSetJsonObject() {
        System.out.println("setJsonObject");
        JSONObject jsonObject = null;
        MyJsonParser instance = new MyJsonParser();
        instance.setJsonObject(jsonObject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
