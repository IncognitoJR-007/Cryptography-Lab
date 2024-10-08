import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class DSASignatureExample {

    public static void main(String[] args) throws Exception {

        // Generate a key pair for DSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        SecureRandom random = SecureRandom.getInstanceStrong();
        keyGen.initialize(1024, random);
        KeyPair keyPair = keyGen.generateKeyPair();

        // Create a signature object using SHA256withDSA
        String message = "Hello, World!";
        Signature signature = Signature.getInstance("SHA256withDSA");

        // Initialize the signature object with the private key
        signature.initSign(keyPair.getPrivate());

        // Update the signature with the message
        signature.update(message.getBytes());

        // Sign the message and get the digital signature
        byte[] digitalSignature = signature.sign();

        // Display the digital signature in Base64 format
        System.out.println("Digital Signature:");
        System.out.println(Base64.getEncoder().encodeToString(digitalSignature));

        // Verify the signature using the public key
        Signature verifier = Signature.getInstance("SHA256withDSA");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(message.getBytes());

        // Check if the signature is verified
        boolean verified = verifier.verify(digitalSignature);
        System.out.println("Signature verified: " + verified);
    }
}
