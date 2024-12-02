public class AverageCalculator {
    public static void main(String[] args) {
        // Example values to compute the average
        int value1 = 4;
        int value2 = 8;
        int value3 = 15;

        // Call the computeAverage method with the example values
        computeAverage(value1, value2, value3);
    }

    public static void computeAverage(int a, int b, int c) {
        double average = (a + b + c) / 3.0; // Calculate the average using floating-point division
        System.out.println("Average: " + average); // Print the result
    }
}
