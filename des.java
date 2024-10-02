import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;
import java.util.Scanner;

class DES {
    public static void main(String[] args){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Plain Text: ");
            String plaintext = scanner.nextLine();
            System.out.println("Enter Key (8 characters): ");
            String key = scanner.nextLine();
            byte[] encryptedBytes = encrypt(plaintext, key);
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Text: " + encryptedText);
            String decryptedText = decrypt(encryptedBytes, key);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static byte[] encrypt(String plaintext, String key) throws Exception {
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plaintext.getBytes());
    }
    public static String decrypt(byte[] encryptedBytes, String key) throws Exception {
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}