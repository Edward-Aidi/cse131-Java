package memorymatch;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.Test;

public class MemoryMatchTest {

	@Test
	public void testGenBoard() {
		Color[][] b1 = MemoryMatch.genBoard();
		Color[][] b2 = MemoryMatch.genBoard();
		assertEquals("Try again. If the distribution is random, these shouldn't be the same very often.", false, b1.equals(b2));
		Color[] linear = new Color[16];
		Color[] used = new Color[8];
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				linear[(i*4)+j] = b1[i][j];			
			}			
		}
		int n = 0;
		for (int i = 0; i < 16; i++){
			if (linear[i] != null){
				for (Color c : used){
					assertEquals("You can only have 2 of any color.", false, linear[i].equals(c));
				}
				for (int j = 0; j < 16; j++){
					if (linear[i].equals(linear[j]) && i != j){
						used[n] = linear[i];
						linear[i] = null;
						linear[j] = null;
						j = 16;
						n++;
					}
				}	
			}
		}
		for (int i = 0; i < 16; i++){
			assertEquals("some colors had no match.", null, linear[i]);
		}
		
	}
	
	public static void simClick(int x, int y) throws AWTException{
	    Robot bot = new Robot();
	    bot.mouseMove(x, y);    
	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
//	@Test
//	public void testClick() {
//		MemoryMatch.playGame();
//		StdDraw.pause(100);
//		try {
//			simClick(300, 300);
//			simClick(300, 300);
//		} catch (AWTException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	

}