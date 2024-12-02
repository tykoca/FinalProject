import java.util.Scanner;
public class Nitrox_Scuba {


    public static void main(String[] args) {
        // Constant variables
        final double FEET_PER_ATMOSPHERE = 33.0;
        final double MAX_O2_PRESSURE = 1.4;
        final double CONTINGENCY_O2_PRESSURE = 1.6;

        Scanner scanner = new Scanner(System.in);

        // Input Data: Depth and percentage of oxygen
        System.out.print("Enter depth and percentage O2   : ");
        int depth = scanner.nextInt();
        int percentageO2 = scanner.nextInt();

        // Calculate Ambient Pressure
        double ambientPressure = (depth / FEET_PER_ATMOSPHERE) + 1;

        // Calculate Partial Pressure of Oxygen
        double fractionO2 = percentageO2 / 100.0;
        double o2Pressure = fractionO2 * ambientPressure;

        // Find Oxygen Pressure Group
        char o2Group = determineOxygenPressureGroup(o2Pressure);

        // Find if O2 pressure exceeds limits
        boolean exceedsMaxO2Pressure = o2Pressure > MAX_O2_PRESSURE;
        boolean exceedsContingencyO2Pressure = o2Pressure > CONTINGENCY_O2_PRESSURE;

        // Output
        System.out.printf("Ambient pressure                : %.2f%n", ambientPressure);
        System.out.printf("O2 pressure                     : %.2f%n", o2Pressure);
        System.out.printf("O2 group                        : %c%n", o2Group);
        System.out.printf("Exceeds maximal O2 pressure     : %b%n", exceedsMaxO2Pressure);
        System.out.printf("Exceeds contingency O2 pressure : %b%n", exceedsContingencyO2Pressure);
    }

    public static char determineOxygenPressureGroup(double o2Pressure) {
        int groupNumber = (int) (o2Pressure * 10);
        return (char) ('A' + groupNumber);

    }
}// end of the Nitrox_Scuba class
