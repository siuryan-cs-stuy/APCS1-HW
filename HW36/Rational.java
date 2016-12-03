// Ryan Siu
// APCS1 pd5
// HW36 -- Be Rational
// 2016-11-28

public class Rational {

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
	this._p *= p;
	this._q *= q;
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
    }
    
}
