package lab0;

import sedgewick.StdDraw;

public class script {
	
	public static int f(int n) {
		if(n <= 0) {
			return 1;
		}
		return 3*f(n-1)+4;
	}
	
	public static void circles(double x, double y, double r) {
		if(r < 0.01) {
			return;
		}
		StdDraw.circle(x, y, r);
		circles(x, y, 0.9*r);
	}
	
	public static void squares( double x , double y, double hw) {
		if(hw < 0.01) {
			return;
		}
		StdDraw.square(0.5, 0.5, hw);
		squares(0.5, 0.5, hw-0.03);
	}
	
	public static void main(String[] args) { 
		squares(0.5, 0.5, 0.5);
		circles(0.5, 0.5, 0.5);
	 }
}