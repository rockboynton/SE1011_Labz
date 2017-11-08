/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 10 - District class with ArrayLists
 * Author: Rock Boynton
 * Created: 11/9/2017
 */

package boyntonrl.Lab10;

import java.util.ArrayList;

/**
 * @author Rock Boynton
 *         Capture usage information for parking lots in a district.
 */
public class District {
    public static final int MAX_LOTS = 20; // Threshold of max possible number of lots in a district.
    private ArrayList<ParkingLot> lots = new ArrayList<>();
    private int closedMinutes;
    private int lastTime = 0;


    /**
     * Set up a district to contain a maximum of MAX_LOTS lots.
     */
    public District(){
    }

    /**
     * Adds a new parking lot to the district.
     * @param color color of the lot
     * @param capacity capacity of the lot
     * @return newIndex the new index for the lot
     */
    public int add(String color, int capacity){
        lots.add(new ParkingLot(color, capacity));
        return lots.size() - 1;
    }

    /**
     * Returns the lot at the given index.
     * @param index index of lot to be returned.
     *              Precondition that the index is valid.
     * @return districtStatus the lot at the given index.
     */
    public ParkingLot getLot(int index){
        return lots.get(index);
    }

    /**
     * Display status information for all lots.
     * See ParkingLot.toString() for the format for each.
     */
    public String toString() {
        String districtStatus = "District status:\n";
        for (int i = 0; i < (lots.size()); i++){
            districtStatus += getLot(i).toString() + "\n";
        }
        return districtStatus;
    }

    /**
     * Record a vehicle entering a given lot at a given time
     * @param lotNumber Number of lot, 0-MAX_LOTS
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleExit for the lot corresponding
     *                  to lotNumber (0 -> lot at index 0, 1 -> lot at index 2, 2 -> lot at index 2, etc.).
     *                  If lotNumber is out of range, the behavior is unspecified
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
        for (int i = 0; i < lots.size(); i++){
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
        while ( (i < lots.size()) && (getLot(i).isClosed()) ){
            i++;
        }
        return (i == lots.size());
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


