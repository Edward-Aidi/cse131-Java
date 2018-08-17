package studio3;

import cse131.ArgsProcessor;

public class Prime {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int n = ap.nextInt("Please enter a number that indicates the number of the primes: ");
		int[] array = new int[n];
		int[] array2 = new int[n];
		for(int i = 0; i < array.length - 2; i++) {
			array[i] = i + 2;
		}
		for(int i = 0; i < array.length - 2; i++) {
			array2[i] = array[i];
		}
		for(int j = 0; j < array.length; j++) {
			for(int k = array2[j]; k < (array.length + 2)/2; k++) {
					for(int i = 0; i < array.length; i++) {
       						if(array[i] == array2[j] * k) {
							array[i] = 0;
						}
					}
			}
		}
		System.out.println("Primes under " + n + " = ");
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				System.out.print(array[i] + "\t");
			}
		}
	}

}
