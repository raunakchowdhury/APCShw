//Raunak Chowdhury
//APCS1 pd2
//HW21 -- Karmacomma,
//2017-23-10

public class Commafier{
    
    public static String commafyR (int num){ //"commify" via recursion
	String bert = ""; // necessary for returning a String
	int lastThreeDigits = num % 1000; // get the last three digits
	//System.out.println(lastThreeDigits); // for testing
	if (0 <= num && num < 1000){
	    return bert += num;
	} else if ( lastThreeDigits == 0) {
	    return bert += commafyR(num / 1000) + "," + "00" + lastThreeDigits; // if the lastthreeDigits has two leading zeroes
	} else if (lastThreeDigits > 0 && lastThreeDigits < 100) {
	    return bert += commafyR(num / 1000) + "," + "0" + lastThreeDigits; // deals with the exception in which the last three digits has a leading 0
	} else {
	    return bert += commafyR(num / 1000) + "," + lastThreeDigits; // if there are no leading zeroes in the last three digits, proceed as normal
	}	    
    }

    public static String commafyF (int num ){
	String retStr = "";
	while (! (num < 1000)){
	    String commaAndDigits = ",";
	    int lastThreeDigits = num % 1000;
	    if ( lastThreeDigits == 0){ // two leading zeroes exception
		commaAndDigits = commaAndDigits + "00" + lastThreeDigits;
	    }
	    else if (lastThreeDigits > 0 && lastThreeDigits < 100) { // one leading zero exception
		commaAndDigits = commaAndDigits + "0" + lastThreeDigits;
	    }
	    else { // otherwise, just add the digits after the comma
		commaAndDigits = commaAndDigits + lastThreeDigits;
	    }
	    retStr = commaAndDigits + retStr;
	    num = num / 1000; // increment num by cutting off the last three integers
	}
	retStr = num + retStr;
	return retStr;
	}
	    
	
    public static void main ( String[] args ){
	for ( String s : args){
	    int num = Integer.parseInt(s);
	    System.out.println(commafyR(num));
	    System.out.println(commafyF(num));
	}

	/*System.out.println(commafyR(100)); //100
	System.out.println(commafyF(100)); //100

	System.out.println(commafyR(14607)); //14,607
	System.out.println(commafyF(14607)); //14,607*/

    }
}
