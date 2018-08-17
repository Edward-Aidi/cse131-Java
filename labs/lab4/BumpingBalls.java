package lab4;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;

public class BumpingBalls {
	
	public static void main(String[] args) {
	 	ArgsProcessor ap = new ArgsProcessor(args);
    	int pause = ap.nextInt("Enter pause time:");
    	int ballnum = ap.nextInt("Enter ball number:");
    	
        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);

        // initial values
        double[] rx = new double[ballnum];
        for(int i = 0; i < ballnum; i++) {
        		rx[i] = Math.random();
        }
        	double[] ry = new double[ballnum]; 
            for(int i = 0; i < ballnum; i++) {
        		ry[i] = Math.random();
        }
        	// position
            
        double[] vx = new double[ballnum]; 
        for(int i = 0; i < ballnum; i++) {
    		vx[i] = Math.random() / 30.0;
        }
        	double[] vy = new double[ballnum];
        for(int i = 0; i < ballnum; i++) {
        	vy[i] = Math.random() / 30.0;
         }
        	// velocity
        
        double radius = 0.05;              // radius

        // main animation loop
        while (true)  { 

            // bounce off wall according to law of elastic collision
            for(int i = 0; i < ballnum; i++) {	                
	                // bounce off another ball
	    	       for(int j = 0; j < ballnum; j++) {
	    	    	   if(j > i) {
	    	    		   if (Math.sqrt(Math.pow((rx[i] + vx[i]- rx[j] - vx[j]), 2) - Math.pow((ry[i] + vy[i] - ry[j] - vy[j]), 2)) < (radius + 0.009) * 2) {
		    		             vx[j] = -vx[j];
		    		             vy[j] = -vy[j];
		    		            }
	    	    	   }
	    	    	   
	    	       }
	        		if (Math.abs(rx[i] + vx[i]) > 1.0 - radius) {
	                	vx[i] = -vx[i];
	                	StdAudio.play("sound/BonkCrsh.wav");
	                }
	             if (Math.abs(ry[i] + vy[i]) > 1.0 - radius) {
	                	vy[i] = -vy[i];
	                	StdAudio.play("sound/elaugh.wav");
	              	}
	             // update position
	                rx[i] = rx[i] + vx[i]; 
	                ry[i] = ry[i] + vy[i]; 
	       }
            
            // clear the background
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0, 0, 1.0);

            // draw ball on the screen
            // StdDraw.setPenColor(StdDraw.BLACK); 
            // StdDraw.filledCircle(rx[], ry[], radius); 
            for(int i = 0; i < ballnum; i++) {
                StdDraw.picture(rx[i], ry[i], "images/smileyface.gif");
            }

            // display and pause for ms
            StdDraw.show(pause); 
        } 
	}

}
