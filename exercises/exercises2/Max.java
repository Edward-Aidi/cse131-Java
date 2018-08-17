package exercises2;

import cse131.ArgsProcessor;

public class Max {

	public static void main(String[] args) {
		//
		// Below, prompt the user for two ints, x and y
		//
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int x = ap.nextInt("Enter the value x");
		int y = ap.nextInt("Enter the value y");
		
		//
		// Now use what you have learned about conditional
		//   execution to print the larger of the two values.
		//
		
		if(x > y) {
			System.out.println("The max of " + x + " and " + y + " is " + x);
		}
		else if(y > x) {
			System.out.println("The max of " + x + " and " + y + " is " + y);
			}
		else {
			System.out.println("The two numbers you just tpyed in are equal.");
		}
		//
		// Run this program testing on various inputs for
		//    x and y:  some where x < y, some where x > y,
		//              some where x == y

	}

}
