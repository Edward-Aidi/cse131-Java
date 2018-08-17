package lab9.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lab9.GameProperties;
import lab9.Guess;
import lab9.providers.ProvidesGuess;

/**
 * Generates a random Guess
 *    Each peg id is represented at most once
 *    There is a peg id for each hole in the game
 * 
 * @author roncytron
 *
 */
public class RandomGuessProvider implements ProvidesGuess {

	final private int numPegs, numCols;

	public RandomGuessProvider(GameProperties gp) {
		this.numPegs = gp.getNumHoles();
		this.numCols = gp.getNumColors();
	}

	/**
	 * Returns a new and random Guess
	 */
	@Override
	public Guess getGuess() {
		List<Integer> list = genSequentialArray();
		Collections.shuffle(list);
		return new Guess(toArray(list));
	}
	
	private List<Integer> genSequentialArray() {
		List<Integer> ans = new ArrayList<Integer>(this.numPegs);
		for (int i=0; i < this.numCols; ++i) {
			ans.add(i);
		}
		return ans;
	}
	
	private int[] toArray(List<Integer> list) {
		int[] ans = new int[this.numPegs];
		for (int i=0; i < this.numPegs; ++i) {
			ans[i] = list.get(i);
		}
		return ans;
	}
		 
}
