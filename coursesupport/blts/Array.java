package blts;

public class Array {

	public static void main(String[] args) {
		String[] names = { "Alice", "Bob", "Carole", "David", "Elaine" };
		
		// now copy this array into an array named copy
		//  Pretend names array is large
		//  So we cannot just do the following (too much to type):
		// String[] copy = { names[0], names[1], names[2] };
		
		// make the copy array empty initially (filled with null) 
		String[] copy = new String[names.length];
		
		// now iterate to fill the array with the contents of names
		for (int i=0; i < names.length; ++i) {
			//  append "ay" to each element copied over
			copy[i] = names[i] + "ay";
			System.out.println("Looking at 0th element of copy " + copy[0]);
		}
//		// did it work?
//		// Let's look at the first array, names
//		for (int i=0; i < names.length; ++i) {
//			System.out.println("Original array names " + names[i]);
//			System.out.println("Copy name is         " + copy[i]);
//		}
//		
//		// shorthand way to interate over the contents
//		//  of an array
//		
//		for (String s : copy) {
//			System.out.println(" copy is " + s);
//		}

	}

}
