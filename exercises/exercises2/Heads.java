package exercises2;

import cse131.ArgsProcessor;

public class Heads {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		double average;
		double sum = 0;
		int N = ap.nextInt("Please enter the times of meeting 10 heads flip.");
		// what are the concepts?
		for(int i = 1; i <= N; i++) {
		int numHeads = 0;
		int numFlips = 0;
		// now flip a coin until we see 10 heads
		while (numHeads != 10) {
			boolean isHeads = Math.random() < 0.5;
			if (isHeads) {
				numHeads = numHeads + 1;
			}
			numFlips = numFlips + 1;
		}
		// here, numHeads should be 10
		sum = sum + numFlips;
		}
		average = sum / (double)N;
		System.out.println("With the experiment running "+ N + " times, " + "the average number of coin flips required to achieve 10 heads is " + average + ".");
	}
}