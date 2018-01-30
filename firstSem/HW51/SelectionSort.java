//Raunak Chowdhury
//APCS1 pd2
//HW51 --  Selection, Natch
//2017-12-11

/***************************************
* class SelectionSort -- implements SelectionSort algorithm
***************************************/

import java.util.ArrayList;

public class SelectionSort
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

// A helper method for returning the min of two Comparables.
public static Comparable min(Comparable a, Comparable b){
        if ( a.compareTo(b) > 0 )
                return b;
        return a;
}

//A helper method that returns the index of the min of an array of comparables.
public static int minIndexOfArray(ArrayList<Comparable> input){
        int minIndex = 0; //stores the min of the ArrayList; set to the first element
        // size - 1 was used in order to prevent an IndexOutOfBoundsException
        for (int i = 0; i < input.size(); i++)
                if ( min( input.get(minIndex), input.get(i) ) == input.get(i) ) //is the min the value that was just extracted from the array?
                        minIndex = i;
        return minIndex;
}

//deletes the first instance of the Comparable in the array.
public static void pop(ArrayList<Comparable> input, Comparable popValue){
        for (int i = 0; i < input.size(); i++) {
                if (input.get(i).compareTo(popValue) == 0) {
                        input.remove(i); //delete the val
                        break;
                }
        }
} // end pop

// copies one array into another
public static ArrayList<Comparable> copyArray (ArrayList<Comparable> a){
        ArrayList<Comparable> b = new ArrayList<Comparable>();
        for (int i = 0; i < a.size(); i++) {
                b.add(a.get(i)); // copy each val into the new array
        }
        return b;
}


// VOID version of SelectionSort
// Rearranges elements of input ArrayList
// postcondition: data's elements sorted in ascending order
public static void selectionSortV( ArrayList<Comparable> data )
{
        /* YOUR IMPLEMENTATION HERE */
        int fakeIndex = 0; //gives the fake 0 index each cycle
        int minIndex = 0; //stores the index of the min
        Comparable min = data.get(fakeIndex); // intialize the min of the array(s)
        Comparable zeroVal = 0; //stores the value at the "0" index

        // you need to sort by cycling exactly size -1 times
        for (int times = 0; times < data.size(); times++) {
                fakeIndex = times; //set the fake 0 val to the times iterated
                min = data.get(fakeIndex); //store the val at the fake 0 index
                minIndex = fakeIndex; //set the minIndex to the "0" val

//find the minimum by cycling in the range [fakeIndex, size)
                for (int i = fakeIndex; i < data.size(); i++) {
                        if (min.compareTo(data.get(i)) > 0) {
                                min = data.get(i); //set the min to the new min if the next val is smaller
                                minIndex = i; //set the new index of the min
                        }
                }
                zeroVal = data.get(fakeIndex); //set the val to be swapped to the "0" value
                //System.out.println("min: " + min);
                //System.out.println("minIndex:" + minIndex);
                data.set(fakeIndex, min); //replace the "zero" val with the min
                //System.out.println("Swapped in fakeIndex: " + data);
                data.set(minIndex, zeroVal); //replace the val where the min was before
                //System.out.println("Swapped in zeroVal: " + data);
        }
}         //end selectionSortV


// ArrayList-returning selectionSort
// postcondition: order of input ArrayList's elements unchanged
//                Returns sorted copy of input ArrayList.
public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
{
        /* YOUR IMPLEMENTATION HERE */
        // create a new array to store the sorted array
        ArrayList<Comparable> retArray = new ArrayList<Comparable>();
        int size = input.size(); // store the size in a var, to prevent the loop from being affected
        int minIndex = minIndexOfArray(input); //stores the initial min value
        ArrayList<Comparable> copiedInput = new ArrayList<Comparable>(); //create a copy of input
        copiedInput = copyArray(input);
        System.out.println("copied array: " + copiedInput);


        for (int i = 0; i < size; i++) {
                //System.out.println(retArray);
                minIndex = minIndexOfArray(copiedInput); // find the min indexfirst
                //System.out.println("index and val: " + minIndex +" "+ copiedInput.get(minIndex));
                retArray.add(copiedInput.get(minIndex)); //append the min
                pop(copiedInput, copiedInput.get(minIndex)); //pop the min from input
                //System.out.println("after pop: " + copiedInput);
        }
        return retArray;
}  //end selectionSort


public static void main( String [] args )
{
/*======================================================
        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        selectionSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );
        ============================================*/

        /*===============for VOID methods=============
           ArrayList coco = populate( 10, 1, 1000 );
           System.out.println( "ArrayList coco before sorting:\n" + coco );
           selectionSortV(coco);
           System.out.println( "ArrayList coco after sorting:\n" + coco );
           ============================================*/


        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        ArrayList glenSorted = selectionSort( glen );
        System.out.println( "sorted version of ArrayList glen:\n"
                            + glenSorted );
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        ArrayList cocoSorted = selectionSort( coco );
        System.out.println( "sorted version of ArrayList coco:\n"
                            + cocoSorted );
        System.out.println( "ArrayList coco after sorting:\n" + coco );
        System.out.println( coco );
        /*==========for AL-returning methods==========
           ============================================*/

}  //end main

}//end class SelectionSort
