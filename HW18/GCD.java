public class GCD{



    
    public static int rGCD ( int a, int b){ // Does a recursive algorithm of GCD
	if (a % b == 0){
	    return b;
	}
	    return rGCD( b, a%b);
    


    public static void countDown(int n){
	for (int x = n; x >= 0; x--){
	    System.out.println(x);
	}
	System.out.println("Yay! This for loop has iterated " + n + " times.");
    }



    

    public static void main ( String[] args ){
	/*	System.out.println( rGCD(15,20) ); // returns 5
    }
	*/
    countDown(100);
    }
    

    } // end class GCD
