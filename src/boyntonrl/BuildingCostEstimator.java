/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 6 - Building Cost Estimator
 * Author: Rock Boynton
 * Created: 10/12/2017
 */

package boyntonrl;

/**
 * Class to estimate of the cost of building a house
 * @author boyntonrl
 */
public class BuildingCostEstimator {

    private static final int COST_PER_SQUARE_FOOT = 130;
    private static final int COST_PER_FULL_BATH = 15000;
    private static final int COST_PER_HALF_BATH = 7000;
    private static final int COST_PER_BEDROOM = 3000;
    private static final int COST_PER_WINDOW = 800;
    private static final int COST_PER_GARAGE_STALL = 8000;

    private double numGarages;
    private int numFullBaths;
    private int numHalfBaths;
    private int numBedrooms;
    private int numWindows;
    private int sqFeet;

    public void setSquareFeet(int sqFeet){
        this.sqFeet = sqFeet;
    }
    public void setNumFullBaths(int numFullBaths){
        this.numFullBaths = numFullBaths;
    }
    public void setNumHalfBaths(int numHalfBaths){
        this.numHalfBaths = numHalfBaths;
    }
    public void setNumBedrooms(int numBedrooms){
        this.numBedrooms = numBedrooms;
    }
    public void setNumWindows(int numWindows){
        this.numWindows = numWindows;
    }
    public void setNumGarages(double numGarages){
        this.numGarages = numGarages;
    }


    public int getNumFullBaths(){
        return numFullBaths;
    }
    public int getNumHalfBaths(){
        return numHalfBaths;
    }
    public int getNumBedrooms(){
        return numBedrooms;
    }
    public int getNumWindows(){
        return numWindows;
    }
    public int getSquareFeet(){
        return sqFeet;
    }
    public double getNumGarages(){
        return numGarages;
    }

    /**
     * Method to estimate of the cost of building a house
     * @return the total cost to build
     */
    public double costToBuild(){
        return (sqFeet * COST_PER_SQUARE_FOOT)       +
                (numFullBaths * COST_PER_FULL_BATH)  +
                (numHalfBaths * COST_PER_HALF_BATH)  +
                (numBedrooms * COST_PER_BEDROOM)     +
                (numWindows * COST_PER_WINDOW)       +
                (numGarages * COST_PER_GARAGE_STALL);

    }
}

//test4.2