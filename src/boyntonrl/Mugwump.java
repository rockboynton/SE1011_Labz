/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 7 - Mugwump class
 * Author: Rock Boynton
 * Created: 10/12/2017
 */

package boyntonrl;

/**
 * Represents the Evil Mugwump (computer player) from some generic tabletop game. The Warrior (human) will attempt
 * to vanquish the evil scourge and save the kingdom.
 * @author boyntonrl
 */
public class Mugwump {
    private int hitPoints; // health of Mugwump
    private int maxHitPoints; // starting health of Mugwump
    private Die d100 = new Die(100);
    private Die d20 = new Die(20);
    private Die d10 = new Die(10);
    private Die d6 = new Die(6);

    /**
     * Constructor for the Mugwump
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
        int regen = 0;
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
                System.out.println("The Mugwump chomps down on you with his Fangs of Death dealing " + damage +
                        " points of damage!");
            } else {
                System.out.println("The Mugwump snaps at you and misses!");
            }
        } else if (attackType == 2){ // else if AI chose to attack with their Razor Sharp Claws
             if (d20.getCurrentValue() >= 12) { // attack hits if they roll 12 or greater
                 for (int diceRolls = 2; diceRolls > 0; diceRolls--) { // rolls two 6-sided dice to calculate damage
                     d6.roll();
                     damage += d6.getCurrentValue();
                 } // end damage calculation for loop for Razor Sharp Claws
                 System.out.println("The Mugwump scratches at you with his Razor Sharp Claws for " + damage +
                         " points of damage!");
             } else {
                 System.out.println("The Mugwump swipes at you but you dodged it!");
             }
        } else if (attackType == 3){ // else if ai chose to lick their wounds
            d6.roll();
            if ((hitPoints + d6.getCurrentValue()) <= maxHitPoints){ // may not exceed initial health
                regen = d6.getCurrentValue();
                hitPoints += regen;
            } else {
                hitPoints = maxHitPoints;
            }
            System.out.println("The Mugwump cowered away and licked his wounds gaining " + regen +
                    " points of health!");
        }
        // return the damage
        return damage;
    }

    /**
     * Calculates Warrior's starting HP by rolling a 10-sided die six times
     * @return hitPoints
     */
    private int rollHitPoints(){
        for (int diceRolls = 10; diceRolls > 0; diceRolls--){ // rolls ten 10-sided die to determine staring hp
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
} // end Mugwump class
