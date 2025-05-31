package C2;

// Interface for Discount
interface Discount {
    double calculate_Discount();
}

// Base class Books
class Books {
    protected String bookName;
    protected String author;
    protected String bookType; // "Paper" or "kindle"
    protected double price;

    public Books(String bookName, String author, String bookType, double price) {
        this.bookName = bookName;
        this.author = author;
        this.bookType = bookType;
        this.price = price;
    }

    public void displayBookDetails() {
        System.out.println("\nBook Details:");
        System.out.println("Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Type: " + bookType);
        System.out.println("Price: $" + price);
    }
}

// Customers class inheriting from Books and implementing Discount
class Customers extends Books implements Discount {
    private String customerName;
    private int customerId;

    public Customers(String customerName, int customerId, String bookName, String author, String bookType, double price) {
        super(bookName, author, bookType, price);
        this.customerName = customerName;
        this.customerId = customerId;
    }

    // Implementing the calculate_Discount method from Discount interface
    @Override
    public double calculate_Discount() {
        if (bookType.equalsIgnoreCase("Paper")) {
            return price * 0.15; // 15% discount for Paper books
        } else if (bookType.equalsIgnoreCase("kindle")) {
            return price * 0.10; // 10% discount for Kindle books
        }
        return 0; // No discount for other types
    }

    public void displayCustomerDetails() {
        System.out.println("\nCustomer Details:");
        System.out.println("Name: " + customerName);
        System.out.println("ID: " + customerId);
        displayBookDetails();
        double discount = calculate_Discount();
        System.out.println("Discount: $" + discount);
        System.out.println("Final Price: $" + (price - discount));
    }
}

public class Q4Main {
    public static void main(String[] args) {
        // Create 3 customer objects
        Customers customer1 = new Customers("John Doe", 101, "The Great Gatsby", "F. Scott Fitzgerald", "Paper", 25.99);
        Customers customer2 = new Customers("Jane Smith", 102, "1984", "George Orwell", "kindle", 12.99);
        Customers customer3 = new Customers("Mike Johnson", 103, "To Kill a Mockingbird", "Harper Lee", "Paper", 19.99);

        // Display details for all customers
        customer1.displayCustomerDetails();
        customer2.displayCustomerDetails();
        customer3.displayCustomerDetails();
    }
}