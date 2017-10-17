package boyntonrl;

import java.util.*;

public class Lab07 {
    public static void main(String[] args) {
        // TODO
        Scanner in = new Scanner(System.in);
        String winner;
        // game loop
        do {
            // print the introduction and rules
            intro();
            // initialize game
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            report(warrior, mugwump);

            // while neither combatant has lost all of their hit points, battle!
            while (warrior.getHitPoints() > 0 && mugwump.getHitPoints() > 0){

            }

            // declare the winner

            // ask to play again
            System.out.println("Thank you for playing Battle Simulator 3000!");
        } while (playAgain(in));
    }
    // Thank the user for playing your game

    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {
        System.out.println("Welcome to Battle Simulator 3000! The world's more low tech battle simulator!");
        System.out.println("You are a Valiant Warrior defending your humble village from an evil Mugwump! \n" +
                "Fight bravely, or the citizens of your town will be the mugwump's dinner!");
        System.out.println("You have your Trusty Sword, which deals decent damage, but can be tough to hit with " +
                "sometimes. You also have your Shield of Light, which is not as strong as your sword, but is " +
                "easier to deal damage with");
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

        // attack!

    }

    /**
     * This method reports the status of the combatants before each new round
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */
    private static void report(Warrior warrior, Mugwump mugwump) {
        System.out.println("Warrior HP: " + warrior.getHitPoints());
        System.out.println("Mugwump HP: " + mugwump.getHitPoints());
    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {
        //TODO
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("How would you like to attack? \n" +
                    "1. Your Trusty Sword\n" +
                    "2. Your Shield of Light\n" +
                    "Enter choice: ")
            if (in.next())
                return in.nextInt();
        }
    }

    /**
     * Determines which combatant attacks first, displays and returns the result.
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        Die d10 = new Die(10);
        boolean tie = true;
        int winner = 0;
        int warriorRoll;
        int mugwumpRoll;
        while (tie){
            d10.roll();
            warriorRoll = d10.getCurrentValue();
            d10.roll();
            mugwumpRoll = d10.getCurrentValue();
            if (warriorRoll > mugwumpRoll){
                winner = 1;
                tie = false;
            } else if (mugwumpRoll > warriorRoll){
                winner = 2;
                tie = false;
            }
        }
        return winner;
    }

    /**
     * This method declares the winner of the epic battle
     * @param winner the name of the winner of the epic battle
     */
    private static void victory(String winner) {
        // TODO
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
        }
        return playAgain;
    }
}
