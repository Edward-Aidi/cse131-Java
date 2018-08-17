package studio2;

import cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int startAmount = ap.nextInt("The amount of money that you start with?");
		int Amount = startAmount;
		double winChance = ap.nextDouble("The probability that you win a gamble?");
		int winAmount = ap.nextInt("If you reach this amount of money, then you won");
		int totalPlays = ap.nextInt("The number of times you simulate the problem");
		double lossChance = 1.0 - winChance;
		double Ruin = 0;
		int rounds = 0;
		int loss = 0;
		String status;
		
		// Expected Ruin Rate
		if (lossChance != winChance) {
			Ruin = (Math.pow(lossChance / winChance, startAmount) - Math.pow(lossChance / winChance, winAmount)) / (1 - Math.pow(lossChance / winChance, winAmount)); 
		}

		if (lossChance == winChance) {
			Ruin = 1 - startAmount / winAmount;
		}
		////
		
		for(int i = 1; i <= totalPlays; i++) {
			while(Amount > 0 && Amount < winAmount) {
				double chance = Math.random();
				if(chance > winChance) {
					Amount = Amount - 1;
				}
				else {
					Amount = Amount + 1;
				}
				rounds = rounds + 1;
			}
			if(Amount == 0) {
				status = "LOSE";
				loss = loss + 1;
			}
			else {
				status = "WIN";
			}
			System.out.println("Simulation " + i + ": " + rounds + " rounds\t      " + status);
			Amount = startAmount;
			rounds = 0;
		}
		double Actual = (double)loss / (double)totalPlays;
		System.out.println();
		System.out.println("Losses: " + loss + "  Simulations: " + totalPlays + 
				"\nActual Ruin Rate: " + Actual + "  Expected Ruin Rate: " + Ruin);
	}

}
