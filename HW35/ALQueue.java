//Byte-Sized -- Aleksandra Koroza and Raunak Chowdhury
//APCS2 pd2
//HW35 -- ..Nor Do Aussies
//2018-17-04

import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar> {

private ArrayList<Quasar> _list;
private int _size;
private int _head;

public ALQueue(){
        _list = new ArrayList<Quasar>();
        _size = 0;
        _head = 0;
}

//~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
//means of removing an element from collection:
//Dequeues and returns the first element of the queue.
public Quasar dequeue(){
        _head = _head + 1;
        _size--;
        return _list.get(_head-1);
}

//means of adding an element to collection:
//Enqueue an element onto the back of this queue.
public void enqueue( Quasar x ){
        _list.add(x);
        _size++;
}

//Returns true if this queue is empty, otherwise returns false.
public boolean isEmpty(){
        return _size == 0;
}

//Returns the first element of the queue without dequeuing it.
public Quasar peekFront(){
        return _list.get(_head);
}

public static void main(String[] args) {
        Queue<String> test = new ALQueue<String>();
        String[] strs = {"hello", "my", "name", "is", "mindy"};
        //populate queue
        for (String s: strs) {
                test.enqueue(s);
                //System.out.println(test.peekFront());
        }
        //should print "hello my name is mindy" twice
        while(!test.isEmpty()) {
                System.out.println(test.peekFront());
                System.out.println(test.dequeue());
        }
}
//~~~~~~~~~~~~~~~~~~~end AP s

}
