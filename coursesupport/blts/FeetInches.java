package blts;

import cse131.ArgsProcessor;

public class FeetInches {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int originalInches = ap.nextInt("How many inches?");

		int feet = originalInches / 12;
		int inches = originalInches % 12;

		System.out.println("We have:");
		if (feet == 1) {
			System.out.println("  " + feet + " foot");
		}
		else {
			System.out.println("  " + feet + " feet");
		}
		if (inches == 1) {
			System.out.println("  " + inches + " inch");
		}
		else {
			System.out.println("  " + inches + " inches");
		}

	}

}
