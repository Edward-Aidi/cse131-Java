package exercises3;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};

		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}

		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		
		String[] Shuffled = new String[original.length];
		for (int i = 0; i < original.length; i++) {
			Shuffled[i] = original[i];
		}
		
		for(int i = Shuffled.length - 1; i >= 0; --i) {
			int o = (int) ((i + 1) * Math.random());
			Shuffled[i] = original[o];
					for(int j = o; j < Shuffled.length - 1; j++) {
						original[j] = original[j + 1];
					}
		
	}
		for (String s: Shuffled) {
			System.out.println("Using method 1-putting cards, Shuffled cards are " + s);
		}

		//String[] Shuffled2 = new String[original.length];

		System.out.println();
		
		String[] Shuffled2 = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};
		
		for (int i = original.length - 1; i >= 0; i--) {
			// random does not include 1
			int k = (int) ((i + 1) * Math.random());
			
			String swap = Shuffled2[i];
			Shuffled2[i] = Shuffled2[k];
			Shuffled2[k] = swap;
		}
		for (String s: Shuffled2) {
			System.out.println("Using method 2-swap, Shuffled cards are " + s);
		}
		
	}
}