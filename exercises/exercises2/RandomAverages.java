package exercises2;

public class RandomAverages {

	public static void main(String[] args) {
		//
		// Write a loop that computes the average
		//     of 1, 2, ... 1000 doubles
		// In each iteration of that loop, print
		//     the average of the doubles generated
		//     thus far.
		//
		// Your code goes below here.
		
		int i = 1;
		double average, random, sum = 0.0;
		while(i <= 1000) {
			random = Math.random();
			sum = sum + random;
			average = sum / (double)i;
			System.out.println("There has " + i + " random numbers, and their average is " + average);
			i =  i + 1;
		}
		
		//
		//  Some questions:
		//    1) How does the average change as your loop progresses?
		//    2) Can you write code in your loop that prints out the average only
		//         every 100 iterations, instead of each iteration?
		//
		// Answers:
		// 	1) The average of the random numbers are approaching 0.5;
		//  2) That is not hard. The codes are as follows:
		
		int j = 0;
		double average2, random2, sum2 = 0.0;
		while(j <= 1000) {
			random2 = Math.random();
			sum2 = sum2 + random2;
			average2 = sum2 / (double)j;
			if(j % 100 == 0) {
			System.out.println(j + " random numbers, and their average is " + average2);
			}
			j =  j + 1;
		}
	}

}
