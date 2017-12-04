//Raunak Chowdhury
//APCS1 pd2
//HW46 -- Al<B> Sorted!.
//2017- 12- 04

import java.util.ArrayList;

public class ALTester {

private int[] _data;

// populate the arrya with random ints
public ALTester(){
        _data = new int [23];
        // populate the array with random ints
        for (int i = 0; i < _data.length; i++) {
                _data[i] = (int) ( Math.random() * 100 );
        }
}

//output _data in [a,b,c] format
public String toString()
{
        String foo = "[";
        for( int i = 0; i < _size; i++ ) {
                foo += _data[i] + ",";
        }
        if ( foo.length() > 1 )
                //shave off trailing comma
                foo = foo.substring( 0, foo.length()-1 );
        foo += "]";
        return foo;
}


public static int max(int a, int b){ // Find the maximum of two INTEGERS
// Pre-condition: take two integers a and b
// Post-condition: return the larger integer
        if (a > b) {
                return a;
        }
        else{
                return b;
        }
}

}
