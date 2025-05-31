package D1;

import java.util.Scanner;
//import java.text.DecimalFormat;

public class Q8SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //DecimalFormat df = new DecimalFormat("0.00"); // For formatting to 2 decimal places
        
        System.out.print("Enter a number to calculate square root: ");
        int number = scanner.nextInt();
        
        try {
            double result = calculateSquareRoot(number);
            System.out.printf("Square root of " + number + " is: %.2f",result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot calculate square root of a negative number.");
        }
    }

    // Method that throws ArithmeticException for negative numbers
    public static double calculateSquareRoot(int number) throws ArithmeticException {
        if (number < 0) {
            throw new ArithmeticException("Negative number input");
        }
        return Math.sqrt(number);
    }
}