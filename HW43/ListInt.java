/*==================================================
  Interface ListInt
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

public interface ListInt {

    //inserts an item at index
    //shifts existing elements to the right
    void add( int index, int newVal );

    //adds an item after the last item
    void add( int newVal );

    //inserts an item at index
    //shifts existing elements to the right
    void remove( int index );

    //return number of meaningful items in _data
    int size();
    
}
