package chords.music;

import book.ch1.Sample;
import sedgewick.StdAudio;

/**
 * Represent a double[] samples array.
 * A Samples object has-a double[] array of samples, which it hides and does not expose except through
 *    the methods defined below.
 * @author roncytron
 *
 */

public class Samples {
	
	private double[] sample;
	
	/**
	 * Capture the specified samples in our local array, so that they are safe from modification
	 * @param samples
	 */
	public Samples(double[] samples) {
		this.sample = new double[samples.length];
		for(int i = 0; i < samples.length; i++) {
			this.sample[i] = samples[i];
		}
	}
	
	/**
	 * Construct samples of the specified length, all zero.
	 * @param length
	 */
	public Samples(int length) {
		this.sample = new double[length];
 	}
	
	/**
	 * Concatenate this and the other sample, returning a NEW samples object, and leaving the two inputs unchanged
	 * @param other
	 * @return the concatenation of these samples with the other samples
	 */
	public Samples concat(Samples other) {
		double[] c = new double[this.sample.length + other.sample.length];
		for(int i = 0; i < this.sample.length; i++) {
			c[i] = this.sample[i];	
		}
		for(int i = this.sample.length; i < this.sample.length+other.sample.length; i++){
			c[i] = other.sample[i-this.sample.length];
		}
		Samples s = new Samples(c);
		return s; // FIXME
	}
	
	/**
	 * Combine this and the other samples, padding by 0 if necessary, returning a NEW samples object, and leaving the two inputs unchanged
	 * @param other
	 * @return the numerical addition of these and the other samples, padded by 0 where necessary
	 */
	public Samples combine(Samples other) {
		if(this.sample.length > other.sample.length){
			double[] c = new double[this.sample.length];
			for(int i = 0; i < other.sample.length; i++) {
				c[i] = this.sample[i] + other.sample[i];	
			}
			for(int i = other.sample.length; i < this.sample.length; i++){
				c[i] = this.sample[i];
			}
			Samples s = new Samples(c);
			return s;
		}
		else{
			double[] c = new double[other.sample.length];
			for(int i = 0; i < this.sample.length; i++) {
				c[i] = this.sample[i] + other.sample[i];	
			}
			for(int i = this.sample.length; i < other.sample.length; i++){
				c[i] = other.sample[i];
			}
			Samples s = new Samples(c);
			return s;
		}
		  // FIXME
	}
	
	/**
	 * 
	 * @return the number of samples
	 */
	
	public int getNumSamples() {
		return sample.length; // FIXME
	}
	
	/**
	 * Play these samples, by calling StdAudio.play(..) passing in the double array of samples
	 */
	public void play() {
		// FIXME
		StdAudio.play(sample);;
	}
	
	public String toString() {
		return "Samples with " + this.getNumSamples() + " values";
	}

	/**
	 * Accessor to return a particular sample
	 * @param i the sample to be returned, with 0 as the first sample
	 * @return the specified sample value
	 */
	public double getSample(int i) {
		return this.sample[i];  // FIXME
	}
	
	/**
	 * Valid only for a positive number of samples, this method returns the maximum value of all samples
	 * @return the maximum value
	 */
	public double getMax() {
		double max = 0.0;
		for(int i = 0; i < sample.length; i++){
			if(max < sample[i]){
				max = sample[i];
			}
		}
		return max;  // FIXME
	}
	
	/**
	 * Valid only for a positive number of samples, this method returns the minimum value of all samples
	 * @return the minimum value
	 */
	public double getMin() {
		double min = 0.0;
		for(int i = 0; i < sample.length; i++){
			if(min > sample[i]){
				min = sample[i];
			}
		}
		return min;  // FIXME
	}

}
