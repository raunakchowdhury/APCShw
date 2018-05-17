/***************************
* interface ListInt
* Declares methods that will be implemented by any
*  class wishing to adhere to this specification.
* This interface specifies behaviors of a list of ints.
***************************/

public interface List
{
// Return number of elements in the list
int size();

// Append an int to the end. Return true.
boolean add( java.lang.Object o );

// Retrieve the Object at index
java.lang.Object get( int index );

// Overwrite the Object at index
java.lang.Object set( int index, java.lang.Object o );

}//end interface ListInt
