public class Driver {

    public static void main (String[] args) {
	System.out.println(Stats.mean(3,6));            // 4
	System.out.println(Stats.mean(4.5,7.5));        // 6.0
	System.out.println(Stats.max(2,100));           // 100
	System.out.println(Stats.max(2.111,2.112));     // 2.112
	System.out.println(Stats.geoMean(8,2));         // 4
	System.out.println(Stats.geoMean(2.3,2.7));     // 2.491987...

	System.out.println(Stats.max(3,82,11));         // 82
	System.out.println(Stats.max(70.4,100.0,99.9)); // 100.0
	System.out.println(Stats.geoMean(1,2,3));       // 1.81712...
	System.out.println(Stats.geoMean(1.1,2.2,3.3)); // 1.99883...
    }

}
