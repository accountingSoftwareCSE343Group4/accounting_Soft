package accounting.software;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class provides methods to encrypt and decrypt data.
 *
 * @author Şahin Eğilmez
 */
public class Crypto {

    private final String initialVector = "0123456789123456"; // This has to be 16 characters

    /**
     *
     * @param input word to be encypted
     * @return encrypted word
     * @throws NoSuchAlgorithmException
     *
     * This method encyrypted for md5 32-bit encyptyng algorithm
     */
    private static String md5(final String input) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] messageDigest = md.digest(input.getBytes());
        final BigInteger number = new BigInteger(1, messageDigest);
        return String.format("%032x", number);
    }

    /**
     *
     * @param mode encrypted mode
     * @param secretKey key to be used
     * @return Cipher for encrypt-descrypt method
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     *
     * This method create Cipher for encrypt and descrypt
     */
    private Cipher initCipher(final int mode, final String secretKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        final SecretKeySpec skeySpec = new SecretKeySpec(md5(secretKey).getBytes(), "AES");
        final IvParameterSpec initialVectorString = new IvParameterSpec(initialVector.getBytes());
        final Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
        cipher.init(mode, skeySpec, initialVectorString);
        return cipher;
    }

    /**
     *
     * @param dataToEncrypt Word to be encrypted
     * @param secretKey key to be used
     * @return encypted word
     *
     * This method encypt to word by secretKey
     */
    public String encrypt(final String dataToEncrypt, final String secretKey) {
        String encryptedData = null;
        try {
            // Initialize the cipher
            final Cipher cipher = initCipher(Cipher.ENCRYPT_MODE, secretKey);
            // Encrypt the data
            final byte[] encryptedByteArray = cipher.doFinal(dataToEncrypt.getBytes());
            // Encode using Base64
            encryptedData = (new BASE64Encoder()).encode(encryptedByteArray);
        } catch (Exception e) {
            System.err.println("Problem encrypting the data");
            e.printStackTrace();
        }
        return encryptedData;
    }

    /**
     *
     * @param encryptedData Word to be decrypted
     * @param secretKey key to be used
     * @return decrypted word
     *
     * This method decryot to word by secretKey
     */
    public String decrypt(final String encryptedData, final String secretKey) {
        String decryptedData = null;
        try {
            // Initialize the cipher
            final Cipher cipher = initCipher(Cipher.DECRYPT_MODE, secretKey);
            // Decode using Base64
            final byte[] encryptedByteArray = (new BASE64Decoder()).decodeBuffer(encryptedData);
            // Decrypt the data
            final byte[] decryptedByteArray = cipher.doFinal(encryptedByteArray);
            decryptedData = new String(decryptedByteArray, "UTF8");
        } catch (Exception e) {
            System.err.println("Problem decrypting the data");
            e.printStackTrace();
        }
        return decryptedData;
    }
}
