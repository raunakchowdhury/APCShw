//Raunak Chowdhury
//APCS1 pd2
//HW57 -- How Deep Does the Rabbit Hole Go?
//2017-12-20

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column):
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1]
 *
 * TASK:
 * Implement methods below, categorize runtime of each.
 * Test in main method.
 ***/


public class Matrix
{
//constant for default matrix size
private final static int DEFAULT_SIZE = 2;

private Object[][] matrix;

//default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
public Matrix()
{
        matrix = new Object [DEFAULT_SIZE][DEFAULT_SIZE];
}


//constructor intializes an a*a matrix
public Matrix( int a )
{
        matrix = new Object [a][a];
}


//return size of this matrix, where size is 1 dimension
private int size()
{
        return matrix.length * 2;
}


//return the item at the specified row & column
private Object get( int r, int c )
{
        return matrix[r][c];
}


//return true if this matrix is empty, false otherwise
private boolean isEmpty()//int r, int c
{
        for (Object[] i : matrix) {
                for (Object o: i) {
                        // if any one of them is not empty, then the matrix is not empty
                        if ( o != null)
                                return false;
                }
        }
        return true;
}


//overwrite item at specified row and column with newVal
//return old value
private Object set( int r, int c, Object newVal )
{
        Object oldVal = matrix[r][c];
        matrix[r][c] = newVal;
        return oldVal;
}


//return String representation of this matrix
// (make it look like a matrix)
public String toString()
{
        String foo = "\n";
        for (Object[] i : matrix) {
                foo += "|";
                for (Object o: i) {
                        foo += " " + o; //add in a space after each object
                }
                foo += "|\n"; //move to the next row
        }
        return foo;
}

// populate the array
public void populate(){
        for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                        matrix[row][col] = row * col + row;
                }
        }
}

//override inherited equals method
//criteria for equality: matrices have identical dimensions,
// and identical values in each slot
public boolean equals( Object rightSide )
{
        Matrix rS = (Matrix) rightSide;
        // check to see that they have equal dimensions first
        if ( this.size() != rS.size() )
                return false;
        //if even one comparison is incorrect, then the two matrices are unequal
        for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                        if ( matrix[row][col] != rS.get(row,col) )
                                return false;
                }
        }
        return true;
}

//swap two columns of this matrix
//(1,1) is top left corner of matrix
//row values increase going down
//column value increase L-to-R
public void swapColumns( int c1, int c2  )
{
        Object storeC1; //store the object
        for (int row = 0; row < matrix.length; row++) {
                storeC1 = matrix[row][c1]; //store the object in col c1
                matrix[row][c1] = matrix[row][c2]; //make the object in col c1 the object in c2
                matrix[row][c2] = storeC1;
        }
}

// copies array a2 into array a1
private void copyArray( Object[] a1, Object[] a2)
{
        for (int i = 0; i < a2.length; i++) {
                a1[i] = a2[i];
        }
}

//swap two rows of this matrix
//(1,1) is top left corner of matrix
//row values increase going down
//column value increase L-to-R
public void swapRows( int r1, int r2  )
{
        //create a placeholder to copy row r1 into
        Object[] r1Array = new Object [matrix.length];
        copyArray( r1Array, matrix[r1] ); // copy r1 into the placeholder
        copyArray( matrix[r1], matrix[r2] ); // r1 takes r2's place
        matrix[r2] = r1Array; //r2 takes r1's place
}


//main method for testing
public static void main( String[] args )
{
        Matrix neo = new Matrix();
        //neo.populate();
        Matrix trinity = new Matrix();
        Matrix max = new Matrix(4);
        max.populate();
        System.out.println("neo: " + neo);
        System.out.println("max: " + max);

        /*===========isEmpty testing==========
           System.out.println("is neo empty? " + neo.isEmpty());
           System.out.println(neo.size());
           ===========*/

        /*========set testing==========
           neo.set(1,1,4);
           System.out.println("neo after set: " + neo);
           ====================*/

        /*========get testing =========
           System.out.println(neo.get(1,1));
           ============================*/

        /*========equals testing======
           System.out.println("1st matrix comparison: " + neo.equals(max) ); //f
           System.out.println("2nd matrix comparison: " + neo.equals(trinity) ); //t
           ===============*/

        /*========swapRows testing========
           max.swapRows(0,1);
           System.out.println("max after swapping: " + max);
           ============*/

        /*========swapColumns testing=======
           max.swapColumns(2,3);
           System.out.println("max after swapping: " + max);
           ==========*/
}
}//end class Matrix
