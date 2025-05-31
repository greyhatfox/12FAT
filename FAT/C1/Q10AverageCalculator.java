package C1;

public class Q10AverageCalculator<T extends Number> {
    private T[] numbers;

    public Q10AverageCalculator(T[] numbers) {
        this.numbers = numbers;
    }

    public double calculateAverage() {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Array is empty. Cannot calculate average.");
            return 0.0;
        }

        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }

        return sum / numbers.length;
    }

    public static void main(String[] args) {
        // Test with Integer array
        Integer[] intArray = {10, 20, 30, 40, 50};
        Q10AverageCalculator<Integer> intCalculator = new Q10AverageCalculator<>(intArray);
        System.out.println("Integer array average: " + intCalculator.calculateAverage());

        // Test with Double array
        Double[] doubleArray = {10.5, 20.5, 30.5, 40.5, 50.5};
        Q10AverageCalculator<Double> doubleCalculator = new Q10AverageCalculator<>(doubleArray);
        System.out.println("Double array average: " + doubleCalculator.calculateAverage());

        // Test with empty array
        Integer[] emptyArray = {};
        Q10AverageCalculator<Integer> emptyCalculator = new Q10AverageCalculator<>(emptyArray);
        System.out.println("Empty array average: " + emptyCalculator.calculateAverage());
    }
}