package lab1;

import cse131.ArgsProcessor;

public class Nutrition {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		// The name of this food, provided as a String
		String name = ap.nextString("Nmae of this food?");
		// The number of grams of carbohydrates in this food
		double carbs = ap.nextDouble("How many grams of carbohydrates in this food?");
		// The number of grams of fat in this food
		double fat = ap.nextDouble("How many grams of fat in this food?");
		// The number of grams of protein in this food
		double protein = ap.nextDouble("How many grams of protein in this food?");
		// The number of calories stated on this food's label
		double statedCals =ap.nextDouble("How many calories stated on this food's label?");
		
		// Do the round for one decimal
		double calcarbs = Math.round(40 * carbs) / 10.0;
		double calfat = Math.round(90 * fat) / 10.0;
		double calpro = Math.round(40 * protein) / 10.0;
		double sub = Math.round((calcarbs + calfat + calpro - statedCals) * 10) / 10.0;
		double fiber = Math.round(sub / 0.04) / 100.0;
		double carboper = Math.round(calcarbs / statedCals * 1000) / 10.0;
		double fatper = Math.round(calfat / statedCals * 1000) / 10.0;
		double protper = Math.round(calpro / statedCals * 1000) / 10.0;
		boolean low_carb = carboper <= 25;
		boolean low_fat = fatper <= 15;
		boolean heads = Math.random() > 0.5;
		
		System.out.println(name + " has \n\t" 
		+ carbs + " grams of carbohydrates = " + calcarbs + " Calories\n\t" 
		+ fat + " grams of fat = " + calfat + " Calories\n\t"
		+ protein + " grams of protein = " + calpro + " Calories\n\n"
				+ "This food is said to have " + statedCals + " (available) Calories."
						+ "\nWith " + sub + " unavailable Calories, this food has " + fiber + " grams of fiber"
								+ "\n\nApproximately\n\t"
								+ carboper + "% of your food is carbohydrates"
										+ "\n\t" + fatper + "% of your food is fat"
												+ "\n\t" + protper + "% of your food is protein\n\n"
														+ "This food is acceptable for a low-carb diet?	" + low_carb
														+ "\nThis food is acceptable for a low-fat diet?	" + low_fat
														+"\nBy coin flip, you should eat this food?	" + heads);
	}

}
