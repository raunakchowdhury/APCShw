/*==================================================
   class GuessNumber -- fun fun fun!

   eg, sample interaction with end user:
   Guess a # fr 1-100: 50
   Too high
   Guess a # fr 1-49: 25
   Too low
   Guess a # fr 26-49: 38
   Correct! It took 3 guesses
   ==================================================*/

import cs1.Keyboard;

public class GuessNumber
{
//instance vars
private int _lo, _hi, _guessCtr, _target;


/*==================================================
   constructor -- initializes a guess-a-number game
   pre:  take a as the lower Bound and b as the higher Bound
   post: _lo is lower bound, _hi is upper bound,
   _guessCtr is 1, _target is random int on range [_lo,_hi]
   ==================================================*/
public GuessNumber( int a, int b )
{
        _lo = a;
        _hi = b;
        _guessCtr = 1;
        _target = (int) (Math.random() * (_hi - _lo) + _lo);
        /* YOUR IMPLEMENTATION HERE */
}


/*==================================================
   void playRec() -- Prompts a user to guess until guess is correct.
   Uses recursion.
   pre: Existing instances have already been initialized
   post: Play the game until the end
   ==================================================*/
public void playRec()
{
        System.out.print("Guess a number between ");
        System.out.print( _lo + "-" + _hi +": ");
        int guess = Keyboard.readInt();

        if (guess == _target) { //if the player guesses correctly
                System.out.println("Correct! You got this number in " + _guessCtr + " guesses.");
                return;
        }
        //deal with invalid inputs that fall outside the given range
        else if(guess > _hi || guess < _lo) {
                System.out.println("Invalid input!");
        }
        // if the guess is more than the target
        else if (guess > _target) {
                System.out.println("Your guess is too high! ");
                _guessCtr++;
                _hi = guess  - 1; //change the range to reflect the guess
        }
        // if the guess is less than the target
        else {
                System.out.println("Your guess is too low!");
                _guessCtr++;
                _lo = guess + 1; //change the range to reflect the guess
        }
        playRec();

        /* YOUR IMPLEMENTATION HERE */
}


/*==================================================
   void playIter() -- Prompts a user to guess until guess is correct.
   Uses iteration.
   pre: all vars have been initialized
   post: play the game till the end
   ==================================================*/
public void playIter()
{
        int guess = 0;

        while (guess != _target) {
                System.out.print("Guess a number between ");
                System.out.print( _lo + "-" + _hi +": ");
                guess = Keyboard.readInt();
                if (guess == _target) //deal with the exception when the range is equal to the target
                        break;
                if(guess > _hi || guess < _lo) {
                        System.out.println("Invalid input!");
                }
                // if the guess is more than the target
                else if (guess > _target) {
                        System.out.println("Your guess is too high! ");
                        _guessCtr++;
                        _hi = guess  - 1;//change the range to reflect the guess
                }
                // if the guess is less than the target
                else {
                        System.out.println("Your guess is too low!");
                        _guessCtr++;
                        _lo = guess + 1; //change the range to reflect the guess
                }
        }
        System.out.println("Correct! You got this number in " + _guessCtr + " guesses.");
        /* YOUR IMPLEMENTATION HERE */
}


//wrapper for playRec/playIter to simplify calling
public void play()
{
        //use one or the other below:
        playRec();
        //playIter();
}


//main method to run it all
public static void main( String[] args )
{

        //instantiate a new game
        GuessNumber g = new GuessNumber(1,100);

        //start the game
        g.play();
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}    //end main

}//end class
