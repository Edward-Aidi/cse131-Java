package exercises5;

public class StringMethods {
	
	//
	// Below are the methods defined for this exercise
	//   The names are not prescribed in the assignment, so choose
	//   names you like (that are meaningful)
	//
	
	//
	// First one is completed for you:
	//
	
	public static String selfConcat(String s) {
		return s + s;
	}
	// A method that takes in a String and an int n, and returns n cpies of the string concatenated together
	public static String ncopy(String s, int n) {
		if(n < 2) {
			return s;
		}
		else{
			String ncopy = s;
			for(int i = 2; i <= n; i++) {
				ncopy = ncopy + s;
			}
			return ncopy;
		}
	}
	
	// rewrite the first one
	public static String re_selfConcat(String s) {
		return ncopy(s, 2);
	}
	
	//that is the inverse of split: it returns a single String with a copy of the joiner string between each part.
	public static String join(String[] array, String joiner) {
		String j = array[0];
		for(int i = 1; i < array.length; i++) {
			j = j + joiner + array[i];
		}
		return j;
	}
	
	// Rewrite your second method in terms of this last one. 
	// To do this, create an array that has n copies of a given String,
	//and then use your join method to concatenate them.
	public static String re_ncopy(String s, int n) {
		if(n < 2) {
			return s;
		}
		else{
			String[] string = new String[n];
			for(int i = 0; i < n; i++) {
				string[i] = s;
			}
			return join(string, "");
		}
	}
	
	//test
	public static void main(String[] args) {
		
		//
		// Testing the methods
		//
		System.out.println(ncopy("echo", 5));
	}

}
