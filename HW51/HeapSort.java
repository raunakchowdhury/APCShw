public class HeapSort {

/* HeapSort method
 * Pre-cond: An array of ints
 * Post-cond: Return a sorted array
 */
public static int[] heapSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
                arr = heapify(arr, i);
                //print(arr);
        }
        return arr;
}

//helper to heapify in minHeap fashion from index i to the end
// root is the "root"
private static int[] heapify (int[] arr, int root){
        int parent;
        int parentOfParent;
        for (int i = root + 1; i < arr.length; i++) {
                //print(arr);
                parent = (i- 1)/2 + root - 1;
                if (arr[i] < arr[parent])
                        arr = swap(arr,i,parent);
                //float the value up
                parentOfParent = (parent-1)/2 + root - 1;
                while(arr[parent] < arr[ parentOfParent ] && parentOfParent > arr.length ) {
                        arr = swap (arr,parent,parentOfParent);
                        parent = parentOfParent;
                }
        }
        return arr;
}

private static int[] swap (int[] arr, int i, int j){
        int first = arr[i];
        arr[i] = arr[j];
        arr[j] = first;
        return arr;
}

private static void print(int[] arr){
        for (int i : arr) {
                System.out.print(i + " ");
        }
        System.out.println();
}

public static void main(String[] args) {
        int[] nums = {12,1,7,3};
        nums = heapSort(nums);
        print (nums);

        int[] nums2 = {12,6,7,2,1};
        print(heapSort(nums2));
}
}
