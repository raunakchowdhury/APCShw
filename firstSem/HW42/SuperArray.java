//Team QAFRaunak Chowdhury and Peter Cwalina
//APCS1 pd2
//HW42 -- Array of Grade 316_
//2017-11-28

/***************************
* class SuperArray version 2.0
* (SKELETON)
* Wrapper class for array. Facilitates resizing,
* resizing
* expansion
* read/write capability on elements
* adding an element to end of array
* adding an element at specified index
* removing an element at specified index
***************************/

public class SuperArray
{

private int[] _data;    //underlying container
private int _size;      //number of elements in this SuperArray


//default constructor – initializes 10-item array
public SuperArray()
{
        _data = new int[10];
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
        int[] temp = new int[ _data.length * 2 ];
        for( int i = 0; i < _data.length; i++ )
                temp[i] = _data[i];
        _data = temp;
        _size *= 2;
}


//accessor -- return value at specified index
public int get( int index )
{
        return _data[index];
}


//mutator -- set value at index to newVal,
//           return old value at index
public int set( int index, int newVal )
{
        int temp = _data[index];
        _data[index] = newVal;
        return temp;
}


//adds an item after the last item
public void add( int newVal )
{
        /* YOUR IMPLEMENTATION HERE */
        int[] temp = new int[_size + 1];
        if (_size != 0) { // if the size of the array is 0, then there doesn't need to be any copying.
                for (int x = 0; x < _size; x++) { // copy the array over
                        temp[x] = _data[x];
                }
                temp[_size] = newVal; // append the newVal after the other values
        } // end if
        else { // if the array's _size is 0
                temp[0] = newVal; // append the newVal at front
        }
        _data = temp;
        //System.out.println("Old size: " + this._size);
        _size += 1; // since the array increased in size, add 1 to size

        /* =============for testing purposes==========
           System.out.println("New array: " + this);
           System.out.println("New size: " + this._size);
         */
}


//inserts an item at index
public void add( int index, int newVal )
{
        /* YOUR IMPLEMENTATION HERE */
        //System.out.println("Size: " + _size);
        int[] temp = new int[_size + 1];
        for (int x = 0; x < index; x++) { // copy the array over, up the index
                //System.out.println("Data val: " + _data[x]);
                temp[x] = _data[x];
        }
        temp[index] = newVal; // add the actual value
        if (_size > index) { // check to see if there are any other vals after the index
                // copy the rest of the array, exclusive of index
                for (int x = index; x < _size; x++) {
                        temp[x + 1] = _data[x];
                }
                //System.out.println("Array: " + this);
        } // end cond
        _data = temp;
        _size += 1; // increase the size, as the array is one more

}


//removes the item at index
//shifts elements left to fill in newly-empted slot
public void remove( int index )
{
        /* YOUR IMPLEMENTATION HERE */
        int[] temp = new int[_size - 1];
        for (int x = 0; x < index; x++) { // copy the array over, up the first value
                //System.out.println("Data val: " + _data[x]);
                temp[x] = _data[x];
        }
        //System.out.println("\nFirst loop complete!");
        if (_size > index) { // check to see if there are any other vals after the index
                // copy the rest of the array, exclusive of index
                for (int x = index + 1; x < _size; x++) {
                        temp[x - 1] = _data[x];
                }
                _data = temp;
                _size -= 1; // shorten the size, as the array is one less
                //System.out.println("Array: " + this);
        }
}


//return number of meaningful items in _data
public int size()
{
        /* YOUR IMPLEMENTATION HERE */
        return _size;
}



//main method for testing
public static void main( String[] args )
{
        SuperArray curtis = new SuperArray();
        System.out.println( "Printing empty SuperArray curtis..." );
        System.out.println( curtis );

        for( int i = 0; i < curtis._data.length; i++ ) {
                curtis.set( i, i * 2 );
        }

        System.out.println("Printing populated SuperArray curtis...");
        System.out.println(curtis);

        for( int i = 0; i < 3; i++ ) {
                curtis.expand();
                System.out.println("Printing expanded SuperArray curtis...");
                System.out.println(curtis);
                System.out.println("new length of underlying array: "
                                   + curtis._data.length );
        }
        System.out.println("------------------------\n"); //seperate them into containers

        SuperArray mayfield = new SuperArray();
        System.out.println("Printing empty SuperArray mayfield...");
        System.out.println(mayfield);

        mayfield.add(5);
        mayfield.add(4);
        mayfield.add(3);
        mayfield.add(2);
        mayfield.add(1);

        System.out.println("Printing populated SuperArray mayfield...");
        System.out.println(mayfield);

        mayfield.remove(3);
        System.out.println("Printing SuperArray mayfield post-remove...");
        System.out.println(mayfield);
        mayfield.remove(3);
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
        mayfield.expand();
        mayfield.add(10,44);
        System.out.println(mayfield);
        /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
}  //end main()


}//end class
