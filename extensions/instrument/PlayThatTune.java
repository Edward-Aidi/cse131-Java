package instrument;
import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.*;
/*************************************************************************
 *  Compilation:  javac PlayThatTune.java
 *  Execution:    java PlayThatTune < input.txt
 *  Dependencies: StdAudio.java StdAudio.java
 *
 *  This is a data-driven program that plays pure tones from
 *  the notes on the chromatic scale, specified on standard input
 *  by their distance from concert A.
 *
 *  % java PlayThatTune < elise.txt
 *
 *
 *  Data files
 *  ----------
 *  http://www.cs.princeton.edu/introcs/21function/elise.txt
 *  http://www.cs.princeton.edu/introcs/21function/99luftballons.txt
 *  http://www.cs.princeton.edu/introcs/21function/freebird.txt
 *  http://www.cs.princeton.edu/introcs/21function/Ascale.txt
 *  http://www.cs.princeton.edu/introcs/21function/National_Anthem.txt
 *  http://www.cs.princeton.edu/introcs/21function/looney.txt
 *  http://www.cs.princeton.edu/introcs/21function/StairwayToHeaven.txt
 *  http://www.cs.princeton.edu/introcs/21function/entertainer.txt
 *  http://www.cs.princeton.edu/introcs/21function/old-nassau.txt
 *  http://www.cs.princeton.edu/introcs/21function/arabesque.txt
 *  http://www.cs.princeton.edu/introcs/21function/firstcut.txt 
 *  http://www.cs.princeton.edu/introcs/21function/tomsdiner.txt
 *
 *************************************************************************/

public class PlayThatTune {

    public static void main(String[] args) {
        
    	ArgsProcessor.useStdInput("music");
    	// Extension - Create an Instrument
        ArgsProcessor ap = new ArgsProcessor(args);
        int f = ap.nextInt("How many frequency factors you wish to use?");
        int[] numerator = new int[f];
        int[] denominator = new int[f];
        double[] strength = new double[f];
        double[] frefactor = new double[f];
        for(int i = 0; i < f; i++) {
        		numerator[i] = ap.nextInt("What numerator would you like to input?");
        }
        for(int i = 0; i < f; i++) {
        		denominator[i] = ap.nextInt("What is the denominator?");
        }
        for(int i = 0; i < f; i++) {
        		strength[i] = ap.nextDouble("What is the relative strength?");
        }
        for(int i = 0; i < f; i++) {
        		frefactor[i] = (double)numerator[i] / (double)denominator[i];
        		System.out.println(frefactor[i]);
        }
        

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
                for(int j = 0; j < f; j++) {
                		a[i] = a[i] + strength[j] * Math.sin(2 * Math.PI * i * frefactor[j] * hz / StdAudio.SAMPLE_RATE);
                }
            }

            // play it using standard audio
            StdAudio.play(a);
        }
    		
        // sound wave drawing
		    	StdDraw.setXscale(0, 2*Math.PI);
		    StdDraw.setYscale(-2, 2);
		for(int i = 0; i < f; i++) {
	        for (double t = 0.0; t < 2 * Math.PI; t += 0.05) {
	            double y = 0.0;
	            StdDraw.setPenColor(Color.BLACK);
	            StdDraw.setPenRadius(0.006);
	            	y = strength[i] * Math.sin(t * frefactor[i]);
	            	StdDraw.point(t, y);
	        }
		}
		for (double t = 0.0; t < 2 * Math.PI; t += 0.005) {
			double y = 0.0;
			double s = 0.0;
			for(int i = 0; i < f; i++) {
				y = strength[i] * Math.sin(t * frefactor[i]);
				s = s + y;
			}
			StdDraw.setPenColor(Color.RED);
			StdDraw.setPenRadius(0.004);
			StdDraw.point(t, s);
			
		}
    }
}
