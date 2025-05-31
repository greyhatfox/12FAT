package D1;

// Generic interface for data processing
interface Processor<T> {
    void process(T data);
}

// Text processor for String data
class TextProcessor implements Processor<String> {
    @Override
    public void process(String data) {
        System.out.println("Processing text data: " + data);
    }
}

// Count processor for Integer data
class CountProcessor implements Processor<Integer> {
    @Override
    public void process(Integer data) {
        System.out.println("Processing count data: " + data);
    }
}

// Measurement processor for Double data
class MeasurementProcessor implements Processor<Double> {
    @Override
    public void process(Double data) {
        System.out.println("Processing measurement data: " + data);
    }
}

public class Q10DataProcessingSystem {
    public static void main(String[] args) {
        // Create processors for each data type
        Processor<String> textProcessor = new TextProcessor();
        Processor<Integer> countProcessor = new CountProcessor();
        Processor<Double> measurementProcessor = new MeasurementProcessor();

        // Process sample data
        textProcessor.process("Hello, World!");
        countProcessor.process(150);
        measurementProcessor.process(23.45);
    }
}