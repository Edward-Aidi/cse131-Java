package blts;

import cse131.ArgsProcessor;

public class Heads {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How many times should we run the simulation?");
		// sum of all flips required to get 10 heads in each simulation
		int sumNumFlips = 0;
		
		// beginning of my loop
		for (int i=0; i < N; ++i) {

			// what are the concepts?
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

			sumNumFlips = sumNumFlips + numFlips;
			// System.out.println("Number of flips was " + numFlips);
		}
		// end
		
		System.out.println("Average number of flips " + (1.0 * sumNumFlips/N));

	}

}
