// Ryan Siu
// APCS1 pd5
// HW18 -- Loopy
// 2016-10-17

public class Driver {

    public static void main( String[] args ) {

	//build Objects from blueprint specified by class Coin

	//test default constructor
	Coin mine = new Coin();

	//test 1st overloaded constructor
	Coin yours = new Coin( "quarter" );

	//test 2nd overloaded constructor
	Coin wayne = new Coin( "dollar", "heads" );

	//test toString() methods of each Coin
	System.out.println("mine: " + mine);
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);
	
	//test flip() method
	System.out.println("\nAfter flipping...");
	yours.flip();
	wayne.flip();
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);
	
	//test equals() method
	if ( yours.equals(wayne) ) 
	    System.out.println( "Matchee matchee!" );
	else
	    System.out.println( "No match. Firestarter you can not be." );

	// a: until x heads have come up
	System.out.println();
	heads(yours, 3);
	System.out.println();
	heads(yours, 1);

	// b: until y matches have come up
	System.out.println();
	matches(yours, wayne, 5);

	// c: until at least 13 matches have come up,
	// and the number of matches is divisible by 2000.
	System.out.println();
	match13(yours, wayne);

    }//end main

    private static void heads (Coin coin, int target) {
	int numHeads = 0;
	while (numHeads < target) {
	    if (coin.flip() == "heads"){
		numHeads += 1;
	    }
	    System.out.println("Flipping coin: " + coin);
	}
	System.out.println("Target of " + target + " heads met.");
    }

    private static void matches (Coin coin1, Coin coin2, int target) {
	int numMatches = 0;
	while (numMatches < target) {
	    if (coin1.flip() == coin2.flip()){
		numMatches += 1;
	    }
	    System.out.println("Flipping coin 1: " + coin1);
	    System.out.println("Flipping coin 2: " + coin2);
	    System.out.println("Match: " + coin1.equals(coin2));
	}
	System.out.println("Target of " + target + " matches met.");
    }

    private static void match13 (Coin coin1, Coin coin2) {
	int numMatches = 0;
	while (numMatches < 13 || 2000 % numMatches != 0) {
	    if (coin1.flip() == coin2.flip()){
		numMatches += 1;
	    }
	    System.out.println("Flipping coin 1: " + coin1);
	    System.out.println("Flipping coin 2: " + coin2);
	    System.out.println("Match: " + coin1.equals(coin2));
	}
	System.out.println("Target of " + numMatches + " matches met.");
    }

}//end class
