package lab9.viz;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * Class to represent a possible peg color as a swatch
 * 
 * @author roncytron
 *
 */
public class Swatch extends JPanel {

	/**
	 * Create the panel.
	 * @param color 
	 */
	public Swatch(Color color) {
		setBackground(color);
		setLayout(null);

	}
	

}
