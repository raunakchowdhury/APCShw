//Raunak Chowdhury
//APCS1 pd2
//HW17 --  So So Fast
//2018-11-03

public class FastSelect {

/******
 * Method: ymin
 * Finds the yth min of the array.
 * @param y Designates the yth min
 * @param arr Designates the array
 * Algorithm:
 * 1. If the y value is greater than half the length of the array, subtract y from the length and call this difference fakeY.
      In the following steps, substitute fakeY for y.
 * 2. Create a range from 0 to the length.
 * 3. Use y as your pivot, and have the array pivot around y.
 * 4. Use the range 0 to length-1 and repeat step 3. Keep subtracting 1 from the upper bound of the range (right) until y exceeds right.
 * 5. The value at index y-1 is the yth minimum.

 * Runtime:
   Best Case: O(logn)
   Worst Case: O(nlogn)
 * The runtime is dependent on the partition method - if the list is fully sorted, partition will run in constant time.
 * Similarly, if the list is scrambled, partition will take O(n) to process the list, making the runtime O(nlogn).
 ****/

public static int ymin (int y, int[] arr){
        if (y > arr.length/2) { //if y is actually greater than half of the array, then the wrong yth min will be generated
                int fakeY = arr.length - y;
                for (int right = arr.length; right > fakeY; right--) {
                        partition(arr,0,right-1,fakeY); //rearranges the array till yth minimum is at position y
                }
        }
        else {
                for (int right = arr.length; right > y; right--) {
                        partition(arr,0,right-1,y); //rearranges the array till yth minimum is at position y
                }
        }
        return arr[y-1];
}

public static int partition( int[] arr, int left, int right, int pvtPos ){
        int pvtVal = arr[pvtPos];
        swap (pvtPos, right, arr); // move pivot to end
        int storPos = left;

        for (int i = left; i <= right; i++) {//i in [left..right-1]{
                if (arr[i] < pvtVal) {
                        swap( storPos, i, arr);
                        storPos += 1;
                }
        }

        //move pivot back to previous location
        swap (right, storPos,arr);
        return storPos;
}

public static void swap(int index1, int index2, int[] arr){
        int oldNum = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = oldNum;
}

public static void print(int[] arr){
        String retStr = "";
        for( int j=0; j<arr.length; j++ )
                retStr = retStr + arr[j] + ",";
        System.out.println(retStr);
}

public static void main(String[] args) {
        //Ensuring partition works
        int[] grr1 = {100,99,98,97,96,95,94};
        System.out.println("=======================");
        System.out.println("Ensuring parition works:");
        partition(grr1,0,5,1); //moves arr[c] to b
        print(grr1);
        partition(grr1,0,5,1); //moves arr[c] to b
        print(grr1);
        partition(grr1,0,5,1); //moves arr[c] to b
        print(grr1);
        System.out.println("====================");

        int[] bestCase = {1,2,3,4};
        System.out.println("Best case for ymin using the array [1,2,3,4]:");
        for (int i:bestCase) {
                System.out.println("Finding the " + i + "th minimum: " + ymin(i,bestCase));
        }

        System.out.println("====================");
        System.out.println("Worst case for ymin using the array [3,2,4,1]:");
        int[] worstCase = {3,2,4,1}; //scrambled
        for (int i:bestCase) {
                System.out.println("Finding the " + i + "th minimum: " + ymin(i,worstCase));
        }
        System.out.println("test");

}
}
