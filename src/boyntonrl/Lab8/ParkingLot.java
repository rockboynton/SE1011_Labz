/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 8 - ParkingLot class
 * Author: Rock Boynton
 * Created: 10/26/2017
 */

package boyntonrl.Lab8;

/**
 * @author Rock Boynton
 * Class to represent parking lots in a district
 * The key operations are markVehicleEntry and markVehicleExit which are called when vehicles enter or exit a lot.
 * These take a time parameter which is the number of minutes since the lot opened.
 */
public class ParkingLot {
    public static final double CLOSED_THRESHOLD = 80.0;
    private String color;
    private int capacity = 1;
    private int numVehicles;
    private int lastTime = 0;
    private int closedMinutes;


    /**
     * Sets up a parking lot with a color and a max capacity.
     * @param color Color of the parking lot.
     * @param capacity Capacity of the parking lot.
     */
    public ParkingLot(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
    }

    /**
     * Sets up a parking lot with only a max capacity.
     * @param capacity Capacity of the parking lot.
     */
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.color = "test";
    }

    public String getColor() {
        return color;
    }

    /**
     * Record a vehicle entering lot at a given time.
     * @param time Entry time in minutes since all lots were opened.
     *             Does nothing if time is less than previously set time.
     */
    public void markVehicleEntry(int time) {
        if (time >= lastTime) {
            if (isClosed()) {
                closedMinutes += (time - lastTime);
            }
            numVehicles++;
            lastTime = time;
        }
//        addMinutesClosed(time);
    }


    /**
     * Record a vehicle exiting lot at a given time.
     * @param time Entry time in minutes since all lots were opened.
     *             Does nothing if time is less than previously set time.
     */
    public void markVehicleExit(int time) {
        if (time >= lastTime) {
            if (isClosed()) {
                closedMinutes += (time - lastTime);
            }
            numVehicles--;
            lastTime = time;
        }
    }

    /**
     * Accessor for the number of vehicles in the lot at the time the method is called.
     * @return numVehicles
     */
    public int vehiclesInLot() {
        return numVehicles;
    }

    /**
     * Determines whether the lot has reached the max threshold as defined by CLOSED_THRESHOLD
     * @return true if lot is closed, false if lot is open.
     */
    public boolean isClosed() {
        return (percentFull() >= CLOSED_THRESHOLD);
    }

    /**
     * Accessor for the time since the lot has been closed.
     * @return minutesClosed
     */
    public int closedMinutes() {
        return closedMinutes;
    }

    private double percentFull() {
        return ((double) numVehicles/capacity) * 100;
    }
    /**
     * Displays the parking lot status with its color and
     */
    public void displayStatus() {
        if (!isClosed()) {
            if ((percentFull() % 1) == 0) {
                System.out.printf("%s parking lot status: %.0f%% \n", color, percentFull());
            } else {
                System.out.printf("%s parking lot status: %.1f%% \n", color, percentFull());
            }
        } else {
            System.out.println(color + " parking lot status: CLOSED");
        }
    }
} // end ParkingLot class
