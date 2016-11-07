/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class SalesClassJUnitTest {
    @Test
    public void testGetDescription() {
    SalesClass unit = new SalesClass("market", 1, 50000);
    String des = unit.getDescription();
    assertEquals("market", des);
    }
    
    @Test
    public void testGetID(){
    SalesClass unit = new SalesClass("market", 1, 50000);
    int id = unit.getID();   
    assertEquals(1, id);        
    }
    
    
}
