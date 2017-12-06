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
        // *** YOUR IMPLEMENTATION HERE ***
        _data = new ArrayList<Comparable>();
}


public String toString()
{
        // *** YOUR IMPLEMENTATION HERE ***
        String foo = "[";
        for( int i = 0; i < size(); i++ ) {
                foo += _data.get(i) + ",";
        }
        if ( foo.length() > 1 )
                //shave off trailing comma
                foo = foo.substring( 0, foo.length()-1 );
        foo += "]";
        return foo;
}


public Comparable remove( int index )
{
        // *** YOUR IMPLEMENTATION HERE ***
        if (index < 0 || index >= size() ) {
                throw new IndexOutOfBoundsException( "Element " + index + " is not in the array!");
        }
        Comparable removedVal = _data.get(index);
        _data.remove( index );
        return removedVal;
}


public int size()
{
        // *** YOUR IMPLEMENTATION HERE ***
        return _data.size(); //placeholder
}


public Comparable get( int index )
{
        // *** YOUR IMPLEMENTATION HERE ***
        if (index < 0 || index >= size() ) {
                throw new IndexOutOfBoundsException( "Element " + index + " is not in the array!");
        }
        return _data.get(index);
}


public void add(Comparable newVal)
{
        // *** YOUR IMPLEMENTATION HERE ***
        // deal with indices that are outside of the array range
        // deal with the case of adding the very first element to the array
        _data.add(newVal);
        //minOfArray();
}

// A helper method for returning the min of two Comparables.
public static Comparable min(Comparable a, Comparable b){
        if ( a.compareTo(b) > 0 )
                return b;
        return a;
}

//A helper method that returns the min of an array of comparables.
public Comparable minOfArray(){
        Comparable min = get(0); //stores the min of the ArrayList; set to the first element
        // size - 1 was used in order to prevent an IndexOutOfBoundsException
        for (int i = 0; i < size(); i++)
                min = min( min, get(i) );
        return min;
}

//deletes the first instance of the Comparable in the array.
public void pop(Comparable popValue){
        for (int i = 0; i < size(); i++) {
                if (get(i).compareTo(popValue) == 0) {
                        remove(i); //delete the val
                        break;
                }
        }
} // end pop

// sorts the array in order. This complies with the limitation of only having a sorted list
public void sort(){
        // create a new array to store the sorted array
        ArrayList<Comparable> retArray = new ArrayList<Comparable>();
        int size = size(); // store the size in a var, to prevent the loop from being affected
        Comparable min = minOfArray(); //stores the initial min value

        for (int i = 0; i < size; i++) {
                min = minOfArray(); // find the min first
                retArray.add(min); //append the min
                pop(min); //pop the min from data
        }

        _data = retArray; //establish an alias to the new Array, thereby setting _data to a sorted version of itself

}

// main method solely for testing purposes
public static void main( String[] args )
{

        OrderedArrayList Franz = new OrderedArrayList();

        // testing linear search
        for( int i = 0; i < 15; i++ )
                Franz.add( (int)( 50 * Math.random() ) );
        System.out.println( Franz );
        /* =====For testing pop()=====*/
        //Franz.pop( Franz.get(1) );
        //System.out.println( "Array after popping item 1: " + Franz );
        /* ============================*/
        //check for sorted-ness
        Franz.sort();
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
