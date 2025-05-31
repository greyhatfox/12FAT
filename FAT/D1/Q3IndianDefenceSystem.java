package D1;

// Base class
class DefenceForce {
    protected String forceName;

    public DefenceForce(String forceName) {
        this.forceName = forceName;
    }

    public void displayForce() {
        System.out.println("Force Name: " + forceName);
    }
}

// Army class
class Army extends DefenceForce {
    private int soldiers;

    public Army(String forceName, int soldiers) {
        super(forceName);
        this.soldiers = soldiers;
    }

    public void displayArmyDetails() {
        System.out.println("--- Army Details ---");
        displayForce();
        System.out.println("Number of Soldiers: " + soldiers);
    }
}

// Navy class
class Navy extends DefenceForce {
    private int ships;

    public Navy(String forceName, int ships) {
        super(forceName);
        this.ships = ships;
    }

    public void displayNavyDetails() {
        System.out.println("--- Navy Details ---");
        displayForce();
        System.out.println("Number of Ships: " + ships);
    }
}

// AirForce class
class AirForce extends DefenceForce {
    private int aircrafts;

    public AirForce(String forceName, int aircrafts) {
        super(forceName);
        this.aircrafts = aircrafts;
    }

    public void displayAirForceDetails() {
        System.out.println("--- Air Force Details ---");
        displayForce();
        System.out.println("Number of Aircrafts: " + aircrafts);
    }
}

public class Q3IndianDefenceSystem {
    public static void main(String[] args) {
        // Create objects for each defence force
        Army army = new Army("Indian Army", 1200000);
        Navy navy = new Navy("Indian Navy", 150);
        AirForce airForce = new AirForce("Indian Air Force", 1700);

        // Display details for each force
        army.displayArmyDetails();
        System.out.println();  // Blank line for separation
        navy.displayNavyDetails();
        System.out.println();  // Blank line for separation
        airForce.displayAirForceDetails();
    }
}