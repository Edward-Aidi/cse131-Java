package studio2;

import cse131.ArgsProcessor;

public class Pi {

	public static void main(String[] args) {
		// generate two random variables as the dart's coordination x & y
		// if x^2 + y ^2 <= 1^2, then this dart is located in this 1/4 circle and we could calculate Pi
		double x = 0.0;
		double y = 0.0;
		int circle = 0;
		double p = 0.0;
		ArgsProcessor ap = new ArgsProcessor(args);
		int throwtimes = ap.nextInt("How many darts that you could like to throw?");
		for(int i = 1; i <= throwtimes; i++) {
			x = Math.random();
			y = Math.random();
			if(Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
				circle = circle +1;
			}
		}
		p = (double)circle / (double)throwtimes * 4.0;
		System.out.println("Through this circle function technique, after " + throwtimes + 
				" of throwing, we computing Pi is approximately equal to " + p);
	}
}
