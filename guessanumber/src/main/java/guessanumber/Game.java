/**
 * 
 */
package guessanumber;

import java.util.Scanner;

/**
 * @author dragos
 *
 */
public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GuessANumber myRandomNumber = new GuessANumber();
		// System.out.println("My random number is: "+
		// myRandomNumber.getHiddenNumber());

		Scanner in = new Scanner(System.in);
		int userGuess = -1;
		String userInput = "";
		do {
			System.out.print("Please input an integer between 0 and 20: ");
			userInput = in.next();
			try {
				userGuess = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				System.out.println("Please input digits only.");
				continue;
			}
			if (userGuess < 0 || userGuess > 20) {
				System.out.println("The number must be between 0 and 20.");
			}
		} while (userGuess != myRandomNumber.getHiddenNumber());

		System.out.println("Congratulations!!!");

		in.close();
	}

}
