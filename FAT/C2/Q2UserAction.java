package C2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Q2UserAction {
    // Private final fields
    private final long timestamp;
    private final String userId;
    private final String actionType;

    // Constructor to initialize fields
    public Q2UserAction(String userId, String actionType) {
        this.timestamp = System.currentTimeMillis(); // or LocalDateTime.now()
        this.userId = userId;
        this.actionType = actionType;
    }

    // Getter methods (no setters allowed for final fields)
    public long getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getActionType() {
        return actionType;
    }

    // Optional: Format timestamp for readable output
    public String getFormattedTimestamp() {
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(
            timestamp / 1000, 
            (int) (timestamp % 1000) * 1_000_000, 
            java.time.ZoneOffset.UTC
        );
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    // Sample usage
    public static void main(String[] args) {
        Q2UserAction action = new Q2UserAction("user123", "LOGIN_ATTEMPT");
        System.out.println("Timestamp: " + action.getFormattedTimestamp());
        System.out.println("User ID: " + action.getUserId());
        System.out.println("Action Type: " + action.getActionType());
    }
}