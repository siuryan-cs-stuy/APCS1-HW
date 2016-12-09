// Ryan Siu and Rihui Zheng - Team Coefficient of Determination
// APCS1 pd5
// HW42 -- Array of Grade 316
// 2016-12-08

/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

public class SuperArray 
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
    public int get( int index ) { return _data[index]; }

    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) 
    {
	int oldValue = _data[index];
        _data[index] = newVal;
	if (index > _lastPos) {
	    _lastPos = index;
	}
	return oldValue;
    }

    //adds an item after the last item
    public void add( int newVal )
    {
	if (_size == _data.length) {
	    expand();
	}
	_lastPos++;
        set( _lastPos, newVal );
	_size++;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal )
    {
	if (_size == _data.length) {
	    expand();
	}
	for (int n = _lastPos; n >= index; n--) {
	    set( n+1, _data[n] );
	}
	_data[index] = newVal;
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
	_data[_lastPos] = 0;
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

	SuperArray mayfield = new SuperArray();
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
