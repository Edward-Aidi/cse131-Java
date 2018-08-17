package lab8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import sedgewick.StdDraw;

/**
 * An immutable Polynomial class.  This means that once
 *   the constructor has finished, nothing about this
 *   Polynomial can change.  We check for this in
 *   our testing of your implementation.
 *   
 * Also this implementation is sparse, in the sense
 * that terms with 0 coefficients, supplied or implied,
 * can and should not be represented here.
 * 
 * For example, 5 + x^100 is a Polynomial with a 0-degree
 * term (5) and a 100-degree term (1).   The 99 terms in between are
 * not mentioned here and are implied to have a coefficient of 0.
 * Moreover, x^202 power would also have a coefficient of 0 for this
 * Polynomial.   By using a sparse representation, we retain only
 * the 0-degree and 100-degree terms in this case.
 * 
 * @author Di Ai
 *
 */
public class SparsePolynomial implements Polynomial {
	//
	// TODO Declare instance variable(s)
	//
	private final Set<Term> term;

	/**
	 * Primary constructor
	 * @param array  collection of Terms for this Polynomial.  
	 * Some coefficients may be 0.0, but those Terms should not
	 * be retained in the Set.
	 */

	public SparsePolynomial(Term[] array) {
		// TODO complete this constructor
		// initial HashSet for term
		this.term = new HashSet<Term>();
		for(int i = 0; i < array.length; i++) {
			if(array[i].getCoefficient() != 0.0) {
				term.add(array[i]);
			}
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SparsePolynomial other = (SparsePolynomial) obj;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		return true;
	}

	@Override
	/**
	 * @param degree of interest
	 * @return coefficient of the degree of interest
	 */
	public int degree() {
		// TODO Auto-generated method stub
		int d = 0;
		for(int i = 0; i < term.toArray().length; i++) {
			if(((Term)term.toArray()[i]).getDegree() > d) {
				d = (int)((Term)term.toArray()[i]).getDegree();
			}
		}
		return d;
	}

	@Override
	/**
	 * @return an array of Terms, one for each degree
	 */
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		double e = 0.0;
		for(int i=0; i< this.term.size(); i++) {
			e = e + ((Term)this.term.toArray()[i]).getCoefficient()*Math.pow(x, ((Term)this.term.toArray()[i]).getDegree());
			}
		return e;
	}

	@Override
	/**
	 * @return an array of Terms, one for each degree
	 */
	public Term[] toArray() {
		// TODO Auto-generated method stub
		Term[] t = new Term[this.degree()+1];
		for(int i = 0; i < this.term.size(); i++) {
			t[((Term)this.term.toArray()[i]).getDegree()] = (Term) this.term.toArray()[i];
		}
		
		for(int j=0; j < t.length; j++) {
			if(t[j] == null) {
				Term tt = new Term(0, j);
				t[j] = tt;
			}
		}
		return t;
	}
	
	@Override
	/**
	 * @return a new Polynomial that is the derivative
	 */
	public Polynomial derivative() {
		// TODO Auto-generated method stub
		Term[] tt = new Term[this.degree()+1];
		for(int i=0; i < tt.length; i++) {
			tt[i] = new Term(this.toArray()[i].getCoefficient()*this.toArray()[i].getDegree(), this.toArray()[i].getDegree()-1); 
		}
		Polynomial p1 = new SparsePolynomial(tt);
		return p1;
	}

	@Override
	/**
	 * @param other another Polynomial
	 * @return the sum of this and the other Polynomial
	 */
	public Polynomial sum(Polynomial other) {
		// TODO Auto-generated method stub
		Term[] tt = new Term[101];
		Term[] thist = new Term[101];
		Term[] othert = new Term[101];
			for(int i =0; i < this.toArray().length; i++) {
				thist[i] = this.toArray()[i];
			}
			for(int i = 0; i < 101; i++) {
				if(thist[i] ==null) {
					Term ttt = new Term(0, i);
					thist[i] = ttt;
				}
			}
			
			for(int j =0; j < other.toArray().length; j++) {
				othert[j] = other.toArray()[j];
			}
			for(int i = 0; i < 101; i++) {
				if(othert[i] ==null) {
					Term ttt = new Term(0, i);
					othert[i] = ttt;
				}
			}
		
		for(int i=0; i< 101; i++) {
			double c = thist[i].getCoefficient() + othert[i].getCoefficient();
			tt[i] = new Term(c, i);
		}
		Polynomial p1 = new SparsePolynomial(tt);
		return p1;
	}
	
	/**
	 * This is completed already for you.  Do not change this constructor.
	 * Convenience constructor to create an empty Polynomial.
	 * Calls the primary constructor passing an empty array of Terms.
	 */
	public SparsePolynomial() {
		this(new Term[0]);
	}

	/**
	 * This Polynomial must not be disturbed by this method.
	 * Be sure to return a new Polynomial that is like this one,
	 * but with the extra term included.
	 * @param t the Term to be included in the new Polynomial
	 * @return new Polynomial as described above
	 */
	public Polynomial addTerm(Term t) {
		int d = t.getDegree();
		if(d > this.degree()) {
			Term[] tt = new Term[d+1];
			for(int i=0; i < this.toArray().length; i++) {
				tt[i] = new Term(this.toArray()[i].getCoefficient(), this.toArray()[i].getDegree());
			}
			for(int i = this.toArray().length; i < t.getDegree(); i++) {
				tt[i] = new Term(0, i);
			}
			tt[t.getDegree()] = new Term(t.getCoefficient(), t.getDegree());
			Polynomial p = new SparsePolynomial(tt);
			return p;
		}
		else {
			Term[] tt = new Term[this.toArray().length];
			for(int i=0; i < this.toArray().length; i++) {
				if(this.toArray()[i].getDegree() == t.getDegree()) {
					tt[i] = new Term(this.toArray()[i].getCoefficient() + t.getCoefficient(), this.toArray()[i].getDegree());
				}
				else {
					tt[i] = new Term(t.getCoefficient(), t.getDegree());
				}
			}
			Polynomial p = new SparsePolynomial(tt);
			return p;
		}
	}
	

	/**
	 * This is provided for you.   
	 * Really, no need to thank me.
	 */
	@Override
	public void plot(double lowx, double highx, double incx) {
		//
		// Determine min and max for y values
		//
		double maxy = this.evaluate(lowx);
		double miny = this.evaluate(lowx);
		for (double x=lowx; x < highx; x = x + incx) {
			double y = this.evaluate(x);
			maxy = Math.max(maxy, y);
			miny = Math.min(miny, y);
		}
		StdDraw.setXscale(lowx, highx);
		StdDraw.setYscale(miny, maxy);
		for (double x=lowx; x < highx; x = x + incx) {
			double y = this.evaluate(x);
			StdDraw.point(x, y);
		}
	}

	/**
	 * 	 * Evaluate this Polynomial at the specified value for x
	 * 	 * @param x value of the unknown
	 * @return the sum of all terms evaluated at x
	 */
	@Override
	public double getCoefficientAtDegree(int degree) {
		// TODO Auto-generated method stub
		if(this.degree() < degree) {
			return 0;
		}
		else {
			for(int i =0; i < this.toArray().length; i++) {
				if(this.toArray()[i].getDegree() == degree) {
					return this.toArray()[i].getCoefficient();
				}
			}
			return 0;
		}
	}

}
