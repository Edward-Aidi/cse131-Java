package lab9.providers;

import lab9.Guess;

/**
 * There are many ways of supplying a Guess:  randomly, by user choice, etc.
 * This interface allows code to be authored for this project so that all implementations
 * of this interface are interchangeable.
 * 
 * For example, it is useful to drive this project with an automatic Guess supplier,
 * hence the implementations RandomGuessProvider and StaticGuessProvider,
 * but in a real game, you might want the user to formulate a Guess.
 * 
 * @author roncytron
 *
 */
public interface ProvidesGuess {

	public Guess getGuess();

}