public class Commafier {

    public static void main (String[] args) {
	System.out.println(commafyR(29384293));
	System.out.println(commafyR(1000));
    }

    public static String commafyR (int input) {
	if (input < 999) {
	    return input + "";
	} else {
	    int hundreds = input % 1000;
	    return commafyR(input / 1000) + "," + hundreds; 
	}
    }

}
