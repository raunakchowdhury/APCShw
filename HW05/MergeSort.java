//Raunak Chowdhury
//APCS1 pd2
//HW05 --  text
//2017-02-06
/*======================================
   class MergeSort
   Implements mergesort on array of ints.

   Summary of Algorithm:
   1. If the array is greater than length 1, split the array. If it is length 1, return it.
   2. Follow step 1 until every element is in its own array.
   3. Merge every array until you get an array for the original length again. You're done.
   ======================================*/

public class MergeSort
{
/******************************************************
* int[] merge(int[],int[])
* Merges two input arrays
* Precond:  Input arrays are sorted in ascending order
* Postcond: Input arrays unchanged, and
* output array sorted in ascending order.
******************************************************/
private static int[] merge( int[] a, int[] b )
{
        int[] mergeArr = new int[a.length + b.length];
        int aCounter = 0; //tracks index
        int bCounter = 0; // tracks index
        int mergeCounter = 0;
        while(aCounter < a.length && bCounter < b.length) {
                if (a[aCounter] < b[bCounter]) { //b is greater than a
                        mergeArr[mergeCounter] = a[aCounter];
                        mergeCounter++;
                        aCounter++;
                }
                else if (b[bCounter] < a[aCounter]) { //a is greater than b
                        mergeArr[mergeCounter] = b[bCounter];
                        mergeCounter++;
                        bCounter++;
                        //System.out.println(bCounter);
                }
                else if (a[aCounter] == b[bCounter]) { //if both are equal
                        mergeArr[mergeCounter] = a[aCounter];
                        mergeCounter++;
                        aCounter++;
                }
        }
        if (bCounter < b.length) { //for the case where a is done, but b is not
                while (bCounter < b.length) {
                        mergeArr[mergeCounter] = b[bCounter];
                        mergeCounter++;
                        bCounter++;
                }
        }
        else if (aCounter < a.length) { //for the vice versa case of the comment above
                while (aCounter < a.length) {
                        mergeArr[mergeCounter] = a[aCounter];
                        mergeCounter++;
                        aCounter++;
                }
        }
        return mergeArr;
}  //end merge()


/******************************************************
* int[] sort(int[])
* Sorts input array using mergesort algorithm
* Returns sorted version of input array (ascending)
******************************************************/
public static int[] sort( int[] arr )
{
        int[] firstHalf = new int[arr.length/2];
        //System.out.println("Length: "+ (arr.length - arr.length/2));
        int[] secondHalf = new int[arr.length - arr.length/2];

        if (arr.length != 1) { //if your length is not 1, continue to split
                for (int i = 0; i < arr.length/2; i++) {
                        firstHalf[i] = arr[i];
                        //System.out.println(firstHalf[i]);
                        //printArray(firstHalf);
                }
                for (int i = arr.length/2; i < arr.length; i++) {
                        secondHalf[i - arr.length/2] = arr[i];
                        //printArray(secondHalf);
                }
                firstHalf= sort(firstHalf);
                secondHalf= sort(secondHalf);
        }
        else{
                return arr;
        }
        //printArray(firstHalf);
        //printArray(secondHalf);
        //printArray( merge(firstHalf, secondHalf) );
        return merge(firstHalf, secondHalf);
}  //end sort()



//-------------------HELPERS-------------------------
//tester function for exploring how arrays are passed
//usage: print array, mess(array), print array. Whaddayasee?
public static void mess( int[] a ) {
        for( int i = 0; i<a.length; i++ )
                a[i] = 0;
}

//helper method for displaying an array
public static void printArray( int[] a ) {
        System.out.print("[");
        for( int i : a )
                System.out.print( i + ",");
        System.out.println("]");
}
//---------------------------------------------------


//main method for testing
public static void main( String [] args ) {

        int[] arr0 = {0};
        int[] arr1 = {1};
        int[] arr2 = {1,2};
        int[] arr3 = {3,4};
        int[] arr4 = {1,2,3,4};
        int[] arr5 = {4,3,2,1};
        int[] arr6 = {9,42,17,63,0,512,23};
        int[] arr7 = {9,42,17,63,0,9,512,23,9};

        System.out.println("\nTesting mess-with-array method...");
        printArray( arr3 );
        mess(arr3);
        printArray( arr3 );

        System.out.println("\nMerging arr1 and arr0: ");
        printArray( merge(arr1,arr0) );

        System.out.println("\nMerging arr4 and arr6: ");
        printArray( merge(arr4,arr6) );

        System.out.println("\nSorting arr4-7...");
        printArray( sort( arr4 ) );
        printArray( sort( arr5 ) );
        printArray( sort( arr6 ) );
        printArray( sort( arr7 ) );
        /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~

           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}  //end main()

}//end class MergeSort
