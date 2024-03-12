package mi.m4x.project.cryptum;

public class SubstitutionCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String KEY = "xyzabcdefghijklmnopqrstuvw";

    public static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int index = ALPHABET.indexOf(Character.toLowerCase(c));
                char encryptedChar = KEY.charAt(index);
                ciphertext.append(Character.isUpperCase(c) ? Character.toUpperCase(encryptedChar) : encryptedChar);
            } else {
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int index = KEY.indexOf(Character.toLowerCase(c));
                char decryptedChar = ALPHABET.charAt(index);
                plaintext.append(Character.isUpperCase(c) ? Character.toUpperCase(decryptedChar) : decryptedChar);
            } else {
                plaintext.append(c);
            }
        }
        return plaintext.toString();
    }
}
