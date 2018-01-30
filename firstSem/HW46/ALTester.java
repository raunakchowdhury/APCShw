//Raunak Chowdhury
//APCS1 pd2
//HW46 -- Al<B> Sorted!.
//2017- 12- 04

import java.util.ArrayList;

public class ALTester {

//populate with random ints 23 times
public static void populate (ArrayList <Comparable> a){
        for ( int i = 0; i < 23; i++ ) {
                //a.add(i*2);
                a.add( (int)(Math.random() * 100) );
        }
}

public static Boolean isSorted (ArrayList <Comparable> a){
        for (int i = 0; i < a.size() - 1; i++) {
                Comparable val = a.get(i); // store the value of i in a var
                Comparable valAfter = a.get(i+1); //store the value after in a var
                if ( val.compareTo(valAfter) > 0 )
                        return false; //this will auto-break the loop if this is true
        }
        return true;
}

public static void main(String[] args) {
        ArrayList<Comparable> foo = new ArrayList<Comparable>();
        populate(foo);
        System.out.println(foo);
        System.out.println( isSorted(foo) );
}
}
