package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void test() {
//		assertEquals(0, Add.add(0, 0));
//		//
//		// write other test cases here:
//		//
//		assertEquals(1, Add.add(1, 0));
//		assertEquals(1, Add.add(-5, 6));
//		assertEquals(5, Add.add(2, 3));
		assertEquals(5, Add.addAny(7, -2));
		assertEquals(-3, Add.addAny(-1, -2));
	}

}
