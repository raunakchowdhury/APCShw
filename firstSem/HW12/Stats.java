// Raunak Chowdhury
// APCS1 pd2
// HW 12 -- stAtistically sPeaking  ​​”If skills sold, truth be told, I'd probably be lyrically Talib Kweli” -Jigga
// 2017-10-05

import java.lang.Math; 

public class Stats{
    public static int mean(int a, int b){ //Find the mean of two INTEGERS
	// Pre-condition: take two integers a and b
	// Post-condition: return the average of the two integers as an integer
	return (a + b)/2;
    }

    public static double mean(double a, double b){ //Find the mean of two DECIMALS
	// Pre-condition: take two doubles a and b
	// Post-condition: return the average of the two doubles as a double
	return (a + b)/2;
    }

    public static int max(int a, int b){ // Find the maximum of two INTEGERS
	// Pre-condition: take two integers a and b
	// Post-condition: return the larger integer
	if (a > b){
	    return a;
	}
	else{
	    return b;
	}
    }

    public static double max(double a, double b){ // Find the maximum of two DECIMALS
	// Pre-condition: take two doubles a and b
	// Post-condition: return the larger double
	if (a > b){
	    return a;
	}
	else{
	    return b;
	}
       
    }

    public static int geoMean(int a, int b){ // find the geometric mean of INTS
	// Pre-condition: takes two ints a and b
	// Post-condition: returns their geometric mean
	return (int) Math.sqrt(a * b);
    }

    public static double geoMean(double a, double b){ // find the geometric mean of DECIMALS
	// Pre-condition: takes two doubles a and b
        // Post-condition: returns their geometric mean
	return Math.sqrt(a * b);
    }


    public static void main(String[] args){
	// Print out the avg of an int
	System.out.println("Testing mean...");
	System.out.println(mean(5,4));
	    
	// Print out the avg of a non-int
	System.out.println(mean(5.56, 4.00));

	//Print out the max of ints/non-ints
	System.out.println("Testing max...");
	System.out.println(max(1,2));
	System.out.println(max(5.56, 4.00));

	//Print out the geometric mean of ints and non-ints
	System.out.println("Testing geoMean...");
	System.out.println(geoMean(16, 4));
	System.out.println(geoMean(25, .4));
	
    }//End main
}//End stats


