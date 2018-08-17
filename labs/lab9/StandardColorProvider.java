package lab9;

import java.awt.Color;
import lab9.providers.ProvidesColor;

public class StandardColorProvider implements ProvidesColor {
	
	private Color[] colors;
	
	public StandardColorProvider(GameProperties gp) {
		this(gp.getNumColors());
	}
	
//	public StandardColorProvider(int numColors) {
//		colors = new Color[numColors];
//	}

	@Override
	public Color getColorForPeg(int p) {
		int size = history.size();
		Guess mostRecent = history.getHistoryAt(size-1);
		return colors[history.getHistoryAt(history.size()-1];
	}
}
