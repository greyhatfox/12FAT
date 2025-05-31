package C1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q7ATMApplication {
    private static double accountBalance = 10000.00; // Initial account balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Simple ATM");
        System.out.printf("Your current balance: ₹%.2f\n", accountBalance);
        System.out.print("Enter amount to withdraw: ");

        try {
            double amount = scanner.nextDouble();
            
            // Validate withdrawal amount
            if (amount % 100 != 0) {
                System.out.println("Error: Withdrawal amount must be in multiples of 100");
                return;
            }
            
            // Check sufficient balance
            if (amount > accountBalance) {
                throw new ArithmeticException("Insufficient Balance");
            }
            
            // Process withdrawal
            accountBalance -= amount;
            System.out.printf("\nWithdrawal successful: ₹%.2f\n", amount);
            System.out.printf("Remaining balance: ₹%.2f\n", accountBalance);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}