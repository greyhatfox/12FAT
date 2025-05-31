package C1;

import java.util.Scanner;

public class Q1Student {
    private String studentId;
    private String name;
    private int age;
    private int[] marks;

    // Parameterized constructor using 'this' keyword
    public Q1Student(String studentId, String name, int age, int[] marks) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    // Method to calculate and return average marks
    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accepting input from user
        System.out.println("Enter Student Details:");
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Age: ");
        int age = scanner.nextInt();
        
        int[] marks = new int[5];
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i+1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Creating Student object
        Q1Student student = new Q1Student(id, name, age, marks);

        // Displaying details and calculating average
        student.displayDetails();
        double average = student.calculateAverage();
        System.out.printf("Average Marks: %.2f\n", average);

        // Determining pass/fail status
        if (average >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        scanner.close();
    }
}