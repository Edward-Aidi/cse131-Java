package speeding;

import cse131.ArgsProcessor;

public class SpeedLimit {
	public static void main(String[] args) { 
		ArgsProcessor ap = new ArgsProcessor(args);
		int speed = ap.nextInt("What is the speed that you drive?");
		int sc = speed - 60;
		int fine = (sc > 10) ? ((sc - 10) * 10 + 50) : 50;
		System.out.println("You reported a speed of " + speed + " MPH for a speed limit of 60 MPH.\n"+
				"You went " + sc + " MPH over the speed limit.\n" +
				 "Your fine is $" + fine +".");
	}
}
