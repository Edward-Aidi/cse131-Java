package studio7;

// A rectangle has a length and a width. 
// A rectangle should be able to provide its area and perimeter. 
// A rectangle can indicate whether it is smaller than another rectangle in terms of area. 
// A rectnagle can indicate whether it is in fact a square.

public class Rectangle {
	private int len;
	private int wid;
	
	public Rectangle() {
		super();
		this.len = 5;
		this.wid = 6;
	}
	
	public int area() {
		return this.len * this.wid;
	}
	
	public int perimeter() {
		return 2*(this.len + this.wid);
	}
	
	public boolean small(int len, int wid) {
		int area = len * wid;
		if(area > this.len * this.wid) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean square() {
		if (this.len == this.wid) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Rectangle rec = new Rectangle();
		System.out.println(rec.area());
		System.out.println(rec.perimeter());
		System.out.println(rec.small(2, 3));
		System.out.println(rec.square());
	}
}
