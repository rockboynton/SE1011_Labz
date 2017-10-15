package boyntonrl;

public class Lab07 {
    public static void main(String[] args) {
        // TODO

        // game loop

        // print the introduction and rules


        // initialize game


        // while neither combatant has lost all of their hit points, battle!

        // declare the winner

        // ask to play again

    }
    // Thank the user for playing your game
}

    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {
        // TODO
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
        // TODO
    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {
        // TODO
    }

    /**
     * Determines which combatant attacks first, displays and returns the result.
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        // TODO
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
    }
}
