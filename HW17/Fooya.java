public class Fooya {

    public static boolean booya (int a) {
	a=4;
	return true;
    }

    public static int hooya () {
	int a = 1;
	int b = 2;
	int c = 3;
	if (a == 1 || booya(1)) { return c; }
	else if (b == 1 || booya(1)) { return b; }
	return 3;
    }

    public static void fooya () {
	int a = 42;
	System.out.println( hooya() );
    }

    public static void main (String[] args) {
	fooya();
    }

}
