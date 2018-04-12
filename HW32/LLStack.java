//Raunak Chowdhury
//APCS2 pd2
//HW32 -- Leon Leonwood Stack
//2018-12-04

import java.util.LinkedList;


public class LLStack<PANCAKE> implements Stack<PANCAKE>{

private LinkedList<PANCAKE> _list;

public LLStack()
{
        _list = new LinkedList<PANCAKE>();
}

//Return true if this stack is empty, otherwise false.
public boolean isEmpty(){
        return _list.size() == 0;
};

//Return top element of stack without popping it.
public PANCAKE peek(){
        return _list.getLast();
};

//Pop and return top element of stack.
public PANCAKE pop(){
        return _list.removeLast();
};

//Push an element onto top of this stack.
public void push( PANCAKE x ){
        _list.add(x);
};


}
