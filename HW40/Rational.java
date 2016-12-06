// Ryan Siu
// APCS1 pd5
// HW40 -- Rational Equality
// 2016-12-07

public class Rational implements Comparable {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private int _p;
    private int _q;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Rational() {
	_p = 0;
	_q = 1;
    }

    
    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars if denom is valid. otherwise
            prints system message and uses default value
      =============================================*/
    public Rational( int p, int q ) {
	this();
	if (q != 0) {
	    _p = p;
	    _q = q;
	} else {
	    System.out.println("Invalid denominator");
	}
    }


    /*=============================================
      String toString() -- overriden toString(), returns rational number in the
                           form p/q 
      pre:  
      post: String represenation is returned
      =============================================*/
    public String toString() {
	return _p + "/" + _q;
    }


    /*=============================================
      double floatValue() -- returns the rational number as a double
      pre:  _q is not 0
      post: double representation is returned
      =============================================*/
    public double floatValue() {
	return (double) _p / (double) _q;
    }


    /*=============================================
      void multiply( Rational ) -- multiplies this rational num by the input num
      pre:  Rational instance is an argument
      post: _p and _q are changed accordingly
      =============================================*/
    public void multiply( Rational Q ) {
	this._p *= Q._p;
	this._q *= Q._q;
    }


    /*=============================================
      void divide( Rational ) -- divides this rational num by the input num
      pre:  Rational instance is an argument
      post: _p and _q are changed accordingly
      =============================================*/
    public void divide( Rational Q ) {
	int p = Q._p;
	int q = Q._q;
	this._p *= q;
	this._q *= p;
    }
    
    /*=============================================
      void add( Rational ) -- adds this rational num by the input num
      pre:  Rational instance is an argument
      post: _p and _q are changed accordingly
      =============================================*/
    public void add( Rational Q ) {
	int p = Q._p;
	int q = Q._q;
	this._p = this._p * q + p * this._q;
	this._q = this._q * q;
    }


    /*=============================================
      void subtract( Rational ) -- subtracts this rational num by the input num
      pre:  Rational instance is an argument
      post: _p and _q are changed accordingly
      =============================================*/
    public void subtract( Rational Q ) {
	int p = Q._p;
	int q = Q._q;
	this._p = this._p * q - p * this._q;
	this._q = this._q * q;
    }

    /*=============================================
      int gcd( int, int ) -- returns the GCD of the two inputs, recursively
      pre:  int a and int b are arguments
      post: the gcd of a and b is returned as an int
      =============================================*/
    public static int gcd( int a, int b ) {
	if (b % a == 0) {
	    return a;
	} else if (a % b == 0) {
	    return b;
	} else {
	    if (a > b) {
		a -= b;
		if (a == 0) {
		    return b;
		}
	    } else {
		b -= a;
		if (b == 0) {
		    return a;
		}
	    }
	    return gcd(a,b);
	}
    }

    /*=============================================
      void reduce() -- reduces this rational number
      pre:  
      post: _p and _q are changed accordingly
      =============================================*/
    public void reduce() {
	if (this._p != 0) {
	    int divisor = gcd(this._p, this._q);
	    this._p /= divisor;
	    this._q /= divisor;
	}
    }


    /*=============================================
      int compareTo(Object) -- compares this Rational number to input Object number using cross multiplication
      pre:  Object is a Rational
      post: returns 1 for this is greater, -1 for this is less, 0 for equal
      =============================================*/
    public int compareTo( Object o ) {
	Rational Q = (Rational)o;
	if (Q._q * this._p > Q._p * this._q) {
	    // this rational is greater
	    return 1;
	} else if (Q._q * this._p < Q._p * this._q) {
	    // input rational is greater
	    return -1;
	} else {
	    // equal
	    return 0;
	}
    }


    /*=============================================
      boolean equals(Object) -- overriden equals() compares this Rational number to input Rational number, handles errors for compareTo()
      pre:  Object is an input
      post: returns true if equal value, false if not equal, error if input is not Rational
      =============================================*/
    public boolean equals( Object o ) {
	if (o instanceof Rational) {
	    return compareTo(o) == 0;
	} else {
	    throw new ClassCastException("\ncompareTo() input is not a Rational");
	}
    }

    // Testing
    public static void main( String[] args ) {
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
	System.out.println(r); // 2/6
	System.out.println( r.floatValue() ); // 0.333...
	System.out.println(s); // 1/2
	r.divide(r); //Divides r by r, changes r to 1
	System.out.println(r); // 12/12
	System.out.println( r.floatValue() ); // 1.0

        Rational t = new Rational(3,4);
	Rational u = new Rational(5,6);
	t.add(u); //Increases t by u, changes r to 38/24.  u remains 5/6
	System.out.println(t); // 2/6
	u.subtract(u); //Decreases u by u, changes u to 0/36
	System.out.println(u); // 0/36

	System.out.println( Rational.gcd(36,30) );
	System.out.println( Rational.gcd(30,36) );
	t.reduce(); //Reduces t to 19/12
	System.out.println(t); //19/12
	u.reduce(); //u has numerator of 0, does not reduce
	System.out.println(u); //0/36

	Rational v = new Rational(1,0); //Invalid denominator, becomes 0/1
	System.out.println(v); //0/1

	System.out.println( t.compareTo(u) ); // 1
	System.out.println( u.compareTo(t) ); // -1
	System.out.println( u.compareTo( new Rational(0,1) ) ); // 0

	Rational w = new Rational(4,5);
	Rational x = new Rational(8,10);
	Rational z = new Rational(3,4);

	System.out.println( w.equals(x) ); // true
	System.out.println( w.equals(z) ); // false

	Object y = new Object();
	System.out.println( w.equals(y) ); // ClassCastException error
    }
    
}
