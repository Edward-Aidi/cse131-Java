package blts;

import sedgewick.StdDraw;

public class KeyboardDemo {

	public static void main(String[] args) {
		//
		// did the user type key?
		//
		// while there is no key typed, do nothing
		while (!StdDraw.hasNextKeyTyped()) {
			// wait, do nothing
			// but don't spin tightly, pause
			StdDraw.pause(100);
		}
		
		char got = StdDraw.nextKeyTyped();
		if (got == 'y') {
			System.out.println("Yes");
		}
		else if (got == 'n'){
			System.out.println("No");
		}
		else {
			System.out.println("What?");
		}
	}

}
