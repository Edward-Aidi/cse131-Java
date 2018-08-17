package lab8;

import org.junit.Test;

import cse131.ArgsProcessor;
import junit.framework.TestCase;

/**
 * 
 * @author roncytron
 *
 */
public class PolynomialPlotTest extends TestCase {

	@Test
	public void testPlot1() {
		ArgsProcessor ap = new ArgsProcessor(new String[0]);
		
		Polynomial xsquared = new SparsePolynomial(new Term[] { new Term(1,2) });
		xsquared.plot(-1000, 1000, 0.5);
		//
		// Pause for input, so the test doesn't close the plot
		//
		assertTrue(ap.nextBoolean("You like this plot? (true or false)"));
	}

}
