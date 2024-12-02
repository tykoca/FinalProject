import java.util.Scanner;
public class TaxTime {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        double income = 0;
        double deduction = 0;
        double taxableIncome;
        char taxGroup;
        double tax;
        double amount;

        do{
            System.out.println("Enter next amount: ");
            amount = keyboard.nextDouble();
            if (amount > 0){
                income = income + amount;
            }else if (amount < 0){
                deduction = deduction - amount;
            }

        }while(amount != 0);
        taxableIncome = computeTaxableIncome(income, deduction);
        taxGroup = chooseTaxGroup(taxableIncome);
        tax = computeTax(taxableIncome, taxGroup);
        displayOutput(income, deduction, taxableIncome, taxGroup,tax);



    }

    public static double computeTaxableIncome(double income, double deduction){
        //If income >= deduction then taxable is income - deduction, else
        //2.2 Taxable is 0.0
        double taxableIncome;
        if (income >= deduction) {
            taxableIncome = income - deduction;

        }else {
            taxableIncome = 0.0;
        }

        return taxableIncome;
    }
    public static char chooseTaxGroup(double taxableIncome){
        char taxGroup;
        if (taxableIncome >= 500000) {
            taxGroup = 'S';

        }else if (taxableIncome >= 200000) {
            taxGroup = 'Q';
        }else if (taxableIncome >= 100000) {
            taxGroup = 'M';
        }else if (taxableIncome >= 50000) {
            taxGroup = 'A';
        }else if (taxableIncome >= 20000) {
            taxGroup = 'R';
        }else {
            taxGroup = 'P';
        }

        return  taxGroup;

    }
    public static double computeTax(double taxableIncome, char taxGroup){
        double tax;
        switch (taxGroup){
            case 'S':
            case 'Q':
                tax = .25 * taxableIncome;
                break;
            case 'M':
                tax = .10 * taxableIncome;
                break;
            case 'A':
            case 'R':
                tax = .03 * taxableIncome;
                break;
            case 'P':
                tax = .0 * taxableIncome;
                break;
            default:
                System.out.println("Error in the group");
                tax = 0.0;
                break;

        }
        return tax;
    }
    public static void displayOutput(double income, double deduction, double taxableIncome, char taxGroup, double tax){
        System.out.println("Income = " + income);
        System.out.println("Deductions = " + deduction);
        System.out.println("Taxable Income = " + taxableIncome);
        System.out.println("Tax Group = " + taxGroup);
        System.out.println("Tax Owed = " + tax);
    }

    }
