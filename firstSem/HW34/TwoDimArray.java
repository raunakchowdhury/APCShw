/******************************
* class TwoDimArray
* (skeleton)
* practice working with 2D arrays
******************************/

// Raunak Chowdhury
// APCS1 pd2
// HW34 -- 2D arrays
// 2017-11-17

public class TwoDimArray
{
//postcond: prints each row of 2D int array a on its own line
//          uses a FOR loop
public static void print1( int[][] a )
{
        for (int row = 0; row < a.length; row++) {  //bloo
                for (int col = 0; col < a[row].length; col++) {
                        System.out.print( a[row][col] + " " );
                } // end loop
                System.out.println();
        } //end loop
          // *** YOUR IMPLEMENTATION HERE ***
}


//postcond: prints each row of 2D int array a on its own line
//          uses a FOREACH loop
public static void print2( int[][] a )
{
        for (int [] i : a) { //bloo
                for (int call : i) {
                        System.out.print(call + " "); //print out each int, with a space
                } // end loop
                System.out.println(); // add a newline for clarity
        } //end loop
          // *** YOUR IMPLEMENTATION HERE ***
}


//postcond: returns sum of all items in 2D int array a
public static int sum1( int[][] a )
{
        // *** YOUR IMPLEMENTATION HERE ***
        int total = 0;
        for (int row = 0; row < a.length; row++) {  //bloo
                for (int col = 0; col < a[row].length; col++) {
                        total += a[row][col];
                } // end loop
        } //end loop
        return total;
}


//postcond: returns sum of all items in 2D int array a
//          * uses helper fxn sumRow
public static int sum2( int [][] m )
{
        // *** YOUR IMPLEMENTATION HERE ***
        int total = 0;
        for (int a = 0; a < m.length; a++) {
                total += sumRow(a, m);
        }
        return total;
}


//postcond: returns sum of all items on row r of 2D int array a
//          uses a FOR loop
public static int sumRow( int r, int[][] a )
{
        // *** YOUR IMPLEMENTATION HERE ***
        int[] newArr = a[r]; // array to be summed
        int total = 0;
        for (int i = 0; i < newArr.length; i++) {
                total += newArr[i]; //loops thru the array to sum it
        }
        return total;
}


//postcond: returns sum of all items on row r of 2D int array a
//          uses a FOREACH loop
public static int sumRow2(int r, int[][] m)
{
        // *** YOUR IMPLEMENTATION HERE ***
        int[] newArr = m[r]; // initialize the section to be added
        int total = 0;
        for (int element : newArr) {
                total += element;
        }
        return total;
}


public static void main( String [] args )
{

        int [][] m1 = new int[4][2];
        int [][] m2 = { {2,4,6}, {3,5,7} };
        int [][] m3 = { {2}, {4,6}, {1,3,5} };
        print1(m1);
        print1(m2);
        print1(m3);
        print2(m1);
        print2(m2);
        print2(m3);

        System.out.print("testing sum1...\n");
        System.out.println("sum m1 : " + sum1(m1)); // 0
        System.out.println("sum m2 : " + sum1(m2)); // 27
        System.out.println("sum m3 : " + sum1(m3)); // 21

        System.out.print("testing sum2...\n");
        System.out.println("sum m1 : " + sum2(m1));    // 0
        System.out.println("sum m2 : " + sum2(m2));    // 27
        System.out.println("sum m3 : " + sum2(m3));    // 21
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}

}//end class TwoDimArray
