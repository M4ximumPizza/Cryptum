package mi.m4x.project.cryptum;

import java.io.*;
import java.util.Scanner;

/**
 * This class is used to encrypt text and files using various encryption algorithms.
 *
 * @author M4ximumPizza
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Ask whether to encrypt or decrypt
        System.out.println("Do you want to encrypt or decrypt?");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int encryptOrDecrypt = scanner.nextInt();
        boolean isDecryption = encryptOrDecrypt == 2;
        scanner.nextLine(); // Consume newline

        // Step 2: Choose algorithm
        System.out.println("Choose algorithm:");
        System.out.println("1. Caesar Cipher");
        System.out.println("2. XOR Encryption");
        System.out.println("3. Substitution Cipher");
        int algorithm = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Step 3: Choose file or text
        System.out.println("Do you want to encrypt/decrypt a file or text?");
        System.out.println("1. File");
        System.out.println("2. Text");
        int fileOrText = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (fileOrText) {
            case 1:
                System.out.println("Enter file path:");
                String filePath = scanner.nextLine();
                File file = new File(filePath);
                if (!file.exists() || !file.isFile()) {
                    System.out.println("Invalid file path!");
                    return;
                }
                String outputFilePath = isDecryption ? "decrypted_" + file.getName() : "encrypted_" + file.getName();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String result;
                        switch (algorithm) {
                            case 1:
                                result = isDecryption ? CaesarCipher.decrypt(line) : CaesarCipher.encrypt(line);
                                break;
                            case 2:
                                result = isDecryption ? XOREncryption.decrypt(line) : XOREncryption.encrypt(line);
                                break;
                            case 3:
                                result = isDecryption ? SubstitutionCipher.decrypt(line) : SubstitutionCipher.encrypt(line);
                                break;
                            default:
                                System.out.println("Invalid option!");
                                return;
                        }
                        writer.write(result);
                        writer.newLine();
                    }
                    reader.close();
                    writer.close();
                    System.out.println("File " + (isDecryption ? "decryption" : "encryption") + " successful. Output file: " + outputFilePath);
                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                break;
            case 2:
                System.out.println("Enter text:");
                String text = scanner.nextLine();
                String result;
                switch (algorithm) {
                    case 1:
                        result = isDecryption ? CaesarCipher.decrypt(text) : CaesarCipher.encrypt(text);
                        break;
                    case 2:
                        result = isDecryption ? XOREncryption.decrypt(text) : XOREncryption.encrypt(text);
                        break;
                    case 3:
                        result = isDecryption ? SubstitutionCipher.decrypt(text) : SubstitutionCipher.encrypt(text);
                        break;
                    default:
                        System.out.println("Invalid option!");
                        return;
                }
                System.out.println(isDecryption ? "Decrypted text: " + result : "Encrypted text: " + result);
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
}
