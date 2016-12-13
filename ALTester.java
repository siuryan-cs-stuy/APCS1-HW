import java.util.ArrayList;

public class ALTester {
    
    ArrayList arr;

    public ALTester() {
	arr = new ArrayList();
	for (int i = 0; i < 23; i++) {
	    arr.add(i);
	}
    }

    public boolean sorted() {
	for (int i = 1; i < arr.size(); i++) {
	    if ((int)arr.get(i) < (int)arr.get(i-1)) {
		return false;
	    }
	}
	return true;
    }

    public static void main (String[] args) {
	ALTester a = new ALTester();
	System.out.println();
	System.out.println(a.sorted());
    }

}
