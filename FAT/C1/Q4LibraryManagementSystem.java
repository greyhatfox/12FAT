package C1;

abstract class Book {
    protected String bookTitle;
    protected String author;
    protected String isbn;
    protected double price;

    public Book(String bookTitle, String author, String isbn, double price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public abstract void displayDetails();
}

class Ebook extends Book {
    private String fileFormat;

    public Ebook(String bookTitle, String author, String isbn, double price, String fileFormat) {
        super(bookTitle, author, isbn, price);
        this.fileFormat = fileFormat;
    }

    @Override
    public void displayDetails() {
        System.out.println("\nEbook Details:");
        System.out.println("Title: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("File Format: " + fileFormat);
        
        if (price < 5500) {
            System.out.println("Price: ₹" + price);
        } else {
            System.out.println("Invalid price for Ebook (must be < ₹5500)");
        }
    }
}

class PrintedBook extends Book {
    private int pageCount;

    public PrintedBook(String bookTitle, String author, String isbn, double price, int pageCount) {
        super(bookTitle, author, isbn, price);
        this.pageCount = pageCount;
    }

    @Override
    public void displayDetails() {
        System.out.println("\nPrinted Book Details:");
        System.out.println("Title: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Page Count: " + pageCount);
        
        if (price >= 500) {
            System.out.println("Price: ₹" + price);
        } else {
            System.out.println("Invalid price for Printed Book (must be ≥ ₹500)");
        }
    }
}

public class Q4LibraryManagementSystem {
    public static void main(String[] args) {
        // Create Ebook with valid price
        Ebook ebook1 = new Ebook("Java Programming", "John Doe", "978-3-16-148410-0", 1200.50, "PDF");
        
        // Create Ebook with invalid price
        Ebook ebook2 = new Ebook("Advanced Java", "Jane Smith", "978-1-23-456789-7", 6000.00, "EPUB");
        
        // Create PrintedBook with valid price
        PrintedBook printedBook1 = new PrintedBook("Design Patterns", "Gamma et al.", "978-0-201-63361-0", 899.99, 395);
        
        // Create PrintedBook with invalid price
        PrintedBook printedBook2 = new PrintedBook("Clean Code", "Robert Martin", "978-0-13-235088-4", 450.00, 464);

        // Display all book details
        ebook1.displayDetails();
        ebook2.displayDetails();
        printedBook1.displayDetails();
        printedBook2.displayDetails();
    }
}