package homeowning;

import cse131.ArgsProcessor;

public class HomeOwning {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor (args);
		String aName = ap.nextString("Your apartment complex name?");
		String zCode = ap.nextString("Your zip code?");
		int rent = ap.nextInt("Your monthly rent of the apartment?");
		double interest = ap.nextDouble("Daily interest payment for your mortgage on the house?");
	
		System.out.println("Name             " + aName + "     \n"+
							"Zip Code         " + zCode + "     \n"+
							"Monthly Rent     " + rent + "     \n"+
							"Daily Interest   " + interest + "     \n");
		
		  // following output
		  int rentY = rent * 12;
		  double rentW = ((double)rentY)/ 52.0;
		  
		  //Interest yearly and weekly
		  double interestY = interest * 365;
		  double interestW = interest * 7.0;
		  System.out.println();
		  System.out.println(aName + " is located in the Zip Code " + zCode +"\n"+
				  			"Rent per year: " + rentY + "\n" +
				  			"Rent per week: " + Math.round((rentW * 100.0)) / 100.0);
		  
		  System.out.println("Interest paid per year: " + Math.round((interestY*100.0))/100.0 +"\n"+
				  			"Interest per week: " + Math.round((interestW*100.0))/100.0 +"\n");
		  
		  //Check whether I should own or rent
		  boolean r = rentY > interestY; 
		  if (!r) {
		   System.out.println("I should rent.");
		  }
		  else {
		   System.out.println("I should own.");
		  }
		  
	}
}
