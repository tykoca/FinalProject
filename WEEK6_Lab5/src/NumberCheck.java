/**
 * @author Tyler Kocadag
 */

import java.util.Scanner;


public class NumberCheck {
    /**
     * calls the get numbers main method
     * then checks if each number is a Fibonacci number and a prime number
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Week 6 - Lab 5");
        int[] numbers = new int[10];
        int count = getNumbers(numbers);

        for (int i = 0; i < count; i++) {
            int num = numbers[i];
            boolean isFibonacci = isFibonacci(num);
            boolean isPrime = isPrime(num);
            String fibonacciResult = isFibonacci ? "is Fibonacci" : "is not Fibonacci";
            String primeResult = isPrime ? "is prime" : "is not prime";

            System.out.println(num + " " + fibonacciResult + " and " + primeResult);

        }
    }

    /**
     * Prompts the user to input up to 10 non-negative integers.
     * @param numbers Array to store the user's input.
     * @return The number of integers entered by the user.
     */
    public static int getNumbers(int[] numbers) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int input;

        do {
            if (count == 10) break;
            System.out.print("Please enter numbers (0 to stop): ");
            input = scanner.nextInt();

            if (input < 0) {
                System.out.println("Please enter a non-negative integer.");
                continue;
            }

            if (input != 0) {
                numbers[count] = input;
                count++;
            }
        } while (input != 0);

        return count;
    }

    /**
     * The method iterates through the Fibonacci sequence until it finds the candidate number or exceeds it.
     * @param candidate  The number to check.
     * @return True if the number is a Fibonacci number, otherwise false.
     */
    public static boolean isFibonacci(int candidate) {
        long previous = 1;
        long current = 0;
        long next;
        while (current < candidate) {
            next = current + previous;
            previous = current;
            current = next;
        }
        return current == candidate;
    }

    /**
     * A prime number is a number greater than 1 that has no divisors other than 1 and itself.
     * @param candidate The number to check.
     * @return True if the number is prime, otherwise false.
     */
    private static boolean isPrime(long candidate) {

        long divisor = 2;

        while (divisor <= Math.sqrt(candidate)) {
            if (candidate % divisor == 0) {
                return(false);
            }
            divisor++;
        }
        return(true);
    }
}
