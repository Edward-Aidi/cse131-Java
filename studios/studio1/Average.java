package studio1;

import cse131.ArgsProcessor;

public class Average {

	public static void main(String[] args) {
		// This is a program for calculating the average of two inputs.
		ArgsProcessor ap = new ArgsProcessor(args);
		
		double n1 = ap.nextDouble("I heard that you purchased insurance yesterday. I did as well. How much was that?");
		double n2 = ap.nextDouble("How much do you believe that mine is?");
		System.out.println("Exactly!");
		
		double Average = (n1 + n2) / (double) 2;
		System.out.println("Let me see, the average of our insurances is..." + Average + ".");
	}

}
