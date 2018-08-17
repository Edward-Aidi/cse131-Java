package roundtables;

public class Carrots {
	public static void main(String[] args) {
		
		//
		// Alice has some number of carrots
		//
		int aliceCarrots = 7;
		//
		// Bob has 3 more than Alice
		//
		int bobCarrots = aliceCarrots + 3;
		//
		// Charles has 4 times Alice's carrots...
		//  
		int charlesCarrots = 4 * aliceCarrots;
		//
		// ... and he stole all of Bob's
		//
		charlesCarrots = charlesCarrots + bobCarrots;
		bobCarrots     = 0;
		//
		// Diane has twice as many as Charles
		//
		int dianeCarrots = 2 * charlesCarrots;
		
		System.out.println("Diane has " + dianeCarrots + " carrots");
	}
}
