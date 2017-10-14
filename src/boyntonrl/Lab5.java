/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 5 - Estimating π
 * Author: Rock Boynton
 * Created: 10/5/2017
 */

package boyntonrl;

import java.util.*;

/**
 * This program estimates the value of π by determining the ratio of the number of randomly generated points
 * that appear in a quarter of a unit circle, to the number of points that appear in the quarter of a unit square.
 * 1. Asks the user to enter the number of randomly generated points to be used to estimate π.
 * 2. Generates the desired number of random points using the Random class.
 * 3. Calculates an estimate for ππ based on the generated points.
 * 4. Determines the number of correct digits in the estimate.
 * 5. Displays the estimated value and the number of correct digits.
 * 6. Asks the user if they would like to generate a new estimate for π.
 * 7. If the user enters y or Y, all of the steps above are repeated. If the user enters n or N, the program displays
 *    the best estimate of π generated while the program ran and then exits.
 */
public class Lab5 {
    public static void main(String args[]){
        Random r = new Random();

        int aNum;
        double underCirclePercent;
        double currentEstimatedPi;
        double bestEstimatedPi = 0;
        int correctDigits;
        int underCircle;
        int x, y; // used to generate points (x, y)

        // summary for user
        System.out.println("This program estimates the value of π by determining the ratio of the number of " +
                "randomly generated points that appear in a quarter of a unit circle, to the number of points " +
                "that appear in the quarter of a unit square.");

        do {
            underCircle = 0;
            aNum = getValidNum();
            for (int i = 0; i < aNum; i++) {
                x = r.nextInt(aNum);
                y = r.nextInt(aNum);
                if ((Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(aNum, 2)) {
                    underCircle++;
                }
            }
            underCirclePercent = (double) underCircle / aNum;
            currentEstimatedPi = underCirclePercent * 4; // π = 4 * A, where A is area under curve of 1/4 unit circle
            correctDigits = correctDigitsOfPi(currentEstimatedPi); // calls method to determine number of correct digits
            bestEstimatedPi = bestPiEstimate(currentEstimatedPi, bestEstimatedPi); // calls method to find new best
            System.out.println("π is estimated to be: " + currentEstimatedPi + "; number of correct digits: " +
                    correctDigits);
            System.out.println();
            //call method to determine if user wants to generate a new estimate
        } while (generateAgain()); //end do-while loop

        System.out.println("The best estimate of π was " + bestEstimatedPi);
    } // end main

    /**
     * Method to get a valid integer from the user
     * Re-prompts user if input is invalid.
     * @return valid number as an int
     */
    public static int getValidNum(){
        boolean validInt = false;
        long aNumLong; //used to determine if user-inputted number is too large to be an int
        int aNum;
        Scanner input = new Scanner (System.in);
        String aNumStr = "";
        while (!validInt) {
            System.out.print("Enter the number of randomly generated points you wish to use" +
                    " to estimate π: ");
            aNumStr = input.next();
            validInt = true; // flag
            int i;
            for (i = 0; i < aNumStr.length() && validInt; i++){
                if (!Character.isDigit(aNumStr.charAt(i))){
                    System.out.println("Sorry, I don't understand..."); // if user input is not a digit
                    validInt = false; // re-prompt user
                }
            }
            if (i == aNumStr.length() && validInt){ // if string contained all digits...
                aNumLong = Long.parseLong(aNumStr);
                if (aNumLong > Integer.MAX_VALUE){ // ...but was too big to be an int
                    validInt = false; // flag
                    System.out.println("Integer value too large...try a smaller number."); //re-prompt
                }
            }
        }
        aNum = Integer.parseInt(aNumStr); //convert string to int
        return aNum; // return valid number as an int
    } // end getValidNum

    /**
     * Determines whether user wants to generate a new estimate for pi.
     * Re-prompts user if input is invalid.
     * @return true if they want to generate a new estimate, false otherwise.
     */
    public static boolean generateAgain(){
        Scanner input = new Scanner (System.in);
        String yOrN;
        boolean isYorN = false;
        boolean generateAgain = false;
        while (!isYorN) {
            System.out.print("Do you want to generate a new estimate for π? (Y for yes) or (N for no): ");
            yOrN = input.next();
            if (yOrN.equalsIgnoreCase("Y") || yOrN.equalsIgnoreCase("N")) {
                isYorN = true;
            } else {
                System.out.println("Sorry I don't understand..."); // re-prompt
                System.out.println();
            }
            if (yOrN.equalsIgnoreCase("Y")){
                generateAgain = true;
            }
        }
        System.out.println();
        return generateAgain; // return true if they want to generate a new estimate, false otherwise.
    } // end generateAgain

    /**
     * Determines whether the current estimate of pi is the best estimate the user has gotten
     * since the program began (most digits the same as the actual Math.PI constant).
     * @param currentEstimatedPi Pi estimate based on user inputted number of generated points
     * @param bestEstimatedPi The best estimate of pi so far (since the program began)
     * @return Updated best estimate of pi (determined by most digits matching actual Math.PI constant)
     */
    public static double bestPiEstimate(double currentEstimatedPi, double bestEstimatedPi){
        int currentCorrectDigits = correctDigitsOfPi(currentEstimatedPi);
        int bestCorrectDigits = correctDigitsOfPi(bestEstimatedPi);

        if (currentCorrectDigits >= bestCorrectDigits){ // if current estimate has more or the same correct digits...
            bestEstimatedPi = currentEstimatedPi; // current estimate becomes new best estimate
        }
        return bestEstimatedPi; // returns updated best estimate of pi
    } // end bestPiEstimate

    /**
     * Determines the number of digits from the estimated pi that match with the actual Math.Pi constant.
     * @param piEstimate Estimated pi from randomly generated points
     * @return the number of matching digits with Math.PI constant as an integer
     */
    public static int correctDigitsOfPi(double piEstimate){
        String piEstimateStr = Double.toString(piEstimate); // converts doubles to strings in order to compare them
        String REAL_PI = Double.toString(Math.PI);
        int correctDigits = 0;
        boolean different = false; //flag

        for (int i = 0; i < piEstimateStr.length() && !different; i++){
            if (piEstimateStr.charAt(i) == REAL_PI.charAt(i)){
                if (piEstimateStr.charAt(i) != '.'){ //ignores the decimal point in doubles
                    correctDigits++;
                }
            } else {
                different = true;
            }
        }
        return correctDigits; // return the number of matching digits with pi
    } // end correctDigitsOfPi
} // end class Lab5
