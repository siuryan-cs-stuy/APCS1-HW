// Ryan Siu
// APCS1 pd5
// HW48 -- Halving the Halves
// 2016-12-19

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

	// Prevent error when getting value at mid
	if ( _data.size() == 0 ) {
	    _data.add(newVal);
	    return;
	}
	
        int low = 0;
	int high = _data.size()-1; // to get the highest index
	int mid = 0;

	// Binary search section
	while (high >= low) {

	    mid = (low + high) / 2;

	    // Uses the Comparable method compareTo (if newVal is less than
	    // the value at mid, then a negative integer is returned
	    if (newVal.compareTo( _data.get(mid) ) < 0) {
	        high = mid - 1;
	    } else if (newVal.compareTo( _data.get(mid) ) > 0) {
		low = mid + 1;
	    } else {
	        break;
	    }
	    
	}

	// Add section
	// Compares the value at index mid to newVal
	// If newVal is greater, insert at index mid + 1
	// Otherwise if equal or less, insert at index mid
	if (newVal.compareTo( _data.get(mid) ) > 0) {
	    _data.add(mid+1, newVal);
	} else {
	    _data.add(mid, newVal);
	}
	
	
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addBinary() calls:");

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addBinary( valToAdd );
	}

	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( Franz );
	System.out.println();
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
 
