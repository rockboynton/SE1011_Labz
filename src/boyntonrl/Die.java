/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 7 - Die Class
 * Author: Rock Boynton
 * Created: 10/12/2017
 */

package boyntonrl;

public class Die {
    private int numSides;
    private int currentValue = (int) (Math.random() * numSides) + 1;

    /**
     * Constructor. Sets the number of sides of the die object.
     * @param numSides number of sides of the die
     */
    public Die(int numSides){
        this.numSides = numSides;
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
}
