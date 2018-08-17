package exercises2;

import cse131.ArgsProcessor;

public class CarefulDivide {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numerator   = ap.nextInt("Enter numerator");
		int denominator = ap.nextInt("Enter denominator");

		// Compute numerator / denominator
		//  as an int result
		// BUT if the division has the denominator
		//   as zero, print some error message
		//   instead of the quotient
		// Otherwise, print the quotient
		//
		int quotient;
		
		if(denominator == 0) {
			System.out.println("Sorry, denominator could not be zero, please type in another one.");
			denominator = ap.nextInt("Enter denominator");
			quotient = numerator / denominator;
		}
		else {
			quotient = numerator / denominator;
		}
		System.out.println("If " + numerator + " and " + denominator + 
				" being the numerator and denominator. Then the quotient is " + quotient);
	}

}
