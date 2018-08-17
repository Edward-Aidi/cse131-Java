package lab9.testing;

import java.util.Arrays;
import java.util.Random;

import lab9.Guess;

public class Support {

	public static Guess genRandomGuess() {
		return new Guess(genRandomArray());
	}

	public static int[] genRandomArray() {
		Random r = new Random();
		int len = r.nextInt(1000)+1;
		int[] ans = new int[len];
		for (int i=0; i < len; ++i) {
			ans[i] = r.nextInt(100);
		}
		return ans;
	}
	
	public static int[] dup(int[] in) {
		int[] ans = Arrays.copyOf(in, in.length);
		return ans;
	}
	
	/**
	 * You must use sets, not this method to find unique occurrences
	 * @param array
	 * @return
	 */
	public static int countCommon(int[] array1, int[] array2) {
		int[] counts1 = counts(array1);
		int[] counts2 = counts(array2);
		int ans = 0;
		for (int i=0; i < Math.min(counts1.length, counts2.length); ++i) {
			if (counts1[i] > 0 && counts2[i] > 0)
				++ans;
		}
		return ans;
	}
	
	private static int[] counts(int[] array) {
		int max=array[0];
		for (int i : array) {
			max = Math.max(max, i);
		}
		int[] count = new int[max+1];
		for (int i : array) {
			++count[i];
		}
		return count;
	}

}
