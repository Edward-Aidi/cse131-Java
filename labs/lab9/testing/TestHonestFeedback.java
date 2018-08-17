package lab9.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import lab9.Guess;
import lab9.implementations.HonestFeedback;

public class TestHonestFeedback {

	@Test
	public void testCompleteSolution() {
		for (int i=0; i < 100; ++i) {
			int[] code = Support.genRandomArray();
			int[] guess = Support.dup(code);
			Guess cguess = new Guess(code);
			Guess gguess = new Guess(code);
			HonestFeedback truth = new HonestFeedback(cguess);
			assertTrue("Failed to detect solution", truth.isSolution(gguess));
			assertEquals("Failed to find correctly placed pegs, code " + cguess + " guess " + gguess, cguess.size(), truth.numSamePosition(gguess));
			assertEquals("Failed to find correct peg colors, code " + cguess + " guess " + gguess, Support.countCommon(code,guess), truth.numIntersection(gguess));
		}
	}

	@Test
	public void testNotCompleteSolution() {
		for (int j=0; j < 100 ; ++j) {
			int[] code = Support.genRandomArray();
			int[] guess = Support.dup(code);
			int numChanged = 0;
			for (int i=0; i < guess.length; ++i) {
				if (Math.random() < 0.5)  {
					++guess[i];
					++numChanged;
				}
			}
			Guess cguess = new Guess(code);
			Guess gguess = new Guess(guess);
			HonestFeedback truth = new HonestFeedback(cguess);
			
			if (numChanged > 0)
				assertTrue("Failed to detect wrong solution", !truth.isSolution(gguess));
			assertEquals("Failed to find correctly placed pegs, code " + cguess + " guess " + gguess, cguess.size()-numChanged, truth.numSamePosition(gguess));
			assertEquals("Failed to find correct peg colors, code " + cguess + " guess " + gguess, Support.countCommon(code,guess), truth.numIntersection(gguess));

		}
	}

}
