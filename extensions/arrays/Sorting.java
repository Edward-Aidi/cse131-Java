package arrays;
import cse131.ArgsProcessor;

public class Sorting {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int size = ap.nextInt("Please enter the size of the sorting integer data: ");
		int sortCount = 0;
		int min = 0, minindex;
		int[] data = new int[size];
		for(int i = 0; i < size; i++) {
			data[i] = ap.nextInt("Please eneter an integer: ");
		}
		while(sortCount < size) {
			min = data[sortCount];
			minindex = sortCount;
			for(int i = sortCount; i < size; i++) {
					if(min > data[i]) {
						min = data[i];
						minindex = i;
					}
				}
				data[minindex] = data[sortCount];
				data[sortCount] = min;
			sortCount = sortCount + 1;
		}
		for(int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		double mean = 0;
		double sum = 0.0;
		for(int i = 0; i < data.length; i++) {
			sum = sum + data[i];
			mean = sum / data.length;
		}
		int max, range;
		double median;
		if(data.length % 2 == 0) {
			median = (data[(data.length-1)/2]+data[(data.length+1)/2]) / 2.0;
		}
		else {
			median = data[(data.length / 2)];
		}
		max = data[data.length -1];
		min = data[0];
		range = data[data.length - 1] - data[0];
		System.out.println("Mean: " + mean +
				"\nMedian: " + median +
				"\nMin: " + min +
				"\nMax: " + max +
				"\nRange: " + range);
	}
}
