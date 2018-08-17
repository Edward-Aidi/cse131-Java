package lab8;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * 
 * @author roncytron
 *
 */

public class SparsePolynomialTest extends TestCase {
	private Polynomial noterms = new SparsePolynomial(new Term[0]);
	private Random random = new Random();

	/**
	 * Tests properties of the class:
	 *    Only one instance variable that must be private and final
	 *    It must be of type Set
	 */
	@Test
	public void testOnlyOneInstanceVar() {
		Field[] fields = SparsePolynomial.class.getDeclaredFields();
		if (fields.length != 1)
			fail("You must have exactly one instance variable in SparsePolynomial, but you have " + fields.length);
		int m = fields[0].getModifiers();
		if (!Modifier.isPrivate(m))
			fail("Your instance variable must be private");
		if (!Modifier.isFinal(m))
			fail("Your instance variable must be final");
		if (!fields[0].getType().equals(java.util.Set.class))
			fail("Your instance variable must be of type java.util.Set, but it is of type " + fields[0].getType());
	}

	/**
	 * The constructor must initialize the instance variable.
	 */
	@Test
	public void testInit() {
		testOnlyOneInstanceVar();
		SparsePolynomial sbp = new SparsePolynomial();
		Set<Term> set = getSet(sbp);
		if (set == null)
			fail("Your instance variable is null.  It must be assigned to be an empty HashSet<Term>() in your constructor.");
		validateSparsePoly(sbp);
	}
	
	/**
	 * Test the degree method for polynomials of increasing degree,
	 *   and for Polynomials of random degree.
	 */
	@Test
	public void testDegree() {
		assertEquals("The degree of a no-Term Polynomial should be 0", 0, noterms.degree());
		assertEquals("The degree of a default constructed Polynomial should be 0", 0, new SparsePolynomial().degree());
		for (int i=1; i < 100; ++i) {
			Term[] terms = genTerms(i);
			SparsePolynomial sbp = new SparsePolynomial(terms); 
			validateSparsePoly(sbp);
			assertEquals("Polynomial " + sbp + " should have degree " + (i-1), i-1, sbp.degree());
		}
		//
		// random degree single-term Polynomials
		//
		for (int i=0; i < 100; ++i) {
			int degree = random.nextInt(1000);
			Term t = new Term(randomNonZero(), degree);
			Polynomial sp = new SparsePolynomial(new Term[] { t } );
			assertEquals("Polynomial " + sp + " wrong degree ",degree, sp.degree());
		}
	}
	
	/**
	 * Zero terms are supposed to be eliminated from the SparsePolynomial.
	 * Also, all Polynomials are supposed to have degree at least 0.
	 */
	@Test
	public void testZeros() {
		Polynomial p1 = new SparsePolynomial();
		Polynomial p2 = synthPoly(new double[] { 0, 0, 0 });
		assertEquals("You are not computing degree correctly for a 0.0 Polynomial: "+p1, 0, p1.degree());
		assertEquals("You are not computing degree correctly for a 0.0 Polynomial: "+p2, 0, p2.degree());
		assertEquals("You are not handling 0.0 coefficients properly in your constructor", p1,p2);
		Polynomial pos = synthPoly(new double[] {  1,  2,  3,  4} );
		Polynomial neg = synthPoly(new double[] { -1, -2, -3, -4} );
		Polynomial sum = pos.sum(neg);
		assertEquals("You are not treating 0.0 coefficient terms properly for a sum", p1, sum);
		validateSparsePoly(p1);
		validateSparsePoly(p2);
		validateSparsePoly(pos);
		validateSparsePoly(neg);
		validateSparsePoly(sum);
	}


	/**
	 * Test for missing terms whose coefficients
	 *   are implied to be 0.0
	 *   
	 * Here p = x-squared + 131
	 *      q = 3x-cubed + 4x + 5
	 */
	@Test
	public void testOneMissingTerm() {
		Polynomial p = new SparsePolynomial(
				new Term[] { new Term(131,0), new Term(1, 2) }
				);
		Polynomial q = new SparsePolynomial(
				new Term[] { new Term(3,3), new Term(4,1), new Term(0,5) }
				);
		validateSparsePoly(p);
		validateSparsePoly(q);
		System.out.println("Showing toString() for a missing term: " + p);
		double valueAt3 = p.evaluate(3.0);
		assertEquals(140.0, valueAt3, .0001);
		Polynomial derivP = new SparsePolynomial(new Term[] { new Term(2,1) });
		validateSparsePoly(derivP);
		assertEquals(derivP, p.derivative());
		Polynomial s = p.sum(q);
		validateSparsePoly(s);
		System.out.println("Showing toString() for summed poly " + s);
		assertEquals(139.0, s.evaluate(1.0), .001);
		
	}

	private Polynomial p1      = synthPoly(new double[] {  4, -7,  0, 11   });
	private Polynomial p2      = synthPoly(new double[] {  7,  5, -2,  5   });     // from assignment
	private Polynomial p3      = synthPoly(new double[] { -1,  2,  3, -4, 5});

	/**
	 * Some simple evaluations on examples that are easy to follow.
	 */
	@Test
	public void testEval1() {
		assertEquals(49.0, p2.evaluate(2.0), .001);
		assertEquals(0.0,  noterms.evaluate(100), .001);
	}


	/**
	 * More rigorous random testing of evaluations.
	 */
	@Test
	public void testEval2() {
		TermGenerator tg = new TermGenerator();
		Polynomial p = new SparsePolynomial();
		validateSparsePoly(p);
		double x = randomNonZero();
		double xpow = 1.0;
		double value = 0.0;
		for (int i=0; i < 10; ++i) {
			assertEquals("Polynomial " + p + " should have value " + value, value, p.evaluate(x), .001);
			double a = randomNonZero();
			p = appendTerm(p, tg.nextTerm(a));
			validateSparsePoly(p);
			value = value + a * xpow;
			xpow = xpow * x;
		}
	}
	
	@Test
	public void testToArray() {
		Polynomial p1 = new SparsePolynomial(new Term[] { new Term(0,5), new Term(1,10)});
		validateSparsePoly(p1);
		Term[] terms = p1.toArray();
		assertEquals("Array " + Arrays.toString(terms) + " has wrong length ",11, terms.length);
		Polynomial p1also = new SparsePolynomial(terms);
		assertEquals(p1 + " and " + p1also + " should be the same",p1,p1also);
	}
	
	@Test
	public void testSum() {
		Polynomial sum     = synthPoly(new double[] { 3, -5, 3, 7, 5});
		validateSparsePoly(sum);
		validateSparsePoly(p1.sum(p3));
		validateSparsePoly(p3.sum(p1));
		assertEquals(sum,     p1.sum(p3));
		assertEquals(sum,     p3.sum(p1));
		assertEquals(noterms, noterms.sum(noterms));
		validateSparsePoly(noterms);
		validateSparsePoly(noterms.sum(noterms));
	}

	@Test
	public void testDeriv() {
		Polynomial p1Deriv = synthPoly(new double[] { -7,  0, 33 });
		Polynomial p2Deriv = synthPoly(new double[] {  5, -4, 15 });

		assertEquals(p1Deriv, p1.derivative());
		assertEquals(p2Deriv, p2.derivative());
		assertEquals(noterms, noterms.derivative());
	}


	@Test
	public void testLikeTheresNoTomorrow() {
		for (int i=0; i < 100; ++i) {
			// Cook up two polynomials of random degree (but at least 1) and with
			//   random coefficients
			double [] coeffs1 = genRandomCoeffs(random.nextInt(7)+1);
			double [] coeffs2 = genRandomCoeffs(random.nextInt(7)+1);
			Polynomial p1 = synthPoly(coeffs1);
			Polynomial p2 = synthPoly(coeffs2);

			// Compute the sum and the derivative of the sum here
			Polynomial sum = new SparsePolynomial();
			TermGenerator tgsum = new TermGenerator();
			Polynomial der = new SparsePolynomial();
			TermGenerator tgder = new TermGenerator();
			for (int j=0; j < Math.max(coeffs1.length, coeffs2.length); ++j) {
				// Sum of this term
				double sTerm = 0;
				if (j < coeffs1.length) sTerm = sTerm + coeffs1[j];
				if (j < coeffs2.length) sTerm = sTerm + coeffs2[j];

				sum = appendTerm(sum, tgsum.nextTerm(sTerm));

				// Derivative of the sum of this term
				if (j > 0) der = appendTerm(der, tgder.nextTerm(sTerm*j));
			}

			// Compare what we computed here with what Polynomial computes
			assertEquals(sum, p1.sum(p2));
			assertEquals(der, p1.sum(p2).derivative());
		}
	}
	
	/**
	 * Make sure Polynomials are not mutated when used.
	 */
	@Test
	public void testNoMutateSum() {
		Polynomial p1  = synthPoly(new double[] {  4, -7,  0, 11, 0, 0, 0, 4   });
		Polynomial p2  = synthPoly(new double[] {  7,  5, -2,  5, 20   });
		Set<Term> p1set = getSet(p1);
		Set<Term> p2set = getSet(p2);
		validateSparsePoly(p1);
		validateSparsePoly(p2);
		Polynomial p3 = p1.sum(p2);
		Set<Term> p3set = getSet(p3);
		assertEquals("Poly p1's Set<Term> changed but shouldn't have",p1set, getSet(p1));
		assertEquals("Poly p2's Set<Term> changed but shoudln't have",p2set, getSet(p2));
		assertFalse("Poly p3's Set<Term> should be different than p1 or 2 but is not",p3set.equals(p1set));
	}
	
	@Test
	public void testNoMutateAddTerm() {
		Polynomial p1  = synthPoly(new double[] {  4, -7,  0, 11, 0, 0, 0, 4   });
		Polynomial p2  = synthPoly(new double[] {  7,  5, -2,  5, 20   });
		Set<Term> p1set = getSet(p1);
		Set<Term> p2set = getSet(p2);
		validateSparsePoly(p1);
		validateSparsePoly(p2);
		for (int i=10; i < 100; ++i) {
			Polynomial p3 = p1.addTerm(new Term(randomNonZero(),i));
			Set<Term> p3set = getSet(p3);
			assertEquals("Poly p1's Set<Term> changed but shouldn't have",p1set, getSet(p1));
			assertFalse("Poly p3's Set<Term> should be different than p1 or 2 but is not",p3set.equals(p1set));
		}
	}
	

	/**
	 * Not a real test but just causes some stuff to print out on console
	 */
	@Test
	public void testPrint() {
		System.out.println("p2 is " +p2);
		System.out.println("p2's derivative is " + p2.derivative());
		System.out.println("Newly constructed poly is " + new SparsePolynomial());
	}


	/**
	 * Factory method to generate a Polynomial from an array of doubles.
	 * @param coeffs
	 * @return
	 */
	private Polynomial synthPoly(double[] coeffs) {
		Polynomial ans = new SparsePolynomial(genTerms(coeffs));
		validateSparsePoly(ans);
		return ans;
	}

	/**
	 * Generate a Term array from an array of coefficients (doubles)
	 * @param coefficients in increasing order from degree 0
	 * @return the coefficients realized as a Term[]
	 */
	public static Term[] genTerms(double[] coefficients) {
		Term[] ans = new Term[coefficients.length];
		for (int i=0; i < coefficients.length; ++i) {
			ans[i] = new Term(coefficients[i], i);
		}
		return ans;
	}

	/**
	 * Generates an array of random positive integer coefficients
	 * @param num The size of the array
	 * @return an array of random numbers, each in the range 1...100
	 */
	private double[] genRandomCoeffs(int num) {
		double[] ans = new double[num];
		for (int i=0; i < num; ++i) {
			ans[i] = random.nextInt(100)+1;
		}
		return ans;
	}

	private Term[] genTerms(int num) {
		return genTerms(genRandomCoeffs(num));
	}

	/**
	 * Generate a random number that is never 0.0
	 * @return random double that is not 0.0
	 */
	private double randomNonZero() {
		double ans = Math.abs(random.nextDouble()) + 0.0001;  // ensure positive (not zero)
		ans = Math.random() < 0.5 ? ans : -ans;          // randomly flip sign
		return ans;
	}
	
	/**
	 * Like Polynomial's addTerm, but for testing
	 *  we don't want to rely on it.
	 * @param p Input Polynomial
	 * @param t new Term to be added
	 * @return 
	 */
	private static Polynomial appendTerm(Polynomial p, Term t) {
		if (!(t.getDegree()==0 && p.degree()==0) && t.getDegree() != p.degree()+1) {
			throw new Error("Improper degree for adding term " + t + " to Polynomial " + p);
		}
		Term[] pt = p.toArray();
		Term[] ans = new Term[t.getDegree()+1];
		for (int i=0; i < pt.length; ++i) {
			ans[i] = pt[i];
		}
		ans[t.getDegree()] = t;
		return new SparsePolynomial(ans);
	}
	
	/**
	 * Check the properties via reflection for Polynomial p,
	 *   assuming it is a SparsePolynomial.
	 * @param p
	 */
	private void validateSparsePoly(Polynomial p) {
		Set<Term> s = getSet(p);
		Set<Integer> degrees = new HashSet<Integer>();
		for (Term t : s) {
			if (t == null) 
				fail("Null found for poly " + p);
			int degree = t.getDegree();
			double coeff = t.getCoefficient();
			if (degree > 0 && coeff == 0.0)
				fail("Poly has 0 coefficient at degree " +  degree + ": " +p);
			if (!degrees.add(degree))
				fail("Poly has two terms of the same degree for degree " + degree + ": " +p);
		}
	}

	/**
	 * Grab a copy of p's Set<Term> by reflection
	 * @param p the Polynomial
	 * @return a copy of the Set<Term> in p
	 */
	private Set<Term> getSet(Polynomial p) {
		testOnlyOneInstanceVar();
		Field[] fields = SparsePolynomial.class.getDeclaredFields();
		Field f = fields[0];
		f.setAccessible(true);
		try {
			Set<Term> theirs = (Set<Term>) (f.get(p));
			Set<Term> ans    = new HashSet<Term>();
			ans.addAll(theirs);
			return ans;
		} catch (IllegalArgumentException e) {
			throw new Error(e);
		} catch (IllegalAccessException e) {
			throw new Error(e);
		}
	}
	
	class TermGenerator {

		private int degree;
		public TermGenerator() {
			this.degree = -1;
		}

		public Term nextTerm(double coeff) {
			return new Term(coeff, ++degree);
		}

	}

}
