package recitation;

import sedgewick.StdDraw;

public class MouseClicks {

	public static void main(String[] args)
	{
		while(true)
		{
			while(!StdDraw.mousePressed())
			{
				//System.out.println("Mouse not pressed");
			}
			
			while(StdDraw.mousePressed())
			{
				//System.out.println("Mouse is pressed");
			}
			System.out.println("You clicked the mouse");
		}
	}
}
