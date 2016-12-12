/*==================================================
  Interface List
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

public interface List {


    // adds an item after the last item
    boolean add( Object x );

    // returns the element at the specified index
    Object get( int index );

    // replaces the element at the specified index 
    // with the specified Object
    Object set( int index, Object o );

    // return number of meaningful items in _data
    int size();
    
}
