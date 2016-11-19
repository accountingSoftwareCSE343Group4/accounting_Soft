/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
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
public class JsonParserTest {
    
    public JsonParserTest() {
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
        JsonParser instance = new JsonParser();
        instance.JSONDecode();
        
        
    }

    /**
     * Test of JSONEncode method, of class MyJsonParser.
     */
    @Test
    public void testJSONEncode() throws JSONException {
        System.out.println("JSONEncode");
        Personnel person = new Personnel();
        Personnel person2 = new Personnel();
        
        List<Personnel> personnelList = new ArrayList<Personnel>();
        JsonParser jsonParser = new JsonParser();
        
        person.setId(121044029);
        person.setName("Gurol");
        person.setLastName("CAY");
        person.setAddress("kiptas 2.etap");
        person.setPhoneNumber("05422387568");
        person.setSalary(1000);
        person.setSskBonus(300);
        
        person2.setId(121044030);
        person2.setName("Alper");
        person2.setLastName("MULAYIM");
        person2.setAddress("yurt");
        person2.setPhoneNumber("05422387569");
        person2.setSalary(1001);
        person2.setSskBonus(301);
            
        personnelList.add(person);
        personnelList.add(person2);
        
        jsonParser.JSONEncode((List<Object>)((Object)personnelList));
        
        
        }


//    /**
//     * Test of writeJsonToFile method, of class JsonParser.
//     */
//    @Test
//    public void testWriteJsonToFile() {
//        System.out.println("writeJsonToFile");
//        JSONObject jsonObj = null;
//        JsonParser instance = new JsonParser();
//        instance.writeJsonToFile(jsonObj);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
}
