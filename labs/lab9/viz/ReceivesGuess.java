package lab9.viz;

import lab9.Guess;

/**
 * Interface used by the visualizer push/pull adapter
 *   so that clicking color choices can be pulled instead of pushed.
 * @author roncytron
 *
 */
public interface ReceivesGuess {
	
	public void sendGuess(Guess trial);

}
