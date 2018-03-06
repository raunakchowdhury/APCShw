//Raunak Chowdhury
//APCS1 pd2
//HW15 -- Thinkers of the Corn, Do You Hear the People SING!
//2017-03-07

/***
 * SKEELTON for class
 * MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 *
 * USAGE:
 * $ java Maze [mazefile]
 * (mazefile is ASCII representation of maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 * 1. Is the array solved? If yes, exit.
 * 2. Is the hero currently out of the array? If yes, return.
 * 3. Has the hero found the exit? If yes, then set solved to true and return.
 * 4. Is the hero embedded in a wall? If yes, return.
 * 5. Set the hero's current position to @ and try every movement in a cardinal direction recursively.
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
private char[][] maze;
private int h, w;   //height, width of maze
private boolean solved;

//initialize constants for map component symbols
final private char HERO =         '@';
final private char PATH =         '#';
final private char WALL =         ' ';
final private char EXIT =         '$';
final private char VISITED_PATH = '.';


public MazeSolver( String inputFile )
{
        // init 2D array to represent maze
        // (80x25 is default terminal window size)
        maze = new char[80][25];
        h = 0;
        w = 0;

        //transcribe maze from file into memory
        try {
                Scanner sc = new Scanner( new File(inputFile) );

                System.out.println( "reading in file..." );

                int row = 0;

                while( sc.hasNext() ) {

                        String line = sc.nextLine();

                        if ( w < line.length() )
                                w = line.length();

                        for( int i=0; i<line.length(); i++ )
                                maze[i][row] = line.charAt( i );

                        h++;
                        row++;
                }

                for( int i=0; i<w; i++ )
                        maze[i][row] = WALL;
                h++;
                row++;
        } catch( Exception e ) { e.printStackTrace();}
        //System.out.println( "Error reading file" ); }

        //at init time, maze has not been solved:
        solved = false;
}  //end constructor


public String toString()
{
        //send ANSI code "ESC[0;0H" to place cursor in upper left
        String retStr = "[0;0H";
        //emacs shortcut: C-q, then press ESC
        //emacs shortcut: M-x quoted-insert, then press ESC

        int i, j;
        for( i=0; i<h; i++ ) {
                for( j=0; j<w; j++ )
                        retStr = retStr + maze[j][i];
                retStr = retStr + "\n";
        }
        return retStr;
}


//helper method to keep try/catch clutter out of main flow
private void delay( int n )
{
        try {
                Thread.sleep(n);
        } catch( InterruptedException e ) {
                System.exit(0);
        }
}


/*********************************************
* void solve(int x,int y) -- recursively finds maze exit (depth-first)
* @param x starting x-coord, measured from left
* @param y starting y-coord, measured from top
*********************************************/
public void solve( int x, int y ) {

        delay(50); //slow it down enough to be followable

        //primary base case
        if ( solved ) { //already solved
                System.out.println(this);
                System.exit(0);
        }
        //other base case(s)...
        else if ( x < 0 || y < 0 ||
                  x > w || y > h ) { //out of bounds
                /* YOUR AMAZEING CODE HERE */
                return;
        }
        else if ( maze[x][y] == EXIT ) { //exit has been found
                /* YOUR AMAZEING CODE HERE */
                maze[x][y] = HERO;
                solved = true;
                return;
        }
        else if (!onPath(x,y) ) { //out of bounds but in array
                /* YOUR AMAZEING CODE HERE */
                return;
        }
        //recursive reduction
        else {
                maze[x][y] = VISITED_PATH;
                /* YOUR AMAZEING CODE HERE */
                solve(x+1,y);
                solve(x-1,y);
                solve(x,y+1);
                solve(x,y-1);
                System.out.println(this);
        }
}

//accessor method to help with randomized drop-in location
public boolean onPath( int x, int y) {
        return maze[x][y] == PATH;
}

}//end class MazeSolver


public class MazeSkel
{
public static void main( String[] args )
{
        try {
                String mazeInputFile = args[0];

                MazeSolver ms = new MazeSolver( mazeInputFile );
                //clear screen
                System.out.println( "[2J" );

                //display maze
                System.out.println( ms );

                //drop hero into the maze (coords must be on path)
                //comment next line out when ready to randomize startpos
                //ms.solve( 4, 3 );
                ms.solve(0,0);

                /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   //drop our hero into maze at random location on path
                   //the Tim Diep way:
                   Random r = new Random();
                   int startX = r.nextInt( 80 );
                   int startY = r.nextInt( 25 );
                   while ( !ms.onPath(startX,startY) ) {
                   startX = r.nextInt( 80 );
                   startY = r.nextInt( 25 );
                   }

                   ms.solve( startX, startY );
                   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        } catch( Exception e ) {
                e.printStackTrace();
                System.out.println( "Error reading input file." );
                System.out.println( "Usage: java Maze <filename>" );
        }
}

}//end class Maze
