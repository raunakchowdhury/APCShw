//Raunak Chowdhury
//APCS1 pd2
//HW16 -- About Face
//2017-03-07

public class Mysterion {

/****************************
 * Sorts the array backwards from b to a
 * @param a Starting location of the slice
 * @param b Ending location of the slice
 * @param c the index at which all the other values within the slice are compared
 * @param arr the array
 ***************************/
public static int backSort(int a, int b, int c, int[] arr){
        int v = arr[c];
        swap(c,b,arr);// arr[c], arr[b];
        int s = a;
        for (int i = a; i < b; i++) { //i in [a ... b-1])
                if (arr[i] < v) {
                        swap(s,i,arr);// arr[s], arr[i];
                        s += 1;
                }
        }
        swap(b,s,arr);// arr[b], arr[s];
        print(arr);
        return s;
}

public static void print(int[] arr){
        String retStr = "";
        for( int j=0; j<arr.length; j++ )
                retStr = retStr + arr[j] + ",";
        System.out.println(retStr);
}
public static void swap(int index1, int index2, int[] arr){
        int oldNum = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = oldNum;
}

public static void main(String[] args) {
        int[] specialArr = {5,1,7,12,9};
        System.out.println(backSort(0,4,2,specialArr));

        int[] grr = {23,13,12,1,1,1};
        System.out.println(backSort(0,4,2,grr));

        int[] grr1 = {100,99,98,97,96,95,94};
        //System.out.println(backSort(0,4,2,grr1));

        //System.out.println(backSort(0,6,2,grr1));
        //System.out.println(backSort(2,6,1,grr1));
        System.out.println(backSort(0,5,1,grr1)); //moves arr[c] to b
        System.out.println(backSort(0,5,1,grr1)); //moves arr[c] to b
        System.out.println(backSort(0,5,1,grr1)); //moves arr[c] to b
        System.out.println(backSort(2,5,0,grr1)); //moves arr[c] to b
}
}
