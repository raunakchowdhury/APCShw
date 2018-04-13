//Raunak Chowdhury
//APCS2 pd2
//HW33 --  What a Racket   or: How I Learned to Stop Worrying and Love the Stack
//2018-13-04

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Peek. Pop the "(".
 *   2. Check whether you are adding, subtracting, or dividing. Pop the op. Peek.
 *   3. If the peek reveals a number, add/subtract/divide it to the total. Pop the number. Peek.
 *   4. If peek reveals a number, repeat step 3.
 *   5. If peek reveals a "(", repeat steps 1-3.
 *   6. If peek reveals a ")", pop the ")" and push the total to the stack. Return the total.
 *
 * STACK OF CHOICE: Stack by ArrayList
 * b/c....
 * - in Linked Lists, you need to store the entry inside a container with pointers, which takes up memory.
 * - ArrayList does not consume memory to create objects because it uses an array as a skeleton, making it the more memory efficient of the two.
 * - That was the deciding factor between the two; the two Stacks' methods have the same runtimes.
 ******************************************************/

public class Scheme
{
/******************************************************
* precond:  Assumes expr is a valid Scheme (prefix) expression,
*           with whitespace separating all operators, parens, and
*           integer operands.
* postcond: Returns the simplified value of the expression, as a String
* eg,
*           evaluate( "( + 4 3 )" ) -> 7
*	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
******************************************************/
public static String evaluate( String expr )
{
        String[] evalString = expr.split("\\s+");
        Stack<String> stack = new ALStack<String>();
        String answer;
        //stack backwards
        for(int i = evalString.length-1; i>=0; i--) {
                stack.push(evalString[i]);
        }
        //the top of the stack is always going to be a (, so it's ok to pop it
        stack.pop();
        //the next string is an op
        String op = stack.pop();
        answer = unload(determineOp(op),stack);
        return answer;

}  //end evaluate()


/******************************************************
* precond:  Assumes top of input stack is a number.
* postcond: Performs op on nums until closing paren is seen thru peek().
*           Returns the result of operating on sequence of operands.
*           Ops: + is 1, - is 2, * is 3
******************************************************/
public static String unload( int op, Stack<String> numbers )
{
        int result = 0;
        String peek = numbers.peek();
        //base cases
        if (op==1) { //add
                while (!peek.equals(")")) {
                        if (isNumber(peek)) {
                                result += Integer.parseInt(peek);
                                numbers.pop();
                                peek = numbers.peek();
                        }
                        else { //if you're not a number then you're a "("
                                numbers.pop(); //take out "("
                                int newOp = determineOp(numbers.pop());
                                numbers.push(unload(newOp,numbers));
                                peek = numbers.peek();
                        }
                }
                //if you're here, then there was a ")"
                numbers.pop();
        }
        else if (op==2) {
                result = Integer.parseInt(peek); //first num should be psotive
                numbers.pop();
                peek = numbers.peek();
                while (!peek.equals(")")) {
                        if (isNumber(peek)) {
                                result -= Integer.parseInt(peek);
                                numbers.pop();
                                peek = numbers.peek();
                        }
                        else { //if you're not a number then you're a "("
                                numbers.pop(); //take out "("
                                int newOp = determineOp(numbers.pop());
                                numbers.push(unload(newOp,numbers));
                                peek = numbers.peek();
                        }
                }
                //if you're here, then there was a ")"
                numbers.pop();
        }
        else if (op==3) {
                result = Integer.parseInt(peek); //avoid multiplying by 0
                numbers.pop();
                peek = numbers.peek();
                while (!peek.equals(")")) {
                        //  System.out.println(peek);
                        if (!peek.equals("(")) {
                                result *= Integer.parseInt(peek);
                                numbers.pop();
                                peek = numbers.peek();
                        }
                        else { //if you're not a number then you're a "("
                                numbers.pop(); //take out "("
                                int newOp = determineOp(numbers.pop());
                                numbers.push(unload(newOp,numbers));
                                peek = numbers.peek();
                        }
                }
                //if you're here, then there was a ")"
                numbers.pop();
        }
        return Integer.toString(result);
}  //end unload()

//helper for determining the operation
private static int determineOp (String op){
        if (op.equals("+")) {
                return 1;
        }
        else if (op.equals("-")) {
                return 2;
        }
        else {
                return 3;
        }
}

//optional check-to-see-if-its-a-number helper fxn:
public static boolean isNumber( String s ) {
        try {
                Integer.parseInt(s);
                return true;
        }
        catch( NumberFormatException e ) {
                return false;
        }
}



//main method for testing
public static void main( String[] args )
{


        String zoo1 = "( + 4 3 )";
        System.out.println(zoo1);
        System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
        //...7


        String zoo2 = "( + 4 ( * 2 5 ) 3 )";
        System.out.println(zoo2);
        System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
        //...17


        String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
        System.out.println(zoo3);
        System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
        //...29

        String zoo4 = "( - 1 2 3 )";
        System.out.println(zoo4);
        System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
        //...-4
        /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

           ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
}  //main

}//end class Scheme
