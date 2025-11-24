import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Random rand = new Random();
    
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("====== NUMBER GUESSING GAME ======");

        while (playAgain) {
            int randomNumber = rand.nextInt(100) + 1; 
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round Started!");
            System.out.println("Guess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println(" Correct! You guessed the number.");
                    guessedCorrectly = true;
                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;
                    System.out.println("You earned " + roundScore + " points!");
                    break;
                } 
                else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } 
                else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
            System.out.println(" Out of attempts! The number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n====== GAME OVER ======");
        System.out.println("Your Total Score: " + totalScore);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}





















