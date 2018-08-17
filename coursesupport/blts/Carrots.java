package blts;

public class Carrots {

	public static void main(String[] args) {
		// Alice has 7 carrots
		
		int aliceCarrots = 7;
		
		// Bob has 3 more than Alice
		
		int bobCarrots = aliceCarrots + 3;
		
		//
		
		int charlesCarrots = 4 * aliceCarrots;
		
		// Charles steals all of Bob's carrots
		
		charlesCarrots = charlesCarrots + bobCarrots;
		bobCarrots     = 0;
		
		// Diane has twice as many as Charles
		
		int dianeCarrots = 2 * charlesCarrots;
		
		System.out.println(dianeCarrots);

	}

}
