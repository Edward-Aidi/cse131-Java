package minesweeper;

import cse131.ArgsProcessor;

public class MineSweeper {

	public static void main (String[] args) {
		
		//
		// Do not change anything between here ...
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int rows = ap.nextInt("How many rows?");
		int cols = ap.nextInt("How many columns?");
		double percent = ap.nextDouble("What is the probability of a bomb?");
		double[][] mine = new double[rows][cols];
		//
		// ... and here
		//
		//  Your code goes below these comments
		//
						
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				mine[i][j] = Math.random();
			}
		}
		boolean[][] mine_b = new boolean[rows][cols]; 
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(mine[i][j] > percent) {
					mine_b[i][j] = false;
				}
				else {
					mine_b[i][j] = true;
				}
			}
		}
		int m = cols;
		int n = rows;
		String[][] minesweeper = new String[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(mine_b[i][j]) {
					minesweeper[i][j] = "*";
				}
				else {
					minesweeper[i][j] = ".";
				}
			}
		}
		// use the int to determine the number of bombs nearby
		int count = 0;
		String c;
		String[][] mine_c = new String[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				// up
				if(!mine_b[i][j]) {
					if(i - 1 > - 1) {
						if(mine_b[i-1][j]) {
							count = count + 1;
						}
					}
					//down
					if(i + 1 < m) {
						if(mine_b[i+1][j]) {
							count = count + 1;
						}
					}
					//left
					if(j - 1 > -1) {
						if(mine_b[i][j-1]) {
							count = count + 1;
						}
					}
					//right
					if(j + 1 < n) {
						if(mine_b[i][j+1]) {
							count = count + 1;
						}
					}
					//upper left
					if(i - 1 > - 1 && j - 1 > -1) {
						if(mine_b[i-1][j-1]) {
							count = count + 1;
						}
					}
					//upper right
					if(i - 1 > - 1 && j + 1 < n) {
						if(mine_b[i-1][j+1]) {
							count = count + 1;
						}
					}
					//down left
					if(i + 1 < m && j - 1 > -1) {
						if(mine_b[i+1][j-1]) {
							count = count + 1;
						}
					}
					//down right
					if(i + 1 < m && j + 1 < n) {
						if(mine_b[i+1][j+1]) {
							count = count + 1;
						}
					}
					c = Integer.toString(count);
					mine_c[i][j] = c;
					count = 0;
				}
				else {
					mine_c[i][j] = "*";
				}
			}
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(minesweeper[i][j] + "  ");
			}
			System.out.print(" \t ");
			for(int j = 0; j < n; j++) {
				System.out.print(mine_c[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
}
