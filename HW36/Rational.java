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
        p = numerator;
        q = denominator;
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
        p *= frac.q;
        q *= frac.p;
}

public static void main(String[] args) {
        Rational r = new Rational(2,3);
        Rational s = new Rational (1,6);
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


}
}
