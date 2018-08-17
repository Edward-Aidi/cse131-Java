package lab3;

import cse131.ArgsProcessor;

public class Dice {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int dices = ap.nextInt("How many dice will be used in this simulation?");
		int times = ap.nextInt("How many times will the dice be thrown?");
		
		int[][] simulation = new int[times][dices];
		for (int i = 0; i < times; i++) {
			for(int j = 0; j < dices; j++) {
				int num = (int) (Math.random() * 6 + 1); 
				// if it is not a six-sided dice, then we could prompt for user to type in
				simulation[i][j] = num;
			}
		}
		
		for(int i = 0; i < times; i++) {
			for(int j = 0; j < dices; j++) {
				System.out.print(simulation[i][j] + " ");
			}
			System.out.println();
		}
		// One thing we are interested in is 
		// how often all of the dice show the same value after they are thrown within one of the T iterations.
		int[] count = new int[times];
		int same = 0;
		for(int i = 0; i < times; i++) {
			for(int j = 0; j < dices; j ++) {
				for(int k = 0; k < j; k++) {
					if(simulation[i][k] != simulation[i][k + 1]) {
						count[i] = count[i] + 1;
					}
				}
			}
		}
		for(int i = 0; i < times; i++) {
			if(count[i] == 0) {
				same = same + 1;
			}
		}
		double prob = (double)same / (double)times;
				
		System.out.println();
		System.out.println("After " + dices + " dices were thrown " + times + " times, there are " + same + 
				" times that all of the dices show the same value.\nAnd the probability is " + prob);
		System.out.println();
		
		// We are next are interested in the sum of the dice values for each throw. 
		// Arrange for your program to print out the dice values' sum each time the dice are thrown 
		// and make sure it is working correctly.
		int[] sum = new int[times];
		for(int i = 0; i < times; i++) {
			for(int j = 0; j < dices; j++) {
				sum[i] = sum[i] + simulation[i][j];
			}
		}
		
		// 5 * dices + 1 means the possible sum numbers that would appear
		int[][] seen = new int[5 * dices + 1][2];
		seen[0][0] = dices;
		seen[0][1] = 0;
		for(int i = 1; i < seen.length; i++) {
			seen[i][0] = seen[i-1][0] + 1;
			seen[i][1] = 0;
			}
		
		// making all the counts = 0 and the left side is the possible sum value
		
		for(int i = 0; i < seen.length; i++) {
			for(int j = 0; j < times; j++) {
				if(seen[i][0] == sum[j]) {
				seen[i][1] = seen[i][1] + 1;
				}
			}
		}
		
		// out print the result
		System.out.println("Sum  | Number of times Sum was seen");
		 for(int i = 0; i < seen.length; i++) {
			 while(seen[i][1] != 0) {
			 for(int j = 0; j < seen[i].length; j++) {
					 if(seen[i][j] < 10){
						 System.out.print(seen[i][j] + "    |   ");
					 }
					 else{
						 System.out.print(seen[i][j] + "   |   ");
					 }
			 }
			 System.out.println();
			 i = i + 1;
			 }
		}
	}
}
