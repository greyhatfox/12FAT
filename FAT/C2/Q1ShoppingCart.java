package C2;

public class Q1ShoppingCart {
    public static double calculateTotal(double[] prices) {
        double total = 0;
        for (double price : prices) {
            if (price > 50) {
                total += price * 0.85; // Apply 15% discount
            } else {
                total += price;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        double[] items = {30, 60, 20, 80, 45};
        double finalTotal = calculateTotal(items);
        System.out.printf("Final total: $ %.2f", finalTotal);
    }
}