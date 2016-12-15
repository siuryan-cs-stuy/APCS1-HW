import cs1.Keyboard;

public class GuessNumber {

    private int randNum;
    private int high;
    private int low;

    public GuessNumber() {
	randNum = (int)(Math.random()*100) + 1;
	high = 100;
	low = 1;
    }

    // Returns positive if too high, negative if too low, 0 if correct
    public int checkGuess( int guess ) {
	int diff = guess - randNum;
	if (diff < 0 && guess > low) {
	    low = guess;
	} else {
	    high = guess;
	}
	return diff;
    }

    public static void main( String[] args ) {

	GuessNumber g = new GuessNumber();
	boolean win = false;
	int guesses = 0;

	while (!win) {
	    System.out.print( "Guess a number between " + g.low + " and " + g.high + ": " );
	    int input = Keyboard.readInt();
	    if (g.checkGuess(input) > 0) {
		System.out.println( "\nToo high, try again..." );
	    } else if (g.checkGuess(input) < 0) {
		System.out.println( "\nToo low, try again..." );
	    } else {
		win = true;
	    }
	    guesses++;
	}

	System.out.println( "Correct! It took " + guesses + " guesses." );
    }

}
