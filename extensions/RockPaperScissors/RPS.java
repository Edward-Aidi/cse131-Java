package RockPaperScissors;

import cse131.ArgsProcessor;

public class RPS {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How many rounds of RPS that you would like to play?");
		int R = 0;
		int P = 1;
		int S = 2;
		int cw = 0;
		int hw = 0;

		for(int i = 0; i < N; i++) {
			int real = (int) Math.floor(Math.random() * 3);
			// System.out.println(real);
			int H = ap.nextInt("What is your move? R = 0, P = 1, S = 2");
			while((H != 0) && (H != 1) && (H != 2)) {
					H = ap.nextInt("Invalid input! Please input another number. What is your move? R = 0, P = 1, S = 2");
			}
				if(real == H) {
					System.out.println("Tie!");
				}
				else if((real == 0 && H == 1) || (real == 1 && H == 2) || (real == 2 && H == 0)) {
					System.out.println("Computer wins!");
					cw = cw + 1;
				}
				else {
					System.out.println("You win!");
					hw = hw + 1;
				}
		}
		String who;
		if(hw > cw) {
			who = "HUMAN";
		}
		else if(hw < cw) {
			who = "COMPUTER";
		}
		else {
			who = "NOBODY";
		}
		System.out.println();
		System.out.println("After "+ N + " rounds of playing RPS,"
				+ "\nComputer wins " + cw + " rounds, and You win " + hw + " rounds."
						+ "\nSo, " + who + " wins.");
		
		
	}

}
