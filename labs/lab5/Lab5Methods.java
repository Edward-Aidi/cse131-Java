package lab5;

public class Lab5Methods {
	/**
	 * sumDownBy2
	 * @param an integer n
	 * @return sum of the positive integers n + (n-2) + (n-4) + ...
	 */
	public static int sumDownBy2(int n) {
		if(n <= 0) {
			return 0;
		}
		else {
			int sum = 0;
			while(n > 0) {
				sum = sum + n;
				n = n -2;
			}
			return sum;
		}
	}
	
	/**
	 * harmonicSum
	 * @param a positive integer, n
	 * @return the sum 1 + 1/2 + 1/3 + ... + 1/(n-1) + 1/n
	 */
	
	public static double harmonicSum(int n) {
		if(n <= 0) {
			return 0;
		}
		else {
			double sum = 0.0;
			for(int i = 1; i <= n; i++) {
				sum = sum + 1/(double)i;
			}
			return sum;
		}
	}
	
	/**
	 * geometricSum
	 * @param a non-negative integer, k
	 * @return the sum 1 + 1/2 + 1/4 + 1/8 + ... + 1/Math.pow(2,k)
	 */
	 public static double geometricSum(int k) {
		 if(k < 0) {
				return 0;
			}
			else {
				double sum = 0.0;
				for(int i = 0; i <= k; i++) {
					sum = sum + 1/(double)Math.pow(2,i);
				}
				return sum;
			}
	 }
	 
	 /**
	  * multPos
	  * @param positive integers j and k
	  * @return the product j*k
	  */
	 public static int multPos(int j, int k) {
		 if(j <= 0 || k <= 0) {
			 return 0;
		 }
		 else {
			 int mult = 0;
			 for(int i = 1; i <= k; i++) {
				 mult = mult + j;
			 }
			 return mult;
		 }
	 }
	 
	 /**
	  * mult
	  * @param integers j and k
	  * @return the product j*k
	  */
	 public static int mult(int j, int k) {
		 if(k <= 0 && j <= 0) {
			 return multPos(Math.abs(j), Math.abs(k));
		 }
		 else if((k < 0 && j > 0) || (k > 0 && j < 0)) {
			 return -multPos(Math.abs(k), Math.abs(j));
		 }
		 else {
			 return multPos(j, k);
		 }
	 }
	 
	 // FIXME: CHANGE FOR COMMIT'S SAKE
	 
	 /**
	  * expt
	  * @param integers n and k, where k >= 0
	  * @return the value of n to the power k
	  */
	 public static int expt(int n, int k) {
		 if(k < 0) {
			 return 0;
		 }
		 else {
			 int expt = 1;
			 for(int i = 0; i < k; i++) {
				 expt = mult(expt, n);
			 }
			 return expt;
		 }
	 }
}
