import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 3;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game");

        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nYou have picked a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + attemptsLimit + " attempts to guess it!");

            while (attempts < attemptsLimit) {
                System.out.println("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Excellent! You have guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += attempts;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("very low... Try again.");
                } else {
                    System.out.println("very high... Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you have used all your attempts. The number was " + generatedNumber);
            }

            System.out.println("Your current score: " + score);
            System.out.println("press something to play again? (yes/no)");

            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing the game!");
        scanner.close();
    }
}