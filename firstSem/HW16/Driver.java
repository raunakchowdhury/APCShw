//Raunak Chowdhury
//APCS1 pd2
//HW16 -- Get It While You Can
//2017-10-14

/***
    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run.
    2. Move the "TOP" line below the first statement. 
    (with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    3. Compile and run again. 
    4. Resolve errors 1 at a time until it works
    5. Repeat 2-4 until TOP meets BOTTOM
***/

public class Driver
{

    // Will flip the coins until one of the coins lands on heads
    // Takes two instances of Coin and the number of times you want to land on heads
    // Observation: you can't access the upFace value if it's private. You need to change the permission for upFace from "private" to "public".
    public static void headsLoop ( Coin class1, Coin class2, int times){
	int i = 0;
	// The "meeps" printed out were to help test to make sure flip() and the loop() were working properly, and in tandem.
	while ( i != times ){
	    class1.flip();
	    class2.flip();
	    
	    if (class1.upFace == "heads"){
		//System.out.println ("meep1");
		i += 1;
	    }
	    // Prevents a potential infinite loop by making sure that i does not exceed "times" when i is at times - 1.
	    if (class2.upFace == "heads" && i != times){
		//System.out.println ("meep2");
		i += 1;
	    }
	} // end while loop
	System.out.println (times + " heads have been rolled between both coins!");
    } // end headsLoop

    // Will flip the coins until the number of times the upfaces are the same reaches the number of times
    // takes two instances of class Coin and the number of matches desired
    public static void matchLoop (Coin class1, Coin class2, int times){
	int i = 0;
	// See the note in headsLoop() about "meep"
	while ( i != times ){
	    class1.flip();
	    class2.flip();
	    if (class1.upFace == class2.upFace){
		i += 1;
		//System.out.println ("meep!");
	    }
	} // end loop
	System.out.println (times + " matches have occurred!");
    }// end matchLoop

    // Will flip the coins until the number of matches is over 13000 and is divisible by the year given
    public static void matcheroo (Coin class1, Coin class2, int year){
        int i = 0;
	// See the note in headsLoop() about "meep"
	while (i < 13000  ){
	    class1.flip();
	    class2.flip();
	    if (class1.upFace == class2.upFace){
		i += 1;
		//System.out.println ("meep!");
	    }
	} // end loop

	while ( i % year != 0){
	    class1.flip();
	    class2.flip();
	    if (class1.upFace == class2.upFace){
		i += 1;
		//System.out.println ("meep!");
	    }
	} // end loop
	    
	System.out.println( i + " was the number of matches made to achieve the desired result.");
    }// end matcheroo
    
    public static void main( String[] args )
    {

	//build Objects from blueprint specified by class Coin

	//test default constructor
	//===================TOP==========================
	Coin mine = new Coin();

	//test 1st overloaded constructor
	Coin yours = new Coin( "quarter" );

	//test 2nd overloaded constructor
	Coin wayne = new Coin( "dollar", "heads" );

	//test toString() methods of each Coin
	/*System.out.println("mine: " + mine);
	  System.out.println("yours: " + yours);
	  System.out.println("wayne: " + wayne);

	  //test flip() method
	  System.out.println("\nAfter flipping...");
	  yours.flip();
	  wayne.flip();
	  System.out.println("yours: " + yours);
	  System.out.println("wayne: " + wayne);

	  //test equals() method
	  if ( yours.equals(wayne) ) 
	  System.out.println( "Matchee matchee!" );
	  else
	  System.out.println( "No match. Firestarter you can not be." );

	  //test headsLoop() method
	  headsLoop(yours, wayne, 10); // Flip heads five times

	  //test matchLoop() method
	  matchLoop( yours, wayne, 10); // Flip until 10 matches have occurred*/

	//test matcheroo() method
	matcheroo ( yours, wayne, 2001); // Make the number of matches divisible by 10

	// ====================BOTTOM======================

    }//end main()

}//end class
