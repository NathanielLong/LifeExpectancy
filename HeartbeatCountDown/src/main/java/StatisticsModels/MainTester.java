package StatisticsModels;

//This is just a main method class to test some of my Statistical Models -- Tyler
public class MainTester {

	public static void main(String[] args) {

		
		//This is to test if the beats reduced by smoking method from StatisticsModels class works
		
		int totalBeats = StatisticsModels.smokingBeatsReduced(10, 6.0) + StatisticsModels.alcoholBeatsReduced("medium") + 
				StatisticsModels.bmiBeatsReduced(56, 200, 'm') + StatisticsModels.educationBeatsReduced("Bachelors", 'm') +
				StatisticsModels.ethnicityBeatsLost("White") + StatisticsModels.incomeBeatsLost(30000, 'm');
		
		System.out.println(totalBeats);
		
	}

}
