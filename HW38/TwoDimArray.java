// Ryan Siu
// APCS1 pd5
// HW38 -- Arrays of Arrays
// 2016-12-01

public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) 
    { 
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < a[i].length; j++) {
		System.out.print(a[i][j]);
	    }
	    System.out.println();
	}
    }


    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) 
    { 
        for (int[] row : a) {
	    for (int cell : row) {
		System.out.print(cell);
	    }
	    System.out.println();
	}
    }


    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a )
    {
	int sum = 0;
        for (int[] row : a) {
	    for (int cell : row) {
	        sum += cell;
	    }
	}
	return sum;
    }


    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) 
    {
	int sum = 0;
        for (int i = 0; i < m.length; i++) {
	    sum += sumRow2( i, m );
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) 
    {
	int sum = 0;
        for (int i = 0; i < a[r].length; i++) {
	    sum += a[r][i];
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m ) 
    { 
        int sum = 0;
	for (int cell : m[r]) {
	    sum += cell;
	}
	return sum;
    }


    //postcond: returns sum of all items in column c of 2D integer array 
    public static int sumCol( int c, int[][] m ) 
    {
	int sum = 0;
        for (int[] row : m) {
	    try {
		sum += row[c];
	    }
	    catch (Exception e) { }
	}
	return sum;
    }


    public static void main( String [] args ) 
    {
	
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	print1(m1);
	print1(m2);
	print1(m3);
	print2(m1);
	print2(m2);
	print2(m3);
	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1)); // 0
	System.out.println("sum m2 : " + sum1(m2)); // 27
	System.out.println("sum m3 : " + sum1(m3)); // 21
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));
	System.out.println("testing sumCol...\n");
	System.out.println("sum c0 of m1 : " + sumCol(0,m1)); // 0
	System.out.println("sum c1 of m2 : " + sumCol(1,m2)); // 9
	System.out.println("sum c2 of m3 : " + sumCol(2,m3)); // 5
    }

}//end class TwoDimArray
