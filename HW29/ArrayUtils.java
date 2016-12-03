// Ryan Siu
// APCS1 pd5
// HW29 -- ArrayUtils with Objects!
// 2016-11-17

public class ArrayUtils {

    // Testing
    public static void main (String[] args) {
	Object[] test = new Object[5];
	//
	popArray(test);
	System.out.println( stringify(test) ); // this
	
    }

    // Static method to populate existing array with ArrayUtils instances
    // NO RETURN, changes the values inside the input array
    // Array ints will be changed randomly to a number from 0-10
    public static void popArray (Object[] arr) {
	for (int i = 0; i < arr.length; i += 1) {
	    arr[i] = new ArrayUtils();
	    // arr[i] = (int)(Math.random() * 10);
	}
    }

    // Static method to return a String version of an array of ints
    public static String stringify (Object[] arr) {
	String retStr = "";
	for (Object i : arr) {
	    retStr += i + ", ";
	}
	return retStr.substring(0,retStr.length()-2);
    }
    
}
