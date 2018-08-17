package blts;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Point {
	
	// has-a x and y coordinate, both integer
	private final int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// if two objects .equal each other, their
	//   hashCodes must be the same
	@Override
	public int hashCode() {
		// random result does not work, breaks contract
		// return (int)(Math.random()*10000);
		// return 0;  does work!
		// return x + y;  (3,4) and (4,3) same value!
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // obj and this are same object
			return true;
		if (obj == null) // obj is null
			return false;
		if (getClass() != obj.getClass())
			// obj is not the same type as this
			return false;
		// same type!
		Point other = (Point) obj;
		// do they agree on x and y?
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		// same type, same values, so yes they are equal
		return true;
	}



	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static void main(String[] args) {
		List<Point> list = new LinkedList<Point>();
		list.add(new Point(131, 132));
		list.add(new Point(131, 132));
		list.add(new Point(0,0));
		System.out.println("List has " + list);
		boolean has = list.contains(new Point(0,0));
		System.out.println("Does it have pt? " + has);

	}


	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	

}
