//Raunak Chowdhury
//APCS1 pd2
//HW56 -- His Toe Grammar
//2017-12-18

/*====================================================================
   An AP-style question, for practice:
   Write the StatPrinter class below. The StatPrinter Object receives an
   ArrayList of nonnegative integers, then builds a frequency ArrayList in which
   the index values are the data and the entry at the index is the frequency.
   For example, if the received data is    2,3,2,5,1,3    then the frequency
   list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
   2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
   the maximum value of the data.

   A capability of the class is to calculate local modes from the frequency
   list. A local mode is a value that is greater than the value at index-1
   and greater than the value at index+1. A local mode is never at the end
   points of the list. For example, if the frequency list is [1,2,1,4,2,3,5]
   then the local modes are 2 and 4.

   This class is also capable of printing a histogram of the frequencies, using
   '*'s to indicate a frequency amount. To print a histogram, the user specifies
   the longest sequence of '*'s used and then all other values are printed in
   proportion to this value. For example, if longest bar is 10 and the frequency
   list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

   0 : **
   1 : ****
   2 : **
   3 : ********
   4 : ****
   5 : ******
   6 : **********

   For each method, state run time efficiency using Big O notation.

   Tips for Awesome:
* Keys to Success are so named for a reason.
* Look over all fxns, think a bit, decide which to tackle first.
   ( Simplest?  Prerequisites? . . . )
* Develop 1 fxn at a time, test it, then move to next.
* For coding today, what extra code do you need to get past compiler?
   ====================================================================*/

import java.util.ArrayList;


public class StatPrinter {

// instance variable for frequencies of each integer in input ArrayList
private ArrayList <Integer> _frequency;


//*************** QUESTION 02 **************************
//precond:  data.size() > 0, each entry b/t 0,100 inclusive
//postcond: _frequency.size() set to max(data) + 1
//          _frequency.get(i) returns frequency of i in data
//eg, for data [2,3,2,5,2,3]
//  _frequency would be [0,0,3,2,0,1]
public StatPrinter( ArrayList <Integer> data ) // O(n^2)
{
        _frequency = new ArrayList <Integer>();
        int totalOccurences = 0;
        /* YOUR IMPLEMENTATION HERE */
        for (int i = 0; i < data.size() && i <= max(data); i++) {
                for (int x : data) {
                        if (x == i) {
                                totalOccurences += 1; //add up the number of occurences in data
                        }
                }
                _frequency.add(totalOccurences); //append it to the end of the array
                totalOccurences = 0; //reset for the next pass
        }
}

/* ===========FOR TESTING =========*/
public ArrayList <Integer> get(){
        return _frequency;
}
/*================================== */

//*************** QUESTION 01 **************************
//precond:  data.size() > 0
//postcond: returns largest integer in data
public Integer max( ArrayList <Integer> data )
{
        /* YOUR IMPLEMENTATION HERE */
        int max = data.get(0);
        for ( int i = 1; i < data.size(); i++) {
                if ( max < data.get(i) ) {
                        max = data.get(i); //basic max function
                }
        } //end loop
        return max;
}


//*************** QUESTION 03 **************************
//postcond: returns true if i > 0 and i < _frequency.size() - 1
//          and _frequency.get( i - 1 ) < _frequency.get( i )
//          and _frequency.get( i + 1 ) < _frequency.get( i )
//          Otherwise, returns false
//eg, for _frequency [1,2,1,5,5,8,2,4]
//    2 and 8 are local modes, so
//    isLocalMode(0) -> false
//    isLocalMode(1) -> true
//    isLocalMode(5) -> true
public boolean isLocalMode( int i )
{
        /* YOUR IMPLEMENTATION HERE */
        return ( i > 0 && i < _frequency.size() - 1
                 && _frequency.get( i - 1 ) < _frequency.get( i )
                 && _frequency.get( i + 1 ) < _frequency.get( i ) );
}


//*************** QUESTION 04 **************************
//postcond: returns list of modes in _frequency
public ArrayList<Integer> getLocalModes()
{
        /* YOUR IMPLEMENTATION HERE */
        ArrayList <Integer> mode = new ArrayList <Integer>();
        for (int i = 0; i < _frequency.size(); i++) {
                if ( _frequency.get(i) >= _frequency.get(i-1) && _frequency.get(i) >= _frequency.get(i+1) ) {
                        mode.add(i); //check for the mode; if it is a mode, then append it
                }
        }
        return mode;
}

// function for multiplying Strings, like in Python
public String multiplyString(String str, int times){
        String baseStr = str; //preserve the original string
        if (times == 0) {
                return "";
        }
        for (int i = 0; i < times; i++) {
                str += baseStr;
                //System.out.println(str);
        }
        return str;
}


//*************** QUESTION 05 **************************
//precond:  longestBar > 0
public void printHistogram( int longestBar )
{
        /* YOUR IMPLEMENTATION HERE */
        // finds the fraction of the stars needed, and then multiplies it by the length
        int numStars = (int) ( (float) _frequency.get(0) / max(_frequency) ) * longestBar;
        //System.out.println(numStars);
        String retStr = ""; //generates the histogram
        for (int i = 0; i < _frequency.size(); i++) {
                retStr += i + " : ";
                retStr += multiplyString("*", numStars );
                retStr += "\n";

                //System.out.println((float) (_frequency.get(i)) / max(_frequency));
                //System.out.println(i + ":" + numStars);
                numStars = (int) ( (float) (_frequency.get(i)) / max(_frequency)  * longestBar);
                //System.out.println(numStars);
        }
        System.out.println(retStr);
}

}//end class StatPrinter