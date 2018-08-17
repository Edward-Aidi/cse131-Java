 package blts;

import java.awt.Color;

import sedgewick.StdDraw;

public class MovingBall {

	public static void main(String[] args) {
		// ball to move across the screen
		// when it reaches the right side
		//    start over at the left side
		
		//  need to represent the current x location
		//   of the ball
		double ballX = 0.0;
		
		StdDraw.setPenColor(Color.MAGENTA);
		StdDraw.setPenRadius(.05);
		while (true) {
			// clear the canvas
			StdDraw.clear();
			
			ballX = ballX + .005;
			if (ballX > 1.0) { // moved too far right
				ballX = 0;     // start again at left
			}
			StdDraw.point(ballX, 0.5);
			// wait 10 ms, but also put the graphics
			//  output into "double buffered" mode
			
			StdDraw.show(10);
		}

	}

}
