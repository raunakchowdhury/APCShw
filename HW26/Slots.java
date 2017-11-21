// Raunak Chowdhury
// APCS1 pd2
// HW26 -- Spin Class
// 2017-11-5

/*****************************************************
 * class Slots
 * simulates a slot machine in your very own terminal
 * Clyde "Thluffy" Sinclair
 * APCS1 pd00
 * HW26 -- Shmoney
 * 2017-11-07
 *****************************************************/

public class Slots
{

    private static final String[] FRUITS = {
	"lime", "lime", "lime", 
	"lemon", "lemon", "lemon", 
	"cherry", "cherry", "cherry", 
	"orange", "orange", "orange", 
	"grapefruit", "grapefruit", "grapefruit", 
	"tangerine", "tangerine", "tangerine", 
	"ugli", "ugli", "ugli",
	"peach", "peach", "peach"
    };
  
    private String[] _fruits; //to be init'd by each instance


    /*=====================================
      Slots() -- default constructor
      pre:  constant array FRUITS exists, has been initialized
      post: mutable array _fruits contains same elements as FRUITS
      =====================================*/
    public Slots()
    {
	//allocate memory for _fruits based on size of FRUITS:
	/* YOUR IMPLEMENTATION HERE */
	_fruits = new String [ FRUITS.length ];
	//copy elements of FRUITS into _fruits:
	/* YOUR IMPLEMENTATION HERE */
        for (int i = 0; i < FRUITS.length; i++){
	    _fruits [i] = FRUITS[i];
	}
    }


    /*=====================================
      String toString() -- overrides inherited toString()
      pre:  
      post: returns String of elements in slots 0 thru 2, separated by tabs
      =====================================*/
    public String toString()
    {
	/* YOUR IMPLEMENTATION HERE */
	String [] strArray = {
	    _fruits [0],
	    _fruits [1],
	    _fruits [2]
	};
	return retArray (strArray);
    }


    /*=====================================
      void swap(int,int) -- array swap util fxn
      pre:  _fruits array exists
      post: elements at indices i, j are swapped
      =====================================*/
    private void swap( int i, int j )
    {
	/* YOUR IMPLEMENTATION HERE */
	String iVal = _fruits[i];
	_fruits[i] = _fruits[j];
	_fruits[j] = iVal;
	
    }


    /*=====================================
      void spinOnce() -- simulate a pull of the slot machine lever
      pre:  _fruits array exists
      post: randomized order of elements in _fruits array
      =====================================*/
    public void spinOnce()
    {
	/* YOUR IMPLEMENTATION HERE */
	int length = _fruits.length; // length of the fruit array
	for (String i : _fruits)
	    {
		int index = (int) ( Math.random() * length );
		int secondIndex = (int) ( Math.random() * length );
	        swap(index, secondIndex); //after taking two random ints, swap
				      
	    }
    }


    /*=====================================
      boolean jackpot() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      false otherwise
      =====================================*/
    public boolean jackpot()
    {
	/* YOUR IMPLEMENTATION HERE */
	if ( _fruits[0] == _fruits[1] &&
	     _fruits[1] == _fruits[2]) // checks to see if all of the fruits are equal
	    { return true; }
	return false;
    }


    /*=====================================
      boolean miniWin() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      or if first 3 slots mutually distinct, 
      false otherwise
      =====================================*/
    public boolean miniWin()
    {
	/* YOUR IMPLEMENTATION HERE */
	if ( _fruits[0] == _fruits[1] &&
	     _fruits[1] == _fruits[2] ) // checks to see if all of the fruits are equal
	    { return true; }
	else if (
		 _fruits[0] != _fruits[1] && // are the three distinct?
		 _fruits[1] != _fruits[2] )
	    { return true; }
	return false;
	    
		
    }


    //A static method to return a String version of an array of ints.
    public static String retArray ( String [] a){
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
    
    //main() method for testing
    public static void main( String[] args )
    {
	//usage: move bar below down 1 line at a time to test functionality...

	Slots machine01 = new Slots();
	Slots machine02 = new Slots();

	//test to verify slot machines function indepently
	System.out.println();
	System.out.println( "Machine01 initial state:\t" + machine01 );
	System.out.println( "Machine02 initial state:\t" + machine02 );

	
	System.out.println( "\nSpinning machine01...\n" );

	machine01.spinOnce();

	System.out.println();
	System.out.println( "Machine01 state:\t" + machine01 );
	System.out.println( "Machine02 state:\t" + machine02 );
	System.out.println();


	//test gamble-until-you-win mechanism

	System.out.println( "Preparing to spin until a mini win! . . ." );
	System.out.println( "------------------------------------" );

	//if you haven't won, spin again until you win!
	while( machine01.miniWin() == false ) {
	    System.out.println( "Your spin..." + "\t" + machine01 );
	    System.out.println( "LOSE\n" );
	    machine01.spinOnce();
	}

	System.out.println( "====================================" );
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "WIN\n" );



	  System.out.println( "Preparing to spin until...jackpot! . . ." );
	  System.out.println( "------------------------------------" );

	  //if you haven't won, spin again until you win!
	  while( machine01.jackpot() == false ) {
	  System.out.println( "Your spin..." + "\t" + machine01 );
	  System.out.println( "LOSE\n" );
	  machine01.spinOnce();
	  }

	  System.out.println( "====================================" );
	  System.out.println( "Your spin..." + "\t" + machine01 );
	  System.out.println( "JACKPOT!\n" );
	  	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class Slots
