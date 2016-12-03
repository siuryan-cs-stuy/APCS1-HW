// Ryan Siu
// APCS1 pd5
// HW20 -- GCD Three Ways
// 2016-10-20

public class Stats {

    // Returns the arithmetic average of two integers
    public static int mean (int a, int b) {
	return (a+b)/2;
    }

    // Returns the arithmetic average of two doubles
    public static double mean (double a, double b) {
	return (a+b)/2;
    }

    // Returns the greater of two integers
    public static int max (int a, int b) {
	if (a > b) {
	    return a;
	} else {
	    return b;
	}
    }

    // Returns the greater of two doubles
    public static double max (double a, double b) {
        if (a > b) {
	    return a;
	} else {
	    return b;
	}
    }

    // Returns the greater of three integers
    public static int max (int a, int b, int c) {
	if (a > b && a > c) {
	    return a;
	} else if (b > c) {
	    return b;
	} else {
	    return c;
	}
    }

    // Returns the greater of three doubles
    public static double max (double a, double b, double c) {
        if (a > b && a > c) {
	    return a;
	} else if (b > c) {
	    return b;
	} else {
	    return c;
	}
    }

    // Returns the geometric mean of two integers
    // Typecasting is needed because sqrt returns a double, and we need to
    // return an integer.
    public static int geoMean(int a, int b) {
	return (int) Math.sqrt(a*b);
    }

    // Returns the geometric mean of two doubles
    public static double geoMean(double a, double b) {
	return Math.sqrt(a*b);
    }

    // Returns the geometric mean of three integers
    // Typecasting is needed because sqrt returns a double, and we need to
    // return an integer.
    public static int geoMean(int a, int b, int c) {
	return (int) Math.pow(a*b*c, 1./3);
    }

    // Returns the geometric mean of three doubles
    public static double geoMean(double a, double b, double c) {
	return (int) Math.pow(a*b*c, 1./3);
    }

    // GCD methods with Ibnul Jahan

    // starts a counter at 1 and goes up checking if the counter divides a and
    // b. It saves the largest counter that works and returns that.

    public static int gcd(int a, int b) {
	int ctr = 1;
	int output = 1;
	while (ctr <= a) {
	    if (a % ctr == 0 && b % ctr == 0) {
		output = ctr;
	    } 
	    ctr += 1;
	}
	return output;
    }

    /*
      Euclid's Algorithm 
      1. if a divides b or b divides a, then return the smaller one
      2. while neither number is equal to 0, continuously subtract the smaller
      from the larger
      3. when one number becomes 3, return the other number
    */

    // it checks if either number divides the other, and returns the smaller
    // number if so. If not, then it subtracts the smaller number from the
    // larger, and checks if the original larger number is equal to 0. If so
    // then return the nonzero number, if not then return the value of the
    // method run again with the new numbers.
    public static int gcdER(int a, int b) {
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
	    return gcdER(a,b);
	}
    }

    // it checks if either number divides the number, and returns the smaller
    // number if so. If not, then as long as neither number is 0, subtract
    // the smaller number from the larger number. When one of the numbers
    // does reach 0, return the other number. 
    public static int gcdEW (int a, int b) {
	if (b % a == 0) {
	    return a;
	} else if (a % b == 0) {
	    return b;
	}
        while (a != 0 && b != 0) {
	    if (a > b) {
		a -= b;
	    } else {
		b -= a;
	    }
	}
	if (a == 0) {
	    return b;
	} return a;
    }

}
