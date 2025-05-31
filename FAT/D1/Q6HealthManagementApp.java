package D1;

// Interface for calorie burning
interface CalorieBurner {
    void burnCalories(int calories);
}

// Interface for water intake
interface WaterIntake {
    void drinkWater(int liters);
}

// Interface for carb usage
interface CarbUsage {
    void useCarb(String nameOfCarb);
}

// Interface for sugar control
interface SugarControl {
    void reduceSugar(int grams);
}

// HealthTracker class implementing all interfaces
class HealthTracker implements CalorieBurner, WaterIntake, CarbUsage, SugarControl {
    @Override
    public void burnCalories(int calories) {
        System.out.println("Burned " + calories + " calories through workout.");
    }

    @Override
    public void drinkWater(int liters) {
        System.out.println("Drank " + liters + " liters of water today.");
    }

    @Override
    public void useCarb(String nameOfCarb) {
        System.out.println("Used a carb **" + nameOfCarb + "** for commuting after a long run to avoid fatigue.");
    }

    @Override
    public void reduceSugar(int grams) {
        System.out.println("Reduced sugar intake by " + grams + " grams.");
    }
}

public class Q6HealthManagementApp {
    public static void main(String[] args) {
        // Create HealthTracker object
        HealthTracker tracker = new HealthTracker();

        // Simulate health tracking activities
        tracker.burnCalories(500);
        tracker.drinkWater(3);
        tracker.useCarb("Parotta");
        tracker.reduceSugar(20);
    }
}