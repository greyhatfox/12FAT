package C2;

class BookStall {
    private String title;
    private int ID;
    private int qty;
    private double price;

    public BookStall(String title, int ID) {
        this.title = title;
        this.ID = ID;
    }

    public void setPrice(int qty, double price) {
        this.qty = qty;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Book ID: " + ID);
        System.out.println("Quantity: " + qty);
        System.out.println("Price per book: ₹" + price);
        System.out.println("Total Cost: ₹" + (qty * price));
    }
}

class Technical extends BookStall {
    public Technical(String title, int ID, int qty, double price) {
        super(title, ID);
        setPrice(qty, price);
    }
}

class NonTechnical extends BookStall {
    public NonTechnical(String title, int ID, int qty, double price) {
        super(title, ID);
        setPrice(qty, price);
    }
}

public class Q5BookStallDemo {
    public static void main(String[] args) {
        Technical techBook = new Technical("Java Programming", 101, 5, 450.0);
        NonTechnical nonTechBook = new NonTechnical("History of Art", 202, 3, 300.0);

        System.out.println("Technical Book Details:");
        techBook.display();

        System.out.println("\nNon-Technical Book Details:");
        nonTechBook.display();
    }
}
