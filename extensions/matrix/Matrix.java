package matrix;


public class Matrix {
	
	private double[][] values;
		
	/**
	 * The Matrix is based on the supplied two-dimensional array of values.
	 * Be sure to make your own copy of the values, so that changes to the
	 *    array outside of this class do not affect your work.
	 * @param values
	 */
	public Matrix(double[][] in) {
		double[][] copy = new double[in.length][in[0].length];
		for(int i = 0; i < copy.length; i++) {
			for(int j = 0; j < copy[0].length; j++) {
				copy[i][j] = in[i][j];
			}
		}
		values = copy;  // FIXME -- make a copy of in
		                //  this is not the same thing as writing:
		                //  values = in
	}
	
	public double getValue(int row, int col) {
		return this.values[row][col];  // Do not change this!
	}
	
	public int getNumRows() {
		return values.length;  // Do not change!
	}
	
	public int getNumCols() {
		return values[0].length; // Do not change!
	}
	
	/**
	 * You must complete this method, or the equals(Object) test will always
	 *   return false. 
	 * Arrays one and two are considered
	 * equal if and only if:
	 *   1) They have the same shape (number of rows and columns agree)
	 *   2) The contents of the two arrays are the same, element by element
	 * @param one
	 * @param two
	 * @return true iff the arrays have the same shape and contents
	 */
	private static boolean arraysAreEqual(double[][] one, double[][] two) {
		int c = 0;
		if(one.length == two.length && one[0].length == two[0].length) {
			for(int i = 0; i < one.length; i++) {
				for(int j = 0; j < one[0].length; j++) {
					if(one[i][j] != two[i][j]) {
						c = c + 1;
					}
				}
			}
			if(c == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		else{
			return false; // FIXME
		}
	}
	
	/**
	 * This was generated initially by eclipse, but
	 *   eclipse does not know how to compare two-dimensional arrays.
	 *   We therefore call arraysAreEequal to do that job.
	 */
	public boolean equals(Object obj) {
		// If this and obj are the same object, they must be equal
		if (this == obj)
			return true;
		// If obj is null ("this" cannot be null), then they are not equal
		if (obj == null)
			return false;
		// If the two objects are not the same type, they are not equal
		if (getClass() != obj.getClass())
			return false;
		//
		// If we get here, we have two objects of the same type.
		// Calling your helper method to determine the arrays' equality.
		Matrix other = (Matrix) obj;
		return arraysAreEqual(this.values, other.values);
	}
	
	/**
	 * 
	 * @param Matrix other
	 * @return a Matrix that equeals this add Matrix other
	 */
	public Matrix plus(Matrix other) {
		double[][] p = new double[this.getNumRows()][this.getNumCols()];
		if(this.getNumCols() == other.getNumCols() && this.getNumRows() == other.getNumRows()) {
			for(int i = 0; i < this.getNumRows(); i++) {
				for(int j = 0; j < this.getNumCols(); j++) {
					p[i][j] = this.getValue(i, j) + other.getValue(i, j);
				}
			}
			Matrix plus = new Matrix(p);
			return plus;
		}
		else{
			throw new IllegalArgumentException("Invalid Input"); // FIXME
		}
	}
	
	/**
	 * Returns a **new Matrix** that is the product of this and the other one.
	 * Does not change this Matrix at all.
	 * @param other
	 * @return
	 */
	public Matrix times(Matrix other) {
		double[][] p = new double[this.getNumRows()][other.getNumCols()];
		if(this.getNumCols() == other.getNumRows()) {
			for(int i = 0; i < this.getNumRows(); i++) {
				for(int j = 0; j < other.getNumCols(); j++) {
					for(int h = 0; h < this.getNumCols(); h++) {
						p[i][j] = p[i][j] + this.getValue(i, h) * other.getValue(h, j);
					}
				}
			}
			Matrix times = new Matrix(p);
			return times;
		}
		else{
			throw new IllegalArgumentException("Invalid Input"); // FIXME
		}
	}
	
	/**
	 * Returns a **new Matrix** that is the transpose of this one.
	 * Does not change this Matrix at all.
	 * @return
	 */
	public Matrix transpose() {
		double[][] p = new double[this.getNumCols()][this.getNumRows()];
		for(int i = 0; i < this.getNumRows(); i++) {
			for(int j = 0; j < this.getNumCols(); j++) {
				p[j][i] = this.getValue(i, j);
			}		
		}
		Matrix t = new Matrix(p);
		return t; // FIXME
	}

	/**
	 * Modifies this Matrix by scaling row i by the supplied factor.
	 * @param i the row to scale, where 0 is the top row
	 * @param factor the amount by which to scale each element of row i
	 */
	public void scaleRow(int i, double factor) {
		if(i < this.getNumRows()) {
			for(int j = 0; j < this.getNumRows(); j++) {
				for(int h = 0; h < this.getNumCols(); h++) {
					if(j == i) {
						this.values[j][h] = this.getValue(j, h)*factor;
					}
				}
			}
		}
		else {
			throw new IllegalArgumentException("Invalid Input");
		}
		// FIXME
	}

	/**
	 * Modifies this matrix by adding row i to row j.  Row 0 is the top row.
	 * @param i
	 * @param j
	 */
	public void addRows(int i, int j) {
		for(int h = 0; h < this.getNumRows(); h++) {
			for(int k = 0; k < this.getNumCols(); k++) {
				if(h == j) {
					this.values[h][k] = this.values[h][k] + this.values[i][k];
				}
			}
		}
		// FIXME
		
	}
	
	/**
	 * Modifies the Matrix by exchanging row i with row j
	 * @param i
	 * @param j
	 */
	public void exchangeRows(int i, int j){
		double p = 0.0;
		for(int h = 0; h < this.getNumRows(); h++) {
			for(int k = 0; k < this.getNumCols(); k++) {
				if(h == j) {
					p = this.values[i][k];
					this.values[i][k] = this.values[h][k];
					this.values[h][k] = p;
				}
			}
		}
		// FIXME
	}

	/**
	 * My gift to you.  This returns a String representation of
	 * the Matrix.  The contents of each row is separated by a tab (\t)
	 * so that columns (kind of) line up.  Each row is separated by a
	 * newline (\n) so that the output looks like a matrix.  The output
	 * of this method should <i>not</i> be used to compare matrices for
	 * equality:  use the .equals(Object) method instead!
	 */
	public String toString() {
		String ans = "";
		for (int i=0; i < values.length; ++i) {
			ans = ans + "\n";
			// Loop below assumes all rows have the same number of columns
			for (int j=0; j < values[0].length; ++j) {
				ans = ans + values[i][j] + "\t";
			}
		}
		return ans;
	}

}
