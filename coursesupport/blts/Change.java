package blts;

import cse131.ArgsProcessor;

public class Change {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);  // as usual
		int initialPennies = ap.nextInt("How many pennies?");
		
		int d = initialPennies / 100;  
		int penniesLeftAfterDollars = initialPennies % 100;  // one way
		
		System.out.println("You have " + d + " dollars");
		System.out.println("Pennies left " + penniesLeftAfterDollars);

		// quarters in the change
		int q = penniesLeftAfterDollars / 25;
		System.out.println("  and "+  q + " quarters");
		
		int afterQuartersChange = penniesLeftAfterDollars % 25;
		
		
		int dimes = afterQuartersChange / 10;
		int afterDimesChange = afterQuartersChange % 10;
		
		System.out.println("  and " + dimes + " dimes");
		System.out.println(" change is now " + afterDimesChange);
		
		int n = afterDimesChange / 5;
		int p = afterDimesChange % 5;
		System.out.println("  and " + n + " nickels");
		System.out.println("  and " + p + " pennies");
		
		int check = 100 * d + 25 * q + 10 * dimes + 5 * n + p;
		System.out.println("check is " + check);
	}

}
