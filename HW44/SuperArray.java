// Ryan Siu
// APCS1 pd5
// HW44 -- In America, the Driver Sits on the Left
// 2016-12-12

/**************************************************
  class SuperArray version 4.0
  Wrapper class for array. Facilitates 
  *  resizing 
  *  expansion 
  *  read/write capability on elements
  *  adding an element to end of array
  *  adding an element at specified index
  *  removing an element at specified index
  ...and now SuperArray complies with the specifications of the 
  List interface. (List.java must be in same dir as this file)
**************************************************/

public class SuperArray implements List
{
    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
	_data = new Object[10];
	_lastPos = -1;
	_size = 0;
    }
    
    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
        String s = "[";
	for (Object a : _data) {
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
	Object[] copy = new Object[_data.length*2];
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
	Object oldValue = _data[index];
        _data[index] = o;
	return oldValue;
    }

    //adds an item after the last item
    public boolean add( Object o )
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
    public Object remove( int index )
    {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("\nindex input is not a valid index");
	}
	Object oldValue = _data[index];
	for (int n = index; n < _lastPos; n++) {
	    _data[n] = _data[n+1];
	}
	_lastPos--;
	_size--;
	return oldValue;
    }

    //return number of meaningful items in _data
    public int size() 
    {
        return _size;
    }
    
    //main method for testing
    public static void main( String[] args ) 
    {

	List mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	int[] test = {3,4,5};
	mayfield.add("hello");
	mayfield.add(4);
	mayfield.add(3.4f);
	mayfield.add(test);
	mayfield.add(1);
	
	System.out.println("Printing populated List mayfield...");
	System.out.println(mayfield);

	System.out.println("Printing third element of List mayfield...");
        System.out.println( mayfield.get(3) );
	System.out.println("Changing third element of List mayfield...");
	mayfield.set(3, "test string");
	System.out.println(mayfield);
	System.out.println("Size of List mayfield...");
	System.out.println( mayfield.size() );
	
	
    }//end main()

}//end class SuperArray
