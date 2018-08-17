package exercises4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Please enter how many coordinates that you would like to store");
		double[] histX = new double[N];
		double[] histY = new double[N];
		int cur = 0;
		
		while (true) {
			StdDraw.clear();
			//
			// Render one frame of your animation below here
			//
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			StdDraw.setPenColor(Color.RED);
			StdDraw.setPenRadius(.05);
			histX[cur] = x;
			histY[cur] = y;
			cur = cur + 1;
			
			if(cur >= histX.length) {
				cur = 0;
			}
		int old = cur;
			StdDraw.point(histX[old], histY[old]);
			
			//  
			// End of your frame
			//
			// Stdraw.show(..) achieves double buffering and
			//   avoids the tight spinning loop
			StdDraw.show(10);
		}

	}

}
