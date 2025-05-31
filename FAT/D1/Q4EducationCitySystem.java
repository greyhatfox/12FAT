package D1;

// Abstract University class
abstract class University {
    protected String name;
    protected String location;

    public University(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Abstract method to be implemented by derived classes
    public abstract void displayDetails();

    // Concrete method common to all universities
    public void commonInfo() {
        System.out.println("All universities are part of Amaravathy Education City.");
    }
}

// VIT-AP University class
class VITAP extends University {
    public VITAP() {
        super("VIT-AP", "Amaravati");
    }

    @Override
    public void displayDetails() {
        System.out.println("\nUniversity: " + name);
        System.out.println("Location: " + location);
        commonInfo();
    }
}

// SRM University class
class SRM extends University {
    public SRM() {
        super("SRM", "Chennai");
    }

    @Override
    public void displayDetails() {
        System.out.println("\nUniversity: " + name);
        System.out.println("Location: " + location);
        commonInfo();
    }
}

// Amrita University class
class Amrita extends University {
    public Amrita() {
        super("Amrita", "Coimbatore");
    }

    @Override
    public void displayDetails() {
        System.out.println("\nUniversity: " + name);
        System.out.println("Location: " + location);
        commonInfo();
    }
}

public class Q4EducationCitySystem {
    public static void main(String[] args) {
        // Create university objects
        University vitap = new VITAP();
        University srm = new SRM();
        University amrita = new Amrita();

        // Display university details
        vitap.displayDetails();
        srm.displayDetails();
        amrita.displayDetails();

        // Simulate cleanup process
        vitap = null;
        srm = null;
        amrita = null;

        // Explicitly request garbage collection
        System.gc();
        System.out.println("\nGarbage collection requested for unused university objects.");

        // Add a pause to observe garbage collection (optional)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    // Finalizer to observe garbage collection (for demonstration)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collector cleaned up a University object");
        super.finalize();
    }
}