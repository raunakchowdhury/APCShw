/*****************************************************
* class DLLNode
* Implements a doubly-linked node,
* for use in lists and other collection classes.
* Stores data of type String
*****************************************************/

public class DLLNode
{
private String _cargo;      //cargo may only be of type String
private DLLNode _nextNode, _prevNode;   //pointers to next, prev DLLNodes

//YOUR IMPLEMENTATION HERE...
//constructor with both nodes
public DLLNode(String cargo, DLLNode prevNode, DLLNode nextNode){
        _cargo = cargo;
        _prevNode = prevNode;
        _nextNode = nextNode;
}

//--------------v  ACCESSORS  v--------------
public String getCargo() {
        return _cargo;
}

public DLLNode getNext() {
        return _nextNode;
}

public DLLNode getPrev(){
        return _prevNode;
}
//--------------^  ACCESSORS  ^--------------

//--------------v  MUTATORS  v--------------
public String setCargo( String newCargo ) {
        String foo = getCargo();
        _cargo = newCargo;
        return foo;
}

public DLLNode setNext( DLLNode newNext ) {
        DLLNode foo = getNext();
        _nextNode = newNext;
        return foo;
}

public DLLNode setPrev( DLLNode newPrev ) {
        DLLNode foo = getPrev();
        _prevNode = newPrev;
        return foo;
}
//--------------^  MUTATORS  ^--------------

// override inherited toString
public String toString() {
        return _cargo.toString();
}

public static void main(String[] args) {
        //Create a node
        DLLNode first = new DLLNode( "cat", null, null );

        //Create a new node after the first
        first.setNext( new DLLNode( "dog", null, first ) );

        //Create a third node after the second
        first.getNext().setNext( new DLLNode( "cow", first.getNext(), null ) );

        first.setPrev(new DLLNode("bork", null, first));
        // print the list, in individual node format
        DLLNode iterator = first.getPrev();

        while (iterator != null) {
                System.out.println(iterator);
                iterator = iterator.getNext();
        }
}
}//end class DLLNode
