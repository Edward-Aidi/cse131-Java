package exercises4;

import sedgewick.StdDraw;

public class WaitPoint {

	public static void main(String[] args) {
		// wait for the mouse to be pressed and released
		
		// here, the mouse has been pressed
		while(!StdDraw.mousePressed()) {
			StdDraw.pause(1000);
			System.out.println("Please press the mouse!");
		}
		// here the mouse is released
		while(StdDraw.mousePressed()) {
			StdDraw.pause(1000);
			System.out.println("Please release the mouse!");
		}
		
		// draw a point at the location of the mouse
		while(!StdDraw.hasNextKeyTyped()) {
			StdDraw.pause(1000);
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			StdDraw.setPenRadius(0.05);
			StdDraw.point(x, y);
			System.out.println("You may try to enter a 'q'.");
		}
		
		// here, a q has been typed

			char key = ' ';
			while(key != 'q') {
				while(!StdDraw.hasNextKeyTyped()) {
				StdDraw.pause(1000);
				}
				key = StdDraw.nextKeyTyped();
				if(key != 'q') {
					System.out.println("You entered " + key + ", but I expected a 'q'.");
				}
			}
			
				StdDraw.text(0.5, 0.5, "Farewell!");

	}

}
