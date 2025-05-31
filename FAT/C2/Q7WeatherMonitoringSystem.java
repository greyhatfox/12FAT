package C2;

// TemperatureSensor class
class TemperatureSensor {
    protected double temp;

    public TemperatureSensor(double temp) {
        this.temp = temp;
    }

    public double getTemp() throws ArithmeticException {
        if (temp > 40) {
            throw new ArithmeticException("Temperature exceeds safe limit (40°C)");
        }
        return temp;
    }
}

// PressureSensor class
class PressureSensor {
    protected double pressure;

    public PressureSensor(double pressure) {
        this.pressure = pressure;
    }

    public double getPressure() throws NullPointerException {
        if (pressure > 100) {
            throw new NullPointerException("Pressure exceeds safe limit (100 units)");
        }
        return pressure;
    }
}

// SensorData class that inherits from both TemperatureSensor and PressureSensor
class SensorData extends TemperatureSensor {
    // Using composition for PressureSensor since Java doesn't support multiple inheritance
    private PressureSensor pressureSensor;

    public SensorData(double temp, double pressure) {
        super(temp);
        this.pressureSensor = new PressureSensor(pressure);
    }

    public void display() {
        try {
            System.out.println("Temperature: " + getTemp());
        } catch (ArithmeticException e) {
            System.out.println("Temperature Error: " + e.getMessage());
        }

        try {
            System.out.println("Pressure: " + pressureSensor.getPressure());
        } catch (NullPointerException e) {
            System.out.println("Pressure Error: " + e.getMessage());
        }
    }
}

// Main class to test the implementation
public class Q7WeatherMonitoringSystem {
    public static void main(String[] args) {
        // Test case 1: Normal values
        System.out.println("Test Case 1 - Normal values:");
        SensorData normalData = new SensorData(25.5, 80.0);
        normalData.display();

        // Test case 2: High temperature
        System.out.println("\nTest Case 2 - High temperature:");
        SensorData highTempData = new SensorData(42.0, 85.0);
        highTempData.display();

        // Test case 3: High pressure
        System.out.println("\nTest Case 3 - High pressure:");
        SensorData highPressureData = new SensorData(30.0, 105.0);
        highPressureData.display();

        // Test case 4: Both high
        System.out.println("\nTest Case 4 - Both high:");
        SensorData bothHighData = new SensorData(45.0, 110.0);
        bothHighData.display();
    }
}