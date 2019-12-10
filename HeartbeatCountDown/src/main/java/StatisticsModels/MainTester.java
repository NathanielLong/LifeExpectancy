package StatisticsModels;

//This is just a main method class to test some of my Statistical Models -- Tyler
public class MainTester {

	public static void main(String[] args) {

		
		//This is to test if the beats reduced by smoking method from StatisticsModels class works
		int cigsPerDay = 10;
		double yearsSmoked = 6;
		System.out.println(StatisticsModels.smokingBeatsReduced(cigsPerDay, yearsSmoked));
		
		System.out.println(StatisticsModels.bmiBeatsReduced(68, 200, 'm'));
	}

}
