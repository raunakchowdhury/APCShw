public class SuperArray implements List {

private int _size;
private Object[] _arr;

public SuperArray(){
        _arr = new Object[10];
}

// Return number of elements in the list
public int size(){
        return _size;
}

// Append an int to the end. Return true.
public boolean add( java.lang.Object o ){
        if (_size == _arr.length) {
                Object[] arr = new Object[_arr.length * 2];
                for (int i = 0; i < _arr.length; i++) {
                        arr[i] = _arr[i];
                }
                _arr = arr;
        }
        _arr[_size] = o;
        _size++;
        return true;
}

// Retrieve the Object at index
public java.lang.Object get( int index ){
        if (index >= _size) {
                throw new IndexOutOfBoundsException();
        }
        return _arr[index];
}

// Overwrite the Object at index
public java.lang.Object set( int index, java.lang.Object o ){
        if (index >= _size) {
                throw new IndexOutOfBoundsException();
        }
        Object oldObj = _arr[index];
        _arr[index] = o;
        return oldObj;
}

public String toString(){
        String retStr = "";
        for (int i = 0; i < _size; i++) {
                retStr += _arr[i].toString() + " ";
        }
        return retStr;
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

        System.out.println("\nTesting get...");
        System.out.println("Item 0: " + mayfield.get(0) );
        System.out.println("Item 4 : " + mayfield.get(4) );
        //erronous cases
        //System.out.println("Item -1 : " + mayfield.get(-1) );
        //System.out.println("Item 99 : " + mayfield.get(99) );

        System.out.println("\nTesting set...");
        System.out.println("Swapping in String \"sadboi\" for: " + mayfield.set(0, "sadboi") );
        System.out.println("Swapping String \"derreck\" for: " + mayfield.set(4, "derreck") );
        // erronous vals
        //System.out.println( mayfield.set(-1, "waht") );
        //System.out.println( mayfield.set(99, "waht") );

        System.out.println("Printing SuperArray mayfield after set...");
        System.out.println(mayfield);

//create a new instance of SuperArray, as remove() and overloaded add() are not in List
        SuperArray wen = new SuperArray();
        if (wen.add(5) ) {
                System.out.println("Value 5 added!");
        }
        if (wen.add("bob") ) {
                System.out.println("String bob added!");
        }
        if (wen.add(3) ) {
                System.out.println("Value 3 added!");
        }
        if (wen.add(2) ) {
                System.out.println("Value 2 added!");
        }
        if (wen.add(1) ) {
                System.out.println("Value 1 added!");
        }

        System.out.println("\nPrinting new array wen...");
        System.out.println(wen);
/*
        System.out.println("\nTesting remove...");
        System.out.println("Removed value " + wen.remove(0) );
        System.out.println("Removed value " + wen.remove(2) );
        // erronous values
        //System.out.println( wen.remove(-1) );
        //System.out.println( wen.remove(99) );

        System.out.println("Printing new SuperArray wen with values removed...");
        System.out.println(wen);

        System.out.println("\nTesting overloaded add...");
        wen.add(1, "shark");
        wen.add(3, "crab");

        //erronous values
        //wen.add(-1, "food");
        //wen.add(45, "mixcoatl");
        System.out.println("Printing new SuperArray wen with values added...");
        System.out.println(wen);

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


}
