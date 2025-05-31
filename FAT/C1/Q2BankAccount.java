package C1;

public class Q2BankAccount {
    // Private attributes for encapsulation
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    
    // Static variable shared by all accounts
    public static String bankName = "MyBank";
    
    // Minimum required balance
    private static final double MIN_BALANCE = 1000.0;

    // Constructor using 'this' keyword
    public Q2BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money with minimum balance check
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Withdrawal failed. Insufficient balance to maintain minimum requirement.");
        }
    }

    // Method to display account details and balance
    public void displayBalance() {
        System.out.println("\nBank Name: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        // Create two bank account objects
        Q2BankAccount account1 = new Q2BankAccount("123456789", "John Doe", 5000.0);
        Q2BankAccount account2 = new Q2BankAccount("987654321", "Jane Smith", 10000.0);

        // Perform operations on account1
        System.out.println("\n--- Account 1 Operations ---");
        account1.displayBalance();
        account1.deposit(2000.0);
        account1.withdraw(3000.0);
        account1.withdraw(4000.0);  // This should fail due to minimum balance
        account1.displayBalance();

        // Perform operations on account2
        System.out.println("\n--- Account 2 Operations ---");
        account2.displayBalance();
        account2.deposit(5000.0);
        account2.withdraw(12000.0); // This should fail
        account2.withdraw(8000.0); // This should succeed
        account2.displayBalance();

        // Display bank name (static variable)
        System.out.println("\nAll accounts are with: " + Q2BankAccount.bankName);
    }
}