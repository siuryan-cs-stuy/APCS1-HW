// Ryan Siu
// APCS1 pd5
// HW16 -- Wayne's World
// 2016-10-13

public class Coin {

    // Instance vars
    private float value;
    private String upFace;
    private String name;
    private int headsCtr;
    private int tailsCtr;
    private float bias;

    // Default constructor
    public Coin() {
	value = 0.0f;
	upFace = "heads";
	name = "null";
	headsCtr = 0;
	tailsCtr = 0;
	bias = 0.5f;
    }

    // Overloaded constructor 1
    // Takes a String argument indicating denomination as input
    public Coin( String name ) {
	this();  // sets instance vars to default values in the default constructor
	this.name = name;  // this.name to specify the instance var, not the argument
    }

    // Overloaded constructor 1
    // Takes a String argument indicating denomination and
    // String argument indicating "heads" or "tails" as input
    public Coin( String name, String upFace ) {
	this(name);  // sets instance vars to values in overloaded constructor 1
        this.upFace = upFace;  // this.upFace to specify the instance var, not the argument
    }

    // Randomly chooses "heads" or "tails" according to bias and
    // returns the outcome
    public String flip() {
	if (bias > Math.random()) {
	    upFace = "heads";
	} else {
	    upFace = "tails";
	}
	return upFace;
    }

    // Overwritten toString() method, returns denomination and face
    public String toString() {
	return "\nDenomination: " + name + "\nFace: " + upFace + "\n";
    }

    // Overwritten equals() method, compares faces of Coin objects
    public boolean equals( Coin coin ) {
	return this.upFace == coin.upFace;   // this.upFace to avoid ambiguity
    }

    // Assigns a double value to instance var value based on the name
    public float assignValue() {
	if (name == "penny") {
	    value = 0.01f;
	} else if (name == "nickel") {
	    value = 0.05f;
	} else if (name == "dime") {
	    value = 0.1f;
	} else if (name == "quarter") {
	    value = 0.25f;
	} else if (name == "half-dollar") {
	    value = 0.5f;
	} else if (name == "dollar") {
	    value = 1f;
	} else {
	    value = 0;
	}
	return value;
    }
}
