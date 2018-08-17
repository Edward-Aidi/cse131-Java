package blts;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};
		
		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}
		
		// declare shuffled array, same size as original
//		String[] shuffled = new String[original.length];
		
		// iterate backwards over shuffled array to fill it in
		for (int i=original.length-1; i >= 0; --i) {
			// pick a card from 0...i in the original array
			// c is an integer 0....i
			int c = (int)  (Math.random() * (i+1));
//			shuffled[i] = original[c];
			// move card c to the "end" of the original deck
			// the "end" is actually index i
			//  we can swap original[i] and original[c]
			String t = original[i];
			original[i] = original[c];
			original[c] = t;
			
		}
		
		System.out.println("");
		
		// print out the results
//		for (int i=0; i < shuffled.length; ++i) {
//			System.out.println("Shuffled at " + i + " is " + shuffled[i]);
//		}
		
		for (int i=0; i < original.length; ++i) {
			System.out.println("Now original at " + i + " is " +original[i]);
		}

	}

}
