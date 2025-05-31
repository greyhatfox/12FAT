package C2;

import java.util.HashMap;

// HotelOrder class
class HotelOrder {
    private String tiffen;
    private int tiffenQty;
    private double tiffenPrice;
    private String lunch;
    private int lunchQty;
    private double lunchPrice;
    private double totalPrice;

    // Constructor to initialize all parameters and calculate total price
    public HotelOrder(String tiffen, int tiffenQty, double tiffenPrice, 
                     String lunch, int lunchQty, double lunchPrice) {
        this.tiffen = tiffen;
        this.tiffenQty = tiffenQty;
        this.tiffenPrice = tiffenPrice;
        this.lunch = lunch;
        this.lunchQty = lunchQty;
        this.lunchPrice = lunchPrice;
        this.totalPrice = (tiffenQty * tiffenPrice) + (lunchQty * lunchPrice);
    }

    // Getters for all attributes
    public String getTiffen() {
        return tiffen;
    }

    public int getTiffenQty() {
        return tiffenQty;
    }

    public double getTiffenPrice() {
        return tiffenPrice;
    }

    public String getLunch() {
        return lunch;
    }

    public int getLunchQty() {
        return lunchQty;
    }

    public double getLunchPrice() {
        return lunchPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Tiffen: " + tiffen + " (Qty: " + tiffenQty + ", Price: " + tiffenPrice + ")" +
               ", Lunch: " + lunch + " (Qty: " + lunchQty + ", Price: " + lunchPrice + ")" +
               ", Total Price: " + totalPrice;
    }
}

public class Q9HotelOrderManagement {
    public static void main(String[] args) {
        // Create a HashMap to store order details
        HashMap<Integer, HotelOrder> orders = new HashMap<>();

        // Create 5 HotelOrder objects and add them to the HashMap
        orders.put(101, new HotelOrder("Idli", 2, 30.0, "Meals", 1, 120.0));
        orders.put(102, new HotelOrder("Dosa", 1, 50.0, "Biryani", 2, 180.0));
        orders.put(103, new HotelOrder("Vada", 3, 10.0, "Curd Rice", 1, 60.0));
        orders.put(104, new HotelOrder("Puri", 2, 40.0, "Thali", 1, 150.0));
        orders.put(105, new HotelOrder("Upma", 1, 35.0, "Sandwich", 2, 90.0));

        // Print all orders from the HashMap
        System.out.println("Hotel Order Details:");
        System.out.println("---------------------");
        for (Integer orderId : orders.keySet()) {
            System.out.println("Order ID: " + orderId);
            System.out.println(orders.get(orderId));
            System.out.println("---------------------");
        }
    }
}