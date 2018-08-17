package blts;

import cse131.ArgsProcessor;

public class BadSwap {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int x = ap.nextInt("Enter x");
		int y = ap.nextInt("Enter y");
		
		// bad swap!
		
		if (x > y) {
			int t = y;   // save the value of y
			System.out.println("before clobber " + y);
			y = x;   // this assignment clobbers y
			System.out.println("after clobber " + y);
			x = t;
		}
		
		System.out.println("x and y are now "
				+ x + " and " + y);
		
	}

}
