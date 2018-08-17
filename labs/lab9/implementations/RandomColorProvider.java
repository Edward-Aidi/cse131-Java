package lab9.implementations;

import java.awt.Color;
import java.util.Random;

import lab9.GameProperties;
import lab9.providers.ProvidesColor;

/**
 * Generate a sequence of random Colors
 * 
 * @author roncytron
 *
 */
public class RandomColorProvider implements ProvidesColor {

	private Color[] colors;
	private Random r = new Random();
	
	public RandomColorProvider(GameProperties gp) {
		this(gp.getNumColors());
	}
	
	private RandomColorProvider(int numColors) {
		colors = new Color[numColors];
		for (int i=0; i < numColors; ++i) {
			colors[i] = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		}
	}
	
	@Override
	public Color getColorForPeg(int p) {
		return colors[p];
	}

}
