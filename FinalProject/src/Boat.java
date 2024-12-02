import java.io.Serializable;

/**
 * Class representing a boat in the fleet.
 */
public class Boat implements Serializable {
    private BoatType type;
    private String name;
    private int year;
    private String makeModel;
    private double length;
    private double purchasePrice;
    private double expenses;

    /**
     * Constructor to initialize a Boat object.
     *
     * @param type          The type of the boat (SAILING or POWER).
     * @param name          The name of the boat.
     * @param year          The year of manufacture.
     * @param makeModel     The make and model of the boat.
     * @param length        The length of the boat in feet.
     * @param purchasePrice The purchase price of the boat.
     */
    public Boat(BoatType type, String name, int year, String makeModel, double length, double purchasePrice) {
        this.type = type;
        this.name = name;
        this.year = year;
        this.makeModel = makeModel;
        this.length = length;
        this.purchasePrice = purchasePrice;
        this.expenses = 0.0;
    }

    // Getters and Setters
    public BoatType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public double getLength() {
        return length;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getExpenses() {
        return expenses;
    }

    /**
     * Adds an expense to the boat if it doesn't exceed the purchase price.
     *
     * @param amount The amount to add as an expense.
     * @return True if the expense is authorized, false otherwise.
     */
    public boolean addExpense(double amount) {
        if (expenses + amount <= purchasePrice) {
            expenses += amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculates the remaining amount that can be spent on the boat.
     *
     * @return The remaining amount allowed for expenses.
     */
    public double getRemainingExpense() {
        return purchasePrice - expenses;
    }

    /**
     * Returns a formatted string representation of the boat.
     *
     * @return Formatted string with boat details.
     */
    @Override
    public String toString() {
        return String.format("    %-7s %-20s %4d %-12s %3.0f' : Paid $%10.2f : Spent $%10.2f",
                type.toString(), name, year, makeModel, length, purchasePrice, expenses);
    }
}
