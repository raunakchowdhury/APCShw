//Raunak Chowdhury
//APCS2 pd2
//HW45 --  Arrr, There Be Priorities Here Matey .
//2018-09-05

import java.util.ArrayList;

public class ArrayPriorityQueue {
ArrayList<String> _list;

//inst an ArrayList
public ArrayPriorityQueue(){
        _list = new ArrayList<String>();
}

//add to the queue normally, O(1)
public void add(String x){
        _list.add(x);
}

// O(1)
public boolean isEmpty(){
        return _list.size() == 0;
}

//iterate thru and find min, O(n)
public String peekMin(){
        String min = _list.get(0);
        for (int i = 1; i<_list.size(); i++ ) {
                if (min.compareTo(_list.get(i)) < 0)
                        min = _list.get(i);
        }
        return min;
}

// O(n^2) in worst case, amortized: O(n)
public String removeMin(){
        String min = _list.get(0);
        int index = 0;
        for (int i = 1; i<_list.size(); i++ ) {
                if (min.compareTo(_list.get(i)) < 0) {
                        min = _list.get(i);
                        index = i;
                }
        }
        return _list.remove(index);
}

public String toString(){
        String retStr = "";
        for (String str : _list)
                retStr += str + " ";
        return retStr;
}

public static void main(String[] args) {
        ArrayPriorityQueue q = new ArrayPriorityQueue();
        System.out.println("Running Brown's test:");
        q.add("foo");
        q.add("moo");
        System.out.println(q);
        System.out.println("removing once...");
        System.out.println(q.removeMin());
        System.out.println(q);
        System.out.println("adding again...");
        q.add("goo");
        q.add("hoo");
        q.add("doo");
        System.out.println(q);
        System.out.println("removing....");
        System.out.println(q.removeMin());
        System.out.println(q);
}
}
