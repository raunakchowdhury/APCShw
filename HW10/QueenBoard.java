/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
private int[][] _board;

public QueenBoard( int size )
{
        _board = new int[size][size];
}


/***
 * precondition: board is filled with 0's only.
 * postcondition:
 * If a solution is found, board shows position of N queens,
 * returns true.
 * If no solution, board is filled with 0's,
 * returns false.
 */
public boolean solve()
{
        int totalQueens = 0;
        for (int row = 0; row < _board.length; row++) {
                addQueen(row,0);
                if (solveH(1)) { //considers all possible outcomes
                        for (int i = 1; i < _board.length; i++) {
                                if (queenPresent(i))
                                        totalQueens++;
                        }
                        if (totalQueens == _board.length) {
                                printSolution();
                                return true;
                        }
                        else
                                solveH(_board.length-1);
                }
                removeQueen(row,0); //remove queen if the possibilities fail
        }
        return false;
}


/**
 * Helper method for solve.
 */
private boolean solveH( int col )
{
        if (col == _board.length) //base case
                return true;
        //is there a Queen?
        if (queenPresent(col)) {
                // if so, remove the queen and add one underneath its former position. move to the next col.
                //If the new queen's position exceeds the length, return false.
                for (int row = 0; row < _board.length; row++) {
                        if (removeQueen(row,col)) {
                                if (row+1==_board.length)
                                        return false;
                                if (!addQueen(row+1, col))
                                        solveH(col-1); //if no queen exists under you, go back
                                break;
                        }
                }
                return solveH(col+1);
        }
        else{
                // can I add the queen?
                for ( int row=0; row < _board.length; row++) {
                        if (addQueen(row,col)) {
                                return solveH(col+1);
                                //break;
                        }
                }
                // you can assume that if the loop completes, there are no spots for da queen
                // the answer is no to the above question
                if (col-1 == 0)
                        return false; //cannot be solved with this state
                return solveH(col-1); //"go back"
        }
}

private Boolean queenPresent(int col){
        for (int row = 0; row < _board.length; row++) {
                if (_board[row][col] == 1)
                        return true;
        }
        return false;
}

public void printSolution()
{
        /** Print board, a la toString...
            Except:
            all negs and 0's replaced with underscore
            all 1's replaced with 'Q'
         */
        String retStr = "";
        String str = toString();
        //System.out.println(str);
        for (int i=0; i < str.length()-2; i++) {
                System.out.println(str.substring(i,i+1));
                if (str.substring(i,i+2).equals("-1")) {
                        retStr += "_";
                        i++;
                }
                else if (str.substring(i,i+1).equals("1"))
                        retStr += "Q";
                else if (str.substring(i,i+1).equals("\t"))
                        retStr += "\t";
                else if (str.substring(i,i+1).equals("\n"))
                        retStr += "\n";
                else
                        retStr += "_";
        }
        retStr += "\n";
        System.out.println(retStr);
}



//================= YE OLDE SEPARATOR =================

/***
 * <General description>
 * precondition: a board exists
 * postcondition:
 * If (row,col) doesn't exist, returns false.
 * If (row,col) exists, a 1 is set down at the position.
 * All the values of tiles on the same row and to the right of the queen are subtracted by 1.
 * All the values of tiles in a diagonal and to the right of the queen are subtracted by 1.
 */
private boolean addQueen(int row, int col){
        if(_board[row][col] != 0) {
                return false;
        }
        _board[row][col] = 1;
        int offset = 1;
        while(col+offset < _board[row].length) {
                _board[row][col+offset]--;
                if(row - offset >= 0) {
                        _board[row-offset][col+offset]--;
                }
                if(row + offset < _board.length) {
                        _board[row+offset][col+offset]--;
                }
                offset++;
        }
        return true;
}


/***
 * <General description>
 * precondition: A board exists
 * postcondition:
 * If there is no queen on the tile, returns false.
 * If there is a queen, the value of the tile is set to 0.
 * All the values of tiles affected by the queen are increased by 1.
 */
private boolean removeQueen(int row, int col){
        if ( _board[row][col] != 1 ) {
                return false;
        }
        _board[row][col] = 0;
        int offset = 1;

        while( col+offset < _board[row].length ) {
                _board[row][col+offset]++;
                if( row - offset >= 0 ) {
                        _board[row-offset][col+offset]++;
                }
                if( row + offset < _board.length ) {
                        _board[row+offset][col+offset]++;
                }
                offset++;
        }
        return true;
}


/***
 * <General description>
 * precondition: _board is filled with values
 * postcondition: returns the String version of _board.
 */
public String  toString()
{
        String ans = "";
        for( int r = 0; r < _board.length; r++ ) {
                for( int c = 0; c < _board[0].length; c++ ) {
                        ans += _board[r][c]+"\t";
                }
                ans += "\n";
        }
        return ans;
}


//main method for testing...
public static void main( String[] args )
{
        /*=====================
           QueenBoard b = new QueenBoard(5);
           System.out.println(b);
           b.addQueen(3,0);
           b.addQueen(0,1);
           System.out.println(b);
           b.removeQueen(3,0);
           System.out.println(b);
           System.out.println(b.solveH(2));
           System.out.println(b.solveH(2));
           b.printSolution();
           ========================*/

        QueenBoard plsSolve = new QueenBoard(4);
        plsSolve.solve();
}

}//end class
