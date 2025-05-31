package C1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int accountNumber;
    private double balance;
    private final Lock lock = new ReentrantLock();
    private static final double MIN_BALANCE = 1000.0;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance < MIN_BALANCE) {
            throw new IllegalArgumentException("Initial balance must be at least " + MIN_BALANCE);
        }
        this.balance = initialBalance;
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        lock.lock();
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive");
            }
            if (balance - amount < MIN_BALANCE) {
                throw new InsufficientFundsException("Cannot withdraw. Minimum balance of " + MIN_BALANCE + " must be maintained.");
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + 
                             ". New balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + 
                             ". New balance: " + balance);
        } finally {
            lock.unlock();
        }
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankCustomer implements Runnable {
    private BankAccount account;

    public BankCustomer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            // Check balance
            System.out.println(Thread.currentThread().getName() + " checking balance: " + account.getBalance());
            
            // Random deposit or withdraw
            double amount = Math.random() * 1000;
            if (Math.random() > 0.5) {
                account.deposit(amount);
            } else {
                try {
                    account.withdraw(amount);
                } catch (InsufficientFundsException e) {
                    System.out.println(Thread.currentThread().getName() + " failed to withdraw: " + e.getMessage());
                }
            }
            
            // Final balance check
            System.out.println(Thread.currentThread().getName() + " final balance: " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Error in thread " + Thread.currentThread().getName() + ": " + e.getMessage());
        }
    }
}

public class Q11BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345, 2000.0);
        
        // Create multiple customer threads
        Thread[] customers = new Thread[5];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Thread(new BankCustomer(account), "Customer-" + (i+1));
        }
        
        // Start all threads
        for (Thread customer : customers) {
            customer.start();
        }
        
        // Wait for all threads to complete
        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        
        System.out.println("Final account balance: " + account.getBalance());
    }
}