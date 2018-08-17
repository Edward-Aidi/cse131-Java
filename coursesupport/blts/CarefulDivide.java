package blts;

import cse131.ArgsProcessor;

public class CarefulDivide {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numerator   = ap.nextInt("Enter numerator");
		int denominator = ap.nextInt("Enter denominator");

		// check that we don't divide by 0

		if (denominator == 0) {
			System.out.println("Quotient is undefined");
		}
		else {
			int result = numerator / denominator;

			System.out.println("Quotient is " + result);
		}

	}

}
