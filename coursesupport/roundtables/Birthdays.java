package roundtables;

import cse131.ArgsProcessor;

public class Birthdays {

	public static void main(String[] args) {
		// Concept:  how many people will enter the room?
		// What arrays do we need to keep track of our data?
		
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How many people entering the room?");
		
		
		int[][] cal = new int[12][31];
		
		for (int i=0; i < N ; ++i) {
			// need to "ask" each person his/her month, date of birth
			int month = (int)(Math.random() * 12);  // between 0 and 11 inclusively
			int date  = (int)(Math.random() * 31);  // between 0 and 30 inclusively
			
			// we record that one more person was born on this month and date
			//
			cal[month][date] = cal[month][date] + 1;
		}
		
		//
		// Now who has the same birthday?
		
		// How many cells have more than person recorded there?
		int numDatesMultBdays = 0;
		int numPeopleSharingBdays = 0;
		for (int m=0; m < 12; ++m) {
			for (int d=0; d < 31; ++d) {
				if (cal[m][d] > 1) {
					numDatesMultBdays = numDatesMultBdays + 1;
					numPeopleSharingBdays = numPeopleSharingBdays + cal[m][d];
				}
			}
		}
		System.out.println("Number of month/date with more than one person born " + numDatesMultBdays);
		System.out.println("Number of people sharing bdays " + numPeopleSharingBdays);
	}

}
