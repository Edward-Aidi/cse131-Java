package lab2;

import cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {
		// prompt how many sticks user would like to play
		ArgsProcessor ap = new ArgsProcessor(args);
		int sticks = ap.nextInt("How many sticks would you like to play?");
		int remain = 1;
		int round = 0;
		int ctook, htook = 0;
		double random =Math.random();
		
		int who = ap.nextInt("Who would like to start? Enter 1 you start, and 0 computer starts first.");
		if(who == 0) {
			System.out.println("Computer starts");
			while(sticks > 0 && remain != 0) {
				if(sticks > 2 && random > 0.5) {
					ctook = 2;
				}
				else {
					ctook = 1;
				}
				remain = sticks - ctook;
				System.out.println("Round " + round + ", " + sticks 
						+ " sticks at start, computer took " + ctook + ", so " 
						+ remain + " sticks remain");
				round = round + 1;
				if(remain > 0) {
					htook = ap.nextInt("How many sticks would you like to take?");
					while(htook > 2 || htook > remain) {
						System.out.println("Illegal input, the number of sticks you take shall below 2 and below what left.");
						htook = ap.nextInt("How many sticks would you like to take?");
					}
					sticks = remain - htook;
					System.out.println("Round " + round + ", " + remain 
							+ " sticks at start, human took " + htook + ", so " 
							+ sticks + " sticks remain");
					if(sticks == 0) {
						System.out.print("Congrats! You win!");
					}
					round = round + 1;
				}
				else {
					System.out.println("Comupter wins");
				}
		}
		}
			else {
				System.out.println("Human starts");
				while(remain > 0) {
					if(remain > 0 && sticks > 0) {
						htook = ap.nextInt("How many sticks would you like to take?");
						while(htook > 2 || htook > sticks) {
							System.out.println("Illegal input, the number of sticks you take shall below 2 and below what left..");
							htook = ap.nextInt("How many sticks would you like to take?");
						}
						remain = sticks - htook;
						round = round + 1;
						System.out.println("Round " + round + ", " + sticks 
								+ " sticks at start, human took " + htook + ", so " 
								+ remain + " sticks remain");
						if(remain == 0) {
							System.out.print("Congrats! You win!");
						}
						else {
							if(remain > 2 && random > 0.5) {
								ctook = 2;
							}
							else {
								ctook = 1;
							}
							sticks = remain - ctook;
							round = round + 1;
							System.out.println("Round " + round + ", " + remain 
									+ " sticks at start, computer took " + ctook + ", so " 
									+ sticks + " sticks remain");
				
						}
					}
					else {
						System.out.println("Comupter wins");
						remain = sticks;
					}
			}
		}
	}

}
