package blts;

import sedgewick.StdIn;
import cse131.ArgsProcessor;

public class Stats {

	public static void main(String[] args) {
		// prompt the user for the file to be used for this run
		ArgsProcessor.useStdInput("datafiles/average");
		while (!StdIn.isEmpty()) {
			double d = StdIn.readDouble();
			System.out.println("We saw double " + d);
		}

	}

}
