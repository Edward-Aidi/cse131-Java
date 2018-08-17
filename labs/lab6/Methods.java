package lab6;

public class Methods {
	
	//
	// In this class, implement the f and g functions described on the lab page
	//

	/**
	 * f function
	 * @param args int x
	 * @return int f recursive function
	 *        	f(x) =    x-10     if x > 100
	               	 = f(f(x+11))  if x <= 100
	 */
	public static int f(int x) {
		if(x > 100) {
			return x-10;
		}
		return f(f(x+11));
	}
	
	/**
	 * g function
	 * @param int x, y
	 * @return int g recursive function
	 *  			g(x,y)  = y+1               if x = 0
          				= g(x-1,1)          if x > 0 and y = 0
          				= g(x-1, g(x, y-1)) if x > 0 and y > 0
	 */
	public static int g(int x, int y) {
		if(x == 0) {
			return y+1;
		}
		if(x > 0 && y == 0) {
			return g(x-1, 1);
		}
			return g(x-1, g(x, y-1));
	}
	
	public static void main(String[] args) {
		
		//
		// from here, call f or g with the appropriate parameters
		//
		System.out.println("f(99) = " + f(99));
		System.out.println("f(87) = " + f(87));
		// f(x) would return 91 for all the x <= 100
		//  		would return x-10 for all the x > 100
		
		System.out.println();
		System.out.println("g(1,0) = " + g(1, 0));
		System.out.println("g(1,2) = " + g(1, 2));
		System.out.println("g(2,2) = " + g(2, 2));
		System.out.println("g(1,1) = " + g(1, 1));
		System.out.println("g(1,3) = " + g(1, 3));
		System.out.println("g(2,3) = " + g(2, 3));
		System.out.println("g(2,4) = " + g(2, 4));
//		System.out.println("g(4,2) = " + g(4, 2));
		// g(x) would return y + 1 for all the x == 0
		//		
		//  		would return stack overflow for all the x >= 4
	}

}
