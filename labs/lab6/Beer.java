package lab6;

public class Beer {
	
	/**
	 * 
	 * @param n input
	 * @return the String of lines
	 */
	public static String bottlesOfBeer(int n) {
		if(n == 1) {
			return "1 bottles of beer on the wall, 1 bottles of beer; "
					+ "you take one down, pass it around, "
					+ "0 bottles of beer on the wall.";
		}
		 return n + " bottles of beer on the wall, "
				+ n + " bottles of beer; you take one down, pass it around, "+ 
				(n-1) +" bottles of beer on the wall.\n" + bottlesOfBeer(n-1);
		
	}	
	
	public static void main(String[] args) {
		System.out.println(bottlesOfBeer(5));
	}

}
