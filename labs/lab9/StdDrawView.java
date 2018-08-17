package lab9;

import java.awt.Color;

import lab9.implementations.RandomColorProvider;
import lab9.providers.ProvidesColor;
import lab9.providers.ProvidesGuess;
import lab9.providers.ReceivesHistory;
import lab9.viz.ColorChooser;
import sedgewick.StdDraw;

public class StdDrawView implements ReceivesHistory, ProvidesColor {
	private GameProperties gp;
	private ProvidesGuess guess;
	private ProvidesColor pc ;
	
	
	public StdDrawView(GameProperties gp, ProvidesGuess guess, ProvidesColor pc) {
		super();
		this.gp = gp;
		this.guess = guess;
		this.pc = pc;
		
		double r = 1/40.0;
		double x = 1/10.0;
		double y = 9/10.0;
		
//		GameProperties interactive = new GameProperties("Interactive");
//		ProvidesColor pc      = new RandomColorProvider(interactive);
//		ProvidesGuess guess = ColorChooser.launchChooser(interactive, pc);
//		StdDrawView sdv = new StdDrawView(gp, guess, pc);
		StdDraw.setXscale();
		StdDraw.setYscale();
		for(double j = 1; j < 12; ++j) {
			for(int i = 0; i < 4; ++i) {
				//history.getHistoryAt(history.size()-1)
				StdDraw.setPenColor(this.getColorForPeg(i));
				StdDraw.filledCircle(x+1/5.0*i, y, r);
			}
			y = y-1/12.0;
		}
	}
	
	@Override
	public void sendHistory(History history) {
		System.out.println(history.getHistoryAt(history.size()-1));
		//this.pc.getColorForPeg(p)
	}

	@Override
	public Color getColorForPeg(int p) {
		
		return null;
	}
}
