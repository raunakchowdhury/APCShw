// Raunak Chowdhury
// APCS1 pd2
// HW22 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
// 2017-24-10


/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
    //Q: How does this initialization make your life easier?
    //A: This allows you to code the isAVowel() method as a one line method instead of a loop
    //This method then allows you to code the last three methods very easily.
    private static final String VOWELS = "aeiouAEIOU";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	return w.indexOf(letter) > -1;
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	return VOWELS.indexOf(letter) > -1;
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	int total = 0;
	for (int i = 0; i < w.length(); i++)
	    {
		String letter = w.substring(i, i + 1); // stores the letter in a variable for clarity
		if (isAVowel(letter)){
		    total += 1;
		}	
	    } // end foreach loop
	return total;
    } 


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
        return countVowels(w) > 0;
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	String retStr = "";
	/* YOUR IMPLEMENTATION HERE */
	if (hasAVowel(w)){
	    for (int i = 0; i < w.length(); i++)
		{
		    String letter = w.substring(i, i + 1); // stores the letter in a variable for clarity
		    if (isAVowel(letter)){
			retStr += letter; //add the vowel to the string
		    }	
		} // end foreach loop
	    return retStr;
	} else {
	    return "There are no vowels in String: " + w; // for futureproofing purposes
	}
    }

    public static String firstVowel( String w){
	String retStr = allVowels (w);
	if ( w == "" ||
	     (!(hasAVowel(w)))
	    {
	return retStr.substring(0, 1);
    }

    


    public static void main( String[] args ) 
    {
	/* YOUR TEST CALLS HERE */
	System.out.println("=============hasA method============");
	System.out.println(hasA("cat", "a"));// true
	System.out.println(hasA("cat", "p"));// false
	
	System.out.println("===========isAVowel method==============");
	System.out.println(isAVowel("p")); // false
	System.out.println(isAVowel("a")); //true

	System.out.println("==============countVowels method================");
	System.out.println(countVowels("brown"));
	System.out.println(countVowels("atanagoge"));

	System.out.println("==============hasAVowel method================");
	System.out.println( hasAVowel("brwn")); //false
	System.out.println(hasAVowel("tngg")); //false
	
	System.out.println(hasAVowel("brown")); //true
	System.out.println(hasAVowel("atanagoge")); //true

	System.out.println("==============allVowels method================");
	System.out.println(allVowels("brwn")); //Nothing
	System.out.println(allVowels("tngg")); //Nothing
	System.out.println(allVowels("brown")); // o
	System.out.println(allVowels("atanagoge")); // aaaoe

	System.out.println("==============firstVowel() method================");
	System.out.println(firstVowel("jood"));
	System.out.println(firstVowel("rennek"));
	System.out.println(firstVowel("pytah"));
	System.out.println(firstVowel(""));
    }//end main()

}//end class Pig
