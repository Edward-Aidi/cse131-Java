package lab6;

import java.awt.Color;

import sedgewick.StdDraw;

public class Triangles {
	
	/**
	 * drawing recursive triangles
	 * @param llx lower-left-hand corner x coordinate
	 * @param lly lower-left-hand corner y coordinate 
	 * @param double size, size length and height of the current square
	 */
	public static void triangles(double llx, double lly, double size) {
		if(size < .001) {
			return;
		}
		StdDraw.line(llx, lly, llx + size/2.0,lly + Math.sqrt(3)*size/2.0);
		StdDraw.line(llx, lly, llx + size, lly);
		StdDraw.line(llx + size/2.0,lly +  Math.sqrt(3)*size/2.0, llx + size, lly);
		
		StdDraw.pause(0);
		triangles(llx, lly, size/2.0);
		triangles(llx + size/4.0, lly + Math.sqrt(3)*size/4.0, size/2.0);
		triangles(llx + size/2.0, lly, size/2.0);
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdDraw.setPenColor(Color.black);
		// 
		// Once you get things working, you an uncomment the two
		//   calls below to StdDraw.show
		//   and that will speed up what you see greatly
		//
		//StdDraw.show(10);  // don't show anything
		triangles(0, 0, 1);
		//StdDraw.show(10);  // until now
	}

}
