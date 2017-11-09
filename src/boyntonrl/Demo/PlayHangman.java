/*
    SE1011
    Fall 2017
    Class Exercise -- Hangman
    William Retert
    11/7/17
 */
package boyntonrl.Demo;

import java.util.Random;
import java.util.Scanner;

/**
 * Driver to play a game of hangman using the Hangman class
 * and the console.  For the rules of the game, see the
 * Hangman class.
 */
public class PlayHangman {
    public static void main(String args[]){

        String wordList[] = { "hello" };
        Random randomPicker = new Random();
        Scanner input = new Scanner(System.in);

        do{
            Hangman hangmanGame = new Hangman(wordList[randomPicker.nextInt(wordList.length)]);

            while(!hangmanGame.hasLost() && !hangmanGame.hasWon()){

                System.out.println("The word: " + hangmanGame);
                System.out.print("Guess a letter: ");
                char letter = input.next().charAt(0);

                if(hangmanGame.makeGuess(letter)){
                    System.out.println("Correct!");
                } else {
                    System.out.println("Oh no!  You were soo close.");
                }
            }

            System.out.println("The word: " + hangmanGame);
            System.out.print("Game over ");

            if(hangmanGame.hasWon()){
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }

        }while(playAgain(input));
    }

    /**
     * Prompt the user for either "y" or "n"  Continue doing so
     * until one or the other is entered (case insensitive)
     * @param input Scanner used to read user input
     * @return true iff the user entered "y"
     */
    private static boolean playAgain(Scanner input) {
        String again;
        do {
            System.out.print("Play again? (y/n) ");
            again = input.next();
            again = again.toLowerCase();
        } while (!again.equals("y") && !again.equals("n"));
        return again.equals("y");
    }
}
