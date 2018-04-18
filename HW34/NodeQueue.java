//Raunak Chowdhury
//APCS2 pd2
//HW34 -- The English Do Not Wait In Line for Soup or Anything Else; They “Queue Up”
//2018-13-04

public class NodeQueue<Quasar> implements Queue<Quasar> {

private LLNode<Quasar> _head;
private LLNode<Quasar> _tail;
private int _size;

public NodeQueue(){
        _size = 0;
}

//~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
//means of removing an element from collection:
//Dequeues and returns the first element of the queue.
public Quasar dequeue(){
        Quasar deleted = _head.getValue();
        _head = _head.getNext();
        _size--;
        return deleted;
}

//means of adding an element to collection:
//Enqueue an element onto the back of this queue.
public void enqueue( Quasar x ){
        LLNode<Quasar> entry = new LLNode<Quasar>(x,null);
        if (isEmpty()) { //add first
                _head = _tail = entry;
                _size++;
                return;
        }
        //every other case
        _tail.setNext(entry);
        _tail = entry;
        _size++;
}

//Returns true if this queue is empty, otherwise returns false.
public boolean isEmpty(){
        return _size == 0;
}

//Returns the first element of the queue without dequeuing it.
public Quasar peekFront(){
        return _head.getValue();
}
//~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

public static void main(String[] args) {
        Queue<String> test = new NodeQueue<String>();
        String[] strs = {"hello", "my", "name", "is", "mindy"};
        //populate queue
        for (String s: strs) {
                test.enqueue(s);
        }
        //should print "hello my name is mindy" twice
        while(!test.isEmpty()) {
                System.out.println(test.peekFront());
                System.out.println(test.dequeue());
        }

}

}
