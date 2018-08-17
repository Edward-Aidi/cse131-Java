package emote;

import java.awt.Color;

import sedgewick.StdDraw;

public class Emersyn {

	/**
	 * Coordinates and dimensions use the StdDraw coordinate system
	 * So, (0.5, 0.5) is the nominal center of the screen
	 *   and 0.5 and 0.5 are the nominal halfWidth and halfHeight
	 * 
	 * @param xCenter x coordinate of center of what you draw
	 * @param yCenter y coordinate of center of what you draw
	 * @param halfWidth half the width of your drawing
	 * @param halfHeight half the height of your drawing
	 * @param howHot on a scale from -1.0 to 1.0, how hot is the emote?
	 * @param howHappy on a scale from -1.0 to 1.0, how happy is the emote?
	 * @param howOther on a scale from -1.0 to 1.0, some third emotion of your choosing
	 */
	public static void emote(
			double xCenter, double yCenter,
			double halfWidth, double halfHeight,
			double howHot, double howHappy, double howOther
			){
		//
		// Do not issue clear or show
		//  Just draw the emote to show the current values of
		//     its emotions, as represented by the inputs above
		//  You can change the face code below:  it's there so
		//    you see something when you run the program as given
		//
		
		//
		// face
		//
		
		double faceRad = 0.9*Math.min(halfWidth, halfHeight);		
		StdDraw.setPenColor(Color.GREEN); 
		StdDraw.filledCircle(xCenter, yCenter, faceRad);	
		
	}

}

