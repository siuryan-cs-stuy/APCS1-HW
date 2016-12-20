// Ryan Siu
// APCS1 pd5
// HW49 -- Dat Bubbly Tho
// 2016-12-20

/*======================================
  class BubbleSort -- implements bubblesort algorithm (vanilla version)

                      ..------..                          
               /~~-.-~__-'`-__  ~-.  .-~-.                
              |   /~~~\     / ~~---\|     |               
              |  ||| * |   | | |  * |     |               
              /_-|\ \ /     \ \ \__.|\.  |                
              ~   \~~   |_|   ~~~~ /   ~-.\               
                   ~-.._      _.-~~                       
                     .--~~~~~~--.                         
                    |  |______|  |                        
                     ~-|______|-~                         
                       |      |                           
                       |______|                           
                       |  |   |                           
                       |__|___|                           
                       |_|| _||                        
                       `--'`--'                           
  ======================================*/

import java.util.ArrayList;

public class BubbleSort 
{

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
	//setup for traversal fr right to left
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
    public static void bubbleSortV( ArrayList<Comparable> data ) 
    {
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


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> data = new ArrayList<Comparable>();
	for (Comparable c : input) {
	    data.add(c);
	}
        for (int i = 0; i < data.size()-1; i++) {
	    for (int j = data.size()-1; j > 0; j--) {
		if (data.get(j).compareTo( data.get(j-1) ) < 0) {
		    Comparable temp = data.get(j);
		    data.set(j, data.get(j-1));
		    data.set(j-1, temp);
		}
	    }
	}
	return data;
    }//end bubbleSort


    public static void main(String [] args)
    {
	
	  ArrayList glen1 = new ArrayList<Integer>();
	  glen1.add(7);
	  glen1.add(1);
	  glen1.add(5);
	  glen1.add(12);
	  glen1.add(3);
	  System.out.println( "ArrayList glen1 before sorting:\n" + glen1 );
	  bubbleSortV(glen1);
	  System.out.println( "ArrayList glen1 after sorting:\n" + glen1 );

	  ArrayList coco1 = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco1 before sorting:\n" + coco1 );
	  bubbleSortV(coco1);
	  System.out.println( "ArrayList coco1 after sorting:\n" + coco1 );
	
	
	  ArrayList glen2 = new ArrayList<Integer>();
	  glen2.add(7);
	  glen2.add(1);
	  glen2.add(5);
	  glen2.add(12);
	  glen2.add(3);
	  System.out.println( "ArrayList glen2 before sorting:\n" + glen2 );
	  ArrayList glen2Sorted = bubbleSort( glen2 );
	  System.out.println( "sorted version of ArrayList glen2:\n" 
	  + glen2Sorted );
	  System.out.println( "ArrayList glen2 after sorting:\n" + glen2 );

	  ArrayList coco2 = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco2 before sorting:\n" + coco2 );
	  ArrayList coco2Sorted = bubbleSort( coco2 );
	  System.out.println( "sorted version of ArrayList coco2:\n" 
	  + coco2Sorted );
	  System.out.println( "ArrayList coco2 after sorting:\n" + coco2 );
	  System.out.println( coco2 );

    }//end main

}//end class BubbleSort



/***
Bulbasaur by Maija Haavisto
                                           /
                        _,.------....___,.' ',.-.
                     ,-'          _,.--"        |
                   ,'         _.-'              .
                  /   ,     ,'                   `
                 .   /     /                     ``.
                 |  |     .                       \.\
       ____      |___._.  |       __               \ `.
     .'    `---""       ``"-.--"'`  \               .  \
    .  ,            __               `              |   .
    `,'         ,-"'  .               \             |    L
   ,'          '    _.'                -._          /    |
  ,`-.    ,".   `--'                      >.      ,'     |
 . .'\'   `-'       __    ,  ,-.         /  `.__.-      ,'
 ||:, .           ,'  ;  /  / \ `        `.    .      .'/
 j|:D  \          `--'  ' ,'_  . .         `.__, \   , /
/ L:_  |                 .  "' :_;                `.'.'
.    ""'                  """""'                    V
 `.                                 .    `.   _,..  `
   `,_   .    .                _,-'/    .. `,'   __  `
    ) \`._        ___....----"'  ,'   .'  \ |   '  \  .
   /   `. "`-.--"'         _,' ,'     `---' |    `./  |
  .   _  `""'--.._____..--"   ,             '         |
  | ." `. `-.                /-.           /          ,
  | `._.'    `,_            ;  /         ,'          .
 .'          /| `-.        . ,'         ,           ,
 '-.__ __ _,','    '`-..___;-...__   ,.'\ ____.___.'
 `"^--'..'   '-`-^-'"--    `-^-'`.''"""""`.,^.`.--' mh

***/
