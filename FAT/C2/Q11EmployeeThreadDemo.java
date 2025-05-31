package C2;

class EmployeeDetails {
    private String name;
    private int id;
    private double salary;
    private String dept;

    // Constructor to initialize employee details
    public EmployeeDetails(String name, int id, double salary, String dept) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.dept = dept;
    }

    // Method to check if name contains 'A'
    public void checkName(String name) {
        if (name.toUpperCase().contains("A")) {
            System.out.println("Valid name");
        } else {
            System.out.println("Not a valid name");
        }
    }

    // Method to display all employee details
    public void display() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + dept);
    }

    // Getter for name
    public String getName() {
        return name;
    }
}

public class Q11EmployeeThreadDemo {
    public static void main(String[] args) {
        // Create an Employee object
        EmployeeDetails emp = new EmployeeDetails("Alice", 101, 50000.0, "HR");

        // Create first thread for name validation
        Thread nameCheckThread = new Thread(() -> {
            emp.checkName(emp.getName());
        });

        // Create second thread for displaying details
        Thread displayThread = new Thread(() -> {
            emp.display();
        });

        // Start both threads
        nameCheckThread.start();
        displayThread.start();

        try {
            // Wait for both threads to complete
            nameCheckThread.join();
            displayThread.join();
        } catch (InterruptedException e) {
            System.out.println("Threads interrupted: " + e.getMessage());
        }

        System.out.println("Main thread finished");
    }
}