// Ryan Siu and Tiffany Moi -- Team <tr>
// APCS1 pd5
// HW43 -- Array of Titanium
// 2016-12-11

/**************************************************
  class SuperArray version 3.0
  Wrapper class for array. Facilitates 
  *  resizing 
  *  expansion 
  *  read/write capability on elements
  *  adding an element to end of array
  *  adding an element at specified index
  *  removing an element at specified index
  ...and now SuperArray complies with the specifications of the 
  ListInt interface. (ListInt.java must be in same dir as this file)
**************************************************/

public class SuperArray implements List
{
    private int[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
	_data = new int[10];
	_lastPos = -1;
	_size = 0;
    }
    
    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
        String s = "[";
	for (int a : _data) {
	    s += a + ",";
	}
	if (s.length() > 1) {
	    s = s.substring(0,s.length()-1);
	}
	s += "]";
	return s;
    }

    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
	int[] copy = new int[_data.length*2];
	for (int i = 0; i <= _lastPos; i++) {
	    copy[i] = _data[i];
	}
	_data = copy;
    }

    //accessor method -- return value at specified index
    public Object get( int index ) { 
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("\nindex input is not a valid index"); 
	}
	return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public Object set( int index, Object o ) 
    {
	int oldValue = _data[index];
        _data[index] = o;
	return oldValue;
    }

    //adds an item after the last item
    public void add( Object o )
    {
	if (size() == _data.length) {
	    expand();
	}
	_lastPos++;
        set( _lastPos, o );
	_size++;
	return true;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Object o )
    {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("\nindex input is not a valid index");
	}
	if (size() == _data.length) {
	    expand();
	}
	for (int n = _lastPos; n >= index; n--) {
	    set( n+1, _data[n] );
	}
	_data[index] = o;
	_lastPos++;
	_size++;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void remove( int index )
    {
	for (int n = index; n < _lastPos; n++) {
	    _data[n] = _data[n+1];
	}
	_lastPos--;
	_size--;
    }

    //return number of meaningful items in _data
    public int size() 
    {
        return _size;
    }
    
    //main method for testing
    public static void main( String[] args ) 
    {
	
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++;
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	ListInt mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	
    }//end main()

}//end class SuperArray
