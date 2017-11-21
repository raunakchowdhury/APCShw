// Raunak Chowdhury
// APCS1 pd2
// HW #36 -- Be Rational
// 2017-11-17

public class Rational {
private int p;
private int q;

//default constructor
public Rational(){
        p = 0; //numerator
        q = 1; // denominator
}

// overloaded constructor
public Rational(int numerator, int denominator){
        this();
        if (denominator != 0) {
                p = numerator;
                q = denominator;
        }
        else {
                System.out.print("Invalid denominator for fraction " + numerator + "/0! ");
                System.out.println("Rational set to default.");
        }
}

// overwritten toString
public String toString(){
        String retStr = p + "/" + q;
        return retStr;
}

public double floatValue(){
        return (double) p / q;
}

public void multiply ( Rational frac ){
        p = this.p * frac.p;
        q = this.q * frac.q;
}

public void divide ( Rational frac ){
        if (this.p == 0 || frac.p == 0) {
                System.out.println("Invalid operation. Divide by 0 error");
        }
        else {
                p *= frac.q;
                q *= frac.p;
        }
} // end divide

public static int gcd ( int a, int b){ // Does a recursive algorithm of GCD
        if (a % b == 0) {
                return b;
        }
        return gcd( b, a%b);
}

public void reduce (){ //your "simplify" method
        int gcd = gcd(p,q); //store the gcd
        this.p /= gcd; //simplify
        this.q /= gcd; //simplify
}

public void add (Rational r){
        this.p *= r.q; // multiply the numerator by the denominator of the other Rational
        this.p += (r.p * this.q); // add the numerator of the other Rational
        this.q *= r.q; // multiply the numerator of the second Rational by the first
}

public void subtract (Rational r){
        this.p *= r.q; // multiply the numerator by the denominator of the other Rational
        this.p -= (r.p * this.q); // add the numerator of the other Rational
        this.q *= r.q; // multiply the numerator of the second Rational by the first
}

/*============================================
   post-cond: 0 if the two Rationals are equal,
            1 if the calling Rational > param,
            -1 if the calling Rational < param
   ============================================*/
public int compareTo( Rational r ){
        double value = floatValue();
        double value2 = r.floatValue();
        if ( value == value2 ) {
                return 0;
        }
        else if( value > value2 ) {
                return 1;
        }
        return -1;
} // end compareTo

public static void main(String[] args) {
        Rational r = new Rational(2,3);
        Rational s = new Rational (1,6);
        Rational undef = new Rational (2,0);
        /*======================================
           System.out.println(undef);
           System.out.println("Testing toString...");
           System.out.println("Rational number r: " + r);
           System.out.println("Rational number s: " + s);

           System.out.println("Testing floatValue...");
           System.out.println( "Rational number r: " + r.floatValue() );
           System.out.println( "Rational number s: " + s.floatValue() );

           System.out.println("Testing multiply...");
           r.multiply(s);
           System.out.println("Rational number r multiplied by s: " + r);

           System.out.println("Testing divide...");
           r.divide(s);
           System.out.println("Rational number r divided by s: " + r);
           // =============HW36===============*/

        System.out.println("Testing add...");
        r.add(s);
        System.out.println("Sum: " + r);

        System.out.println("Testing subtract...");
        r.subtract(s);    // 9/18
        System.out.println("Difference: " + r);
        //s.subtract(r);
        //System.out.println("Difference: " + s);

        System.out.println("Testing reduce...");
        r.reduce();
        System.out.println(r);    // 1/2

        System.out.println("Testing reduce...");
        r.reduce();
        System.out.println(r);

        Rational r2 = new Rational (2,3); // for testing purposes
        System.out.println("Testing compareTo...");
        System.out.println( "r compared to s: " + r.compareTo(s) );
        System.out.println( "s compared to r: " + s.compareTo(r) );
        System.out.println( "r compared to r2: " + r.compareTo(r2) );
} //end main

} // end class Rational
