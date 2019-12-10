package StatisticsModels;

public class StatisticsModels {
	
	public static int heartbeatsPerYear = 39420000;
	
	
	public static int smokingBeatsReduced(int cigarettesPerDay, double yearsSmoked) {
		// This calculates how many beats are reduced based on cigarettes smoked per day
		// and how long in years user has
		// smoked. If the user is not a smoker, the beatsReduced is 0. If the user is a
		// smoker, the beats are
		// reduced by 770 per cigarette (11 minutes lost per cigarette * an average of
		// 70 beats per minute) * 365 days/year
		// * yearsSmoked.

		int beatsReduced = 0;

		if (cigarettesPerDay == 0) {
			beatsReduced = 0;
		} else if (cigarettesPerDay > 0) {
			beatsReduced = (int) ((cigarettesPerDay * 770) * (365 * yearsSmoked));
		}

		return beatsReduced;

	}

	public static int alcoholBeatsReduced(String drinksPerWeekCategory) {
		// This method calculates beats reduced over lifetime by drinking categories. 0
		// drinks per week reduces beats by 0.
		// 1-2 drinks per week reduces beats by 19440000 over lifetime, etc.

		int beatsReduced = 0;

		if (drinksPerWeekCategory == "none") {
			beatsReduced = 0;
		} else if (drinksPerWeekCategory != "none") {
			switch (drinksPerWeekCategory) {

			case "low": // 1-2 drinks per day
				beatsReduced = (int) (heartbeatsPerYear * 0.5);
				break;
			case "medium": // 2-3.5 drinks per day
				beatsReduced = (int) (heartbeatsPerYear * 1.5);
				break;
			case "high": // Greater than 3.5 drinks per day
				beatsReduced = (int) (heartbeatsPerYear * 4.5);
				break;
			}
		}

		return beatsReduced;

	}

	public static int educationBeatsReduced(String educationLevelCategory, char gender) { //this needs to be finished

		int beatsReduced = 0;

		if (educationLevelCategory == "bachelors") {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * -2.8);
				break;
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * -1.9);
				break;
			}
		} else if (educationLevelCategory == "noHS") {
			switch (gender) {
			case 'f':
				beatsReduced = 228636000; // needs to be fixed
				break;
			case 'm':
				beatsReduced = 291708000; // needs to be fixed
				break;
			}
		}

		return beatsReduced;

	}

	public static int bmiBeatsReduced(int heightInInches, int weightInPounds, char gender) {

		int beatsReduced = 0;

		double bmi = 703 * (weightInPounds / (heightInInches * heightInInches));

		if (bmi < 18.5) {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * 4.5);
				break;
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * 4.3);
				break;
			}
		} else if (bmi < 25) {
			beatsReduced = 0;
		} else if (bmi < 30) {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * 0.8);
				break;
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * 1.0);
			}
		} else if (bmi >= 30) {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * 3.5);
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * 4.2);
			}
		}

		return beatsReduced;

	}
	
	public static int incomeBeatsLost (int income, char gender) {
		
		int beatsReduced = 0;
		
		if (income <= 25000) {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * 2.7);
				break;
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * 0.7);
				break;
			}
		} else if (income <= 47500) {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * 1.3);
				break;
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * -1.5);
			}
		} else if (income <= 77500) {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * -1.4);
				break;
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * -6.6);
			}
		} else if (income <= 127000) {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * -2.1);
				break;
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * -11.0);
				break;
			}
		} else {
			switch (gender) {
			case 'f':
				beatsReduced = (int) (heartbeatsPerYear * -10.9);
				break;
			case 'm':
				beatsReduced = (int) (heartbeatsPerYear * -12.0);
				break;
			}
		}
				
		return beatsReduced;
		
	}

}
