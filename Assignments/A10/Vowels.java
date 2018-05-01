/**
 *              Team Assignment 10, CPSC 233
 * Class:       Vowels.java
 * Purpose:     The class contains a single static method that determines the 
 *              number of vowels in a string- with a  twist: the use of control 
 *              structures is not allowed. The method must rely purely on 
 *              recursion to accomplish this.
 *
 * @author      T01-3
 * Date:        March 30, 2018
 */
public class Vowels {

    public static int numOfVowels(String str) {

        // Terminating condition is when String is empty. This condition is 
        // guaranteed to be reached because each successive call to numOfVowels
        // will use a String where first letter has been removed
        if (str.length() < 1) {

            return 0;

        } else {
            
            // First letter of parameter is checked to see if it is a vowel. If 
            // it is, then return is increased by 1. Recursive call is passed 
            // original String, with the first letter removed. Process repeats
            // until every letter has been checked and removed from String.
            
            if ("aeiou".contains(str.toLowerCase().charAt(0) + "")) {
                return 1 + numOfVowels(str.substring(1));
            } else {
                return numOfVowels(str.substring(1));
            }

        } // end if-else

    } // end numOfVowels

} // end class Vowels
