// Raunak Chowdhury
// APCS1 pd2
// HW40 -- Make It Better
// 2017-11-21

// ======================== Program Operation ====================================
// 1. Run main
// 2. The array will be printed out using a "Stringifier" method
// 3. Select the coordinates for the first String to be swapped (uses Keyboard)
// 4. Select the coordinates for the second String to be swapped (uses Keyboard)
// 5. Calls swap(), which swaps the two Strings and then prints out the new array
// 6. A prompt will pop up asking if you want to continue
//      i. If you say no, the program ends
//      ii. If you say yes, repeat steps 2-6
// ===============================================================================

// New Changes:
// 1. Added a catch to prevent errors caused by entering non-Int values
// 2. The program now prints out the array after every iteration
// 3. Added exception handling when the program asks the user to iterate again
// 4. The printed arrays now properly show up in rows and columns

import cs1.Keyboard;

public class Swapper {
// create a hard-coded 2-D array
// 2 rows by 3 cols
static String[][] arr = {
        {"bat", "bert", "bark"},
        {"fork", "jork", "cork"},
};

public static void swap ( int row1, int col1, int row2, int col2){
        String pos = arr [row1][col1]; // store the position of the first String to be swapped
        arr[row1][col1] = arr[row2][col2]; // Switch the value of the first String to the second
        arr[row2][col2] = pos; // Switcht the value of the second String to the first
        System.out.println( "Your new array is: " + ret2DArray(arr) ); //print out the new Array
}

//=================================================================
//A static method to return a String version of an array of Strings.
//=================================================================
public static String retArray (String[] a){
        String retStr = "[";
        for (int i = 0; i < a.length; i++) {
                if (i == a.length - 1) {
                        retStr += a[i];
                }
                else {
                        retStr += a[i] + ", ";
                }
        } // end loop
        retStr += "]";
        return retStr;
}

//============================================================
// A static method to return a String version of a 2D array
//============================================================
public static String ret2DArray (String[][] arr){
        String returnArray = "\n{\n";
        for (int i = 0; i < arr.length; i++) {
                returnArray += retArray( arr[i] ); // looks at each row's array and Stringifies them
                if (i != arr.length - 1) { // a check to make sure that there isn't a comma at the end
                        returnArray += ",";
                }
                returnArray += "\n";
        }
        returnArray += "}";
        return returnArray;
}

public static void visualizeSwap(){
        System.out.println( "Here's your array: " + ret2DArray(arr) );
        // =====================FIRST STRING============================
        System.out.print("Choose the row of your first String: ");
        int row1 = Keyboard.readInt();
        System.out.println();
        System.out.print("Choose the column of your first String: ");
        int col1 = Keyboard.readInt();
        System.out.println();

        //=======================SECOND STRING==========================
        System.out.print("Choose the row of your second String: ");
        int row2 = Keyboard.readInt();
        System.out.println();
        System.out.print("Choose the column of your second String: ");
        int col2 = Keyboard.readInt();
        System.out.println();

        // here be a checker to make sure you don't fall outside the range
        if (row1 < arr.length &&
            row2 < arr.length &&
            col1 < arr[0].length &&
            col2 < arr[0].length)
        {
                swap( row1,col1, row2,col2);
        }
        else {
                System.out.println( "Invalid values!");
        }
} // end visualizeSwap

//==============================================
// deal with exceptions, depending on user input
// =============================================
public static void stayExceptions(String choice){
        if (!(choice.equals("Y") ||
              choice.equals("y") ) )
        {
                System.out.println("Not a valid input! Iterating again...");
        }
}

public static void main (String[] args) {
        while (true) { // keep going as long as the user wants it to go
                try {
                        visualizeSwap(); // the actual algorithm
                }
                catch (Exception e) { //deals with the exception that Ints were not entered
                        System.out.println();
                        System.out.println("Invalid inputs! Did you use non-Integer values?");
                }

                //allows a person to drop out of the loop
                System.out.print("Would you like to continue? (Y/N) ");
                String choice = Keyboard.readString(); //stores the user input
                if ( choice.equals( "N") ||
                     choice.equals("n") )
                {
                        break;
                }
                else
                {
                        stayExceptions(choice); // deals with different exceptions based on user input
                }
                System.out.println();
        } // end loop
} //end main
} // end class Swapper
