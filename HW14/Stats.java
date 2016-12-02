// Ryan Siu
// APCS1 pd5
// HW14 -- stAtistically sPeaking
// 2016-10-07

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

}
