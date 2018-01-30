// Team "Press F to Pay Respects" -- Raunak Chowdhury, Jude Grodesky, Peter Cwalina
// APCS1 pd2
// HW24 -- Imetay Otay Ineshay
// 2017-27-10


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

/* Expansions (not in order):
   1. Included the y exception (Treat y as a vowel when in front of a string) 
   2. Added support for capitialization 
   3. Added support for punctuation 
   4. Added support for exceptions such as mixed lowercase and uppercase strings, and strings with no letters in them
   5. Added Scanner class utility
*/

import java.util.Scanner;

public class Pig
{
    //Q: How does this initialization make your life easier?
    //A: This allows you to code the isAVowel() method as a one line method instead of a loop
    //This method then allows you to code the last three methods very easily.
    private static final String VOWELS = "aeiouAEIOU";
    private static final String CONST = "bcdfghjklmnpqrstvwxyz";
    private static final String PUNCT = ".?,!):";


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
      ;      =====================================*/
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
	    return ""; // for futureproofing purposes
	}
    }

    //pre: w != null
    //post: firstVowel("") --> ""
    //      firstVowel("zzz") --> ""
    //      firstVowel("meatball") --> "e"
    public static String firstVowel( String w){
	String retStr = allVowels (w);
	if (retStr == ""){
	    return ""; 
	} else {
	    return retStr.substring(0, 1);
	}
    }

    //pre: w != null and w.length() > 0
    //post: beginsWithVowel("apple")  --> true
    //      beginsWithVowel("strong") --> false
    public static Boolean beginsWithVowel (String w){
	return isAVowel(w.substring(0,1));	
    }

    public static Boolean hasConsonants ( String w ){ //checks to see if there are ANY consonants in a string
	w = w.toLowerCase();
	for ( int i = 0; i < w.length(); i++){
	    if ( CONST.indexOf(w.substring (i,i+1)) > -1 ){
		return true;
	    }
	}
	return false;
    }


    // Holds the actual algorithm for the pigLatin method
    public static String basePig ( String w ){
	String retStr = "";
	String punctHolder = ""; // used to hold the punctuation
	String lastChar = w.substring( w.length() - 1 ); //stores the last character of the String

	if ( PUNCT.indexOf(lastChar) > -1 ){ //checks for punctuation based on the string
	    punctHolder += lastChar; // this seems inefficient, but is needed to add the punctuation at the end of method
	    w = w.substring(0, w.length() - 1); // change w so that it no longer have the punct mark
	}

	if( beginsWithVowel(w)) { 
	    retStr += w + "way"; 
	}
	else {
	    if (hasAVowel(w)){
		int firstVowel = w.indexOf(firstVowel(w)); //find the index of the first vowel in the string
		String firstPart = w.substring(0, firstVowel); //find the section of the string up to the first vowel
		retStr += w.substring(firstVowel); // add everything after the first vowel
		retStr += firstPart; //add the rest of the string
		retStr += "ay";
	    }
	    else if (hasA(w ,"y")) { // y exception
		int firstVowel = w.indexOf("y"); //find the index of the first y in the string
		String firstPart = w.substring(0, firstVowel); //find the section of the string up to the first y
		retStr += w.substring(firstVowel); // add everything after the first y
		retStr += firstPart; //add the rest of the string
		retStr += "ay";
	    }
	    else { // if no vowels
		if (! hasConsonants (w) ){ //checks to see if there are any consonants in the string
		    retStr = w;
	      }
	      else {
		    retStr += w + "ay";
	      }
	    }
	}
	retStr += punctHolder + " "; // if there is no punct, a null string is added; otherwise, the punct is added
	// The space is for clarity
	return retStr;
    }

    //pre: w.length() > 0
    //post: engToPig("apple")  --> "appleway"
    //      engToPig("strong") --> "ongstray"
    //      engToPig("java")   --> "avajay"
    public static String engToPig(String w){
	String retStr = "";
	
	if (w.substring(0,1).equals( w.toUpperCase().substring(0,1)) ){ // is the first letter uppercase?
	    if ( w.equals( w.toUpperCase()) ){ // is the entire String uppercase?
		retStr += basePig(w).toUpperCase();
	    }
	    else { // takes care of the randomized lowercase and caps
		String firstChar = w.substring(0,1); //first character
		String firstPigChar =  basePig(w).substring(0,1); //creat a variable that stores the first charachter of the pigged string
		w = firstChar.toLowerCase() + w.substring(1); // change w so that the first character is lowercase
		retStr += firstPigChar.toUpperCase() + basePig(w).substring(1);
	    }
	}
	else {
		retStr += basePig(w); // if not, just follow the regular rules
	}
	return retStr;
    }

    
    public static void main( String[] args ) 
    {
	/* YOUR TEST CALLS HERE *//*
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
	   System.out.println(firstVowel("meatball"));// "e"

	   System.out.println("==============beginsWithVowel() method================");
	   System.out.println(beginsWithVowel("jood")); // f
	   System.out.println(beginsWithVowel("rennek")); // f
	   System.out.println(beginsWithVowel("pytah")); // f
	   System.out.println(beginsWithVowel("odeski")); // t
	   System.out.println(beginsWithVowel("oodj")); // t
	   System.out.println(beginsWithVowel("alina")); //t

	   System.out.println("==============beginsWithVowel() method================");
	   System.out.println( engToPig("apple"));  // "appleway"
	   System.out.println( engToPig("character")); // "aracterchay"
	   System.out.println( engToPig("strong")); // "ongstray"
	   System.out.println(engToPig("java"));   //"avajay"*/
	

	//Live user input shenangians
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()){
	    System.out.print(engToPig(sc.next()));
	}


    }//end main()

}//end class Pig
