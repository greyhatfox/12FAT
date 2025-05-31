package D1;

class TheatreBookingSystem {
    private int availableSeats;

    public TheatreBookingSystem(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    // Synchronized method to book seats
    public synchronized void bookSeat(String customerName) {
        if (availableSeats > 0) {
            System.out.println(customerName + " successfully booked a seat. Remaining seats: " + --availableSeats);
        } else {
            System.out.println(customerName + " failed to book a seat. No seats available.");
        }
    }
}

public class Q11MovieBookingApp {
    public static void main(String[] args) {
        // Create booking system with 3 available seats
        TheatreBookingSystem bookingSystem = new TheatreBookingSystem(3);

        // Create and start customer threads
        for (int i = 1; i <= 4; i++) {
            final String customerName = "Customer " + i;
            new Thread(() -> bookingSystem.bookSeat(customerName)).start();
        }
    }
}