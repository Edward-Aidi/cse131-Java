package blts;

import cse131.ArgsProcessor;

public class TimesTable {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Max value for table?");
		
		//  Table should include 0...N  --> N+1 rows and columns
		int[][] table = new int[N+1][N+1];
		for (int r=0; r <= N; ++r) { // each row
			for (int c=0; c <= N; ++c) { // each col
				table[r][c] = r * c;
			}
		}
		
		// System.out.println(Arrays.deepToString(table));
		//
		// labels for each column
		System.out.print("     ");
		for (int c=0; c <= N; ++c) {
			System.out.print(c + "  ");
		}
		System.out.println();
		for (int c=0; c <= N+1; ++c) {
			System.out.print("---");
		}
		System.out.println("");
		// produce a table, row by row
		for (int r=0; r <= N; ++r) {
			// label this row
			System.out.print(r + " | ");
			for (int c=0; c <= N; ++c) {
				// print with space to the right
				//   but all on the same line
				int entry = table[r][c];
				if (entry < 10) { // one digit
					System.out.print(" " + table[r][c] + " ");					
				}
				else {
					System.out.print(table[r][c] + " ");
				}
			}
			// end of that row
			System.out.println();
		}

	}

}
