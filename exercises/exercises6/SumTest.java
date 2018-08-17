package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

import roundtables.Sum;

public class SumTest {

	@Test
	public void test() {
		assertEquals(0,  Sum.sum(0));
		assertEquals(3, Sum.sum(2));
		assertEquals(55, Sum.sum(10));
	}

}
