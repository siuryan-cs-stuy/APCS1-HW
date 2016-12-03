// Ryan Siu
// APCS1 pd5
// HW21 -- For the Lulz Love of Strings
// 2016-10-25

public class Foresrever {

    // Testing
    public static void main (String[] args) {
	System.out.println( fenceF(0) );
	System.out.println( fenceF(1) );
	System.out.println( fenceF(5) );
	System.out.println( reverseF("stressed") );  // desserts
	System.out.println( reverseF("abcde") );     // edcba
	System.out.println( reverseR("stressed") );  // desserts
	System.out.println( reverseR("abcde") );     // edcba
    }

    // Takes non-negative posts, returns String represenation of a fence with
    // the specified number of posts
    public static String fenceF (int posts) {
	String fence = "|";

	// Special case
	if (posts == 0) {
	    return "";
	}

	// Loops and adds posts to fence
	for (int i = 1; i < posts; i += 1) {
	    fence += "--|";
	}
	return fence;
    }

    // Takes String s and returns s with letters reversed
    // Uses for loop
    public static String reverseF (String s) {
	String reverse = "";

	// Adds the ith letter to the front of the reversed string,
	// as i goes from the first letter to the last
	for (int i = 0; i < s.length(); i += 1) {
	    reverse = s.substring( i, i+1 ) + reverse;
	}
	return reverse;
    }

    // Takes String s and returns s with letters reversed
    // Uses recursion
    public static String reverseR (String s) {

	// Base case
	if (s.length() == 0) {
	    return "";
	} else {
	    int posLastChar = s.length()-1;
	    return s.substring(posLastChar) +
		reverseR( s.substring( 0, posLastChar ) );
	}
    }
    
}
