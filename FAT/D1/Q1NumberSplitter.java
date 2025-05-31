package D1;

import java.util.Scanner;

public class Q1NumberSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        System.out.print("Enter position to split (1-based index): ");
        int position = scanner.nextInt();
        
        // Validate position
        if (position <= 0) {
            System.out.println("Position must be a positive integer");
            return;
        }
        
        // Calculate the divisor to split the number
        long divisor = 1;
        long temp = number;
        int digitCount = 0;
        
        // Count digits in the number
        while (temp != 0) {
            temp /= 10;
            digitCount++;
        }
        
        // Validate position doesn't exceed digit count
        if (position > digitCount) {
            System.out.println("Position exceeds number length");
            return;
        }
        
        // Calculate the divisor
        for (int i = 0; i < digitCount - position; i++) {
            divisor *= 10;
        }
        
        // Split the number
        long part1 = number / divisor;
        long part2 = number % divisor;
        
        // Calculate sum
        long sum = part1 + part2;
        
        // Display results
        System.out.println("Part 1 = " + part1);
        System.out.println("Part 2 = " + part2);
        System.out.println("Sum of parts = " + part1 + "+" + part2 + "=" + sum);
    }
}