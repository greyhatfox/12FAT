package C2;

class Vacation {
    private static final int MAX_SLOT_CAPACITY = 10;
    private static int slot1 = 2;  // Initial bookings for slot A
    private static int slot2 = 2;  // Initial bookings for slot B
    private static int slot3 = 2;  // Initial bookings for slot C

    // Synchronized method to book slots
    public synchronized void slotBooking(char slotType, String facultyName, int id) {
        switch (slotType) {
            case 'A':
                if (slot1 < MAX_SLOT_CAPACITY) {
                    slot1++;
                    System.out.println(facultyName + " (ID: " + id + ") allotted Slot1-A. Current bookings: " + slot1);
                } else {
                    System.out.println("Slot1-A not available for " + facultyName + ". Choose a different slot.");
                }
                break;
            case 'B':
                if (slot2 < MAX_SLOT_CAPACITY) {
                    slot2++;
                    System.out.println(facultyName + " (ID: " + id + ") allotted Slot2-B. Current bookings: " + slot2);
                } else {
                    System.out.println("Slot2-B not available for " + facultyName + ". Choose a different slot.");
                }
                break;
            case 'C':
                if (slot3 < MAX_SLOT_CAPACITY) {
                    slot3++;
                    System.out.println(facultyName + " (ID: " + id + ") allotted Slot3-C. Current bookings: " + slot3);
                } else {
                    System.out.println("Slot3-C not available for " + facultyName + ". Choose a different slot.");
                }
                break;
            default:
                System.out.println("Invalid slot type for " + facultyName);
        }
    }

    public static void showSlotAvailability() {
        System.out.println("\nCurrent Slot Availability:");
        System.out.println("Slot1-A: " + (MAX_SLOT_CAPACITY - slot1) + " remaining");
        System.out.println("Slot2-B: " + (MAX_SLOT_CAPACITY - slot2) + " remaining");
        System.out.println("Slot3-C: " + (MAX_SLOT_CAPACITY - slot3) + " remaining");
    }
}

class FacultyThread extends Thread {
    private Vacation vacationSystem;
    private String facultyName;
    private int id;
    private char preferredSlot;

    public FacultyThread(Vacation vacationSystem, String facultyName, int id, char preferredSlot) {
        this.vacationSystem = vacationSystem;
        this.facultyName = facultyName;
        this.id = id;
        this.preferredSlot = preferredSlot;
    }

    @Override
    public void run() {
        vacationSystem.slotBooking(preferredSlot, facultyName, id);
    }
}

public class Q12VacationBookingSystem {
    public static void main(String[] args) {
        Vacation vacationSystem = new Vacation();
        
        // Create 15 faculty threads trying to book slots
        FacultyThread[] facultyThreads = new FacultyThread[15];
        
        // Initialize threads with different slot preferences
        for (int i = 0; i < 15; i++) {
            char slot;
            if (i % 3 == 0) slot = 'A';
            else if (i % 3 == 1) slot = 'B';
            else slot = 'C';
            
            facultyThreads[i] = new FacultyThread(vacationSystem, "Faculty" + (i+1), 1000 + i, slot);
        }

        // Start all threads
        for (FacultyThread thread : facultyThreads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (FacultyThread thread : facultyThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }

        // Show final slot availability
        Vacation.showSlotAvailability();
    }
}