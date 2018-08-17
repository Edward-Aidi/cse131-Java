package roundtables;

import java.util.HashSet;
import java.util.Set;

public class Point {
	private int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
	public boolean equals(Point other) {
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Set<Point> points = new HashSet<Point>();
		points.add(new Point(1,2));
		points.add(new Point(1,2));
		System.out.println(points);
	}

}
