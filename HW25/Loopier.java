// Raunak Chowdhury
// APCS1 pd2
// HW25 -- HW #25: All Hallow's Eve Getting Real Spooky Out Here      
// 2017-10-31

public class Loopier{
    //A static method to populate an existing array with randomly generated ints.
    public static void randArray (int[] a , int lowerBound, int upperBound){
	for (int i = 0; i < a.length; i++){
	    int randInt = (int) ((Math.random() * (upperBound - lowerBrand) ) + lowerBound);
	    a[i] = randInt;
	}
    }

    //A static method to return a String version of an array of ints.
    public static String retArray (int[] a){
	String retStr = "[";
	for (int i = 0; i < a.length; i++){
	    if (i == a.length - 1){
		retStr += a[i];
	    }
	    else {
		retStr += a[i] + ", ";
	    }
	} // end loop
	retStr += "]";
	return retStr;
    }

    public static int freq( int[] a, int target ){
	int total = 0;
	for ( int i = 0; i < a.length; i++ ){
	    if ( a[i] == target ){
		total += 1;
	    }
	} // end loop
	return total;
    }


    // takes an array, and truncates it from 0 to the index, exclusive
    // essentially a slice method for strings, but the first index is 0
    public static int[] truncateArray ( int[] a , int index ){ 
	int[] retArray = new int[index];
	for (int i = 0; i < index; i++){
	    retArray[i] = a[i];
	}
	return retArray;
	
    } // end truncateArray


    //overloaded truncatedArray
    // takes an array, and truncates it from b to c, exclusive
    public static int[] truncateArray ( int[] a , int b, int c ){ 
	int[] retArray = new int[c - b];
	for (int i = b; i < c; i++){
	    retArray[i - b] = a[i];
	}
	return retArray;
	
    } // end truncateArray

    //a linear search function that will return the index of the first occurrence of a target in an existing array, or -1 if not found. 
    public static int linSearch( int[] a, int target ){
	for (int i = 0; i < a.length; i++){
	    if (a[i] == target){
		return i;
	    }// end loop
	}
	return -1;
    }

    //a recursive linear search function that will return the index of the first occurrence of a target in an existing array, or -1 if not found.
    public static int linSearchR( int[] a, int target ){
	String str = "" + target;
        if ( retArray(a).indexOf( str ) == -1){ // converts the array to a string, and then checks to see if the target is in the string
	    return -1;
	}
	//==================================
	int total = 0;
	if ( a[0] == target ){
	    return total; //since indexes start at 0, there is no need to add 1
	}
     	else{
	    //System.out.println (retArray ( truncateArray(a, 1, a.length) ) ); // testing purposes
	    return total += 1 + linSearchR( truncateArray(a, 1, a.length), target ); // if neither condition is satisfied add one to the total and repeat, with the first element of the array removed
	}
	
    }

    // return the number of occurrences of a target in an existing array
    public static int freqRec( int[] a, int target ){
	int lastIndex = a.length - 1; //store the last index
	int[] nextArray = truncateArray(a, lastIndex); // the current array, with the last element removed
	
	if ( a.length < 1 ){ // deal with null arrays and stuff
	    return 0;
	}
	else if ( a.length == 1){ //cover the base cases at the end
	    if ( a[0] == target){
		return 1;
	    }
	    else { 
		return 0;
	    }
	}
	else {
	    if ( a[lastIndex] == target){
		return 1 + freqRec( nextArray, target );
	    }
	    else {
		return 0 + freqRec( nextArray, target );
	    }    
	} //end last else
    } // end freqRec


    public static void main (String [] args){
	int[] x = {4, 5, 6 , 6 , 6};
	int[] target = {5};
	int[] anArray = new int[10];
	// retArray------------------------------------
	System.out.println( retArray(x) ); // {4, 5, 6 , 6 , 6}
	// randArray-----------------------------------
	randArray(anArray); //call method first
	System.out.println("anArray: " + retArray(anArray) ); // generate a random set of ints in the array
	//linSearch------------------------------------
	System.out.println( "linSearch: " + linSearch(x, 5) ); //1
	System.out.println( "linSearch: " + linSearch(x, 0) ); // -1
	System.out.println( "linSearch: " + linSearch(x, 6) ); // 2
	//linSearchR------------------------------------
	System.out.println( "linSearchR: " + linSearchR(x, 5) ); //1
	System.out.println( "linSearchR: " + linSearchR(x, 0) ); // -1
	System.out.println( "linSearchR: " + linSearchR(x, 6) ); //2	
	// freq-----------------------------------------
	System.out.println("freq: " + freq (x, 6) ); // 3
	System.out.println( "freq: " +freq (x, 3) ); // 0
	// freqRec -------------------------------------
	System.out.println("freqRec: " + freq (x, 6) ); // 3
	System.out.println( "freqRec: " +freq (x, 3) ); // 0
	// testing truncateArray (helper method)--------
	System.out.println("truncateArray: " + retArray (truncateArray (x , x.length - 1)) ); //[4, 5, 6, 6]
	System.out.println("truncateArray (overloaded): " + retArray (truncateArray (x , 1, x.length)) ); //[5, 6, 6, 6]
    }// end main

}
