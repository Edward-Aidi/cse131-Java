package watermelons;

import java.util.Arrays;

public class Watermelons {
	
	/**
	 * Computes the sum of each distinct pair of entries in the incoming array.
	 * A given pair of entries has its sum computed only once.  So if you
	 * compute the sum for entries 2 and 4, and that sum appears in your answer
	 * array, then you do not also compute the sum of entries 4 and 2.
	 * Depending on the input, the same sum value may appear multiple times in the result.
	 * For example, if all of the incoming values are 0, then so are all of the returned values.
	 * @param nums an array of integers, possibly containing duplicates
	 * @return an array containing the sums of pairs as described above
	 */
	private static int factorial(int n) {
		return (n>1)? n*factorial(n-1):1;
	}
	
	public static int[] allPairSums(int[] nums) {
		int c = factorial(nums.length)/(factorial(nums.length - 2)*2);
		int[] ans = new int[c];  // FIXME compute ans as the result you want
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			for(int j = i+1; j < nums.length; j++) {
				ans[k] = nums[i] + nums[j];
				k++;
			}
		}
		return ans;
	}
	
	/**
	 * The method below must COMPUTE and return a solution as described
	 * on the web page for this extension.  
	 * 
	 * You must compute the solution by trying
	 * lots of possibilities, and finding the one that yields the right answer.
	 * 
	 * You can run the provided unit test to see if you are right.
	 * @param pairSums is array of watermelon pairwise sums.  In other words,
	 *    each element of pairSums represents the sum of one pair of watermelons in our puzzle.
	 * @return
	 */
	public static int[] getSolution(int[] pairSums) {
		//ordering the Watermelon by weight
		Arrays.sort(pairSums);
		int[] nums = new int[5];
		int[] ans = new int[10];
		int count = 0;
		// sum of all the watermelon weight
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum = sum + pairSums[i];
		}
		sum = sum / 4;
				
		nums[2] = sum - pairSums[0] - pairSums[9];
		
		// if there are only 5 watermelons to be weighed, the middle one must be the total sum minus the heavier two and light two
		// also, we could know that nums[1] = pairSums[0] -nums[0] and nums[nums.length] = pairSums[pairSums.length] - nums[nums.length -1]
		
		boolean[] test = new boolean[10];
		int[] nnums = new int[5];
		
		for(int i = 1; i < pairSums[0]; i++) {
			nums[0] = i;
			nums[1] = pairSums[0] - i;
			for(int j = nums[2]; j < pairSums[9]; j++) {
				nums[3] = pairSums[9] - j;
				nums[4] = j;
				ans[0] = nums[0] + nums[1];
				ans[1] = nums[0] + nums[2];
				ans[2] = nums[0] + nums[3];
				ans[3] = nums[0] + nums[4];
				ans[4] = nums[1] + nums[2];
				ans[5] = nums[1] + nums[3];
				ans[6] = nums[1] + nums[4];
				ans[7] = nums[2] + nums[3];
				ans[8] = nums[2] + nums[4];
				ans[9] = nums[3] + nums[4];

				// make judgements
				
				for(int c = 0; c < pairSums.length; c++) {
					test[c] = false;
				}
				
				for(int a = 0; a < pairSums.length; a++) {
					if(!test[a] && ans[a] == pairSums[a]) {
							test[a] = true;
					}
					for(int b1 = 0; b1 < test.length; b1++) {
						if(!test[b1]) {
							count++;
						}
					if(count == 0) {
						for(int l=0; l < nums.length; l++) {
							nnums[l] = nums[l];
						}
					}
					}
				}
				
			}
		}
		return nnums;
	}

	/**
	 * Compare two arrays for equality.  They must first be
	 * sorted, so that Arrays.equals can do its thing element
	 * by element, as is it wants.
	 * 
	 * However, what if the caller doesn't want the arrays to
	 * be disturbed?  We therefore clone the arrays (copies are
	 * made of them) before we do the compare, and we compare the
	 * clones.
	 * @param one: an array, not mutated
	 * @param two: another array, not mutated
	 * @return true iff the arrays' contents are the same
	 */
	public static boolean sameIntArrays(int[] one, int[] two) {
		int[] cone = (int[]) one.clone();
		int[] ctwo = (int[]) two.clone();
		Arrays.sort(cone);
		Arrays.sort(ctwo);
		return Arrays.equals(cone, ctwo);
	}


}
