import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileEncryptorDecryptor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to File Encryptor/Decryptor!");
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = sc.nextInt(); // Read user choice

        // Input file path
        System.out.println("Enter the path of the input file:");
        sc.nextLine(); // Consume newline left by sc.nextInt()
        String inputFilePath = sc.nextLine(); // Read input file path

        // Output file path
        System.out.println("Enter the path of the output file:");
        String outputFilePath = sc.nextLine(); // Read output file path

        // Encryption/decryption key
        System.out.println("Enter the encryption/decryption key:");
        int key = sc.nextInt(); // Read encryption/decryption key

        try {
            // Perform chosen operation
            if (choice == 1) {
                encryptFile(inputFilePath, outputFilePath, key);
                System.out.println("File encrypted successfully!");
            } else if (choice == 2) {
                decryptFile(inputFilePath, outputFilePath, key);
                System.out.println("File decrypted successfully!");
            } else {
                System.out.println("Invalid choice. Please choose 1 or 2.");
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            sc.close(); // Close the scanner to prevent resource leak
        }
    }

    // Method to encrypt the content of a file
    public static void encryptFile(String inputFilePath, String outputFilePath, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                // Encrypt each character by adding the key
                char encryptedChar = (char) (ch + key);
                writer.write(encryptedChar);
            }
        }
    }

    // Method to decrypt the content of a file
    public static void decryptFile(String inputFilePath, String outputFilePath, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                // Decrypt each character by subtracting the key
                char decryptedChar = (char) (ch - key);
                writer.write(decryptedChar);
            }
        }
    }
}
