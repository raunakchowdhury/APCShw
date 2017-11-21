public class TwoArray {
public static void populate2D( int [][] arr){
        int counter = 0;
        for (int[] row : arr) {
                for (int col = 0; col < row.length; col++) {
                        row[col] = counter;
                        counter += 1;
                } // end first for loop
        }
}

public static void print2D (int [][] arr){
        for (int [] i: arr) { //bloo
                for (int call : i) {
                        System.out.println(call);
                } // end loop
                System.out.println();
        } //end loop
}

public static void main(String[] args) {
        int [][] b = new int [2][3];
        populate2D(b);
        print2D(b);
}
}
