/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 7 - Warrior class
 * Author: Rock Boynton
 * Created: 10/12/2017
 */

package boyntonrl;

/**
 * Represents the Valiant Warrior (human player) from some generic tabletop game who attempts to
 * vanquish the Evil Mugwump (computer player) and save the Kingdom.
 */
public class Warrior {
    private int hitPoints; // health of Warrior
    private Die d20 = new Die(20);
    private Die d10 = new Die(10);
    private Die d8 = new Die(8);
    private Die d4 = new Die(4);

    /**
     * Constructor for the Valiant Warrior.
     * Calls rollHitPoints() to calculate starting HP.
     */
    public Warrior(){
        hitPoints = rollHitPoints();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Deducts damage from Mugwump's hit
     * @param hp hit points/damage
     */
    public void takeDamage(int hp){
        hitPoints -= hp;
    }

    /**
     * This method handles the attack logic for the Warrior
     * @param type the choice of attack: 1 for sword, 2 for shield
     * @return the amount of damage (hp) an attack has caused, 0 if the attack misses
     */
    public int attack(int type){

        int damage = 0;
        d20.roll();
        if (type == 1){ // if user chose to attack with his Trusty Sword
            if (d20.getCurrentValue() >= 12){ // attack hits if 20 sided die rolls 12 or greater
                for (int diceRolls = 2; diceRolls > 0; diceRolls--){ // rolls two 8-sided die to calculate damage
                    d8.roll();
                    damage += d8.getCurrentValue();
                } // end damage calculation for loop for Trusty Sword
                System.out.println("You swing your Trusty Sword and slash the Mugwump dealing " + damage +
                        " points of damage!");
            } else {
                System.out.println("You swing your sword and miss the foul creature!");
            }
        } else if (type == 2) { // else if user chose to attack with his Shield of Light
            if (d20.getCurrentValue() >= 8) { // attack hits if 20-sided die rolls 8 or greater
                d4.roll(); // rolls one 4-sided die to calculate attack points
                damage += d4.getCurrentValue();
                System.out.println("You hit the Mugwump with your shield of light for " + damage +
                        " points of damage!");
            } else {
                System.out.println("You lunge at the beast with your shield of light but miss!");
            }
        } // end if/else if statement

        return damage;
    }

    /**
     * Calculates Warrior's starting HP by rolling a 10-sided die six times.
     * @return hitPoints
     */
    private int rollHitPoints(){
        for (int diceRolls = 6; diceRolls > 0; diceRolls--){
            d10.roll();
            hitPoints += d10.getCurrentValue();
        }
        return hitPoints;
    }
} // end Warrior class
