// Raunak Chowdhury
// APCS1 pd2
// HW17 -- Do I repeat myself?
// 2017-10-16


public class Repeater
{
    public static String fenceW (int numPosts ){
	String fence = "|";
	while (numPosts > 1){
	    fence += "--|";
	    numPosts -= 1;
	} // end loop
	return fence;
    } // end fenceW()

    public static String fenceR (int numPosts){
	int nextNumPost = numPosts - 1;
	if (numPosts <= 0){
	    return "";
	}
	if (numPosts == 1){
	    return  "|"; // Wil stick a post at the end of the fence
	}
	else {
	    return  "|--" + fenceR(nextNumPost); // I tried doing "--|", but what would happen was that there would be two posts at the end. So I switched up the post order
	    
	} // end conditionals
    } // end fenceR()
    
    public static void main ( String[] args ){
	System.out.println(fenceR(0)); // prints a fence using recursion
	System.out.println(fenceW(3)); // prints a fence via loop
    } // end main
	
} // end class Repeater()
