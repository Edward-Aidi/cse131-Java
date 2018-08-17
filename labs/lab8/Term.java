package lab8;

/**
 * Represent an as-yet unevaluated term of a polynomial.
 * A term has-a
 *      coefficient, which is a double
 *      degree, which is an int
 *      
 * Examples:
 * Given the term  3.27 x squared
 *   its coefficient is 3.27
 *   its degree      is 2
 *   
 * Given the term 131
 *    its coefficient is 131.0
 *    its degree      is 0
 * 
 * @author yournamehere
 *
 */

public class Term {
	private final double coefficient;
	private final int degree;
	
	public Term(double coeff, int degree) {
		super();
		this.coefficient = coeff;
		this.degree = degree;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coefficient);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + degree;
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
		Term other = (Term) obj;
		if (Double.doubleToLongBits(coefficient) != Double.doubleToLongBits(other.coefficient))
			return false;
		if (degree != other.degree)
			return false;
		return true;
	}



	public double getCoefficient() {
		return coefficient;
	}



	public int getDegree() {
		return degree;
	}



	@Override
	public String toString() {
		return "Term [" + coefficient + "*x^" + degree + "]";
	}



	public double evaluateTermAtX(double x){
		return this.coefficient * Math.pow(x, this.degree);
	}
	
	
}