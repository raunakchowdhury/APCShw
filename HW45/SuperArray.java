// Raunak Chowdhury
// APCS1 pd2
// HW43 -- adhering to a published standard (implementing an interface)
// 2017-11-30r

/***************************
* class SuperArray version 3.0
* ( SKELETON )
* Wrapper class for array. Facilitates resizing,
* resizing
* expansion
* read/write capability on elements
* adding an element to end of array
* adding an element at specified index
* removing an element at specified index
*
* ...and now SuperArray complies with the specifications of the
* ListInt interface. (ListInt.java must be in same dir as this file)
***************************/

public class SuperArray implements List
{

private java.lang.Object[] _data; //underlying container
private int _size;      //number of elements in this SuperArray
private Boolean addSwitch; //used for determning whether the index came from add or from the user

//default constructor – initializes 10-item array
public SuperArray()
{
        _data = new java.lang.Object[10];
        _size = 0;
}


//output SuperArray in [a,b,c] format
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


//double capacity of SuperArray
private void expand()
{
        java.lang.Object[] temp = new java.lang.Object[ _data.length * 2 ];
        for( int i = 0; i < _data.length; i++ )
                temp[i] = _data[i];
        _data = temp;
}


//accessor -- return value at specified index
public java.lang.Object get( int index )
{
        return _data[index];
}


//mutator -- set value at index to o,
//           return old value at index
public java.lang.Object set( int index, java.lang.Object o )
{
        java.lang.Object temp = _data[index];
        _data[index] = o;
        return temp;
}


//adds an item after the last item
public boolean add( java.lang.Object o )
{
        addSwitch = true; // "notifies" the overloaded add that the input is from this method
        add( _size, o );
        addSwitch = false; //sets it to false to guard against inappropriate user input
        return true;
}


//inserts an item at index
public void add( int index, java.lang.Object o )
{

        // deal with indices that are outside of the array range
        // deal with the case of adding the very first element to the array
        if (  !addSwitch && (index < 0 || index >= size()) ) {
                throw new IndexOutOfBoundsException( "Element " + index + " is not in the array!");
        }
        //first expand if necessary
        if ( _size >= _data.length )
                expand();
        for( int i = _size; i > index; i-- ) {
                _data[i] = _data[i-1]; //each slot gets value of left neighbor
        }
        _data[index] = o;
        _size++;
}


//removes the item at index
//shifts elements left to fill in newly-empted slot
public java.lang.Object remove( int index )
{
        java.lang.Object removedVal = _data[index];
        for( int i = index; i < _size - 1; i++ ) {
                _data[i] = _data[i+1];
        }
        _data[_size-1] = 0;
        _size--;
        return removedVal;
}


//return number of meaningful items in _data
public int size()
{
        return _size;
}



//main method for testing
public static void main( String[] args )
{

        List mayfield = new SuperArray();
        System.out.println("Printing empty SuperArray mayfield...");
        System.out.println(mayfield);

// since add returns a boolean, a cond could be used to indicate success
        if (mayfield.add(5) ) {
                System.out.println("Value 5 added!");
        }
        if (mayfield.add("bob") ) {
                System.out.println("String bob added!");
        }
        if (mayfield.add(3) ) {
                System.out.println("Value 3 added!");
        }
        if (mayfield.add(2) ) {
                System.out.println("Value 2 added!");
        }
        if (mayfield.add(1) ) {
                System.out.println("Value 1 added!");
        }

        System.out.println("Printing populated SuperArray mayfield...");
        System.out.println(mayfield);

        /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
           // we can report the value removed, since remove returns the removed value
           System.out.println("Value removed: " + mayfield.remove(3));
           System.out.println("Printing SuperArray mayfield post-remove...");
           System.out.println(mayfield);

           System.out.println("Value removed: " + mayfield.remove(3));
           System.out.println("Printing SuperArray mayfield post-remove...");
           System.out.println(mayfield);

           mayfield.add(3,99);
           System.out.println("Printing SuperArray mayfield post-insert...");
           System.out.println(mayfield);
           mayfield.add(2,88);
           System.out.println("Printing SuperArray mayfield post-insert...");
           System.out.println(mayfield);
           mayfield.add(1,77);
           System.out.println("Printing SuperArray mayfield post-insert...");
           System.out.println(mayfield);

           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
}  //end main()


}//end class


/***
             ,,########################################,,
          .*##############################################*
        ,*####*:::*########***::::::::**######:::*###########,
      .*####:    *#####*.                 :*###,.#######*,####*.
 *####:    *#####*                      .###########*  ,####*
   .*####:    ,#######,                        ##########*    :####*
 *####.    :#########*,                       ,,,,,,,,.      ,####:
 ####*  ,##############****************:,,               .####*
     :####*#####################################**,        *####.
 *############################################*,   :####:
        .#############################################*,####*
          :#####:*****#####################################.
 *####:                  .,,,:*****###########,
             .*####,                            *######*
               .####* :*#######*               ,#####*
 *###############*,,,,,,,,::**######,
 *##############################:
 *####*****##########**#####*
                      .####*.            :####*
                        :####*         .#####,
 *####:      *####:
                           .*####,  *####*
                             :####*####*
 *######
 *##

         -Miranda Chaiken '16

 ***/
