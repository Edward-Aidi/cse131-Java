package lab9.viz;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * Class to display a chosen peg color
 * 
 * @author roncytron
 *
 */
public class Choice extends JPanel {

	/**
	 * Create the panel.
	 */
	public Choice() {
		setBackground(Color.WHITE);
		setLayout(null);

	}
	
	public void setColor(Color c) {
		setBackground(c);
	}
	
	public void resetColor() {
		setBackground(Color.WHITE);
	}

}
