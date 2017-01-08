package accounting.software;

import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * This class provides methods to encrypt and decrypt data.
 *
 * @author Şahin Eğilmez
 */
public class Crypto {

    private static SecretKeySpec specKey; //special key for criptography
    private static byte[] key; // key for system UTF-8

    /**
     * 
     * @param myKey initilazition to key
     */
    public static void initKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            specKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    /**
     * this method encypt to string for secretKey of user 
     * @param strToEncrypt word for wanted encrypting
     * @param secretKey special key
     * @return  encipted word
     */
    public static String encrypt(String strToEncrypt, String secretKey) {
        try {
            initKey(secretKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, specKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException 
                | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    /**
     * this method decrypt to string for secretKey of user
     * @param strToDecrypt  word for wanted decrypting
     * @param secretKey special key
     * @return decrypted word
     */
    public static String decrypt(String strToDecrypt, String secretKey) {
        try {
            initKey(secretKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, specKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

}
