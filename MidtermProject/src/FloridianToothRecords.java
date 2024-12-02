import java.util.Scanner;

/**
 * Program FloridianToothRecords
 * This program records the dental data for a family from Florida, storing information about
 * their teeth types. The program allows the user to print records, extract a tooth, calculate
 * root canal indices, and exit. The tooth data is stored in a three-dimensional array where
 * each family member has rows for upper and lower teeth.
 */
public class FloridianToothRecords {

    private static final int MAX_PEOPLE = 6;       // Maximum number of family members
    private static final int MAX_TEETH = 8;        // Maximum number of teeth per row
    private static final char[] VALID_TEETH = {'I', 'B', 'M'};  // Valid teeth types: Incisors, Bicuspids, Missing

    /**
     *Main method for Program FloridianToothRecords
     *
     * @param args command line arguments not used
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        // Get the number of family members
        int numberOfPeople = getNumberOfPeople(scanner);
        String[] familyNames = new String[numberOfPeople];
        char[][][] teethRecords = new char[numberOfPeople][2][MAX_TEETH];

        // Get details for each family member
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.print("Please enter the name for family member " + (i + 1) + ": ");
            familyNames[i] = scanner.next();

            teethRecords[i][0] = getTeethRow(scanner, "uppers", familyNames[i]);
            teethRecords[i][1] = getTeethRow(scanner, "lowers", familyNames[i]);
        }

        // Main menu loop
        while (true) {
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it: ");
            char choice = scanner.next().toLowerCase().charAt(0);

            switch (choice) {
                case 'p':
                    printRecords(familyNames, teethRecords);
                    break;
                case 'e':
                    extractTooth(scanner, familyNames, teethRecords);
                    break;
                case 'r':
                    reportRootCanalIndices(teethRecords, numberOfPeople);
                    break;
                case 'x':
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    return;
                default:
                    System.out.println("Invalid menu option, try again");
            }
        }
    }
    /**
     * Prompts the user to enter the number of family members.
     *
     * @param scanner Scanner object for user input
     * @return the validated number of family members
     */
    private static int getNumberOfPeople(Scanner scanner) {
        int numberOfPeople;
        while (true) {
            System.out.print("Please enter number of people in the family: ");
            numberOfPeople = scanner.nextInt();
            if (numberOfPeople > 0 && numberOfPeople <= MAX_PEOPLE) {
                return numberOfPeople;
            }
            System.out.println("Invalid number of people, try again");
        }
    }
    /**
     * Prompts the user to enter a row of teeth for a given family member.
     *
     * @param scanner Scanner object for user input
     * @param rowType String indicating "uppers" or "lowers" row
     * @param name the name of the family member
     * @return a char array representing the row of teeth
     */
    private static char[] getTeethRow(Scanner scanner, String rowType, String name) {
        char[] teeth = new char[MAX_TEETH];
        while (true) {
            System.out.print("Please enter the " + rowType + " for " + name + ": ");
            String input = scanner.next().toUpperCase();

            if (input.length() <= MAX_TEETH && isValidTeeth(input)) {
                for (int i = 0; i < input.length(); i++) {
                    teeth[i] = input.charAt(i);
                }
                return teeth;
            }
            System.out.println("Invalid teeth types, try again");
        }
    }
    /**
     * Validates the given teeth string against allowed teeth types.
     *
     * @param teeth String representing a row of teeth
     * @return true if all characters in the string are valid teeth types, otherwise false
     */
    private static boolean isValidTeeth(String teeth) {
        for (char tooth : teeth.toCharArray()) {
            boolean valid = false;
            for (char validTooth : VALID_TEETH) {
                if (tooth == validTooth) {
                    valid = true;
                    break;
                }
            }
            if (!valid) return false;
        }
        return true;
    }
    /**
     * Prints the dental records for each family member.
     *
     * @param familyNames Array of family member names
     * @param teethRecords 3D array representing upper and lower teeth rows for each member
     */
    private static void printRecords(String[] familyNames, char[][][] teethRecords) {
        for (int i = 0; i < familyNames.length; i++) {
            System.out.println(familyNames[i]);
            System.out.print("  Uppers: ");
            for (int j = 0; j < MAX_TEETH; j++) {
                if (teethRecords[i][0][j] != 0) {
                    System.out.print((j + 1) + ":" + teethRecords[i][0][j] + " ");
                }
            }
            System.out.println();
            System.out.print("  Lowers: ");
            for (int j = 0; j < MAX_TEETH; j++) {
                if (teethRecords[i][1][j] != 0) {
                    System.out.print((j + 1) + ":" + teethRecords[i][1][j] + " ");
                }
            }
            System.out.println();
        }
    }
    /**
     * Allows the user to extract a specific tooth for a family member.
     *
     * @param scanner Scanner object for user input
     * @param familyNames Array of family member names
     * @param teethRecords 3D array of teeth data
     */
    private static void extractTooth(Scanner scanner, String[] familyNames, char[][][] teethRecords) {
        int memberIndex;

        // Family member selection with validation
        while (true) {
            System.out.print("Which family member: ");
            String member = scanner.next().toLowerCase();
            memberIndex = getFamilyMemberIndex(familyNames, member);
            if (memberIndex != -1) {
                break;
            }
            System.out.println("Invalid family member, try again");
        }

        char layer;
        int layerIndex;

        // Tooth layer selection with validation
        while (true) {
            System.out.print("Which tooth layer (U)pper or (L)ower: ");
            layer = scanner.next().toLowerCase().charAt(0);
            if (layer == 'u' || layer == 'l') {
                layerIndex = (layer == 'u') ? 0 : 1;
                break;
            }
            System.out.println("Invalid layer, try again");
        }

        int toothNum;

        // Tooth number selection with validation
        while (true) {
            System.out.print("Which tooth number: ");
            toothNum = scanner.nextInt() - 1;
            if (toothNum >= 0 && toothNum < MAX_TEETH && teethRecords[memberIndex][layerIndex][toothNum] != 'M') {
                teethRecords[memberIndex][layerIndex][toothNum] = 'M';
                break;
            }
            System.out.println("Invalid tooth number or missing tooth, try again");
        }
    }
    /**
     * Reports the total root canal indices for the entire family.
     *
     * @param teethRecords 3D array representing teeth data for each family member
     * @param familySize the number of family members
     */
    // Method to report root canal indices for the entire family
    private static void reportRootCanalIndices(char[][][] teethRecords, int familySize) {
        int numIncisors = 0, numBicuspids = 0, numMissing = 0;

        for (int i = 0; i < familySize; i++) {
            numIncisors += countTeethType(teethRecords[i], 'I');
            numBicuspids += countTeethType(teethRecords[i], 'B');
            numMissing += countTeethType(teethRecords[i], 'M');
        }

        // Calculate and display root canal indices for the total count
        calculateRootCanalIndices(numIncisors, numBicuspids, numMissing);
    }

    /**
     * Counts a specific type of tooth for a family member's teeth.
     *
     * @param teeth  a 2D array representing upper and lower teeth rows
     * @param target the tooth type to count ('I', 'B', or 'M')
     * @return the count of the specified tooth type
     */
    private static int countTeethType(char[][] teeth, char target) {
        int count = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < MAX_TEETH; k++) {
                if (teeth[j][k] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Calculates and displays the root canal indices based on the counts of
     * incisors, bicuspids, and missing teeth using the formula Ix^2 + Bx - M = 0.
     *
     * @param I the number of incisors
     * @param B the number of bicuspids
     * @param M the number of missing teeth
     */
    private static void calculateRootCanalIndices(int I, int B, int M) {
        // Calculate the discriminant for the equation
        double discriminant = Math.pow(B, 2) - 4 * I * (-M);

        if (discriminant >= 0) {
            // Calculate both roots of the quadratic equation
            double root1 = (-B + Math.sqrt(discriminant)) / (2 * I);
            double root2 = (-B - Math.sqrt(discriminant)) / (2 * I);

            // Print the roots with the specified phrasing
            System.out.printf("One root canal at     %.2f%n", root1);
            System.out.printf("Another root canal at %.2f%n", root2);
        } else {
            System.out.println("No real root canals.");
        }
    }
    /**
     * Finds the index of a family member in the array.
     *
     * @param familyNames Array of family member names
     * @param member the name of the family member to find
     * @return the index of the family member or -1 if not found
     */
    private static int getFamilyMemberIndex(String[] familyNames, String member) {
        for (int i = 0; i < familyNames.length; i++) {
            if (familyNames[i].equalsIgnoreCase(member)) {
                return i;
            }
        }
        return -1;
    }
}