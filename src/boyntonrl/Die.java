/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 7 - Die Class
 * Author: Rock Boynton
 * Created: 10/12/2017
 */

package boyntonrl;

/**
 * Represents a die object that has a default 6 sides or a number of sides specified by the
 * constructor when called
 * @author boyntonrl
 */
public class Die {
    private int numSides = 6; // default die has 6 sides
    private int currentValue = (int) (Math.random() * numSides) + 1;

    /**
     * Constructor. Sets the number of sides of the die object.
     * @param numSides number of sides of the die
     */
    public Die(int numSides) {
        if (!(numSides > 100)){ // if number of sides inputted is less than 100...
            this.numSides = numSides; // number of sides set
        } // else default numSides will stay 6
    }

    /**
     * Accessor for numSides.
     * @return numSides
     */
    public int getNumSides() {
        return numSides;
    }

    /**
     * Accessor for currentValue.
     * @return currentValue
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * Rolls the die...sets it's current value to a new randomly chosen side.
     */
    public void roll(){
        currentValue = (int) (Math.random() * numSides) + 1;
    }
} // end Die class
