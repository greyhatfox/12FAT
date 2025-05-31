package D1;

import java.util.Scanner;
import java.util.Arrays;

// Custom exception for invalid border countries
class InvalidBorderCountryException extends Exception {
    public InvalidBorderCountryException(String country) {
        super("Error: " + country + " does not share a border with India.");
    }
}

public class Q7BorderSecuritySystem {
    // List of India's neighboring countries (case-insensitive comparison)
    private static final String[] NEIGHBORING_COUNTRIES = {
        "Pakistan", "China", "Nepal", 
        "Bhutan", "Bangladesh", "Myanmar", "Afghanistan"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the name of a country: ");
        String inputCountry = scanner.nextLine().trim();
        
        try {
            if (isNeighboringCountry(inputCountry)) {
                System.out.println(inputCountry + " shares a border with India.");
            } else {
                throw new InvalidBorderCountryException(inputCountry);
            }
        } catch (InvalidBorderCountryException e) {
            System.out.println(e.getMessage());
        }
    }

    // Check if the country is India's neighbor
    private static boolean isNeighboringCountry(String country) {
        return Arrays.stream(NEIGHBORING_COUNTRIES)
                   .anyMatch(neighbor -> neighbor.equalsIgnoreCase(country));
    }
}