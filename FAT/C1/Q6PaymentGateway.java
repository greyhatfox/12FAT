package C1;
// PaymentMethod interface
interface PaymentMethod {
    void processPayment(double amount);
}

// CreditCard implementation
class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;

    public CreditCard(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void processPayment(double amount) {
        if (amount <= 100) {
            System.out.println("Error: Credit card payment amount must be greater than ₹100");
            return;
        }
        System.out.printf("Processing credit card payment of ₹%.2f\n", amount);
        System.out.println("Card: ****-****-****-" + cardNumber.substring(12));
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Payment successful!\n");
    }
}

// PayPal implementation
class PayPal implements PaymentMethod {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        if (amount <= 100) {
            System.out.println("Error: PayPal payment amount must be greater than ₹100");
            return;
        }
        System.out.printf("Processing PayPal payment of ₹%.2f\n", amount);
        System.out.println("Account: " + email);
        System.out.println("Payment successful!\n");
    }
}

// BankTransfer implementation
class BankTransfer implements PaymentMethod {
    private String accountNumber;
    private String bankName;

    public BankTransfer(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    public void processPayment(double amount) {
        if (amount <= 100) {
            System.out.println("Error: Bank transfer amount must be greater than ₹100");
            return;
        }
        System.out.printf("Processing bank transfer of ₹%.2f\n", amount);
        System.out.println("Bank: " + bankName);
        System.out.println("Account: " + accountNumber);
        System.out.println("Payment successful!\n");
    }
}

// Main class to demonstrate the payment gateway
public class Q6PaymentGateway {
    public static void main(String[] args) {
        // Create payment method instances
        PaymentMethod creditCard = new CreditCard("1234567812345678", "John Doe");
        PaymentMethod payPal = new PayPal("john.doe@example.com");
        PaymentMethod bankTransfer = new BankTransfer("9876543210", "State Bank");

        // Test valid payments
        System.out.println("--- Processing Valid Payments ---");
        creditCard.processPayment(1500.50);
        payPal.processPayment(2000.00);
        bankTransfer.processPayment(3500.75);

        // Test invalid payments (amount <= 100)
        System.out.println("--- Testing Invalid Payments ---");
        creditCard.processPayment(50.00);
        payPal.processPayment(100.00);
        bankTransfer.processPayment(0.00);
    }
}