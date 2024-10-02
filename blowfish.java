import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class Blowfish{
    public String encrypt(String password,String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        byte[] keyData = key.getBytes();
        SecretKeySpec KS = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, KS);
        String encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes(Charset.forName("UTF-8"))));
        return encrypted;
    }
    public String decrypt(String encrypted,String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        byte[] keyData = key.getBytes();
        SecretKeySpec KS = new SecretKeySpec(keyData, "Blowfish");
        byte[] encryptedData = Base64.getDecoder().decode(encrypted);
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, KS);
        byte[] decrypted = cipher.doFinal(encryptedData);
        String decryptedString = new String(decrypted, Charset.forName("UTF-8"));
        return decryptedString;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        final String password = "Knf@1234";
        final String key = "knowlegefactory";
        System.out.println("Password: "+password);
        Blowfish blowfish = new Blowfish();
        String encrypted = blowfish.encrypt(password, key);
        System.out.println("Encrypted: "+encrypted);
        String decrypted = blowfish.decrypt(encrypted, key);
        System.out.println("Decrypted: "+decrypted);
    }
}