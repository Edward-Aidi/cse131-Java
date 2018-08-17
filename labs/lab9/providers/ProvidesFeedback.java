package lab9.providers;

import lab9.Guess;

/**
 * Recall that a peg is identified by a small nonnegative integer, such as 0 or 2.
 * In the description below, the term "peg id" denotes the small nonnegative integer
 *   present in a Guess.
 *   
 * The methods below take in a supplied Guess and judge them with respect to some
 *   goal.  Because the goal is not a parameter in this interface, it must have been
 *   supplied to an implementation of this interface when it was instantiated, or
 *   it must somehow be inherent to the implementation.
 *   
 * @author roncytron
 *
 */
public interface ProvidesFeedback {

	/**
	 * For the supplied Guess, how many peg ids occur in the correct position
	 *   with respect to the desired goal?
	 * For example, if the goal is 0 2 3 1
	 *            and the guess is 0 1 3 4
	 * then the result is 2, because the pegs with ids 0 and 3 are in exactly the
	 * right position.
	 * @param guess the Guess to be judged with respect to the goal
	 * @return the number of peg ids in the correct position
	 */
	public int numSamePosition(Guess guess);

	/**
	 * Given the supplied Guess, how many peg ids are in common with the desired
	 *    goal and the guess?
	 *    
	 * For example, if the goal is 0 2 3 1
	 *            and the guess is 0 1 3 4
	 * then the result is 3 because peg ids 0, 1, and 3 occur in both the goal and
	 * the guess.
	 * @param guess the Guess to be judged with respect to the goal
	 * @return the number of peg ids in common with the goal and the guess
	 */
	public int numIntersection(Guess guess);
	
	/**
	 * Is the solution correct?   This can be reduced from numSamePosition(guess)
	 *   returning an answer showing all pegs of the Guess are in the correct
	 *   position.
	 * @param guess the supplied Guess to be judged
	 * @return true iff the guess is completely correct
	 */
	public boolean isSolution(Guess guess);

}