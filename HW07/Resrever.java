//Jon Chowder-Issac 
//APCS2 pd2
//HW 07 -- A Man, A Plan, A Canal: Panama!
//2018-02-14

public class Resrever {

    public static String revL(String s) { //O(n) runtime
        String result = "";
        for(int i = s.length()-1; i > -1; i--) {
            result += s.substring(i, i+1);
        }
        return result;
    }

    public static String revLogL(String s) { //O(nlogn) runtime
        String left = ""; //Cuts s in half
        String right = "";

        if(s.length() > 1) {
            left = s.substring(0, s.length()/2); //Fills two strings with the respective half in s
            right = s.substring(s.length()/2);
        }
        else
            return s;

        return revLogL(right) + revLogL(left); //Adds the right half to the left --> reversed
    }
    
    public static void main(String[] args) {

        //Testing revLinear
        System.out.println(revL("stressed"));
        System.out.println(revL("automatic"));
        System.out.println(revL("a"));
        System.out.println(revL("de"));
        
        //Testing revLogLinear
        System.out.println(revLogL("stressed"));
        System.out.println(revLogL("automatic"));
        System.out.println(revLogL("a"));
        System.out.println(revLogL("de"));

    }

}
