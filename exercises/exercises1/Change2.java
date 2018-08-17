package exercises1;

import cse131.ArgsProcessor;

public class Change2 {

	public static void main(String[] args) {
		//
		// Below, prompt the user to enter a number of pennies
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		//
		// Then, compute and print out how many 
		//    dollars, quarters, dimes, nickels, and pennies
		// should be given in exchange for those pennies, so as to
		// minimize the number of coins (see the videos)
		//
		int penn = ap.nextInt("Please enter a number of pennies...");
		int dollars = penn / 100;
		int quarters = (penn - 100 * dollars) / 25;
		int dimes = (penn - 100 * dollars - 25 * quarters) / 10;
		int nikels = (penn - 100 * dollars - 25 * quarters - dimes * 10) / 5;
		int pennies = penn - 100 * dollars - 25 * quarters - dimes * 10 - nikels * 5;
		
		System.out.println("For " + penn + " pennies:\n" +
				dollars + " dollars\n" +
				quarters + " quarters\n" +
				dimes + " dimes\n" +
				nikels + " nickels\n" +
				pennies + " pennies\n");
	}
}
