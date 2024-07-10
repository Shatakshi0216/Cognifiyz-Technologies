import java.util.*;

class RandomPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of password: ");
        int passwordLen = sc.nextInt();
        char password[] = new char[passwordLen];

        // Define character sets for password generation
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$%^&*?/+=_-~`':,.";
        String numbers = "0123456789";

        // Combine all character sets into one string
        String combination = upperCase + lowerCase + specialCharacters + numbers;
        Random ram = new Random();

        // Generate a random password of the specified length
        for (int i = 0; i < passwordLen; i++) {
            password[i] = combination.charAt(ram.nextInt(combination.length()));
        }

        System.out.println("Generated password is: " + new String(password));
    }
}
