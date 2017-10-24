/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 7 - Lab07 Class with main
 * Author: Rock Boynton
 * Created: 10/19/2017
 */

package boyntonrl;

import java.util.*;

/**
 * Driver for a generic tabletop game where a Valiant Warrior (human player) from some generic tabletop game
 * attempts to vanquish the Evil Mugwump (computer player) and save the Kingdom.
 */
public class Lab07 {
    public static void main(String[] args) {
        // TODO
        Scanner in = new Scanner(System.in);
        // game loop
        do {
            String winner = "none";
            // print the introduction and rules
            intro();
            // initialize game
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            // while neither combatant has lost all of their hit points, battle!
            while (winner.equals("none")){// TODO
                report(warrior, mugwump);
                System.out.println();
                winner = battle(warrior, mugwump, in);
            }
            // declare the winner
            victory(winner);
            // ask to play again
        } while (playAgain(in));
        // Thank the user for playing your game
        System.out.print("Thank you for playing Battle Simulator 3000!");
    } // end main


    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {
        System.out.println("Welcome to Battle Simulator 3000! The world's more low tech battle simulator!");
        System.out.println("You are a Valiant Warrior defending your humble village from an evil Mugwump! \n" +
                "Fight bravely, or the citizens of your town will be the mugwump's dinner!");
        System.out.println("You have your Trusty Sword, which deals decent damage, but can be tough to hit with " +
                "sometimes.\nYou also have your Shield of Light, which is not as strong as your sword, but is " +
                "easier to deal damage with.");
        System.out.println("Let the epic battle begin!");
    }

    /**
     * This method handles the battle logic for the game.
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     * @return The name of the victor, or "none", if the battle is still raging on
     */
    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in) {
        // determine who attacks first
        String winner = "none";
        int player = initiative();
        int choice;
        int damage;
        int half = 1; //count which half the round is (1 for first half, 2 for second half)
        // attack!
        while (half <= 2 && winner.equals("none")) { //while 1st half or second half and winner not yet declared
            if (player == 1) {
                choice = attackChoice(in);
                damage = warrior.attack(choice);
                mugwump.takeDamage(damage);
                half++;
                player = 2; // if warrior was the first player of the round, mugwump will be the next player
            } else if (player == 2) {
                damage = mugwump.attack();
                warrior.takeDamage(damage);
                half++;
                player = 1; //if mugwump is the first player of the round, warrior will be the next player
            }
            if (warrior.getHitPoints() <= 0) {
                winner = "Mugwump";
            } else if (mugwump.getHitPoints() <= 0) {
                winner = "Warrior";
            }
        } // end while loop for round
        return winner;
    }

    /**
     * This method reports the status of the combatants before each new round
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */
    private static void report(Warrior warrior, Mugwump mugwump) {
        System.out.println();
        System.out.println("Warrior HP: " + warrior.getHitPoints());
        System.out.println("Mugwump HP: " + mugwump.getHitPoints());
    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {
        String options = "How would you like to attack? \n" +
                "1. Your Trusty Sword\n" +
                "2. Your Shield of Light\n" +
                "Enter choice (1 or 2): ";
        int choice;
        do {
            System.out.print(options);
            while (!in.hasNextInt()) { // while the input is not an int...
                System.out.println("Invalid input"); //...input is invalid
                System.out.print(options); // re-prompt
                in.next();
            }
            choice = in.nextInt();
            if (!(choice == 1 || choice == 2)){ // if input is not one of the choices...
                System.out.println("Invalid input");// ...input is invalid so re-prompt
            }
        } while (!(choice == 1 || choice == 2));
        return choice;
    }

    /**
     * Determines which combatant attacks first, displays and returns the result.
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        Die d10 = new Die(10);
        boolean tie = true;
        int starter = 0;
        int warriorRoll;
        int mugwumpRoll;
        while (tie){
            d10.roll();
            warriorRoll = d10.getCurrentValue();
            d10.roll();
            mugwumpRoll = d10.getCurrentValue();
            if (warriorRoll > mugwumpRoll){
                starter = 1;
                System.out.println("The Warrior attacks first!");
                tie = false;
            } else if (mugwumpRoll > warriorRoll){
                starter = 2;
                System.out.println("The Mugwump attacks first!");
                tie = false;
            }
        }
        return starter;
    }

    /**
     * This method declares the winner of the epic battle
     * @param winner the name of the winner of the epic battle
     */
    private static void victory(String winner) {
        // TODO
        if (winner.equals("Warrior")) {
            System.out.println("You won the battle! The citizens cheer and invite you back to town for a feast" +
                             " as thanks for saving their lives (again)!");
        } else if (winner.equals("Mugwump")){
            System.out.println("You lost the battle. The citizens of your town were eaten by the evil Mugwump.");
        }
    }

    /**
     * This method asks the user if they would like to play again
     * @param in Scanner
     * @return true if yes, false otherwise
     */
    private static boolean playAgain(Scanner in) {
        // TODO
        boolean playAgain = false;
        String input;
        System.out.print("Would you like to play again? ");
        input = in.next();
        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
            playAgain = true;
            System.out.println();
        }
        return playAgain;
    }
}
