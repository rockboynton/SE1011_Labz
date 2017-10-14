/*
 * SE1011-011
 * Fall 2017
 * Assignment: Lab 3 GUI
 * Author: Rock Boynton
 * Created: 9/21/2017
 */

package boyntonrl;

import javax.swing.*;

public class Lab3GUI {
    /**
     * This program asks the user if they are a single filer or married joint filer. It then asks for their expected
     * earned income for 2018 and displays the estimated taxes they will be required to pay by March 15, 2018.
     * This is the GUI implementation:
     */
    public static void main(String args[]) {
        String singleOrMarried = JOptionPane.showInputDialog(null, "Are you a single filer" +
                " or married joint filer? Input s for single or m for married: ");
        String strExpectedEarnedIncome = JOptionPane.showInputDialog(null, "What is your" +
                " expected earned income for 2018 expressed as a number with no commas? ");

        final int EXPECTED_EARNED_INCOME = Integer.parseInt(strExpectedEarnedIncome);
        final int[] TAX_BRACKET_INCOMES_SINGLE = {0, 9325, 37950, 91900, 191650, 416700, 418400, 418401};
        final double[] TAX_BRACKET_RATES = {0, .10, .15, .25, .28, .33, .35, .396};
        final int[] TAX_BRACKET_INCOMES_MARRIED = {0, 18650, 75900, 153100, 233350, 416700, 470700, 470701};
        final int NUMBER_OF_BRACKETS = TAX_BRACKET_RATES.length;

        double estimatedTax = 0; // Initialize total tax variable
        int index = 1; // Index used for arrays declared above

        int[] taxBracket = {};                                               //
        if (singleOrMarried.equals("s")) {                                   //
            taxBracket = TAX_BRACKET_INCOMES_SINGLE;                         //  Initialize new array to reference
        } else if (singleOrMarried.equals("m")) {                            //  tax bracket determined by user input
            taxBracket = TAX_BRACKET_INCOMES_MARRIED;                        //
        }                                                                    //

        while (index < NUMBER_OF_BRACKETS) { // Index will be out of range, defining end of loop
            if (index == NUMBER_OF_BRACKETS - 1) {  // Last tax bracket is a little tricky
                estimatedTax += (EXPECTED_EARNED_INCOME - taxBracket[index]) * TAX_BRACKET_RATES[index];
            } else if (EXPECTED_EARNED_INCOME < taxBracket[index]) {
                estimatedTax += (EXPECTED_EARNED_INCOME - taxBracket[index - 1]) * TAX_BRACKET_RATES[index]; // This condition would mean the income is less than than the
                break;                                                                                       //  next tax bracket, therefore add tax to total then break
            } else {
                estimatedTax += (taxBracket[index] - taxBracket[index - 1]) * TAX_BRACKET_RATES[index]; // Add taxed income in bracket to total
            }
            index ++; // Update index to move on to next tax bracket
        }
        JOptionPane.showMessageDialog(null, "Your estimated taxes that you will be required" +
                " to pay by March 15, 2018 is $" + estimatedTax);
    } // end main
} // end class Lab3GUI

