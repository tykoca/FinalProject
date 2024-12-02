public class PowerfulArray {
    private static final int NUMBER_OF_ELEMENTS = 6;
    private static final int POWER_EXPONENT = 3;

    public static void main(String[] args) {
        // Create an array of doubles with the specified number of elements
        double[] array = new double[NUMBER_OF_ELEMENTS];

        // Use a for loop to initialize the array entries to the index raised to the power of 3
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            array[i] = Math.pow(i, POWER_EXPONENT);
            // Print each element's value to confirm the computation
            System.out.println("Element at index " + i + " is: " + array[i]);
        }
    }
}
