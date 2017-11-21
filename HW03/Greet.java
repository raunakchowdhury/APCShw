/* Raunak Chowdhury
APCS1 pd2
HW 03 -- Howdy, <VeryInterestingPerson>!
2017-09-18 */

public class Greet{
    public static void greet( String name ){
	System.out.print ("Why, hello there, ");
	System.out.print (name);
	System.out.println (". How do you do?");
    }
    
    public static void main ( String[] args){
	greet ("Foo");
	greet ("Moo");
	greet ("Zoo");
    }
}
	
