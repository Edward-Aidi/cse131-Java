package blts;

public class Die {

	public static void main(String[] args) {
		double t = Math.random();  // choose only once
		if (t < 1.0/6.0) {
			System.out.println("1");
		}
		else if (t < 2.0/6.0) {
			System.out.println("2");
		}
		else if (t < 3.0/6.0){  
			System.out.println("3");
		}
		else if (t < 4.0/6.0) {
			System.out.println("4");
		}
		else if (t < 5.0/6.0) {
			System.out.println("5");
		}
		else {
			System.out.println("6");
		}

	}

}
