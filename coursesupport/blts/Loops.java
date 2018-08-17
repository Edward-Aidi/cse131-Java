package blts;

public class Loops {

	public static void main(String[] args) {
		// 0 to 9 inclusively
		
		int i = 0;
		while (i <= 9) {
			System.out.print(i +  " ");  // does not skip to a new line
			i = i + 1;
		}
		System.out.println(); // skips to the new line

		// 1 to 10 inclusively
		int j = 1;
		while (j <= 10) {
			System.out.print(j + " ");
			j = j + 1;
		}
		System.out.println();
		
		// 0 to 10, including 0, excluding 10
		int k = 0;
		while (k < 10) {
			System.out.print(k + " ");
			k = k + 1;
		}
		System.out.println();
		
		// like the one above, but jumping by 2
		int m = 0;
		while (m < 10) {
			System.out.print(m + " ");
			m = m + 2;
		}
		System.out.println();
	}

}
