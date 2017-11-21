// Raunak Chowdhury
// APCS1 pd2

public class Experiment{
    // Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
    public static String helloName(String name) {
	return "Hello " + name +"!";
    }

    //Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".

    public static String makeAbba(String a, String b) {
	String retStr = "";
	retStr += a;
	retStr += b;
	retStr += b;
	retStr += a;
	return retStr;
    }


    // Given a string, return a string where for every char in the original, there are two chars.
    public static String doubleChar(String str) {
	String retStr ="";
	for (int i = 0; i < str.length(); i ++){
	    retStr += str.substring(i, i+1);
	    retStr += str.substring(i, i+1);
	}
	return retStr;
    }

    // Return the number of times that the string "hi" appears anywhere in the given string.
    public static int countHi(String str) {
	int times = 0;
	if (str.length() <= 1){
	    return times;
	}
	int lengths = str.length() - 2;
	for (int i = 0; i < lengths; i++){
	    if(str.substring(i, i + 2).equals("hi")){
		times += 1;
	    }
	}
	if (str.substring(lengths, str.length()).equals("hi")){
	    times += 1;
	}
	return times;
    }

    // Return true if the string "cat" and "dog" appear the same number of times in the given string.
    public static boolean catDog(String str) {
	int catTimes = 0;
	int dogTimes = 0;
	int lengths = str.length() - 3;

	if (str.length() <= 2){
	    return catTimes == dogTimes;
	}
	// cat/dog loop
	for (int i = 0; i < lengths; i++){
	    if(str.substring(i, i + 3).equals("cat")){
		catTimes += 1;
	    }
	    if(str.substring(i, i + 3).equals("dog")){
		dogTimes += 1;
	    }
	}
	if (str.substring(lengths, str.length()).equals("cat")){
	    catTimes += 1;
	} 
	if (str.substring(lengths, str.length()).equals("dog")){
	    dogTimes += 1;
	}
	return catTimes == dogTimes;
    }

    // Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
    public static int countCode(String str) {
	int times = 0;
	if (str.length() <= 3){
	    return times;
	}
	int lengths = str.length() - 4;
	for (int i = 0; i < lengths; i++){
	    if(str.substring(i, i + 2).equals("co")){
		if (str.substring(i + 3, i + 4).equals("e")){ 
		    times += 1;
		}
	    }
	}
	if (str.substring(str.length() - 4, str.length() - 2).equals("co")){
	    if (str.substring(str.length() - 1, str.length()).equals("e")){ 
		times += 1;
	    }
	}
	return times;
    }

    // Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.
    public static int min(int a, int b){ // Find the minimum of two DECIMALS
	// Pre-condition: take two doubles a and b
	// Post-condition: return the smaller double
	if (a > b){
	    return b;
	}
	else{
	    return a;
	} 
    }
    
    public static boolean endOther(String a, String b) {
	String aLower = a.toLowerCase();
	String bLower = b.toLowerCase();
	String truncator = "";
	int minStr = min (aLower.length(),bLower.length());

	if (minStr == aLower.length()){
	    truncator = bLower.substring(bLower.length() - minStr, bLower.length());
	    return aLower.equals(truncator);
	}
	else {
	    truncator = aLower.substring(aLower.length() - minStr, aLower.length());
	    return bLower.equals(truncator);
	}
    }

    //Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
    public static boolean xyzThere(String str) {
	int length = str.length();
	int lengths = length - 3;
	int i = 0;
	// these conditionals are to deal with extraneous exceptions (like null and "xy"
	if (str.equals("xyz")){
	    return str.equals("xyz");
	}
	else if (length <= 3){
	    return false;
	}
	else if (str.equals(".xyz")){
	    i += 4;
	}

	// while loop for general xyz finding 
	while (i < lengths){
	    if (str.substring(i, i + 3).equals("xyz") &&
		i != 0){
		if (! str.substring(i - 1, i).equals(".") && // check behind
		    ! str.substring(i, i + 1).equals(".")){ // check in front
		    return true;
		}
	    }
	    
	    if (i == 0 && str.substring(i, i + 3).equals("xyz")){ //pesky exception requires pesky code - check in front if the beginning portion is "xyz"
		if (! str.substring(i, i + 1).equals(".")){
		    return true;
		}
	    }
	    i += 1;
	}
	
	if (str.substring(lengths, length).equals("xyz")){
	    if (! str.substring(lengths - 1, lengths).equals(".")){
		return true; // takes care of the exception of "xyz" at the end
	    }
	}
	return false; // if everything above was false/not called, the method will return flase by default
    }
    

    public static void main ( String[] args){
	System.out.println("helloName method:");
	System.out.println(helloName("Bob")); // "Hello Bob!"
	System.out.println(helloName("Alice")); // "Hello Alice!"
	System.out.println(helloName("X")); // "Hello X!"
	System.out.println("-----------------");

	System.out.println("makeAbba method:");
	System.out.println(makeAbba("Hi", "Bye")); // "HiByeByeHi"
	System.out.println(makeAbba("Yo", "Alice")); // "YoAliceAliceYo"
	System.out.println(makeAbba("What", "Up")); // "WhatUpUpWhat"
	System.out.println("-----------------");

	System.out.println("doubleChar method:");
	System.out.println(doubleChar("The")); // "TThhee"
	System.out.println(doubleChar("AAbb")); // "AAAAbbbb"
	System.out.println(doubleChar("Hi-There"));// "HHii--TThheerree"
	System.out.println("-----------------");

	System.out.println("countHi method:");
	System.out.println(countHi("abc hi ho")); // 1
	System.out.println(countHi("ABChi hi")); // 2
	System.out.println(countHi("hihi")); // 2
	System.out.println("------------------");

	System.out.println("catDog method:");
	System.out.println(catDog("catdog")); // true
	System.out.println(catDog("catcat")); //false
	System.out.println(catDog("1cat1cadodog")); // true
	System.out.println("-----------------");

	System.out.println("countCode method:");
	System.out.println(countCode("aaacodebbb")); // 1
	System.out.println(countCode("codexxcode")); // 2
	System.out.println(countCode("cozexxcope")); // 2
	System.out.println("-----------------");

	System.out.println("endOther method:");
	System.out.println(endOther("Hiabc", "abc")); // true
	System.out.println(endOther("AbC", "HiaBc")); // true
	System.out.println(endOther("abc", "abXabc")); // true
	System.out.println("-----------------");

	System.out.println("xyzThere method:");
	System.out.println(xyzThere("abcxyz")); // true
	System.out.println(xyzThere("abc.xyz")); // false
	System.out.println(xyzThere("xyz.abc")); // true
	System.out.println("-----------------");

    }
	
}

