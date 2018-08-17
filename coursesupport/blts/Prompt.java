package blts;

import cse131.ArgsProcessor;

public class Prompt {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int x = ap.nextInt("Enter x:");
		int y = ap.nextInt("Enter y:");

	}

}
