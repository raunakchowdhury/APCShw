public class Passer {

public static int _jerry;

public Passer(){
        System.out.println(_jerry + 1);
}

// change the val of  int a
public static int addOne( int a){
        int b;
        //System.out.println(b+1);
        return a += 1;
}

public static String turnHey (){
        return "hey";

}

public static void main(String[] args) {
        //test of integers
        Passer bert = new Passer();
        System.out.println(_jerry);
        /**

           System.out.println("========TESTING INTEGERS=========");
           int a = 3;
           System.out.println(a);
           a = bert.addOne(a);
           System.out.println(a);
           int b = 4;
           //System.out.println(a == b);
           // Conclusion: pass-by-ref
           // a points to 4 instead of 3

           // ======NON PRIMITIVES============
           System.out.println("===========NON-PRIMITIVES=========");
           String c = "hey";
           String f = "foo";
           System.out.println(f.equals(c)); //false
           f = turnHey();
           System.out.println(c.equals(f)); //true
           //Conclusion: Java is pass-by-ref. We set the String f to "hey", which caused the addresses of c and f to be equal.

           //String b = "ryan";
         **/

}
}
