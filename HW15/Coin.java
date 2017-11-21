// Raunak Chowdhury
// APCS1 pd2
// HW15 --  Wayne's World
// 2017-10-11

import java.lang.Math;

public class Coin{
    //attributesCreate a var that stores what side the coin is facing
    private double value; // monetary worth
    private String upFace; // face showing currently. (“heads” or “tails”)
    private String name; // “penny”, “nickel”, etc.
    private int flipCtr; // number of times this coin has been flipped
    private int headsCtr; // number of times this coin has landed heads-up
    private int tailsCtr; // number of times this coin has landed tails-up
    private double bias; // likelihood of landing heads-up every time (1.0) or tails-up every time (0.0)

    // default constructor
    public Coin(){
	upFace = "heads";
	bias = 0.5; // Set the probability of rolling heads
    }

    // overloaded constructor that takes an argument for the denomination, and sets the name to said denomination
    public Coin ( String currency ){
	this();
	name = currency;
	assignValue();
	
    }

    // overloaded constructor that takes two arguments in order to set the denomination and the upFace value
    public Coin ( String currency, String faceState){
	this();
	name = currency;
	upFace = faceState;
	assignValue();
    }

    
    // overwritten toString()
    public String toString(){
	String retStr = name;
	retStr += " -- ";
	retStr += upFace;
	return retStr;
    }

    // assigns a monetary value to the currency set upon the creation of the instance
    public void assignValue(){
	if (name == "quarter"){
	    value = 0.25;
	}
	else if (name == "dime"){
	    value = 0.10;
		}
	else if (name == "nickel"){
	    value = 0.05;
	}
	else if (name == "penny"){
	    value = 0.01;
	}
	else {
	    value = 1.00;
	}
    } // end method assignValue
    
    // Compare attributes
    public Boolean equals ( Coin  otherObject ){
	return  upFace == otherObject.upFace;
      }
    // Since the parameter indicated in Driver.java was an instance of a class, I thought that calling that class as the argument (as it is done when creating the class) would solve the dilemma of what to attach to the front of my argument. Apparently, my intuition was correct.

    
    //flip() method
    public void flip (){
	double rand = Math.random(); // create a var in order to store the random value
      	if (rand <= bias){ // "Flips" a coin, and generates a result based on the output, relative to the probability of bias
	    upFace = "heads";
	}
	else {
	    upFace = "tails";
	}
    } // end method flip()

    // ========================== MAIN ================================
    // Created a main method in order to independently test methods without messing up Driver.java
    public static void main (String[] args){
	System.out.println ("Testing default constructor...");
	Coin mine = new Coin();
	System.out.println("mine: " + mine);

	System.out.println ("Testing overloaded constructor 1...");
	Coin yours = new Coin("quarter");
	System.out.println("yours: " + yours);

	System.out.println ("Testing overloaded constructor 2...");
	Coin wayne = new Coin( "dollar", "heads" );
	System.out.println("wayne: " + wayne);

	System.out.println ("Testing flip methods...");
	mine.flip();
	System.out.println(mine);
	
    } // end main
    


    
} //end class Coin
