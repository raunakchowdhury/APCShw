public class StatsDriver{
    public static void main(String[] args){
	// Test the max methods that take on three params
        System.out.println("Testing max of three params...");
	System.out.println(Stats.max(3,4,5)); //int max
	System.out.println(Stats.max(3.5,7.2,14.9)); // double max

	//Test the geometric means that take on three params
	System.out.println("Testing geometric mean of three params...");
	System.out.println(Stats.geoMean(3,9,27));
	System.out.println(Stats.geoMean(3.0,9.0,27.0)); // double geoMean
	
			   
    }// end main
}// End StatsDriver
