package exercises2;

public class Die {

	public static void main(String[] args) {

		//
		// Use the random number generator
		//    (Math.random())
		// so that this program prints out one of
		// the following integers:
		//   1 2 3 4 5 6
		// with equal probability
		//
		int die;
		
		double random = Math.random();
		
		if(random < 1.0/6.0) {
			die = 1;
		}
		else if(random < 2.0 / 6.0){
			die =2;
		}
		else if(random < 3.0/6.0){
			die = 3;
		}
		else if(random < 4.0/6.0){
			die = 4;
		}
		else if(random < 5.0/6.0){
			die = 5;
		}
		else{
			die = 6;
		}
		// Note this program does not prompt the user
		//  for input, it just produces one of the
		//  above integers as output, as if by 
		//  throw of a die
		//
		System.out.println("The die you just rolled turns out to be " + die);
		// System.out.println(random);
	}

}
