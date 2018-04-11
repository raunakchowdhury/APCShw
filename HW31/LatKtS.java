//Raunak Chowdhury
//APCS2 pd2
//HW31 -- Stack: What Is It Good For?               well, this.
//2018-10-04

/*****************************************************
* skeleton for class LatKtS
* Driver class for Latkes.
* Uses a stack to reverse a text string, check for sets of matching parens.
*****************************************************/


public class LatKtS
{

/**********************************************************
* precondition:  input string has length > 0
* postcondition: returns reversed string s
*                flip("desserts") -> "stressed"
**********************************************************/
public static String flip( String s )
{
        Latkes stack = new Latkes(s.length());
        String retStr = "";
        for (int i=0; i<s.length(); i++) {
                stack.push(s.substring(i,i+1));
        }
        while (!stack.isEmpty()) {
                retStr += stack.pop();
        }
        return retStr;
}  //end flip()


/**********************************************************
* precondition:  s contains only the characters {,},(,),[,]
* postcondition: allMatched( "({}[()])" )    -> true
*                allMatched( "([)]" )        -> false
*                allMatched( "" )            -> true
**********************************************************/
public static boolean allMatched( String s )
{
        if (s.equals(""))
                return true;
        Latkes stack = new Latkes(s.length());
        for (int i=0; i<s.length(); i++) {
                String sub = s.substring(i,i+1);
                // if {,[,( then add it to the stack
                if (sub.equals("{") || sub.equals("(") || sub.equals("["))
                        stack.push(sub);
                /**********************************************************
                 * check to see if the reverse character is in the stack
                 * if it's not in the stack, return false
                 * if it is, remove it from the stack
                 ***********************************************************/
                else {
                        String pop = stack.pop();
                        //System.out.println("pop" + i + ": " + pop);
                        //System.out.println("sub" + i + ": " + sub);
                        if (sub.equals("}")) {
                                if (pop == null || !pop.equals("{"))
                                        return false;
                        }
                        else if (sub.equals("]")) {
                                if ( pop == null || !pop.equals("["))
                                        return false;
                        }
                        else if ( sub.equals(")")) {
                                if (pop == null || !pop.equals("("))
                                        return false;
                        }
                }
        }
        //if you're at this point and the stack is empty, then all {,(,[ have matches
        return stack.isEmpty();
}  //end allMatched()

//main method to test
public static void main( String[] args )
{
        System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" ));    //true
        System.out.println(allMatched( "([)]" ) );    //false
        System.out.println(allMatched( "(){([])}" ) );    //true
        System.out.println(allMatched( "](){([])}" ) );    //false
        System.out.println(allMatched( "(){([])}(" ) );    //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) );    //true
        /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

           ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
}

}//end class LatKtS
