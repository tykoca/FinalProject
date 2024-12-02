import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FleetManager class manages a fleet of boats, allowing operations such as adding, removing,
 * and printing boats, as well as managing expenses and file I/O for persistence.
 */
public class FleetManagementSystem {
    private ArrayList<Boat> fleet;
    private Scanner keyboard;

    /**
     * Constructs a FleetManager instance and initializes the fleet and keyboard input.
     */
    public FleetManagementSystem() {
        fleet = new ArrayList<>();
        keyboard = new Scanner(System.in);
    }

    /**
     * Main method to run the Fleet Management System.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        FleetManagementSystem manager = new FleetManagementSystem();
        manager.loadData(); // Loads fleet data from CSV or database
        System.out.println("Welcome to the Fleet Management System");
        System.out.println("--------------------------------------\n");
        manager.run();
        manager.saveData(); // Saves fleet data to the database
        System.out.println("\nExiting the Fleet Management System");
    }

    /**
     * Runs the Fleet Management System, presenting a menu for user interaction.
     */
    private void run() {
        while (true) {
            System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            String choice = keyboard.nextLine().trim().toUpperCase();
            if (choice.isEmpty()) {
                System.out.println("Invalid menu option, try again.");
                continue;
            }
            char option = choice.charAt(0);
            switch (option) {
                case 'P':
                    printFleet();
                    break;
                case 'A':
                    addBoat();
                    break;
                case 'R':
                    removeBoat();
                    break;
                case 'E':
                    requestExpense();
                    break;
                case 'X':
                    return;
                default:
                    System.out.println("Invalid menu option, try again.");
            }
        }
    }

    /**
     * Loads fleet data from a database file if available; otherwise, loads from a CSV file.
     */
    private void loadData() {
        String csvFileName = "FinalProject/src/FleetData.csv";
        File csvFile = new File(csvFileName);
        File dbFile = new File("FleetData.db");

        // Try loading from database first
        if (dbFile.exists()) {
            System.out.println("DB file exists");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbFile))) {
                fleet = (ArrayList<Boat>) ois.readObject();
                System.out.println("Fleet data loaded from database.");
                System.out.printf("number of boats: %d\n", fleet.size());
                return; // Database loaded successfully
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading from database: " + e.getMessage());
                System.out.println("Attempting to load data from CSV...");
            }
        }

        // If database fails or doesn't exist, load from CSV
        if (csvFile.exists()) {
            System.out.println("Loading from CSV: " + csvFileName);
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//                String line = br.readLine(); // Read and skip the header row
//                if (line != null && line.trim().toLowerCase().startsWith("type,")) {
//                    System.out.println("Skipping header row: " + line);
//                }
                String line;
                while ((line = br.readLine()) != null) {
                    Boat boat = parseBoatFromCSV(line);
                    if (boat != null) {
                        fleet.add(boat);
                        System.out.println("Loaded boat: " + boat);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading from CSV file: " + e.getMessage());
            }
        } else {
            System.out.println("No existing data found. Initializing an empty fleet.");
        }
    }

    /**
     * Saves fleet data to a database file for persistence.
     */
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FleetData.db"))) {
            oos.writeObject(fleet);
            System.out.println("Fleet data saved to database.");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    /**
     * Parses a line of CSV data to create a Boat object.
     *
     * @param line A line of CSV data.
     * @return A Boat object created from the CSV data, or null if the data is invalid.
     */
    private Boat parseBoatFromCSV(String line) {
        String[] tokens = line.split(",");
        if (tokens.length != 6) {
            System.err.println("Invalid CSV line: " + line);
            return null;
        }
        try {
            BoatType type = BoatType.valueOf(tokens[0].trim().toUpperCase());
            String name = tokens[1].trim();
            int year = Integer.parseInt(tokens[2].trim());
            String makeModel = tokens[3].trim();
            double length = Double.parseDouble(tokens[4].trim());
            double purchasePrice = Double.parseDouble(tokens[5].trim());
            return new Boat(type, name, year, makeModel, length, purchasePrice);
        } catch (Exception e) {
            System.err.println("Error parsing CSV line: " + line);
            return null;
        }
    }

    /**
     * Prints a formatted report of the entire fleet.
     */
    private void printFleet() {
        System.out.println("\nFleet report:");
        double totalPaid = 0.0;
        double totalSpent = 0.0;
        for (Boat boat : fleet) {
            System.out.println(boat);
            totalPaid += boat.getPurchasePrice();
            totalSpent += boat.getExpenses();
        }
        String totalLine = String.format("    Total%47s : Paid $%9.2f : Spent $%10.2f",
                "", totalPaid, totalSpent);
        System.out.println(totalLine);
        System.out.println();
    }

    /**
     * Prompts the user to add a new boat to the fleet using CSV data input.
     */
    private void addBoat() {
        System.out.print("Please enter the new boat CSV data          : ");
        String line = keyboard.nextLine();
        Boat boat = parseBoatFromCSV(line);
        if (boat != null) {
            fleet.add(boat);
        }
    }

    /**
     * Prompts the user to remove a boat by name.
     */
    private void removeBoat() {
        System.out.print("Which boat do you want to remove?           : ");
        String name = keyboard.nextLine().trim();
        Boat boat = findBoatByName(name);
        if (boat != null) {
            fleet.remove(boat);
        } else {
            System.out.println("Cannot find boat " + name);
        }
    }

    /**
     * Makes the user to request and process an expense for a specific boat.
     */
    private void requestExpense() {
        System.out.print("Which boat do you want to spend on?         : ");
        String name = keyboard.nextLine().trim();
        Boat boat = findBoatByName(name);
        if (boat != null) {
            System.out.print("How much do you want to spend?              : ");
            String amountStr = keyboard.nextLine().trim();
            try {
                double amount = Double.parseDouble(amountStr);
                double totalExpense = boat.getExpenses() + amount;
                if (totalExpense <= boat.getPurchasePrice()) {
                    boat.addExpense(amount);
                    System.out.printf("Expense authorized, $%.2f spent.%n", boat.getExpenses());
                } else {
                    double amountLeft = boat.getPurchasePrice() - boat.getExpenses();
                    System.out.printf("Expense not permitted, only $%.2f left to spend.%n", amountLeft);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount entered.");
            }
        } else {
            System.out.println("Cannot find boat " + name);
        }
    }

    /**
     * Finds a boat in the fleet by its name.
     *
     * @param name The name of the boat to find.
     * @return The Boat object with the specified name
     */
    private Boat findBoatByName(String name) {
        for (Boat boat : fleet) {
            if (boat.getName().equalsIgnoreCase(name)) {
                return boat;
            }
        }
        return null;
    }
}