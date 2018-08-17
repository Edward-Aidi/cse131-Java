package exercises8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Point {
	
	//
	// has-a x and y coordinate, both integers
	//  these are immutable so you should declare them "final"
	//
	// declare instance variables here:
	//
	private final int x, y;
	
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// if two objects .equal each other, their hashCodes must be the same
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) // obj and this are same object
			return true; // obj is null
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			// obj is not the same type as this
			return false;
		Point other = (Point) obj;
		// same type!
		if (x != other.x)
		// do they agree on x and y?
			return false;
		if (y != other.y)
			return false;
		// same type, same values, so yes they are equal
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public static void main(String[] args) {
		List<Point> pl = new LinkedList<Point>();
		pl.add(new Point(1, 2));
		pl.add(new Point(1, 2));
		pl.add(new Point(2, 2));
		
		System.out.println(pl);
		System.out.println();
		
		Set<Point> ps = new HashSet<Point>();
		ps.add(new Point(1, 2));
		ps.add(new Point(1, 2));
		ps.add(new Point(2, 2));
		
		System.out.println(ps);
		
	}

}
