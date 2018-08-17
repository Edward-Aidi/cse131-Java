package exercises4;

import sedgewick.StdIn;
import cse131.ArgsProcessor;

public class Stats {

	public static void main(String[] args) {
		// prompt the user for the file to be used for this run
		ArgsProcessor.useStdInput("datafiles/average");

		//
		//  Read in the data from the opened file, computing the
		//     sum, average, count, max, and min
		//  of the data
		//
		int count = 0;
		double sum = 0, max = 0, min = 0, average = 0;
		while(!StdIn.isEmpty()) {
			double d = StdIn.readDouble();
			count = count + 1;
			sum = sum + d;
			max = min = d;
			if(d > max) {
				max = d;
			}
			else {
				min = d;
			}
		}
		average = sum / (double)count;
		sum = Math.round(sum * 100) /100;
		average = Math.round(average * 100)/100;
		//  count is the number of doubles read from the file
		//  The other statistics should be clear from their names
		//
		System.out.println("We read "+ count + " numbers, and the statistics of these numbers are as follows:");
		System.out.println("sum\taveage\tcount\tmax\tmin");
		System.out.println(sum + "\t" + average + "\t" + count + "\t" + max + "\t" + min);
	}

}
