package lab9.providers;

import java.awt.Color;

public interface ProvidesColor {

	/**
	 * Given the integer code for a peg, what is its Color
	 * @param p integer code for a peg (0, 1, 2, etc.)
	 * @return the Color to be associated with that peg
	 */
	public Color getColorForPeg(int p);

}