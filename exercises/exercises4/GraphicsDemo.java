package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class GraphicsDemo {

	public static void main(String[] args) {
		// blue point (look carefully, will be very small on your screen)
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.point(.5, .5);
		// larger green point
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.filledCircle(.5, .5, .05);
		
		// or
		StdDraw.setPenRadius(.5);
		StdDraw.point(.5, .5);
		
		// unfilled red triangle
		StdDraw.setPenColor(Color.RED);
		double[] x = {.25, .5, .75};
		double[] y = {.25, .75, .25};
		StdDraw.polygon(x, y);
		// yellow circle, filled
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.filledCircle(.5, .5, .5);
		// filled blue rectangle
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(.5, .5, .25, .25);
		


	}

}
