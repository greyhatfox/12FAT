package C1;
import java.util.*;
import java.util.Map.Entry;

public class Q9StudentManagementSystem {

    // Helper method to add students with duplicate roll number check
    private static void addStudent(HashMap map, int rollNumber, String name) {
        if (map.containsKey(rollNumber)) {
            throw new IllegalArgumentException("Duplicate roll number not allowed: " + rollNumber);
        }
        map.put(rollNumber, name);
    }
    public static void main(String[] args) {
        // Create ArrayList to store student names
        ArrayList studentNames = new ArrayList();
        
        // Create HashMap to store roll number to name mapping
        HashMap rollNumberMap = new HashMap();
        
        // Add some student names to the ArrayList
        studentNames.add("Alice Johnson");
        studentNames.add("Bob Smith");
        studentNames.add("Charlie Brown");
        studentNames.add("Diana Prince");
        
        // Map roll numbers to names (with duplicate check)
        try {
            addStudent(rollNumberMap, 101, "Alice Johnson");
            addStudent(rollNumberMap, 102, "Bob Smith");
            addStudent(rollNumberMap, 103, "Charlie Brown");
            addStudent(rollNumberMap, 104, "Diana Prince");
            
            // Try to add duplicate roll number
            addStudent(rollNumberMap, 101, "Eve Williams");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        // Display student names using Iterator
        System.out.println("List of Students:");
        Iterator nameIterator = studentNames.iterator();
        while (nameIterator.hasNext()) {
            System.out.println("- " + nameIterator.next());
        }
        
        // Display roll number mapping using for-each loop
        System.out.println("\nRoll Number Mapping:");
        for (Object entry : rollNumberMap.entrySet()) {
            Entry mapEntry = (Entry) entry;
            System.out.println("Roll #" + mapEntry.getKey() + ": " + mapEntry.getValue());
        }
    }
    
}