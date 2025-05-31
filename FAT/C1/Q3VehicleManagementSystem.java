package C1;

import java.util.Scanner;

// Base Vehicle class
abstract class Vehicle {
    protected String vehicleId;
    protected String vehicleName;
    protected double fuelCapacity;
    protected int maxSpeed;

    public Vehicle(String vehicleId, String vehicleName, double fuelCapacity, int maxSpeed) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.fuelCapacity = fuelCapacity;
        this.maxSpeed = maxSpeed;
    }

    public abstract void startEngine();
    
    public double calculateTime(int distance) {
        return (double) distance / maxSpeed;
    }

    public void stopEngine(double time) {
        System.out.printf("Engine stopped. Time taken: %.2f hours\n", time);
    }
}

// Derived Car class
class Car extends Vehicle {
    public Car(String vehicleId, String vehicleName, double fuelCapacity, int maxSpeed) {
        super(vehicleId, vehicleName, fuelCapacity, maxSpeed);
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started - Vroom Vroom!");
    }
}

// Derived Truck class
class Truck extends Vehicle {
    public Truck(String vehicleId, String vehicleName, double fuelCapacity, int maxSpeed) {
        super(vehicleId, vehicleName, fuelCapacity, maxSpeed);
    }

    @Override
    public void startEngine() {
        System.out.println("Truck engine started - Rumble Rumble!");
    }
}

// Derived Motorcycle class
class Motorcycle extends Vehicle {
    public Motorcycle(String vehicleId, String vehicleName, double fuelCapacity, int maxSpeed) {
        super(vehicleId, vehicleName, fuelCapacity, maxSpeed);
    }

    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started - Vroom!");
    }
}

public class Q3VehicleManagementSystem {

    private static void processVehicle(Vehicle vehicle, int distance, String type) {
        System.out.println("\n--- " + type + " ---");
        vehicle.startEngine();
        double time = vehicle.calculateTime(distance);
        System.out.printf("Time to travel %d km: %.2f hours\n", distance, time);
        vehicle.stopEngine(time);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create vehicles
        Vehicle car = new Car("C001", "Toyota Camry", 50.0, 120);
        Vehicle truck = new Truck("T001", "Ford F-150", 80.0, 80);
        Vehicle motorcycle = new Motorcycle("M001", "Harley Davidson", 15.0, 100);

        System.out.print("Enter distance to travel (in km): ");
        int distance = scanner.nextInt();

        processVehicle(car, distance, "Car");
        processVehicle(truck, distance, "Truck");
        processVehicle(motorcycle, distance, "Motorcycle");

        scanner.close();
    }

}