package exercises1;

import cse131.ArgsProcessor;

public class Change {

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
		int pennremain = penn % 100;
		
		int quarters = pennremain / 25;
		pennremain = pennremain % 25;
				System.out.println(pennremain);
		
		int dimes = pennremain / 10;
		pennremain = pennremain % 10;
				System.out.println(pennremain);			
				
		int nikels = pennremain / 5;
		pennremain = pennremain % 5;
				System.out.println(pennremain);
				
		int pennies = pennremain;
		
		System.out.println("For " + penn + " pennies:\n" +
				dollars + " dollars\n" +
				quarters + " quarters\n" +
				dimes + " dimes\n" +
				nikels + " nickels\n" +
				pennies + " pennies\n");
	}
}
