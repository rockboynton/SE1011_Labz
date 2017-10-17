/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 7 - Mugwump class
 * Author: Rock Boynton
 * Created: 10/12/2017
 */

package boyntonrl;

public class Mugwump {
    private int hitPoints;
    private int maxHitPoints;
    private Die d100 = new Die(100);
    private Die d20 = new Die(20);
    private Die d10 = new Die(10);
    private Die d6 = new Die(6);

    // add methods here

    /**
     * Constructor for the Evil Mugwump
     * Calls rollHitPoints() to calculate starting HP
     */
    public Mugwump(){
        hitPoints = rollHitPoints();
        maxHitPoints = hitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Deducts damage from Warrior's hit
     * @param hp hit points/damage
     */
    public void takeDamage(int hp){
        hitPoints -= hp;
    }

    /**
     * This method handles the attack logic for the Mugwump
     * @return the amount of damage an attack has caused, 0 if the attack misses or the Mugwump heals
     */
    public int attack() {
        int damage = 0;
        // get attack type from ai
        int attackType = ai();
        // roll attack die
        d20.roll();

        // determine results of attack
        if (attackType == 1) { // if the AI chose to attack with their Fangs of Death
            if (d20.getCurrentValue() >= 16) { // attack hits if they roll 16 or greater
                for (int diceRolls = 3; diceRolls > 0; diceRolls--) { // rolls three 6-sided dice to calculate damage
                    d6.roll();
                    damage += d6.getCurrentValue();
                } // end damage calculation for loop for Fangs of Death
            } // end if attack hits
        } else if (attackType == 2){ // else if AI chose to attack with their Razor Sharp Claws
             if (d20.getCurrentValue() >= 12) { // attack hits if they roll 12 or greater
                 for (int diceRolls = 2; diceRolls > 0; diceRolls--) { // rolls two 6-sided dice to calculate damage
                     d6.roll();
                     damage += d6.getCurrentValue();
                 } // end damage calculation for loop for Razor Sharp Claws
             } // end if attack hits
        } // end if/else if statement

        // return the damage
        return damage;

    }

    /**
     * Calculates Warrior's starting HP by rolling a 10-sided die six times
     * @return hitPoints
     */
    private int rollHitPoints(){
        for (int diceRolls = 10; diceRolls > 0; diceRolls--){
            d10.roll();
            hitPoints += d10.getCurrentValue();
        }
        return hitPoints;
    }

    /**
     * This method determines what action the Mugwump performs
     * @return 1 for a Claw attack, 2 for a Bite, and 3 if the Mugwump licks its wounds, instead
     */
    private int ai() {
        int attackType = 0;
        d100.roll();
        int rollResult = d100.getCurrentValue();
        if (rollResult <= 75){
            attackType = 1;
        } else if (rollResult <= 90){
            attackType = 2;
        } else if (rollResult <= 100){
            attackType = 3;
        }
        return attackType;
    }
}
