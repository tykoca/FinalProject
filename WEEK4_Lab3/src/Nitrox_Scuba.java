import java.util.Scanner;
public class Nitrox_Scuba {

    private static Scanner keyboard = new Scanner(System.in);
    // Constant variables
    private static final byte FEET_PER_ATMOSPHERE = 33;
    private static final double MAXIMAL_P02 = 1.4;
    private static final double CONTINGENCY_P02 = 1.6;

    public static void main(String[] args) {
        // Input data: depth and percentage of oxygen
        System.out.println("WEEK 4 - LAB 3");


        System.out.print("Enter depth and percentage of oxygen: ");

        int depth = keyboard.nextInt();
        int percentage02 = keyboard.nextInt();

        double ambientPressure = (depth /(double) FEET_PER_ATMOSPHERE) + 1;

        System.out.println("Ambient pressure \t\t\t\t: " + ambientPressure);

        double oxygenfractionO2 = percentage02 / 100.0;
        double partialPressureO2 = oxygenfractionO2 * ambientPressure;
        System.out.println("02 Pressure \t\t\t\t\t: " + partialPressureO2);

        boolean exceedMaximal = partialPressureO2 > MAXIMAL_P02;
        boolean exceedContingency = partialPressureO2 > CONTINGENCY_P02;

        int index = (int)(partialPressureO2 * 10);
        char compute0PG = (char)('A' + index);

        System.out.println("02 group \t\t\t\t\t\t: " + compute0PG);

        System.out.println("Exceeds Maximal 02 Pressure \t: " + exceedMaximal);
        System.out.println("Exceeds Contingency 02 Pressure \t: " + exceedContingency);

    }
}// end of the Nitrox_Scuba class
