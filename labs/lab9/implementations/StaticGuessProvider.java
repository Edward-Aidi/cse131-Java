package lab9.implementations;

import lab9.GameProperties;
import lab9.Guess;
import lab9.providers.ProvidesGuess;

/**
 * Formulate one random Guess and stick with it
 * 
 * @author roncytron
 *
 */
public class StaticGuessProvider implements ProvidesGuess {

	final private Guess guess;

	public StaticGuessProvider(GameProperties gp) {
		this(new RandomGuessProvider(gp).getGuess());
	}
	
	public StaticGuessProvider(Guess guess) {
		this.guess = guess;
	}

	/**
	 * Always returns the same Guess, formulated when this class was instantiated
	 */
	@Override
	public Guess getGuess() {
		return this.guess;
	}
		 
}
