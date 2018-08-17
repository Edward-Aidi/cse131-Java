package lab9.testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import lab9.Guess;

public class TestGuess {
	
	@Test
	public void testInit() {
		for (int i=0; i < 100; ++i) {
			Guess g = Support.genRandomGuess();
		}
	}
	
	@Test
	public void testSize() {
		for (int i=0; i< 100; ++i) {
			int[] arr = Support.genRandomArray();
			Guess g = new Guess(arr);
			assertEquals("size() not implemented correctly", arr.length, g.size());
		}
	}
	
	@Test
	public void testGet() {
		for (int i=0; i < 100; ++i) {
			int[] arr = Support.genRandomArray();
			Guess g = new Guess(arr);
			for (int j=0; j < arr.length; ++j) {
				assertEquals("getChoice("+j+") not working", arr[j], g.getChoice(j));
			}
		}
	}
	
	@Test
	public void testHashCodeEquals() {
		
		for (int i=0; i < 100; ++i) {
			int[] arr1 = Support.genRandomArray();
			Guess g1 = new Guess(arr1);
			Guess g2 = new Guess(Support.dup(arr1));
			assertEquals("Bad hashcode for " + g1 + " and " + g2,g1.hashCode(),g2.hashCode());
			assertTrue("You must implement hashCode and equals in Guess", g1.equals(g2));
		}
		
	}
	
	@Test
	public void testToString() {
		for (int j=0; j < 100; ++j) {
			int[] arr = Support.genRandomArray();
			Guess g   = new Guess(arr);
			for (int i=0; i < arr.length; ++i) {
				assertTrue("You must implement toString to show the integers", g.toString().contains(""+arr[i]));
			}
			
		}
	}
	
}
