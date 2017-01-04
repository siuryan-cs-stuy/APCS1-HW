import java.util.ArrayList;

public class MySorts {
    
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // Iterate through every element forward: O(n)
    // Iterate through elements backward: O(n)
    // Comparison: O(1)
    // Create temp var: O(1)
    // Set: O(1)
    // Set: O(1)
    // O(n) * O(n) * (O(1) + O(1) + O(1) + O(1)) => O(n^2) is the dominating term
    // bubbleSort is O(n^2)
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	
        for (int i = 0; i < data.size()-1; i++) {
	    for (int j = data.size()-1; j > 0; j--) {
		if (data.get(j).compareTo( data.get(j-1) ) < 0) {
		    Comparable temp = data.get(j);
		    data.set(j, data.get(j-1));
		    data.set(j-1, temp);
		}
	    }
	}
    }//end bubbleSortV

    
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // maxPos var: O(1)
    // Iterate through data backwards: O(n)
    // set value of maxPos: O(1)
    // Iterate through data backwards: O(n)
    // Comparison: O(1)
    // set value of maxPos: O(1)
    // data.set: O(1)
    // O(1) + O(n) * (O(1) + O(n) * (O(1) + O(1)) + O(1)) => O(n^2) is the dominating term
    // selectionSort is O(n^2)
    public static void selectionSortV( ArrayList<Comparable> data ) {
    //note: this version places greatest value at rightmost end,

    //maxPos will point to position of SELECTION (greatest value)
	int maxPos;
        
	for (int i = data.size()-1; i >= 0; i--) {
	    maxPos = i;
	    for (int j = maxPos; j >= 0; j--) {
		if (data.get(maxPos).compareTo( data.get(j) ) < 0) {
		    maxPos = j;
		}
	    }
	    data.set( i, data.set( maxPos, data.get(i) ));
	}

    }//end selectionSort


    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // Iterate through data forwards: O(n)
    // Iterate through data backwards: O(n)
    // Comparison: O(1)
    // data.set: O(1)
    // partition++: O(1)
    // O(n) * (O(n) * (O(1) + O(1)) + O(1))  => O(n^2) is the dominating term
    // insertionSort is O(n^2)
    public static void insertionSortV( ArrayList<Comparable> data ) {
	
	for (int partition = 1; partition < data.size(); partition++) {
	    for (int j = partition; j > 0; j--) {
		if (data.get(j).compareTo( data.get(j-1) ) < 0) {
		    data.set( j, data.set( j-1, data.get(j) ) );
		} else { 
		    break;
		}
	    }
	    partition++;
	}
    }//end insertionSortV

}
