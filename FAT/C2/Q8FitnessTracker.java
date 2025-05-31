package C2;

import java.text.ParseException;

// Custom exception for activity limit exceeded
class ActivityLimitExceededException extends Exception {
    public ActivityLimitExceededException(double totalHours) {
        super("Logged activity exceeds 24 hours: " + totalHours + " hrs.");
    }
}

public class Q8FitnessTracker {
    public static void main(String[] args) {
        String[] logs = {"2.5", "5", "six", "10", "8"};
        double totalHours = 0;
        
        for (String log : logs) {
            try {
                // Parse the activity duration
                double hours = parseActivityDuration(log);
                totalHours += hours;
                
                // Check if total exceeds 24 hours
                if (totalHours > 24) {
                    throw new ActivityLimitExceededException(totalHours);
                }
                
                System.out.println("Total activity logged: " + totalHours + " hrs.");
            } catch (ParseException e) {
                System.out.println("Data format error: '" + log + "' is not a valid number.");
            } catch (ActivityLimitExceededException e) {
                System.out.println("Exception: " + e.getMessage());
                break; // Stop processing further logs
            }
        }
    }
    
    // Helper method to parse activity duration from string
    private static double parseActivityDuration(String input) throws ParseException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new ParseException(input, 0);
        }
    }
}