//Raunak Chowdhury
//APCS2 pd2
//HW21 -- Rockin’ Through the Night
//2018-03-20

public class LList implements List {

LLNode node;

public LList(){
        node = new LLNode();
}

// Instantiate a linked list with the first element being filled
public LList(String input){
        node = new LLNode(input);
}

//add node to list, containing input String as its data
public boolean add( String x ){
        LLNode parseNode = node;
        while(parseNode != null) {
                //System.out.println("Current node: " + parseNode);
                if (parseNode.getNext() == null)
                        break;
                parseNode = parseNode.getNext();
        }
        parseNode.setNext(x);
        return true;
}

//return data in element at position i
public String get( int i ){
        LLNode getNode = node;
        for (int times = 1; times <= i; times++) {
                getNode = getNode.getNext();
        }
        return getNode.getCargo();
}

//overwrite data in element at position i
public String set( int i, String x){
        LLNode parseNode = node;
        for (int times = 1; times <= i; times++) {
                parseNode = parseNode.getNext();
        }
        return parseNode.setCargo(x);
}

//return length of list
public int size(){
        LLNode parseNode = node;
        int size = 0;
        while(parseNode != null) {
                parseNode = parseNode.getNext();
                size++;
        }
        return size;
}

//overwritten toString()
public String toString(){
        return node.toString();
}

public static void main(String[] args) {
        LList list1 = new LList("moony");
        //System.out.println(list1.node);
        System.out.println("=============================");
        System.out.println("Size: " + list1.size());
        System.out.println("Adding padfoot and harry to list1...");
        list1.add("padfoot");
        list1.add("harry");
        System.out.println("printing list1...: " + list1);
        System.out.println("list1's size: "+ list1.size());
        System.out.println("============================");
        System.out.println("get the value at index 0: " + list1.get(0));
        System.out.println("get the value at index 2: " + list1.get(2));
        System.out.println("============================");
        System.out.println("replacing " + list1.set(1,"hermione")+ " with hermione");
        System.out.println("replacing " + list1.set(0,"ron")+ " with ron");
        System.out.println("printing list1 again....: " + list1 );
}
}
