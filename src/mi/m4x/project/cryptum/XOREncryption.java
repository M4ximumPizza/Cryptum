package mi.m4x.project.cryptum;

/**
 * This class is used to encrypt and decrypt text using a XOR cipher.
 *
 * @author M4ximumPizza

 */
public class XOREncryption {
    public static String encrypt(String plaintext) {
        char[] key = {'K', 'E', 'Y'};
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            ciphertext.append((char) (plaintext.charAt(i) ^ key[i % key.length]));
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        return encrypt(ciphertext); // XOR encryption is symmetric
    }
}

