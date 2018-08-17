package lab8;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;

/**
 * 
 * @author roncytron
 *
 */
public class TermTest {
	
	private Random r = new Random();

	@Test
	public void testInit() {
		for (int i=0; i < 100; ++i) {
			double coeff = r.nextDouble();
			int degree = r.nextInt(100);
			//
			// Just making sure the constructor is there
			//
			Term t = new Term(coeff, degree);
		}
	}
	
	@Test
	public void testGetters() {
		for (int i=0; i < 100; ++i) {
			double coeff = r.nextDouble();
			int degree = r.nextInt(100);
			Term t = new Term(coeff, degree);
			assertEquals("Constructed Term has wrong coefficient", coeff, t.getCoefficient(), .001);
			assertEquals("Constructed Term has wrong power", degree, t.getDegree());
		}
	}
	
	/**
	 * Evaluate the same coefficient and x with increasing degree
	 * So for random a and x, this tests
	 *     a x ^ 0    a x ^1   a x ^2   etc.
	 * We make sure neither a nor x is 0.0
	 */
	@Test
	public void testEvaluate() {
		for (int i=0; i < 100; ++i) {
			double a = randomNonZero();
			double x = randomNonZero();
			
			double result = a;
			for (int degree=0; degree < 100; ++degree) {
				//
				// Loop invariant:  
				//    result = a * x to the degree power
				//
				Term t = new Term(a, degree);
				assertEquals(result, t.evaluateTermAtX(x), .001);
				result = result * x;
			}
		}
	}
	
	/**
	 * Make sure Term's toString has the elements required
	 *   by the lab assignment.
	 */
	@Test
	public void testToString() {
		for (int i=0; i < 100; ++i) {
			double coeff = r.nextDouble();
			int degree = r.nextInt(100);
			Term t = new Term(coeff, degree);
			String s = t.toString();
			assertTrue("Term's toString() result doesn't contain the coefficient", s.contains(""+Math.abs(coeff)));
			assertTrue("Term's toString() result doesn't contain the degree", s.contains(""+degree));
			assertTrue("Term's toString() result doesn't contain the character 'x'", s.contains("x"));
			assertTrue("Term's toString() result doesn't contain the character '^'", s.contains("^"));
		}

	}
	
	/**
	 * Make sure that identical terms have the same
	 *   hashCode() and equal(..) each other
	 */
	@Test
	public void testHashCodeAndEquals() {
		double a   = randomNonZero();
		int degree = r.nextInt(100);
		Term[] identicals = new Term[100];
		for (int i=0; i < identicals.length; ++i) {
			identicals[i] = new Term(a, degree);
		}
		//
		// probabilistically
		//   at least two of these should differ
		//   if hashCode is implemented incorrectly
		//
		Term first = identicals[0];
		for (int i=0; i < identicals.length; ++i) {
			if (identicals[i].hashCode() != first.hashCode()) {
				fail("Term " + identicals[i] + " is the same as " + first + " but has a different hashCode.");
			}
			if (!identicals[i].equals(first)) {
				fail("Term " + identicals[i] + " is the same as " + first + " but they do not equal each other.");		
			}
			if (!first.equals(identicals[i])) {
				fail("Term " + identicals[i] + " is the same as " + first + " but they do not equal each other.");		
			}
		}
	}
	
	@Test
	public void testDifferentTermsNotEqual() {
		double a   = randomNonZero();
		int degree = r.nextInt(100);
		Term t1 = new Term(a, degree);
		//
		//  The following terms all differ from t1
		//  They cannot all have the same hashCode()
		//  And none of them should equal t1
		boolean sameHashCode = true;
		for (int i=0; i < 100; ++i) {
			double aprime = a + randomNonZero();
			int    dprime = r.nextInt(100);
			Term t2 = new Term(aprime, dprime);
			if (t1.equals(t2)) {
				fail("Term " + t1 + " should not equal term " + t2 + " but your .equals(...) returned true");
			}
			if (t1.hashCode() != t2.hashCode())
				sameHashCode = false;
		}
		if (sameHashCode) {
			fail("You always return the same value for .hashCode().  You can do better");
		}
	}
	
	/**
	 * Generate a random number that is never 0.0
	 * @return random double that is not 0.0
	 */
	private double randomNonZero() {
		double ans = Math.abs(r.nextDouble()) + 0.0001;  // ensure positive (not zero)
		ans = Math.random() < 0.5 ? ans : -ans;          // randomly flip sign
		return ans;
	}

}
