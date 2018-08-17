package blts;

public class GenRandomData {

	public static void main(String[] args) {
		for (int i=0; i < 1000; ++i) {
			double r = Math.random(); // between 0 and 1, not including 1
			double s = Math.pow(10, (int)(Math.random() * 10)-3);
			System.out.println(r*s);
		}

	}

}
