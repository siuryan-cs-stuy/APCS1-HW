public class Driver {

    public static void main (String[] args) {
	System.out.println(Stats.mean(3,6));        // 4
	System.out.println(Stats.mean(4.5,7.5));    // 6.0
	System.out.println(Stats.max(2,100));       // 100
	System.out.println(Stats.max(2.111,2.112)); // 2.112
	System.out.println(Stats.geoMean(8,2));     // 4
	System.out.println(Stats.geoMean(2.3,2.7)); // 2.491987...
    }

}
