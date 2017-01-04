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
    // For loop: O(n)
    // Compare: O(1)
    // Shifting elements: O(n)
    // Inserting element: O(1)
    // O(n) + (O(1) + O(n) + O(1)) = O(2n) + O(2)
    // O(2n) is the dominating term
    // addLinear is O(n)
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
    // Declaring vars: O(1) + O(1) + O(1)
    // While loop (binary search): O(log2 n)
    // Shifting elements: O(n)
    // Inserting element: O(1)
    // O(1) + O(1) + O(1) + O(log2 n) + O(n) + O(1) = O(n) + O(log2 n) + O(4)
    // O(n) is the dominating term
    // addBinary is O(n)
    public void addBinary( Comparable newVal )
    { 
	//initialize high, low, midpt indices
	int lo = 0;
	int med = 0;
	int hi = _data.size()-1;

	while ( lo <= hi ) { //running until target is found or bounds cross

	    med = (lo + hi) / 2;
	    int x = _data.get(med).compareTo( newVal );
	        
	    if ( x == 0 ) {
		//equal value found, insert here
		_data.add( med, newVal );
		return;
	    }
	    else if ( x > 0 )
		//newVal < med, so look at lower half of data
		hi = med - 1;
	    else
		//newVal > med, so look at upper half of data
		lo = med + 1;
	}
	// If you made it this far, newVal is not present.
	// So insert at lo.
	_data.add( lo, newVal );
    }//end addBinary	


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
 
