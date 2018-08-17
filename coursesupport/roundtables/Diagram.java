package roundtables;

import cse131.ArgsProcessor;

public class Diagram {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		//
		// Let's ask the user about his or her preferences
		//
		boolean wantToDoIt = Math.random() < ap.nextDouble("How badly do you want to do it?");
		boolean endsInDisaster = Math.random() < ap.nextDouble("How likely is disaster?");
		boolean makesGoodStory = Math.random() < ap.nextDouble("Good story in it?");
		
		if (wantToDoIt) {
			System.out.println("Do it, because we want to");
		}
		else {
			if (endsInDisaster) {
				if (makesGoodStory) {
					System.out.println("Do it, disaster imminent, but good story");
				}
				else {
					System.out.println("Don't do it");
				}
			}
			else {
				System.out.println("Do it, what could possibly go wrong?");
			}
		}

	}

}
