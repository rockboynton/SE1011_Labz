/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 4
 * Author: Rock Boynton
 * Created: 9/28/2017
 */

package boyntonrl.Lab4;

import java.util.*;
import java.lang.*;

public class Lab4 {
    public static void main(String args []) {
        /*
         * This is program runs a game where the user has an uncle close to death and they get to choose between
         * receiving an their inheritance in one of two ways:
         * 1. Starting with a given amount (such as $5000), he will add that amount to their total inheritance every week, or
         * 2. Starting with one penny, he will double their inheritance every week.
         * Option 2 will always outpace option 1 at some point in the future, but the game is when picking which will be
         * a better financial decision for you... will option 2 yield more before your uncle dies?
         */

        int WEEKS_TILL_DEATH_MAX = 40;
        int LINEAR_STARTING_AMOUNT_MAX = 5000;
        double ONE_CENT = 0.01;

        Scanner input = new Scanner(System.in);

        double startingAmountLinear;
        double linearTotal;
        double exponentialTotal;
        double inheritanceDifference;
        int weeksTillDeath;
        int weeksLeftLoop;
        int weeks;
        int playAgain;
        int choice;

        do {
            weeksTillDeath = (int) (Math.random() * WEEKS_TILL_DEATH_MAX); // assigning var to a random value between 0 and WEEKS_TILL_DEATH_MAX
            startingAmountLinear = (Math.random() * LINEAR_STARTING_AMOUNT_MAX); // assigning var to a random value between 0 and LINEAR_STARTING_AMOUNT_MAX
            linearTotal = startingAmountLinear;
            exponentialTotal  = ONE_CENT;
            weeksLeftLoop = weeksTillDeath - 1; // subtract 1 so it doesn't print the week the uncle dies
            weeks = 1;
            System.out.print("Suppose you have a wealthy uncle who gives you two options for your inheritance. He will" +
                    " add to your inheritance every weeks until he dies according to one of two schemes:\n" +
                    "1. Starting with a given amount ($0-5000), he will add that amount to your total inheritance every weeks, or\n" +
                    "2. Starting with one penny, he will double your inheritance every weeks.\n" +
                    "Enter which option you would prefer: ");
            choice = input.nextInt(); //determines whether user choose exponential or linear
            while (exponentialTotal < linearTotal && weeksLeftLoop > 0) { //loop runs until either exponential total surpasses linear total or their uncle dies
                System.out.format("Week %2d Linear: $%,.2f, Exponential: $%,.2f\n", weeks, linearTotal, exponentialTotal);
                linearTotal += startingAmountLinear;
                exponentialTotal *= 2; //doubles every week
                weeks++; //increment weeks number that is display
                weeksLeftLoop--; //decrement weeks left in loop  end while loop
            }
            if (weeksLeftLoop > 0){ //if the exponential total already surpassed the linear total...
                System.out.format("Week %2d Linear: $%,.2f, Exponential: $%,.2f\n", weeks, linearTotal, exponentialTotal);
                for (int weeksLeft = weeksLeftLoop; weeksLeft > 0; weeksLeft--){ //this calculates the exponential total for the rest of the weeks until the uncle dies
                    exponentialTotal *= 2;
                }
            } //end if statement
            System.out.println();
            inheritanceDifference = Math.abs(linearTotal - exponentialTotal);
            if ((choice == 1 && linearTotal > exponentialTotal) || (choice == 2 && linearTotal < exponentialTotal)) { //if the user "won"
                System.out.format("Your uncle dies after %2d weeks so you got lucky and " +
                        "ended up with an extra $%,.2f", weeksTillDeath, inheritanceDifference);
            } else { // if the user "lost"
                System.out.format("Your uncle dies after %2d weeks so you got unlucky and " +
                        "missed out on an extra $%,.2f", weeksTillDeath, inheritanceDifference);
            } //end if statement
            System.out.println(); //skip line
            System.out.println("Do you want to play again? (1 for yes) or (0 for no): ");
            playAgain = input.nextInt();
            System.out.println(); //skip line
        } while (playAgain == 1); //determines if the user wants to play again, otherwise end do while loop
    } //end main
} // end class Lab4
