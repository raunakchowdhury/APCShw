// Raunak Chowdhury
// APCS1 pd2
// HW07 -- On the Origins of a BigSib
// 2017-09-26

public class BigSib{
    // instance vars
    private String helloMsg;

    // Constructor
    public BigSib (){
	helloMsg = "Why hello there,";
	    }
    
    public BigSib ( String newStr ){
	helloMsg = newStr;
    }

    
    // greet method
    public String greet ( String str){
	String newStr;
       	newStr = helloMsg;
	newStr += " ";
	newStr += str;
	return newStr; 
    }
}

/* The constructor uses the same process as the setHelloMsg method, but the time at which the intial phrase (eg. "Word up") is stored differs greatly. setHelloMsg only stores the beginning phrase at the time of the method call, but the constructor does this automatically, bypassing the need to type more lines of code that just generates clutter. I like this a lot. */

