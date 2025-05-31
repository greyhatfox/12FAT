package C1;
import java.util.Scanner;

// Custom exception for invalid username length
class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

public class Q8LoginSystem {

    public static void validateUsername(String username) 
            throws InvalidUsernameException, IllegalArgumentException {
        // Check for minimum length
        if (username.length() < 6) {
            throw new InvalidUsernameException("Username is too short. It must be at least 6 characters long.");
        }
        
        // Check for spaces
        if (username.contains(" ")) {
            throw new IllegalArgumentException("Username cannot contain spaces.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();       
        
        try {
            validateUsername(username);
            System.out.println("Login successful.");
        } catch (InvalidUsernameException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}