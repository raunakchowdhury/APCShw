//Raunak Chowdhury
//APCS1 pd2
//HW49 -- Halving the Halves
//2017-12-08

/********************************
* class OrderedArrayList
* wrapper class for ArrayList.
* Imposes the restriction that stored items
* must remain sorted in ascending order
********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
// instance of class ArrayList, holding objects of type Comparable
// (ie, instances of a class that implements interface Comparable)
private ArrayList<Comparable> _data;


// default constructor initializes instance variable _data
public OrderedArrayList()
{
        _data = new ArrayList<Comparable>();
}


public String toString()
{
        return _data.toString();
}


public Comparable remove( int index )
{
        return _data.remove(index);
}


public int size()
{
        return _data.size();
}


public Comparable get( int index )
{
        return _data.get(index);
}


/***
 * add takes as input any comparable object
 * (i.e., any object of a class implementing interface Comparable)
 * inserts newVal at the appropriate index
 * maintains ascending order of elements
 * uses a linear search to find appropriate index
 ***/
public void add( Comparable newVal )
{
        for( int p = 0; p < _data.size(); p++ ) {
                if ( newVal.compareTo( _data.get(p) ) < 0 ) {
                        //newVal < oal[p]
                        _data.add( p, newVal );
                        return; //Q:why not break?
                }
        }
        _data.add( newVal ); //newVal > every item in oal, so add to end
}

// Employs binary search to insert an element
public void addBin( Comparable val ){
        // set vars to act as the range
        int lo = 0;
        int hi = size();
        // find the midpoint of the hi and lo. This will be used in binary search.
        int midpoint = (lo + hi) / 2;

// deal with the scenario where val is greater than the last element or less than the first element
        if ( val.compareTo( _data.get(0) ) <= 0 ) {
                _data.add(0,val);
                return; // if the val has been added, no need to run the rest of the code
        }
        else if ( val.compareTo( _data.get(size()-1) )  >= 0) {
                _data.add(size(), val);
                return; // see above comment
        }

        while (true) {
                // look to see if val is sandwiched between the indices, based on midpoint.
                // this accounts for the scenario where a second value is added which matches a number in the array.
                if ( val.compareTo( _data.get(midpoint) ) <= 0 &&
                     val.compareTo( _data.get(midpoint - 1) ) >= 0 ) {
                        _data.add(midpoint, val);
                        return;
                }

                // if the algorithm is searching too far to the left
                else if (val.compareTo( _data.get(midpoint) ) > 0)
                        lo = midpoint; // shift the range to a smaller section to the right

                // if the algorithm is searching too far to the right
                else if ( val.compareTo( _data.get(midpoint-1) ) < 0)
                        hi = midpoint; //shift the range to a smaller section to the left

                midpoint = (lo + hi) / 2; //set the midpoint based on the new lo/hi
        } //end loop
} //end addBin()


// main method solely for testing purposes
public static void main( String[] args )
{
        OrderedArrayList Franz = new OrderedArrayList();

        // testing linear search
        for( int i = 0; i < 15; i++ )
                Franz.add( (int)( 50 * Math.random() ) );
        System.out.println( Franz );
        System.out.println("Testing addBin()...");
        Franz.addBin(0);
        Franz.addBin(-15);
        Franz.addBin(155);
        Franz.addBin(999);
        Franz.addBin(74);
        System.out.println("Array after addBin(): " + Franz);

        //check for sorted-ness
        //if msg does not appear, list was sorted
        for( int i=0; i<Franz.size()-1; i++ ) {
                System.out.println("at i: " + Franz.get(i) );
                if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
                        System.out.println( " *** NOT sorted *** " );
                        break;
                }
        }
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}  //end main()

}//end class OrderedArrayList
