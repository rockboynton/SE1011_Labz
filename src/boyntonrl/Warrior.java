package boyntonrl;

public class Warrior {
    private int hitPoints;
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


    public void takeDamage(int hp){
        //TODO
    }

    public int attack(int type){
        int attackPoints = 0;
        if (type == 1){ // If user chose to attack with his Trusty Sword
            d20.roll();
            if (d20.getCurrentValue() >= 12){ //Attack hits if 20 sided die rolls 12 or greater
                for (int diceRolls = 2; diceRolls > 0; diceRolls--){ // Rolls two 8-sided die to calculate attack points
                    d8.roll();
                    attackPoints += d8.getCurrentValue();
                } // end attack point calculation for loop
            } // end if attack hits
        } else if (type == 2) { // Else if user chose to attack with his Shield of Light
            d20.roll();
            if (d20.getCurrentValue() >= 8) { // Attack hits if 20-sided die rolls 8 or greater
                d4.roll(); // Rolls one 4-sided die to calculate attack points
                attackPoints += d4.getCurrentValue();
            } // end if attack hits
        } // end else if user attacked with his Shield of Light
        return attackPoints;
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
}
