package roundtables;

public class Mpy {

	public static void main(String[] args) {
		int a = 3;
		int b = 8;
		
		int ans = 0;
		for (int i=0; i < a; ++i) {
			ans = ans + b;
		}
		
		System.out.println(ans);
	}

}
