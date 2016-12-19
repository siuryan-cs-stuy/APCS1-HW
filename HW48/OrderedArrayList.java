// Ryan Siu
// APCS1 pd5
// HW46 -- ascending
// 2016-12-14

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList<Comparable>();
    }


    public String toString() {
	return _data.toString();
    }


    public Comparable remove( int index ) {
	return _data.remove(index);
    }


    public int size() {
	return _data.size();
    }

    
    public Comparable get( int index ) {
	return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) {
	for (int i = 0; i < _data.size(); i++) {

	    // Uses the Comparable method compareTo (if newVal is less than
	    // get(i), then a negative integer is returned
	    if (newVal.compareTo( _data.get(i) ) < 0) {
		_data.add(i, newVal);
		return;
	    }
	    
	}
	_data.add(newVal);
    }

    // addBinary takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a binary search to find appropriate index
    public void addBinary( Comparable newVal ) {
        int low = 0;
	int high = _data.size() - 1;
	int mid;
	while (low != high) {

	    mid = (low + high) / 2;
	    int midValue = _data.get(mid);

	    // Uses the Comparable method compareTo (if newVal is less than
	    // get(i), then a negative integer is returned
	    if (newVal.compareTo( midValue ) < 0) {
		high = midValue;
	    } else if (newVal.compareTo( midValue ) > 0) {
		low = midValue;
	    } else {
		_data.add(mid, newVal);
	    }
	}
	
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addLinear( valToAdd );
	}

	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println();
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
 
