public class Loop {
public static void main(String[] args) {
        //Showing that foreach loops CANNOT modify values
        int[] air = new int[10];
        int thing = 0;
        for (int a :air ) {
                thing = a;
        }
        for (int a : air) {
                System.out.print(a + " "); //prints out 0s ( the default val for an int) instead of 5s
        }
        System.out.println();
}
}
