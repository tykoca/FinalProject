public class ExamDoWhile {
    private static final int QUARTER_WAY = 2;
    private static final int HALF_WAY = 4;
    private static final int ALL_THE_WAY = 8;

    public static void main(String[] args) {
        int numberOfValues = 0;
        int total = 0;
        boolean madeIt;

        do {
            numberOfValues++;
            while (numberOfValues < HALF_WAY) {
                total += numberOfValues;
                numberOfValues++;
            }
            madeIt = (total - numberOfValues) % 2 == 0;
            numberOfValues -= QUARTER_WAY;

            // Output the current state of the variables
            System.out.println("Number of Values: " + numberOfValues);
            System.out.println("Total: " + total);
            System.out.println("Made It: " + madeIt);
            System.out.println("-------------------------");
        } while (total < ALL_THE_WAY);

        // Final output after the loop ends
        System.out.println("Final Number of Values: " + numberOfValues);
        System.out.println("Final Total: " + total);
        System.out.println("Final Made It: " + madeIt);
    }
}
