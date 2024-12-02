import java.util.Scanner;

public class DiamondsAreAGirlsBestFriend {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Create a girl
        System.out.print("Enter the name of the girl : ");
        String girlName = scan.nextLine();
        Girl girl = new Girl(girlName);

        System.out.println(girl.toString()); // Display initial status

        while (true) {
            System.out.print("Enter carats and value     : ");
            double carats = scan.nextDouble();
            double value = scan.nextDouble();

            if (carats <= 0) {
                break;
            }

            Diamond diamond = new Diamond(carats, value);
            boolean accepted = girl.acceptDiamond(diamond);
            if (accepted) {
                System.out.println("Woohoo, the girl took the diamond");
            } else {
                System.out.println("Aaargh, the diamond was rejected ");
            }

            System.out.println(girl.toString());
        }

        System.out.println(girl.toString());
    }
}
