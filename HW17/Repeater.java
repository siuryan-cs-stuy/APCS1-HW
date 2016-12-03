// Ryan Siu
// APCS1 pd5
// HW17 -- Do I repeat myself? Very well, then I repeat myself
// 2016-10-14

public class Repeater {

    // Prints test cases
    public static void main (String[] args) {
	System.out.println( fenceW(1) );
	System.out.println( fenceW(0) );
	System.out.println( fenceW(10) );
	System.out.println( fenceR(1) );
	System.out.println( fenceR(0) );
	System.out.println( fenceR(10) );
    }

    // Takes a non-negative integer
    // Returns String representation of a fence with specified number of posts
    // Uses while loop
    public static String fenceW (int posts) {
	String fence = "";
	int lenFence = 0;
	while (lenFence < posts) {
	    fence += "|--";
	    lenFence += 1;
	}
	if (posts != 0) {
	    // substring to get rid of the extra bars
	    fence = fence.substring(0, posts*3-2);
	}
	return fence;
    }

    // Takes a non-negative integer
    // Returns String representation of a fence with specified number of posts
    // Uses recursion
    public static String fenceR (int posts) {
	if (posts == 1) {
	    return "|";
	} else if (posts == 0) {
	    return "";
	}
	return fenceR(posts - 1) + "--|";
    }

}
