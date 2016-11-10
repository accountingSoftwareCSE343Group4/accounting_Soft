/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
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
        
    }

    /**
     * Test of JSONEncode method, of class MyJsonParser.
     */
    @Test
    public void testJSONEncode() {
        System.out.println("JSONEncode");
        MyJsonParser tempJson = new MyJsonParser();
        
        MyJsonParser jsonParser = new MyJsonParser();
        List<Personal> personalList = new ArrayList<Personal>();
        personalList.add(new Personal(121044029,"gurol","cay","null","05422387568"));
        
        System.out.println(personalList.get(0));
        
        for(Personal person: personalList) {
            jsonParser.getPersonalJsonArr().put(person);
            
        }
        //System.out.println(jsonParser.getJsonObj());
        
        jsonParser.getJsonObj().append("Personal", jsonParser.getPersonalJsonArr());
        
        System.out.println(jsonParser.getJsonObj());
    }
    
}
