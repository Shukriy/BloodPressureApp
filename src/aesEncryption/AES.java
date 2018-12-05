package aesEncryption;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Class for encrypting passwords of users. with AES.
 * @author Thomas Cunningham
 *
 */
public class AES{
    private static byte[] key = "dsnkj67HJDSfdkJA".getBytes(StandardCharsets.UTF_8);
    
    /**
     * String can be submitted to this to be encrypted.
     * @param toEncrypt The plaintext to be encrypted
     * @return A byte array containing the encyrpted result
     * @throws Exception Thrown if AES cipher is not found.
     */
    public static byte[] encrypt(String toEncrypt) throws Exception{
    	byte[] prepared = toEncrypt.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(prepared);
    }
    
    /**
     * Byte array can be submitted to this to be decrypted to plaintext
     * @param toDecrypt The byte array containing the encrypted information
     * @return The plainttext decrypted result
     * @throws Exception Thrown if AES cipher not found.
     */
    public static String decrypt(byte[] toDecrypt) throws Exception{
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(toDecrypt));
    }
}