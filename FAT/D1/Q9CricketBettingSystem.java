package D1;

/* import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q9CricketBettingSystem {
    public static void main(String[] args) {
        // Create an ArrayList to store player bets
        ArrayList<String> bettingRecords = new ArrayList<>();
        
        // Sample betting data (can be replaced with actual data input)
        Collections.addAll(bettingRecords, 
            "Kohli", "Rohit", "Kohli", "Dhoni", "Kohli",
            "Pant", "Rohit", "Bumrah", "Jadeja", "Dhoni"
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the player's name to find the number of bets placed: ");
        String playerName = scanner.nextLine().trim();

        // Calculate frequency of the player's name
        int betCount = Collections.frequency(bettingRecords, playerName);

        System.out.println("Total bets placed on " + playerName + ": " + betCount);
    }
} */

import java.util.ArrayList;
import java.util.Scanner;

public class Q9CricketBettingSystem {
    public static void main(String[] args) {
        // Initialize betting records
        ArrayList<String> bettingRecords = new ArrayList<>();
        bettingRecords.add("Kohli");
        bettingRecords.add("Rohit");
        bettingRecords.add("Kohli");
        bettingRecords.add("Dhoni");
        bettingRecords.add("Kohli");
        bettingRecords.add("Pant");
        bettingRecords.add("Rohit");
        bettingRecords.add("Bumrah");
        bettingRecords.add("Jadeja");
        bettingRecords.add("Dhoni");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the player's name to find the number of bets placed: ");
        String playerName = scanner.nextLine();

        // Manual count implementation
        int count = 0;
        for (String name : bettingRecords) {
            if (name.equalsIgnoreCase(playerName)) {
                count++;
            }
        }

        System.out.println("Total bets placed on " + playerName + ": " + count);
    }
}