//Raunak Chowdhury
//APCS1 pd2
//HW41 -- Array of Steel
//2017-10-14

/***************************
* class SuperArray
* Wrapper class for array. Facilitates resizing,
* getting and setting element values.
***************************/

public class SuperArray
{

private int[] _data;    //underlying container
private int _size;      //number of elements in this SuperArray


//default constructor – initializes 10-item array
public SuperArray()
{
        /* YOUR IMPLEMENTATION HERE */
        this._data = new int[10];
}

//=================================================================
//A static method to return a String version of an array of Strings.
//=================================================================
public static String retArray (int[] a){
        String retStr = "[";
        for (int i = 0; i < a.length; i++) {
                if (i == a.length - 1) {
                        retStr += a[i];
                }
                else {
                        retStr += a[i] + ", ";
                }
        } // end loop
        retStr += "]";
        return retStr;
}

//output SuperArray in [a,b,c] format
public String toString()
{
        /* YOUR IMPLEMENTATION HERE */
        return retArray(this._data);
}

// copies one array into another
public int[] copyArray (int[] a, int n){
        int[] b = new int[a.length + n];
        for (int i = 0; i < a.length; i++) {
                b[i] = a[i]; // copy each val into the new array
        }
        return b;
}

//double capacity of SuperArray
private void expand()
{
        /* YOUR IMPLEMENTATION HERE */
        int[] newArray = copyArray(this._data, this._data.length); //stores the copied array
        this._data = newArray; // sets the value of _data to newArray
        // It's super interesting that though newArray has double the values, _data takes on the memory of newArray.
        // My initial hypothesis was that _data was an alias, proven by when I ran the following code:
        /* proof of alias
           _data[0]=69;
           System.out.println(retArray(_data));
           System.out.println( retArray(newArray) );
         */

}


//accessor -- return value at specified index
public int get( int index )
{
        /* YOUR IMPLEMENTATION HERE */
        return this._data[index];
}


//mutator -- set value at index to newVal,
//           return old value at index
public int set( int index, int newVal )
{
        /* YOUR IMPLEMENTATION HERE */
        int oldIndex = this._data[index];
        this._data[index] = newVal;
        return oldIndex;
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
        }
        /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
}  //end main()


}//end class
