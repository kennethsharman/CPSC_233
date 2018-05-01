/**
 *              Team Assignment 1, CPSC 233
 * Class:       GuessingGame.java
 * Purpose:     User inputs guesses for a randomly generated number
 *              between 1-20 and will continue until guess is correct.
 *
 * @author      T01-3
 * Date:        January 23, 2018
 */

// Imports the keyboard scanner and the random generator.
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
	/**
	 * Retrieve guess in form of an integer from user input. Generate the random
	 * number. Determine if guess is correct.
	 *
	 * @print integer data type
	 */
	public static void main(String[] args) {
		// Allows the user to use the keyboard to input values and creates the random
		// number generator.
		Scanner keyboard = new Scanner(System.in);
		Random rand = new Random();

		// Initializes minimum and maximum values for the random numbers as well as the
		// users choice.
		int min = 1;
		int max = 20;
		int choice;

		// Chooses the random number.
		System.out.println("**********Welcome to the Guessing Game!**********");
		System.out.println();
		int randNum = min + rand.nextInt(max);
		System.out.println("The secret number is " + randNum + ".");

		// Repeats input prompt until user successfully guesses random number.
		do {
			System.out.print("Enter a number between 1-20: ");
			while (!keyboard.hasNextInt()) // Checks to see if the user input something other than a number.
			{
				System.out.print("Please only enter an integer between 1-20: ");
				keyboard.next();
			}

			choice = keyboard.nextInt();
			if ((choice > 20) || (choice < 1)) // Checks to see if number is out of range.
			{
				System.out.println();
				System.out.println("Please only enter a number between 1-20.");
			} else if (choice < randNum) // Checks to see if the guess is too low.
			{
				System.out.println("Too low.");
				System.out.println();
			} else if (choice > randNum) // Checks to see if the guess is too high.
			{
				System.out.println("Too high.");
				System.out.println();
			} else if (choice == randNum) // Checks to see if the guess is the same as the random number.
			{
				System.out.println();
				System.out.println("That's the number I was thinking of. Well done!");
				System.out.println("Thanks for playing.");
				System.out.println("Shutting down...");
			}
		} while (choice != randNum); // Checks if the condition is met.

	} // End of main method

} // End of class GuessingGame
