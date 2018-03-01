//Chong Frank Chowder
//APCS1 pd2
//HW03 -- I Am Still Searching
//2017-02-01

/*
   Algorithm:
   1. Begin on the top right corner.
   2. Check to see if the current value matches the target. If it does, return the coordinates.
   3. If it does not match, check to see if the target is greater or less than the current value.
   4. If the target is greater, check to see if the next row exists.
    i. If it exists, hop down to the next row and repeat steps 2-5.
    ii. If it does not exist, return (-1, -1).
   5. If the target is smaller, check to see if the preceding column exists.
    i. If it exists, move one left and repeat steps 2-5.
    ii. If it does not exist, return (-1, -1).
 */
public class MatrixFinder {

public static String locateCoord(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length - 1;
        while ( matrix[row][col] != target) {
                //exit conditions
                if ( matrix[row][col] < target ) {
                        if (row + 1 >= matrix.length)
                                return "(-1,-1)";
                        row++;
                }
                else if ( matrix[row][col] > target ) {
                        if (col - 1 < 0)
                                return "(-1,-1)";
                        col--;
                }
        }
//if the loop completes without returning, then there is a matching value
        return "(" + row + "," + col + ")";
}

public static void main(String[] args) {
        // 1x1 matrix
        int[][] test1 = {  {1}  };
        System.out.println("Locating 1 in test1: " + locateCoord(test1,1)); //(0,0)
        System.out.println("Locating 0 in test1: " + locateCoord(test1,0)); //(-1,-1)

        int[][] test2 = {
                {4,5,6,7},
                {300,500,700,900},
                {301,501,701,901},
                {1001,4001,7001,9001}
        };
        System.out.println("Locating 4 in test2: " + locateCoord(test2,4)); //(0,0)
        System.out.println("Locating 701 in test2: " + locateCoord(test2,701)); //(2,2)
        System.out.println("Locating 7011 in test2: " + locateCoord(test2,7011)); //(-1,-1)
        System.out.println("Locating 1000 in test2: " + locateCoord(test2,1000)); //(-1,-1)

        int[][] test3 = {
                {1,2,3},
                {2,3,4},
                {3,4,5}
        };
        System.out.println("Locating 4 in test3: " + locateCoord(test3,4)); //(1,2)
        System.out.println("Locating 5 in test3: " + locateCoord(test3,5)); //(2,2)

        int[][] test4 = {
                {1,2,3},
                {20,35,40},
                {30,40,50}
        };
        System.out.println("Locating 30 in test4: " +locateCoord(test4,30));//(2,0)
}

}//end MatrixFinder
