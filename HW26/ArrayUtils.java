// Ryan Siu
// APCS1 pd5
// HW26 -- I Demand Arrays!
// 2016-11-2

public class ArrayUtils {

    // Testing
    public static void main (String[] args) {
	int[] test = new int[5];
	popArray(test);
	for (int i : test) {
	    System.out.println( i ); // should have same numbers as
	}
	System.out.println( stringify(test) ); // this
	
	Object[] test1 = new Object[5];
	populate(test1);
	System.out.println( stringify(test) );
    }

    // Static method to populate existing array with randomly generated ints
    // NO RETURN, changes the values inside the input array
    // Array ints will be changed randomly to a number from 0-10
    public static void popArray (int[] arr) {
	for (int i = 0; i < arr.length; i += 1) {
	    arr[i] = (int)(Math.random() * 10);
	}
    }

    public static void populate (Object[] arr) {
	for (int i = 0; i < arr.length; i += 1) {
	    arr[i] = (int)(Math.random() * 10);
	}
    }

    // Static method to return a String version of an array of ints
    public static String stringify (int[] arr) {
	String retStr = "";
	for (int i : arr) {
	    retStr += i + ", ";
	}
	return retStr.substring(0,retStr.length()-2);
    }
    
}
