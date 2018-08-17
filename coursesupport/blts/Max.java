package blts;

import cse131.ArgsProcessor;

public class Max {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int x = ap.nextInt("Enter x");
		int y = ap.nextInt("Enter y");
		int max = 0;
		
		if (x > y) {
			max = x;
		}
		else {
			max = y;
		}
		
		
		System.out.println("Max of " + 
		   x + " and " + y + " is " + max);

	}

}
