package studio6;

public class Methods {

	// Your methods go below this line
	/**
	 * factorial
	 * @param int n
	 * @return int fact(n) = 1*2*3*...*n
	 */
	public static int fact(int n) {
		if(n == 0) {
			return 1;
		}
			return n * fact(n-1);
	}
	
	/**
	 * Fibonacci
	 * @param int n
	 * @return int fib(n) = fib(n-1) + fib(n-2)
	 */
	public static int fib(int n) {
		if(n <= 1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	/**
	 * isOdd
	 * @param int n
	 * @return boolean true/false whether n is odd
	 */
	public static boolean isOdd(int n) {
		if(n == 0) {
			return false;
		}
		return !isOdd(n-1);
	}
	
	/**
	 * sum
	 * @param int a, b
	 * @return int sum
	 */
	public static int sum(int a, int b) {
		if(b == 0) {
			return a;
		}
		return sum(a+1, b-1);
	}
	
	/**
	 * factorial
	 * @param int n
	 * @return int fact(n) = n*(n-1)*(n-2)*...*1
	 */
//	public static int fact(int n) {
//		if(n == 0) {
//			return 1;
//		}
//		return n * fact(n-1);
//	}
	
	/**
	 * sumDownBy2
	 * @param int n
	 * @return int n + (n-2) + (n-4) +...
	 */
	public static int sumDownBy2(int n) {
		if(n <= 1) {
			return n;
		}
		return n + sumDownBy2(n-2);
	}
	
	/**
	 * harmonicSum
	 * @param int n
	 * @return double 1 + 1/2 + 1/3 +...+ 1/(n-1) + 1/n
	 */
	public static double harmonicSum(int n) {
		if(n == 1) {
			return 1;
		}
		return  1/(double)n + harmonicSum(n-1);
	}
	
	/**
	 * mult
	 * @param int a,b
	 * @return int a*b
	 */
	public static int mult(int a, int b) {
		if(b == 0) {
			return 0;
		}
		return a + mult(a, b-1);
	}
}
