package exercises4;

import cse131.ArgsProcessor;

public class Pitches {

	public static void main(String[] args) {
		// encoding has 0 as concert A
		//    1 would be Bb, just above A
		//   -1 would be Ab, just below A
		ArgsProcessor ap = new ArgsProcessor(args);
		double freq = 0;
		double freq2 = 0;
		double freq_7 = 0;
		double freq2_7 = 0;
		double ratio;
		double ratio2;
		String[] pitch = {"A", "Bb", "B", "C", "Db", "D", "E", "Fb", "F", "Gb", "G", "Ab"};
		
		int key = ap.nextInt("Please enter an interger to represent a pitch, 0 is A");
		int key2 = ap.nextInt("Please enter another interger to represent a pitch, 0 is A");

		freq = 440 * Math.pow(2, (double)key / 12.0);
		freq_7 = freq * Math.pow(2, 7.0 / 12.0);
		ratio = freq_7 / freq;
		
		int i = 0;
		if(key > 0) {
			i = key % 12;
		}
		else if(key < 0){
			i = (12 + key) % 12;
		}
		else {
			i = 0;
		}
		
		// second key
		
		freq2 = 440 * Math.pow(2, (double)key2 / 12.0);
		freq2_7 = freq2 * Math.pow(2, 7.0 / 12.0);
		ratio2 = freq2_7 / freq2;
		
		int j = 0;
		if(key2 > 0) {
			j = key2 % 12;
		}
		else if(key2 < 0){
			j = (12 + key2) % 12;
		}
		else {
			j = 0;
		}
		
		System.out.println("You are looking for " + pitch[i] + " and " + pitch[j] + ", " + " and its frequency is " + freq + " and " + freq2 +
				".\nThe frequency of a pitch 7 chromatic steps higher is " + freq_7 + " and " + freq2_7 +
				",\nand the ratio of the two frequencies is " + ratio + " and " + ratio2);

	}

}
