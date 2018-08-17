 package studio4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class Flag {

	
	public static void main(String[] args) {
		//
		//  Add code for your studio below here.
		//
		// surrounding
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(.006);
		StdDraw.rectangle(.5, .5, .303, .203);
		
		// red flag
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledRectangle(.5, .5, 0.3, 0.2);
		
		//stars
		StdDraw.setPenColor(Color.YELLOW);
		double[] x = {0.24, 0.29, 0.3, 0.31, 0.36, 0.32, 0.336, 0.3, 0.264, 0.28};
		double[] y = {0.62, 0.62, 0.66, .62, .62, .59, .55, .57, .55, .59};
		double[] x1 = {.44, .444, .46, .45, .456, .44, .424, .43, .42, .436};
		double[] y1 = {.58, .564, .564, .56, .544, .55, .544, .56, .564, .564};
		double[] x2 = new double[x1.length];
		double[] y2 = new double[y1.length];
		double[] x3 = new double[x1.length];
		double[] y3 = new double[y1.length];
		double[] x4 = new double[x1.length];
		double[] y4 = new double[y1.length];
		for(int i = 0; i < x1.length; i++) {
			x2[i] = x1[i];
			y2[i] = y1[i] + 0.06;
			x3[i] = x1[i] - 0.04;
			y3[i] = y1[i] + 0.1;
			x4[i] = x1[i] - 0.04;
			y4[i] = y1[i] - 0.04;
		}
		StdDraw.filledPolygon(x, y);
		StdDraw.filledPolygon(x1, y1);
		StdDraw.filledPolygon(x2, y2);
		StdDraw.filledPolygon(x3, y3);
		StdDraw.filledPolygon(x4, y4);
		// text
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.25, 0.65, "China");
		StdDraw.pause(1000);
		StdDraw.text(0.35, 0.6, "China");
		StdDraw.pause(1000);
		StdDraw.text(0.5, 0.5, "China");
		StdDraw.pause(1000);
		StdDraw.text(0.65, 0.4, "China");
		StdDraw.pause(1000);
		StdDraw.text(0.75, 0.35, "China");
		
		//National Anthem
    	ArgsProcessor.useStdInput("music");

        // repeat as long as there are more integers to read in
        while (!StdIn.isEmpty()) {

            // read in the pitch, where 0 = Concert A (A4)
            int pitch = StdIn.readInt();

            // read in duration in seconds
            double duration = StdIn.readDouble();

            // build sine wave with desired frequency
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int N = (int) (StdAudio.SAMPLE_RATE * duration);
            double[] a = new double[N+1];
            for (int i = 0; i <= N; i++) {
                a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            }

            // play it using standard audio
            StdAudio.play(a);
        }
	}

}
