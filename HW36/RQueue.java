//Raunak Chowdhury
//APCS2 pd2
//HW36 -- Now Let’s Consider You Lot at Fake Terry’s
//2018-17-04

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
//instance variables
private LLNode<T> _front, _end;
private int _size;


// default constructor creates an empty queue
public RQueue()
{
        _size = 0;
}  //end default constructor


public void enqueue( T enQVal )
{
        //add at the _end
        LLNode<T> newVal = new LLNode<T>(enQVal,null);
        if (!isEmpty()) {
                _end.setNext(newVal);
        }
        else {
                _front = newVal; //set both front and end to new val
        }
        _end = newVal;
        _size++;
}  //end enqueue()


// remove and return thing at front of queue
// assume _queue ! empty
public T dequeue()
{
        //sample();
        T deleted = null;
        if (!isEmpty()) {
                deleted = _front.getValue();
                _front = _front.getNext();
                _size--;
        }
        return deleted;
}  //end dequeue()


public T peekFront()
{
        return _front.getValue();
}


/******************************************
* void sample() -- a means of "shuffling" the queue
* Algo:
* 1. Choose a random integer between 0 and size.
* 2. Enqueue and dequeue the chosen integer number of times.
******************************************/
public void sample()
{
        int chosen = (int) (Math.random() * _size);  //the RNG index for the front
        //stop before the selected index
        for(int i = 0; i < chosen; i++) {
                enqueue(dequeue());
        }
}  //end sample()


public boolean isEmpty()
{
        return _size == 0;
}   //O(?)


// print each node, separated by spaces
public String toString()
{
        String retStr = "";
        LLNode<T> select = _front;
        while (select!= null) {
                retStr += select.getValue();
                retStr += " ";
                select = select.getNext();
        }
        return retStr;
}  //end toString()



//main method for testing
public static void main( String[] args )
{

        RQueue<String> PirateQueue = new RQueue<String>();

        System.out.println("\nnow enqueuing...");
        PirateQueue.enqueue("Dread");
        PirateQueue.enqueue("Pirate");
        PirateQueue.enqueue("Robert");
        PirateQueue.enqueue("Blackbeard");
        PirateQueue.enqueue("Peter");
        PirateQueue.enqueue("Stuyvesant");

        System.out.println("\nnow testing toString()...");
        System.out.println( PirateQueue );    //for testing toString()...

        System.out.println("\nnow testing sample()...");
        for (int times = 0; times < 4; times++) {
                PirateQueue.sample();
                //System.out.println( PirateQueue ); //for testing toString()...
        }


        System.out.println("\nnow dequeuing...");
        System.out.println( PirateQueue.dequeue() );
        System.out.println( PirateQueue.dequeue() );
        System.out.println( PirateQueue.dequeue() );
        System.out.println( PirateQueue.dequeue() );
        System.out.println( PirateQueue.dequeue() );
        System.out.println( PirateQueue.dequeue() );

        System.out.println("\nnow dequeuing fr empty queue...");
        System.out.println( PirateQueue.dequeue() );
        /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

           ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

}  //end main

}//end class RQueue
