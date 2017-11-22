// Raunak Chowdhury
//

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
// A static method to return a String version of a 2-D array
//============================================================
public static String ret2DArray (String[][] arr){
        String returnArray = "[";
        for (int i = 0; i < arr.length; i++) {
                returnArray += retArray( arr[i] ); // looks at each row's array and Stringifies them
                if (i != arr.length - 1) { // a check to make sure that there isn't a comma at the end
                        returnArray += ",";
                }
        }
        returnArray += "]";
        return returnArray;
}

public static void main (String[] args) {
        System.out.println( "Here's your array: " + ret2DArray(arr) );
        while (true) { // keep going as long as the user wants it to go
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
                System.out.print("Would you like to continue? (Y/N) ");
                if ( Keyboard.readString().equals( "N") ) { //allows a person to drop out of the loop
                        break;
                }
                System.out.println();
        } // end loop
} //end main
} // end class Swapper
