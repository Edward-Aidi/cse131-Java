package lab8;

/**
 * 
 * @author roncytron
 *
 */
public interface Polynomial {
	
	/**
	 * Return the degree of this Polynomial, computed
	 *   as the highest degree Term of this Polynomial over
	 *   all Terms with non-zero coefficients.
	 * The degree of all Polynomials is at least 0, because
	 *   a Polynomial with no Terms is equivalent to 0.0 x^0.
	 * @return the degree of this Polynomial
	 */
	public int degree();
	
	/**
	 * Returns the coefficient of the term at the specified degree.  If no
	 *   such term exists in the Polynomial, 0.0 should be returned.
	 * @param degree of interest
	 * @return coefficient of the degree of interest
	 */
	public double getCoefficientAtDegree(int degree);
	
	/**
	 * Evaluate this Polynomial at the specified value for x
	 * @param x value of the unknown
	 * @return the sum of all terms evaluated at x
	 */
	
	public double evaluate(double x);
	
	/**
	 * Creates an array of length degree() + 1 from the Terms of this Polynomial.
	 * All elements of this array are instantiated Term objects (none are null).
	 * 
	 * The term at index i has degree i.  Thus, given
	 * the Polynomial with Terms (in no particular order)
	 *      
	 *      4x squared
	 *       x cubed
	 *      14
	 *  The array that is returned would look as follows:
	 *  Index:         0      1      2      3
	 *  Contents:    14,0    0,1    4,2    1,3
	 *  where each of the contents is a coeff,degree pair as 
	 *     realized by a Term object.
	 *     
	 *  Note that at index 1, a new Term(0,1) is created because
	 *    there was no Term with degree 1 in the Polynomial's Set of Terms.
	 * @return an array of Terms, one for each degree
	 */
	public Term[] toArray();
	
	/**
	 * Returns a new Polynomial that is the derivative
	 *   of this one.  Be sure not to modify this Polynomial.
	 * @return
	 */
	
	public Polynomial derivative();


	/**
	 * Return a new Polynomial that is the sum of this
	 *    one and the other one.
	 * Be sure not to disturb this Polynomial.
	 * @param other another Polynomial
	 * @return the sum of this and the other Polynomial
	 */
	
	public Polynomial sum(Polynomial other);

	/**
	 * Return a new Polynomial that includes the supplied Term.
	 * If the supplied term is of the same degree as an already existing
	 * Term in this Polynomial, the the coefficients of the supplied and
	 * existing terms are summed in the returned new Polynomial
	 * 
	 * 
	 * This Polynomial must not be disturbed by this method.
	 * Be sure to return a new Polynomial that is like this one,
	 * but with the extra term included.
	 * @param t the Term to be included in the new Polynomial
	 * @return new Polynomial as described above
	 */
	public Polynomial addTerm(Term t);

	/**
	 * Use StdDraw to plot this Polynomial using the
	 *   specified range of values for x.
	 * @param lowx lowest value of x, inclusive
	 * @param highx highest value of x, exclusive
	 * @param incx increment for x between plotted values
	 */
	public void plot(double lowx, double highx, double incx);

}
