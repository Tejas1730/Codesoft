import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        // Step 1: Generate a random number
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int maxAttempts = 5; // Limit the number of attempts
        int attempts = 0;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I've selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        Scanner scanner = new Scanner(System.in);

        // Step 2: Loop for user guesses
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess;

            // Input validation
            try {
                userGuess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            attempts++;

            // Step 3: Compare guesses
            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You've guessed the correct number!");
                break;
            }

            // Feedback on remaining attempts
            if (attempts < maxAttempts) {
                System.out.println("You have " + (maxAttempts - attempts) + " attempts remaining.");
            }
        }

        // If the user didn't guess correctly within the attempts
        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}