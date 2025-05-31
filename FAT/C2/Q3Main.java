package C2;

import java.util.ArrayList;
import java.util.Scanner;

abstract class SingingCompetition {
    // Abstract method to read details
    public abstract void ReadDetails();

    // Method to display venue details
    public void DisplayVenue() {
        System.out.println("Competition Venue: Grand Music Hall, New York");
        System.out.println("Date: December 15, 2025");
        System.out.println("Time: 7:00 PM");
    }
}

class Singers extends SingingCompetition {
    private String name;
    private int age;
    private String living_city;
    private String singer_id;
    private static ArrayList<Singers> singersList = new ArrayList<>();

    // Constructor
    public Singers(String name, int age, String living_city, String singer_id) {
        this.name = name;
        this.age = age;
        this.living_city = living_city;
        this.singer_id = singer_id;
        singersList.add(this);
    }

    // Implementation of abstract method
    @Override
    public void ReadDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter singer details:");
        System.out.print("Name: ");
        this.name = scanner.nextLine();
        System.out.print("Age: ");
        this.age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Living City: ");
        this.living_city = scanner.nextLine();
        System.out.print("Singer ID: ");
        this.singer_id = scanner.nextLine();
    }

    // Method to display singer details
    public void displayDetails() {
        System.out.println("\nSinger Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Living City: " + living_city);
        System.out.println("Singer ID: " + singer_id);
    }

    // Method to search for a singer by ID
    public static Singers Search(String singer_id) {
        for (Singers singer : singersList) {
            if (singer.singer_id.equals(singer_id)) {
                return singer;
            }
        }
        return null;
    }

    // Method to count singers above 30
    public static int Count() {
        int count = 0;
        for (Singers singer : singersList) {
            if (singer.age > 30) {
                count++;
            }
        }
        return count;
    }
}

public class Q3Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create array of Singers objects
        System.out.print("Enter number of singers: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Singers[] singers = new Singers[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for singer " + (i + 1) + ":");
            singers[i] = new Singers("", 0, "", "");
            singers[i].ReadDetails();
        }
        
        // Display venue details
        System.out.println("\nCompetition Information:");
        singers[0].DisplayVenue();
        
        // Display all singers' details
        System.out.println("\nAll Singers:");
        for (Singers singer : singers) {
            singer.displayDetails();
        }
        
        // Search for a singer
        System.out.print("\nEnter singer ID to search: ");
        String searchId = scanner.nextLine();
        Singers foundSinger = Singers.Search(searchId);
        if (foundSinger != null) {
            System.out.println("Singer found:");
            foundSinger.displayDetails();
        } else {
            System.out.println("Singer not found.");
        }
        
        // Count singers above 30
        int above30 = Singers.Count();
        System.out.println("\nNumber of singers above 30 years: " + above30);
    }
}