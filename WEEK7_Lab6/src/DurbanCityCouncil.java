import java.util.Scanner;



public class DurbanCityCouncil {


    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Week 7 - Lab 6");
        System.out.println("How many houses in the street? : ");
        int numberOfHousesInTheStreet = keyboard.nextInt();

        int[] houseNumbers = new int[numberOfHousesInTheStreet];

        int index;

        for (index = 0; index < houseNumbers.length; index++) {
            System.out.println("What is the next house number? : ");
            houseNumbers[index] = keyboard.nextInt();

        }

        int[][] houseAges = new int[numberOfHousesInTheStreet][];

        int rowIndex;
        int colIndex;

        for (rowIndex = 0; rowIndex < houseAges.length; rowIndex++) {
            System.out.println("How many people live in" + houseNumbers[rowIndex] + ":");
            int peopleInHouse = keyboard.nextInt();
            houseAges[rowIndex] = new int[peopleInHouse];

            for (colIndex = 0; colIndex < houseAges[rowIndex].length; colIndex++) {

                System.out.print("What is the age of person" + (colIndex + 1));
                houseAges[rowIndex][colIndex] = keyboard.nextInt();
            }//end of the inner for oop
        }

        int totalStreetAge = 0;
        for (rowIndex = 0; rowIndex < houseAges.length; rowIndex++) {
            int totalAge = 0;
            for (colIndex = 0; colIndex < houseAges[rowIndex].length; colIndex++) {

                totalAge = totalAge + houseAges[rowIndex][colIndex];

            }// end of inner for loop column
            System.out.println("House " + (houseNumbers[rowIndex]) + "has a total age of " + totalAge);
            totalStreetAge = totalStreetAge + totalAge;
        }
        System.out.println("the street has a total age of" + totalStreetAge);
    }
}// end of the durban city program







