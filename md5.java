import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class MD5{
    public static String getMd5Hash(String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashtext = no.toString(16);
        while(hashtext.length() < 32){
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public static void main(String[] args) throws Exception{
        final String message = "Hello World";
        System.out.println("Message: "+message);
        System.out.println("MD5 Hash: "+getMd5Hash(message));
    }

}