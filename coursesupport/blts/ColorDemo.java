package blts;

import java.awt.Color;

import sedgewick.StdDraw;

public class ColorDemo {

	public static void main(String[] args) {
		// for new Color(r, g, b)    r = red, g = green, b = blue
		// values of each component range 0 to 255, inclusively
		Color c = new Color(0, 0, 0);
		StdDraw.setPenColor(c);
		StdDraw.filledSquare(0.5, 0.5, 0.5);

	}

}
