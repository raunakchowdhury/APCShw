// Raunak Chowdhury
// APCS1 pd2
// HW20 -- For the Lulz Love of Strings .
// 2017-10-19

public class Foresrever{
    public static String fenceF (int posts ){
	String fence = "";
	if (posts > 0){
	    fence += "|";
	}
	for (int i = 2; i <= posts; i++){
	    fence += "--|";
	}
	return fence;
    }// end FenceF 

    public static String reverseF ( String s){
	String newStr = "";
	int lengths = s.length() - 1;// This will be used to access the string from the other side (as a string's characters from 0 to the length -1)
	for (int i = 0; i <= lengths; i++){
	    String slice =  s.substring (lengths - i,lengths - i + 1); // to access each individual char in the string
	    //System.out.println(slice); // used for debugging
	    newStr += slice;
	}
	return newStr;
    } // end reverseF


    public static String reverseR (String s){
	int lengths = s.length();
	if( lengths <= 1){ //Added null string protection 
	    return s;
	}
	else{
	    return s.substring(lengths -1) +
		reverseR(s.substring(0, lengths - 1)); // Add the the last character, and then take the ReverseR of the String without the last character
	}
    } // end reverseR

    public static void main ( String[] args ){
	System.out.println("fenceF function:");
	System.out.println(fenceF(1));
	System.out.println(fenceF(2));
	System.out.println(fenceF(3));
	System.out.println(fenceF(0));
	System.out.println("-----------------");

      	System.out.println("reverseF function:");
	System.out.println(reverseF("Bryan"));
	System.out.println(reverseF("Jack Zaia"));
	System.out.println(reverseF("Connie Lei"));
	System.out.println(reverseF("Raunak"));
	System.out.println(reverseF("omae wa mou shinderu"));
	System.out.println(reverseF("nani"));
	System.out.println("-----------------");

	System.out.println("reverseR function:");
	System.out.println(reverseR("Bayan"));
	System.out.println(reverseR("Jake Zaia"));
	System.out.println(reverseR("Connie Lei"));
	System.out.println(reverseR("Raunak"));
	System.out.println(reverseR("omae wa mou shinderu"));
	System.out.println(reverseR("nani"));
	System.out.println("-----------------");
	
    }
}
