//Raunak Chowdhury
//APCS2 pd2
//HW21 --  text
//2018-03-19

/*****************************************************
* class LLNode
* Implements a node, for use in lists and other container classes.
* Stores its data as a String
*****************************************************/

public class LLNode
{
//instance vars
private String cargo;
private LLNode next;

// constructor
public LLNode(){
        cargo = null;
        //next = new LLNode();
}

public LLNode(String data){
        cargo = data;
}

//--------------v  ACCESSORS  v--------------
public String getCargo()
{
        return cargo;
}

public LLNode getNext()
{
        return next;
}
//--------------^  ACCESSORS  ^--------------


//--------------v  MUTATORS  v--------------
public String setCargo(String newCargo)
{
        String oldCargo = cargo;
        cargo = newCargo;
        return oldCargo;
}

public LLNode setNext(String nextCargo)
{
        LLNode oldNext = next;
        //if (next.equals( null))
        next = new LLNode(nextCargo);
        return oldNext;
}
//--------------^  MUTATORS  ^--------------


// override inherited toString
public String toString()
{
        if (next == null)
                return cargo;
        return cargo + "," + next.toString();
}


//main method for testing
public static void main( String[] args )
{
        //PROTIP: try creating a few nodes: traversible, connected...
        //note anything notable as you develop and test...
        LLNode tester = new LLNode();
        tester.setCargo("padfoot");
        tester.setNext("moony");
        tester.getNext().setNext("bob");
        System.out.println(tester);


}    //end main

}//end class LLNode
