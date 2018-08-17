package exercises3;

public class CopyArrayAndPigLatin {

	private static final char A = 0;

	public static void main(String[] args) {
		String[] names = { "Alice", "Bob", "Carole", "David", "Elaine" };
		
		// first copy the above array into an array named copy
		//  Pretend the names array is large
		//  So we cannot just do the following (too much to type):
		//     String[] copy = { names[0], names[1], names[2] };
		//
		System.out.println("The copy of the name arrays are as follows");
		String[] copy = new String[names.length];
		for(int i = 0; i < names.length; i++) {
			copy[i] = names[i];
		}
		for(int i = 0; i < names.length; i++) {
			System.out.println(copy[i]);
		}

		// 
		// Follow the instructions on the web page to check
		// that your copy is correct.  Then cause the copy to store the
		// copied strings in "Pig Latin".  Do this by iteration without
		// assuming the length or contents of the names array.
		//
		
		// The following Pig Latin is based on Wiki's description
		// yet the video just shows adding "ay" to the end of the names to create Pig Latin.
		// Just to make this clarification
		System.out.println("\nThe Pig Latin of the name arrays are as follows");
		String[] PigLatin = new String[names.length];
		for(int i = 1; i < names.length; i++) {
			char initial = copy[i].charAt(0);
			if(initial == 'A' || initial == 'E' || initial == 'I' || initial == 'O' || initial == 'U') {
				PigLatin[i] = copy[i] + "ay";
			}
			else {
				copy[i].substring(1);
				PigLatin[i] = copy[i].substring(1) + copy[i].charAt(0) + "a";
			}
			System.out.println(PigLatin[i]);
		}
	}
}
