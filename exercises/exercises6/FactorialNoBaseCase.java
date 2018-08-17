package exercises6;

public class FactorialNoBaseCase {
	
	public static int factorial(int n) {
		return n * factorial(n-1);
	}

	public static void main(String[] args) {
		int ans = factorial(2);
		System.out.println("Answer is " + ans);
	}
}

// von Leeuwenhoek's speculation may be wrong because it could not tell where this woman (base) comes from.


// we could see that the codes encounter overstack problem because we did not initiate the first recursion value return
// so this return n*factorial(n-1) would continuously go on forever until it meets the limit of the stack. And the program would stop.