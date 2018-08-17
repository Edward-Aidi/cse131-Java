package arrays;
import cse131.ArgsProcessor;

public class Birthday {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How many people stepped in the room?");
		int[][] bday = new int[12][31];
		int[] month = new int[N];
		int[] day = new int[N];

		for(int i = 0; i < N; i++) {
			month[i] = (int) Math.floor(Math.random() * 12 + 1);
		}
		for(int i = 0; i < N; i++) {
			day[i] = (int) Math.floor(Math.random() * 31 + 1);
		}
		
		for(int i = 0; i < N; i++) {
				System.out.print(month[i] + "\t");
				System.out.print(day[i]);
			System.out.println();
		}
		
		// create a row = month; column = days two-dimensional array to record
		for(int i = 0; i < N; i++) {
			bday[month[i]-1][day[i] - 1] =  bday[month[i]-1][day[i] - 1] + 1;
		}
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 31; j ++) {
				System.out.print(bday[i][j]);
			}
			System.out.println();
		}
		
		//For each month, the fraction (or percentage) of people born in that month.
		int[] mon = new int[12];
		double[] monfrac = new double[12];
		mon[0] = bday[0][0];
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 30; j++) {
				mon[i] = mon[i] + bday[i][j+1];
			}
			monfrac[i] = Math.round((double)mon[i] / (double)N * 100) / 100.0;
		}
		System.out.println("The fraction (or percentage) of people born in each month is ");
		for(int i = 0; i < 12; i++) {
			System.out.print(monfrac[i] + "\t");
		}
		//The average of the 12 values you computed for the above.
		System.out.println();
		double sum = 0;
		for(int i = 0; i < 11; i++) {
			sum = sum + monfrac[i + 1];
		}
		double monave = Math.round(sum / 12.0 * 1000) / 1000.0;
		System.out.println("The average of the 12 values is "+ monave);
		//For each day, the fraction (or percentage) of people born on that day, whether in the same or in a different month.
		int[] da = new int[31];
		double[] dafrac = new double[31];
		da[0] = bday[0][0];
		
		for(int j = 0; j < 31; j++) {
			for(int i = 0; i < 11; i++)
			{
				da[j] = da[j] + bday[i+1][j];
			}
			dafrac[j] = Math.round((double)da[j] / (double)(N) * 100) / 100.0;
		}
		System.out.println("The fraction (or percentage) of people born in each day is ");
		for(int i = 0; i < 31; i++) {
			System.out.print(dafrac[i] + "\t");
		}
		//The average of the 31 values you computed for the above.
		System.out.println();
		
		sum = 0;
		for(int i = 0; i < 30; i++) {
			sum = sum + dafrac[i + 1];
		}
		double daave = Math.round(sum / 31.0 * 1000) / 1000.0;
		System.out.println("The average of the 31 values is "+ daave);
		//The fraction (or percentage) of people born on exactly the same day.
		
		int count = 0;
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 31; j++) {
				if(bday[i][j] > 1) {
					count = count + 1;
				}
			}
		}
		double same = (double)count / (double)N;
		System.out.println("The fraction (or percentage) of people born on exactly the same day is " + same);
	}

}
