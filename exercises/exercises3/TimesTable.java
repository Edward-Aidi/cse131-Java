package exercises3;

import cse131.ArgsProcessor;

public class TimesTable {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Max value for table?");
		
		//  Table should include rows and columns for 0...N  
		//     making N+1 rows and columns
		int[][] times = new int[N + 1][N + 1];
		for(int i = 0; i <= N; i++) { // each row
			for(int j = 0; j <= N; j++) { // each column
					times[i][j] = i * j;
				}
		}
		//produce labels
		System.out.print("     ");
		for(int i = 0; i <= N; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();
		for(int i = 0; i <= N+1; i++) {
			System.out.print("---");
		}
		System.out.println();
		
		for(int i = 0; i <= N; i++) {
			System.out.print(i + " | ");
			for(int j = 0; j <= N; j++) {
				// capture one digit entry and to make it two
				int entry = times[i][j];
				if(entry < 10) {
					System.out.print(" " + times[i][j] + " ");
				}
				else {
					System.out.print(times[i][j] + " ");
				}
			}
			//end of each row, switch to the second row
			System.out.println();
		}
	}

}
