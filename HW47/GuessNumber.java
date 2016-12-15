// Ryan Siu
// APCS1 pd5
// HW47 -- Keep Guessing
// 2016-12-15

import cs1.Keyboard;

public class GuessNumber {

    // instance vars
    private int randNum;
    private int high;
    private int low;

    
    // default constructor
    public GuessNumber() {
	randNum = (int)(Math.random()*100) + 1;
	high = 100;
	low = 1;
    }

    // Returns positive if too high, negative if too low, 0 if correct
    public int checkGuess( int guess ) {
	int diff = guess - randNum;
	if (diff < 0) {
	    if (guess > low) {
		low = guess;
	    } else {
		throw new UnsupportedOperationException( "Input guess for checkGuess(int) was out of range" );
	    }
	} else {
	    if (guess < high) {
		high = guess;
	    } else {
		throw new UnsupportedOperationException( "Input guess for checkGuess(int) was out of range" );
	    }
	}
	return diff;
    }

    // gameplay
    public static void main( String[] args ) {

	GuessNumber g = new GuessNumber();
	boolean win = false;
	int guesses = 0;

	while (!win) {
	    System.out.print( "Guess a number from " + g.low + "-" + g.high + ": " );
	    int input = Keyboard.readInt();
	    try {
		int result = g.checkGuess(input);
		if (result > 0) {
		    System.out.println( "Too high, try again..." );
		} else if (result < 0) {
		    System.out.println( "Too low, try again..." );
		} else if (result == 0){
		    win = true;
		}
		guesses++;
	    } catch (UnsupportedOperationException e) {
		System.out.println( "Your guess was out of the given range..." );
	    }
	}

	System.out.println( "Correct! It took " + guesses + " guesses." );
    }

}
