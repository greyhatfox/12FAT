package C1;

class Cinema {
    private int availableTickets;
    private int totalRevenue = 0;

    public Cinema(int totalSeats) {
        this.availableTickets = totalSeats;
    }

    public synchronized void bookTickets(String user, int requestedTickets) {
        System.out.println(user + " is trying to book " + requestedTickets + " ticket(s).");

        if (requestedTickets <= availableTickets) {
            availableTickets -= requestedTickets;
            int cost = requestedTickets * 200;
            totalRevenue += cost;
            System.out.println(user + " successfully booked " + requestedTickets + " ticket(s). Total cost: ₹" + cost);
        } else {
            System.out.println("Not enough tickets available for " + user + ". Requested: " + requestedTickets + ", Available: " + availableTickets);
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }
}

class User extends Thread {
    private Cinema cinema;
    private int ticketsToBook;
    private String userName;

    public User(Cinema cinema, String userName, int ticketsToBook) {
        this.cinema = cinema;
        this.userName = userName;
        this.ticketsToBook = ticketsToBook;
    }

    public void run() {
        cinema.bookTickets(userName, ticketsToBook);
    }
}

public class Q12TicketBookingSystem {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(10); // Total 10 tickets available

        User u1 = new User(cinema, "Alice", 4);
        User u2 = new User(cinema, "Bob", 5);
        User u3 = new User(cinema, "Charlie", 3); // This may fail if not enough tickets

        u1.start();
        u2.start();
        u3.start();

        try {
            u1.join();
            u2.join();
            u3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal tickets left: " + cinema.getAvailableTickets());
        System.out.println("Total revenue collected: ₹" + cinema.getTotalRevenue());
    }
}
