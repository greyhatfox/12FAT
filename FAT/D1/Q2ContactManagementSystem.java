package D1;

import java.util.Scanner;

class Contact {
    private String name;

    // Constructor that processes the name
    public Contact(String name) {
        this.name = name;
        
        // Calculate and display total characters
        int charCount = calculateCharacterCount(name);
        System.out.println("Total characters in name: " + charCount);
        
        // Display name in reverse
        String reversedName = reverseName(name);
        System.out.println("Name in reverse: " + reversedName);
    }

    // Method to calculate character count without built-in functions
    private int calculateCharacterCount(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // We've reached the end of the string
        }
        return count;
    }

    // Method to reverse name without built-in functions
    private String reverseName(String str) {
        int length = calculateCharacterCount(str);
        char[] reversed = new char[length];
        
        for (int i = 0; i < length; i++) {
            reversed[i] = str.charAt(length - 1 - i);
        }
        
        return new String(reversed);
    }
}

public class Q2ContactManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        
        // Create contact object which will process the name
        new Contact(name);
    }
}