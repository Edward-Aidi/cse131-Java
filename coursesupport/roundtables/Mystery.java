package roundtables;

public class Mystery {
	
	public static int mys(int n) {
		if (n == 0)
			return 0;
		else {
			// capture answer in a variable
			//   so we can see it under the debugger
			int ans = n - mys(n-1);
			return ans;
		}
	}

	public static void main(String[] args) {
		System.out.println(mys(3));
	}

}
