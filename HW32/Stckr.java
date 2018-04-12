/*****************************************************
* class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
*****************************************************/

public class Stckr
{
public static void main( String[] args )
{
        Stack cakesA = new ALStack();
        Stack cakesL = new LLStack();
        //AL implementation
        /******************************
        * Testing procedure:
        * 1. Push multiple values.
        * 2. Call isEmpty().
        * 3. Pop all values and print them.
        * 4. Call isEmpty() again.
        ******************************/
        cakesA.push("jamie");
        cakesA.push("taylor");
        cakesA.push("foop");
        cakesA.push("shmoop");
        cakesA.push("soup");
        cakesA.push("crop");
        cakesA.push("duster");
        cakesA.push("coop");

        System.out.println(cakesA.pop());//coop
        System.out.println(cakesA.pop());//duster
        System.out.println(cakesA.pop());//crop
        System.out.println(cakesA.pop());//soup
        System.out.println(cakesA.pop());//shmoop
        System.out.println(cakesA.pop());//foop
        System.out.println(cakesA.pop());//taylor
        System.out.println(cakesA.pop());//jamie
        System.out.println(cakesA.isEmpty());//jamie


        System.out.println("Testing LLStack...");
        cakesL.push("jamie");
        cakesL.push("taylor");
        cakesL.push("foop");
        cakesL.push("shmoop");
        cakesL.push("soup");
        cakesL.push("crop");
        cakesL.push("duster");
        cakesL.push("coop");

        System.out.println(cakesL.pop());//coop
        System.out.println(cakesL.pop());//duster
        System.out.println(cakesL.pop());//crop
        System.out.println(cakesL.pop());//soup
        System.out.println(cakesL.pop());//shmoop
        System.out.println(cakesL.pop());//foop
        System.out.println(cakesL.pop());//taylor
        System.out.println(cakesL.pop());//jamie
        System.out.println(cakesL.isEmpty());//jamie
}
}//end class
