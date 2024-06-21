import java.util.Scanner;

class PasswordStrength {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Prompt the user to enter their password
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        strengthChecker(password);
    }

    // Method to check the strength of the password
    public static void strengthChecker(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        // Convert password into array and check its characters
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialCharacter = true;
            }
        }

        // Determine the strength of the password
        int strength = 0;
        if (password.length() < 8) {
            strength++;
        }
        if (hasUpperCase) {
            strength++;
        }
        if (hasLowerCase) {
            strength++;
        }
        if (hasDigit) {
            strength++;
        }
        if (hasSpecialCharacter) {
            strength++;
        }

        // Print the strength of the password
        switch (strength) {
            case 1:
                System.out.println("Strength: Very Weak");
                break;
            case 2:
                System.out.println("Strength: Weak");
                break;
            case 3:
                System.out.println("Strength: Moderate");
                break;
            case 4:
                System.out.println("Strength: Strong");
                break;
            case 5:
                System.out.println("Strength: Very Strong");
                break;
        }

        // Provide suggestions to improve the password
        if (password.length() < 8) {
            System.out.println("Your password must contain at least 8 characters.");
        }
        if (!hasUpperCase) {
            System.out.println("Your password must contain at least 1 uppercase character.");
        }
        if (!hasLowerCase) {
            System.out.println("Your password must contain at least 1 lowercase character.");
        }
        if (!hasDigit) {
            System.out.println("Your password must contain at least 1 digit.");
        }
        if (!hasSpecialCharacter) {
            System.out.println("Your password must contain at least 1 special character.");
        }
    }
}
