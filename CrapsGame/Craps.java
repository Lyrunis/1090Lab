import java.util.Random;
import java.util.Scanner;

public class Craps{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1; // Generate a random number between 1 and 6 for die 1
            int die2 = rnd.nextInt(6) + 1; // Generate a random number between 1 and 6 for die 2
            int sum = die1 + die2; // Calculate the sum of the two dice
            System.out.println("Rolling the dice...");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lost."); // Player loses if the sum is 2, 3, or 12
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won."); // Player wins if the sum is 7 or 11
            } else {
                int point = sum; // Set the point to the sum
                System.out.println("Point is set to " + point);
                boolean continueRolling = true;

                while (continueRolling) {
                    die1 = rnd.nextInt(6) + 1; // Generate a random number between 1 and 6 for die 1
                    die2 = rnd.nextInt(6) + 1; // Generate a random number between 1 and 6 for die 2
                    sum = die1 + die2; // Calculate the sum of the two dice
                    System.out.println("Rolling the dice...");
                    System.out.println("Die 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + sum);

                    if (sum == 7) {
                        System.out.println("You rolled a 7. You lost."); // Player loses if they roll a 7
                        continueRolling = false;
                    } else if (sum == point) {
                        System.out.println("You made the point! You won."); // Player wins if they roll the point again
                        continueRolling = false;
                    } else {
                        System.out.println("Trying for point " + point + "..."); // Player continues rolling to make the point
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String playAgainChoice = scanner.nextLine();
            playAgain = playAgainChoice.equalsIgnoreCase("y"); // Check if the player wants to play again
            System.out.println();
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}