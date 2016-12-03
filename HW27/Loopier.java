// Ryan Siu
// APCS1 pd5
// HW27 -- Recurse, Recurse, on Elements Not the First!
// 2016-11-3

public class Loopier {

    public static void main (String[] args) {
	int[] arr = {0,1,2,3,4,4};
	
	System.out.println( linSearch(arr,2) ); // 2
	System.out.println( linSearch(arr,6) ); // -1
	System.out.println( linSearchR(arr,2) ); // 2
	System.out.println( linSearchR(arr,6) ); // -1
	System.out.println( linSearchR(arr,4) ); // 4
	System.out.println( freq(arr,4) ); // 2
	System.out.println( freq(arr,6) ); // 0
	System.out.println( freqRec(arr,4) ); // 2
	System.out.println( freqRec(arr,6) ); // 0
	
    }

    public static int linSearch (int[] a, int target) {
	for (int i = 0; i < a.length; i++) {
	    if (a[i] == target) {
		return i;
	    }
	}
	return -1;
    }

    // Doesn't return -1 for when target isn't in a
    /* 
    public static int linSearchR (int[] a, int target) {
        if (a.length == 0) {
	    return -1;
	} else if (a[0] == target) {
	    return 0;
	} else {
	    int[] newA = new int[a.length-1];
	    for (int i = 0; i < newA.length; i++) {
		newA[i] = a[i+1];
	    }
	    return linSearchR(newA, target) + 1;
	}
    }
    */

    public static int linSearchR (int[] a, int target) {
	return linSearchHelp(a, target, 0);
    }

    public static int linSearchHelp (int[] a, int target, int index) {
        if (a.length == index) {
	    return -1;
	} else if (a[index] == target) {
	    return index;
	} else {
	    return linSearchHelp(a, target, index + 1);
	}
    }
    
    public static int freq (int[] a, int target) {
	int ctr = 0;
	for (int i : a) {
	    if (i == target) {
		ctr += 1;
	    }
	}
	return ctr;
		
    }

    public static int freqRec (int[] a, int target) {
	if (a.length == 0) {
	    return 0;
	} else {
	    int[] newA = new int[a.length-1];
	    for (int i = 0; i < newA.length; i++) {
		newA[i] = a[i+1];
	    }
	    if (a[0] == target) {
		return freqRec(newA, target) + 1;
	    } else {
		return freqRec(newA, target);
	    }
	}
    }
    
}
