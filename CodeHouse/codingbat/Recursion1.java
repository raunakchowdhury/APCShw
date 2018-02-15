public class Recursion1 {

public static boolean array220(int[] array, int index){
        int n = array.length;
        if (index == n || index + 1 == n)
                return false;
        else if ( array[index + 1]/array[index] == 10 )
                return true;
        return array220(array, index+1);
}

public static void main(String[] args) {
        int[] test1 = {1}; //make sure the false endpoint condition works
        int[] test2 = {1,100,200,2000}; //make sure that the comparison and recursive call work by putting the values at the end of the array
        int[] test3 = {1,10}; // make sure that the comparison and recursive call works

        System.out.println("Testing test1: " + array220(test1,0));
        System.out.println("Testing test2: " + array220(test2,0));
        System.out.println("Testing test3: " + array220(test3,0));
}

}//end class
