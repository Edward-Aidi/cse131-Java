package studio7;

import cse131.ArgsProcessor;

// When a Die is constructed, it is specified to have n number of sides. 
//Each time the die is thrown, a random integer is returned in the range 1..n, inclusively.

// Die has a 
	public class Die {

		private int side;
		
		public Die(int side) {
			this.side = side;
		}
		
		public int Roll() {
			int rollNum = (int)(Math.random() * this.side);
			return rollNum;
		}


	public static void main(String[] args){
		ArgsProcessor ap = new ArgsProcessor(args);
		int side = ap.nextInt("How many sides?");
		if(Math.random() > 0.5) {
			Die dice1 = new Die(side);
			System.out.println("Fair dice " + dice1.Roll());
		}
		else {
			if(Math.random() > 0.5) {
				System.out.println("Loaded dice 1");
			}
			else {
				Die dice1 = new Die(side);
				int d = 2;
				while(dice1.Roll()==1) {
					d = dice1.Roll();
				}
				System.out.println("Loaded dice " + d);

			}
		}
	}
}