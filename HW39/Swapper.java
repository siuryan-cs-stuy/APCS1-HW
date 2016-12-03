//**********************************************************************
// Ryan Siu
// APCS1 pd5
// HW39 -- Put it together
// 2016-12-03
//
// The operation of this program runs as follows: an instance of Swapper
// is created, passing in a specified number of rows and columns and
// create a 2D array of that size (or if none is specified, use 3x3).
// The user is then prompted to choose a first position and a second
// position from a displayed range, and the values at these two
// positions in the array are swapped. If the positions chosen by the
// user are out of the bounds of the array, then an error message is
// printed and the swap does not occur. The positions of each index in
// the array is determined by the row, then the column as follows:
// [
// [0, 1, 2],
// [3, 4, 5]
// ]
//
//**********************************************************************

import cs1.Keyboard;

public class Swapper {

    // Instance vars
    private String[][] arr;
    public static String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    // Default constructor
    // Calls overloaded constructor with 3 rows and 3 columns
    public Swapper () {
        this(3,3);	
    }

    // Overloaded constructor
    // Creates 2D array with specified rows and columns, populates with
    //   randomly generated Strings
    public Swapper ( int rows, int cols ) {
	arr = new String[rows][cols];
	for (int i = 0; i < arr.length; i++ ) {
	    for (int j = 0; j < arr[i].length; j++) {
		arr[i][j] = uniqueString();
	    }
	}
    }

    // Randomy generates a 3 or 4 letter String and returns it
    public String uniqueString () {
	String retStr = "";
	int numLetters = (int)(Math.random() * 2 + 3);
        for (int i = 0; i < numLetters; i++) {
	    int randIndex = (int)(Math.random() * 26);
	    retStr += LETTERS.substring(randIndex, randIndex+1);
	}
	return retStr;
    }

    // Overwritten toString() method, returns visual representation of 2D array
    public String toString() {
	String retStr = "[";
	for (String[] row : arr) {
	    retStr += "\n[";
	    for (String cell : row) {
		retStr += cell + ", ";
	    }
	    retStr = retStr.substring( 0, retStr.length() - 2 );
	    retStr += "],";
	}
	retStr = retStr.substring( 0, retStr.length() - 1 );
	retStr += "\n]";
	return retStr;
    }

    // Swaps the Strings at the specified positions in the array
    public void swap ( int pos1, int pos2 ) {
	if ( validPos(pos1) && validPos(pos2) ) {
	    String placeholder = valueAt(pos1);
	    setValue( pos1, valueAt(pos2) );
	    setValue( pos2, placeholder );
	} else {
	    System.out.println( "Invalid position(s). Cannot swap." );
	}
    }

    // Returns the String at the specified position in the array
    public String valueAt ( int pos ) {
	for (int i = 0; i < arr.length; i++ ) {
	    if (pos - arr[i].length < 0) {
		return arr[i][pos];
	    } else {
		pos -= arr[i].length;
	    }
	}
	return "";
    }

    // Sets the value of the specified position in the array to the
    //   specified value
    public void setValue ( int pos, String value ) {
	for (int i = 0; i < arr.length; i++ ) {
	    if (pos - arr[i].length < 0) {
		arr[i][pos] = value;
		break;
	    } else {
		pos -= arr[i].length;
	    }
	}
    }

    // Returns whether a specified pos is in the array
    public boolean validPos ( int pos ) {
	return pos >= 0 && pos < numCells();
    }

    // Returns the number of indicies in the array 
    public int numCells() {
	int numCells = 0;
        for (int i = 0; i < arr.length; i++) {
	    numCells += arr[i].length;
	}
	return numCells;
    }

    // User interface
    public static void main ( String[] args ) {
	Swapper s = new Swapper(5,6);
	System.out.println();
	System.out.println( s );
	System.out.println();
	System.out.println( "Select two positions of the array to swap. (0 - " + (s.numCells()-1) + ")");
	System.out.print( "First pos: " );
	int pos1 = -1;
	while (pos1 == -1) {
	    pos1 = Keyboard.readInt();
	}
	System.out.print( "Second pos: " );
	int pos2 = -1;
	while (pos2 == -1) {
	    pos2 = Keyboard.readInt();
	}
        s.swap( pos1, pos2 );
	System.out.println();
	System.out.println( s );
    }
    
}



