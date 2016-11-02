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
 * @author segilmez
 */
public class CryptoTest {
    
    public CryptoTest() {
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
     * Test of encrypt method, of class Crypto.
     */
    @Test
    public void testEncrypt() {
         System.out.println("encrypt");
        String dataToEncrypt = "This is a test message.";
        String secretKey = "abcde";
        Crypto instance = new Crypto();
        String expResult = "rI2gf+cE9UA6VJtggxrgu30QVnKpZ3o=";
        String result = instance.encrypt(dataToEncrypt, secretKey);
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class Crypto.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        String encryptedData = "rI2gf+cE9UA6VJtggxrgu30QVnKpZ3o=";
        String secretKey = "abcde";
        Crypto instance = new Crypto();
        String expResult = "This is a test message.";
        String result = instance.decrypt(encryptedData, secretKey);
        assertEquals(expResult, result);
    }
    
}
