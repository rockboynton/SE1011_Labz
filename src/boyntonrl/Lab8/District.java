/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 8 - District class
 * Author: Rock Boynton
 * Created: 10/26/2017
 */

package boyntonrl.Lab8;

/**
 * @author Rock Boynton
 *         <p/>
 *         Capture usage information for parking lots in a district.
 */
public class District {
    public static final int MAX_LOTS = 20;
    private ParkingLot[] lots = new ParkingLot[MAX_LOTS];
    private int closedMinutes;
    private int lastTime = 0;
    private int numLots;


    /**
     * Set up a district with up to MAX_LOTS parking lots.
     */
    public District(){

    }

    /**
     * Adds a new parking lot to the district.
     * @param color
     * @param capacity
     * @return
     */
    public int add(String color, int capacity){
        int newIndex   = numLots;
        lots[newIndex] = new ParkingLot(color, capacity);
        numLots++;
        return newIndex;
    }

    /**
     * Returns the lot at the given index.
     * @param index index of lot to be returned.
     *              Precondition that the index is valid.
     * @return
     */
    public ParkingLot getLot(int index){
        return lots[index];
    }

    /**
     * Display status information for all lots.
     * See ParkingLot.displayStatus for the format for each.
     */
    public String toString() {
        String districtStatus = "District status:\n";
        for (int i = 0; i < (numLots); i++){
            districtStatus += getLot(i).toString() + "\n";
        }
        return districtStatus;
    }

    /**
     * Record a vehicle entering a given lot at a given time
     * @param lotNumber Number of lot, 1-3
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleEntry for the lot corresponding
     *                  to lotNumber (1 -> lot1, 2 -> lot2, 3 -> lot3).
     *                  If lotNumber is out of range, the behavior is unspecified.
     */
    public void markVehicleEntry(int lotNumber, int time) {
        if (time >= lastTime) {
            if (isClosed()) {
                closedMinutes += (time - lastTime);
            }
            getLot(lotNumber).markVehicleEntry(time);
            lastTime = time;
//            closedMinutes(time);
        }
    }

    public int vehiclesParkedInDistrict(){
        int numVehicles = 0;
        for (int i = 0; i < numLots; i++){
            numVehicles += getLot(i).vehiclesInLot();
        }
        return numVehicles;
    }

    /**
     * Record a vehicle exiting a given lot at a given time.
     * @param lotNumber Number of lot, 0-MAX_LOTS
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleExit for the lot corresponding
     *                  to lotNumber (0 -> lot at index 0, 1 -> lot at index 2, 2 -> lot at index 2, etc.).
     *                  If lotNumber is out of range, the behavior is unspecified
     */
    public void markVehicleExit(int lotNumber, int time) {
        if (time >= lastTime) {
            if (isClosed()) {
                closedMinutes += (time - lastTime);
            }
            getLot(lotNumber).markVehicleExit(time);
            lastTime = time;
//            closedMinutes(time);
        }
    }

    /**
     * Checks the status of all lots in the district
     * @return true if and only if all lots are closed in the district
     */
    public boolean isClosed() {
        int i = 0;
        while ( (i < numLots) && (getLot(i).isClosed()) ){
            i++;
        }
        return (i == numLots);
    }

    /**
     * Computes the time all lots were reported as closed.
     *
     * @return number of minutes all three lots were closed
     */
    public int closedMinutes() {
        return closedMinutes;
    }
}

