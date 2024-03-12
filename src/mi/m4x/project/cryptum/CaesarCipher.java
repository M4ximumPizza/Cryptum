package mi.m4x.project.cryptum;

public class CaesarCipher {
    public static String encrypt(String plaintext) {
        int shift = 3;
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                ciphertext.append((char) (((c - base + shift) % 26) + base));
            } else {
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        int shift = 3;
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                plaintext.append((char) (((c - base - shift + 26) % 26) + base));
            } else {
                plaintext.append(c);
            }
        }
        return plaintext.toString();
    }
}