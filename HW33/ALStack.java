import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

ArrayList<PANCAKE> _list;

public ALStack(){
        _list = new ArrayList<PANCAKE>();
}

//Return true if this stack is empty, otherwise false.
public boolean isEmpty(){
        return _list.size() == 0;
}

//Return top element of stack without popping it.
public PANCAKE peek(){
        return _list.get(_list.size()-1);
}

//Pop and return top element of stack.
public PANCAKE pop(){
        return _list.remove(_list.size()-1);
}

//Push an element onto top of this stack.
public void push( PANCAKE x ){
        _list.add(x);
}

}
