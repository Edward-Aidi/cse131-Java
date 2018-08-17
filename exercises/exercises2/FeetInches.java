package exercises2;

import cse131.ArgsProcessor;

public class FeetInches {

	public static void main(String[] args) {
		//
		// Prompt the user for a number of inches
		//
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int input = ap.nextInt("Please type in the number of inches that you could like to convert.");
		
		// Convert that into feet and inches
		//   BUT
		// Be sure to use the singular "foot" or "inch"
		//   where appropriate, as discussed in
		//   the introductory video
		//
		
		int feet = input / 12;
		int inches = input % 12;
		String f, i;
		
		if(feet <= 1) {
			f = "foot";
		}
		else {
			f = "feet";
		}
		
		if(inches <= 1) {
			i = "inch";
		}
		else {
			i = "inches";
		}
		
		System.out.println(input + " inches will produce: " + feet + " " + f + " and "+ inches + " " + i);
		// For example, 61 inches would produce
		//    the output
		//   5 feet and 1 inch
		//

	}

}
