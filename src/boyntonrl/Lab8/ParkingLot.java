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
    private int capacity;
    private boolean closed = false;
    private int minutesClosed;
    private double percentFull;
    private int numVehicles;

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
    }

    public String getColor() {
        return color;
    }

    /**
     * Called when a vehicle enters the lot.
     * //TODO what else?
     * @param time Number of minutes since the lot opened.
     */
    public void markVehicleEntry(int time) {
        //TODO
    }

    /**
     * Called when a vehicle exits the lot.
     * //TODO what else?
     * @param time Number of minutes since the lot opened.
     */
    public void markVehicleExit(int time) {
        //TODO
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
        return closed;
    }

    /**
     * Accessor for the time since the lot has been closed. //TODO find out if this resets to zero after it reopens
     * @return minutesClosed
     */
    public int closedMinutes() {
        return minutesClosed;
    }

    /**
     * Prints the color of the lot and the percentage of the lot that is occupied.
     */
    public void displayStatus() {
        System.out.printf("%s parking lot status: %.1f%%.", color, percentFull);
    }

} // end ParkingLot class
