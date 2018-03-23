//Kachow-der -- Raunak Chowdhury and Kathleen Wong
//APCS2 pd2
//HW23 -- Give and Take
//2018-03-22
/*****************************************************
* class LList
* Implements a linked list of LLNodes, each containing String data
*****************************************************/

public class LList implements List //your List interface must be in same dir
{

//instance vars
private LLNode _head;
private int _size;

// constructor -- initializes instance vars
public LList( )
{
        _head = null; //at birth, a list has no elements
        _size = 0;
}


//--------------v  List interface methods  v--------------

public boolean add( String newVal )
{
        LLNode tmp = new LLNode( newVal, _head );
        _head = tmp;
        _size++;
        return true;
}


public String get( int index )
{
        if ( index < 0 || index >= size() )
                throw new IndexOutOfBoundsException();

        String retVal;
        LLNode tmp = _head; //create alias to head

        //walk to desired node
        for( int i=0; i < index; i++ )
                tmp = tmp.getNext();

        //check target node's cargo hold
        retVal = tmp.getCargo();
        return retVal;
}


public String set( int index, String newVal )
{

        if ( index < 0 || index >= size() )
                throw new IndexOutOfBoundsException();

        LLNode tmp = _head; //create alias to head

        //walk to desired node
        for( int i=0; i < index; i++ )
                tmp = tmp.getNext();

        //store target node's cargo
        String oldVal = tmp.getCargo();

        //modify target node's cargo
        tmp.setCargo( newVal );

        return oldVal;
}


//return number of nodes in list
public int size() {
        return _size;
}

//--------------^  List interface methods  ^--------------


// override inherited toString
public String toString()
{
        String retStr = "HEAD->";
        LLNode tmp = _head; //init tr
        while( tmp != null ) {
                retStr += tmp.getCargo() + "->";
                tmp = tmp.getNext();
        }
        retStr += "NULL";
        return retStr;
}

public String remove(int i){
        LLNode first = _head;
        LLNode deletedNode;
        for (int node = 0; node <= i-1; node++)
                first = first.getNext();
        deletedNode = first.getNext();
        first.setNext( deletedNode.getNext() ); //link the node before to the node after the "deleted" one
        return deletedNode.getCargo();
}

public void add( int i, String s ){
        LLNode first = _head;
        System.out.println(size());
        // extreme conds
        if (i == 0) {
                add(s);
                return;
        }
        if (i > size())
                throw new IndexOutOfBoundsException();
        // loop to cycle to the elemetn prior to where it should be added
        for (int node = 0; node <= i-1; node++)
                if (first.getNext() != null)
                        first = first.getNext();
        LLNode newNode = new LLNode (s,first.getNext()); //link it to the formerly next element
        first.setNext(newNode); //link first to the added node
}


//main method for testing
public static void main( String[] args )
{
        LList james = new LList();

        System.out.println( james );
        System.out.println( "size: " + james.size() );

        james.add("beat");
        System.out.println( james );
        System.out.println( "size: " + james.size() );

        james.add("a");
        System.out.println( james );
        System.out.println( "size: " + james.size() );

        james.add("need");
        System.out.println( james );
        System.out.println( "size: " + james.size() );

        james.add("I");
        System.out.println( james );
        System.out.println( "size: " + james.size() );

        System.out.println( "2nd item is: " + james.get(1) );

        james.set( 1, "got" );
        System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

        System.out.println( james );

        System.out.println();
        System.out.println("Trying remove...");
        System.out.println("Removing " + james.remove(1));
        System.out.println(james);

        System.out.println();
        System.out.println("Trying add at index...");
        System.out.println("Adding a to its former position...");
        james.add(1,"a");
        System.out.println(james);
        System.out.println("Adding | to the ends of the array...");
        james.add(0,"|");
        System.out.println(james);
        james.add(james.size(),"|");
        System.out.println(james);
        System.out.println("Trying to add outside of the array...");
        james.add(90000,"rip");
}

}//end class LList
