package blts;

public class RandomAverages {

	public static void main(String[] args) {
		int i=0;
		double sum = 0.0;
		while (i < 1000000) {
			sum = sum + Math.random();
			i = i + 1;    
			// at this point, we have summed i random variables
			// let's reduce the output by only saying something every 100 iterations
			if (i % 100000 == 1)
				System.out.println("As of " + i + ", our  average is " + (sum / i));
		}

	}

}
