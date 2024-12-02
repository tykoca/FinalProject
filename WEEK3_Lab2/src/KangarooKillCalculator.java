import java.util.Scanner;


public class KangarooKillCalculator {

    public static final double ROAD_WIDTH = 0.01;
    public static final double KILL_PROBABILITY = 1.47;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter side of square in km  : ");
        double side = scanner.nextDouble();

        System.out.print("Enter roads length in km    : ");
        double roadsLength = scanner.nextDouble();

        System.out.print("Enter number of 'roos       : ");
        int numRoos = scanner.nextInt();
        double density = calculateKangarooDensity(side, numRoos);
        double roadSurfaceArea = calculateRoadSurfaceArea(roadsLength);
        double expectedKills = calculateExpectedKills(density, roadSurfaceArea);
        int kills = (int) expectedKills;
        int injuries = (expectedKills - kills) > 0 ? 1 : 0;

        // Output
        System.out.println("Expected number of kills is : " + kills);
        System.out.println("Expected number of injuries : " + injuries);
    }

    public static double calculateKangarooDensity(double side, int numRoos) {
        return numRoos / (side * side);
    }

    public static double calculateRoadSurfaceArea(double roadsLength) {
        return roadsLength * ROAD_WIDTH;
    }

    public static double calculateExpectedKills(double density, double roadSurfaceArea) {
        return density * roadSurfaceArea * KILL_PROBABILITY;
    }
}