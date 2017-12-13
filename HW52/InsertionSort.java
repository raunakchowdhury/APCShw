//Raunak Chowdhury
//APCS1 pd2
//HW52 --  Poker Face
//2017-12-12

/***************************************
*  class InsertionSort -- implements InsertionSort algorithm
***************************************/

import java.util.ArrayList;

public class InsertionSort
{
//~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
//precond: lo < hi && size > 0
//postcond: returns an ArrayList of random integers
//          from lo to hi, inclusive
public static ArrayList populate( int size, int lo, int hi ) {
        ArrayList<Integer> retAL = new ArrayList<Integer>();
        while( size > 0 ) {
                //     offset + rand int on interval [lo,hi]
                retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
                size--;
        }
        return retAL;
}

//randomly rearrange elements of an ArrayList
public static void shuffle( ArrayList al ) {
        int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
                //pick an index at random
                randomIndex = (int)( (i+1) * Math.random() );
                //swap the values at position i and randomIndex
                al.set( i, al.set( randomIndex, al.get(i) ) );
        }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


// VOID version of InsertionSort
// Rearranges elements of input ArrayList
// postcondition: data's elements sorted in ascending order
public static void insertionSortV( ArrayList<Comparable> data )
{
        /* YOUR IMPLEMENTATION HERE */
        int marker = 0; //denotes the end of the sorted region
        Comparable previousVal = 0;

        //tracks the number of times the algorithm traces through
        for ( int times = 0; times < data.size(); times++) {
                /*
                 * traces backwards through the sorted region to sort the most current value
                 * acts as a "pass"
                 */
                for (int i = marker; i > 0; i--) {
                        //compare the tracked value with the previous value
                        if ( data.get(i).compareTo(data.get(i-1)) < 0 ) {
                                previousVal = data.get(i-1); // get the previous value
                                data.set(i-1, data.get(i)); // replace the previous value with i
                                //set the value that was vacated by i with the previous value
                                data.set(i, previousVal);
                        }
                        else
                                break;
                } //end pass
                marker++; //advance the sorted region by one
        }
}  //end insertionSortV


// ArrayList-returning insertionSort
// postcondition: order of input ArrayList's elements unchanged
//                Returns sorted copy of input ArrayList.
public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input )
{
        /* YOUR IMPLEMENTATION HERE */
        ArrayList<Comparable> copiedInput = new ArrayList<Comparable>();
        // copy the array over
        for (Comparable o : input) {
                copiedInput.add(o);
        }
        insertionSortV(copiedInput);
        return copiedInput;
}  //end insertionSort


public static void main( String [] args )
{
        /*===============for VOID methods=============
           System.out.println("\n*** Testing sort-in-place (void) version... *** ");
           ArrayList glen = new ArrayList<Integer>();
           glen.add(7);
           glen.add(1);
           glen.add(5);
           glen.add(12);
           glen.add(3);
           System.out.println( "\nArrayList glen before sorting:\n" + glen );
           insertionSortV(glen);
           System.out.println( "\nArrayList glen after sorting:\n" + glen );

           ArrayList coco = populate( 10, 1, 1000 );
           System.out.println( "\nArrayList coco before sorting:\n" + coco );
           insertionSortV(coco);
           System.out.println( "\nArrayList coco after sorting:\n" + coco );
           ============================================*/


        System.out.println( "*** Testing non-void version... *** " );
        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "\nArrayList glen before sorting:\n" + glen );
        ArrayList glenSorted = insertionSort( glen );
        System.out.println( "\nsorted version of ArrayList glen:\n"
                            + glenSorted );
        System.out.println( "\nArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "\nArrayList coco before sorting:\n" + coco );
        ArrayList cocoSorted = insertionSort( coco );
        System.out.println( "\nsorted version of ArrayList coco:\n"
                            + cocoSorted );
        System.out.println( "\nArrayList coco after sorting:\n" + coco );
        System.out.println( coco );
        /*==========for AL-returning methods==========
           ============================================*/

}  //end main

}//end class InsertionSort
