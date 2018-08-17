package studio5;

public class Methods {
	
	/**
	 * Implemented correctly
	 * @param x one thing to add
	 * @param y the other thing to add
	 * @return the sum
	 */
	public static int sum(int x, int y) {
		return x+y;
	}
	
	/**
	 * 
	 * @param x one factor
	 * @param y another factor
	 * @return the product of the factors
	 */
	public static int mpy(int x, int y) {
		int mpy = 0;
		for(int i = 0; i < y; i++) {
			mpy = sum(mpy, x); // mpy = mpy + x;
		}
		return mpy;  // FIXME
	}
	
	/**
	 * 
	 * @param x one thing to add
	 * @param y another thing to add
	 * @param z another thing to add
	 * @return the average of the three
	 */
	public static double avg3(int x, int y, int z) {
		return sum(sum(x, y), z) / 3.0; // x + y + z
	}
	
	/**
	 * @param array one declared array
	 * @return the sum
	 */
	public static double sumArray(double[] array) {
		double sumA = 0.0;
		for(int i = 0; i < array.length; i++) {
			sumA = sumA + array[i];
		}
		return sumA;
	}
	
	/**
	 * @param array one declared array
	 * @return average
	 */
	public static double average(double[] array) {
		return sumArray(array) / (double)array.length;
	}
	
	// Your call
	/**
	 * @param num a positive double number 
	 * @param epsilon the precision of sqrt's calculation
	 * @return the sqrt of this number
	 */
	public static double sqrt(double num, double epsilon) {
		if(num < 0) {
			System.out.println("Please enter a number that could be square rooted");
			return 0.0;
		}
		else {
			double t = num / 2.0;
			while(Math.abs(t - num/t) > epsilon * t){
				t = (num/t + t) /2.0;
			}
			return t;
		}
	}
	
	//Pig Latin
	/**
	 * @param String
	 * @return String pig latin
	 */
	
	// string tringsay
	
	public static String pig(String s) {
		String pig;
		pig = s.substring(1);
		return pig + s.substring(0, 1) + "ay";
	}
}
