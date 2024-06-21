import java.util.Scanner;

class TempConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter unit of measurement (F for Fahrenheit and C for Celsius): ");
        char unit = sc.next().charAt(0);

        double result = 0;

        // Check if the unit is Fahrenheit
        if (unit == 'F' || unit == 'f') {
            // Convert Fahrenheit to Celsius
            result = ((temperature - 32) * 5) / 9;
            System.out.println("Converted temperature is " + result + " Celsius.");
        }

        // Check if the unit is Celsius
        else if (unit == 'C' || unit == 'c') {
            // Convert Celsius to Fahrenheit
            result = ((9 * temperature) / 5) + 32;
            System.out.println("Converted temperature is " + result + " Fahrenheit.");
        }

        // If the unit is neither Fahrenheit nor Celsius
        else {
            System.out.println("Sorry! It is not a valid unit.");
        }
    }
}
