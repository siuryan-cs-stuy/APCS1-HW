// Ryan Siu
// APCS1 pd5
// HW45 -- Al<B> Sorted!
// 2016-12-13

import java.util.ArrayList;

public class ALTester {
    
    private ArrayList arr;

    // default constructor
    // creates 23 Integers contained within the ArrayList class
    public ALTester() {
	arr = new ArrayList();
	for (int i = 0; i < 23; i++) {
	    arr.add(i);
	}
    }

    // returns true if the Integers in the array are arithmetically
    // increasing by index, returns false otherwise
    public boolean sorted() {
	for (int i = 1; i < arr.size(); i++) {
	    if ((int)arr.get(i) <= (int)arr.get(i-1)) {
		return false;
	    }
	}
	return true;
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
        String s = "[";
	for (Object a : arr) {
	    a = (int)a;
	    s += a + ",";
	}
	if (s.length() > 1) {
	    s = s.substring(0,s.length()-1);
	}
	s += "]";
	return s;
    }

    // testing
    public static void main (String[] args) {
	ALTester a = new ALTester();
	System.out.println(a);
	System.out.println(a.sorted());
	a.arr.set(0,1);
	System.out.println(a);
	System.out.println(a.sorted());
	a.arr.set(0,0);
	a.arr.remove(0);
	a.arr.add(23);
	System.out.println(a);
	System.out.println(a.sorted());
    }

}
