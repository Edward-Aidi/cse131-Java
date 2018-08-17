package lab7;
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class First30Percent extends TestCase {

	String s1 = "either your getName() method isn't doing its job or you're not " +
			"setting your instance variables properly"; 
	String s2 = "either your getGPA() method isn't doing its job or you're not " +
			"setting your instance variables properly";
	String s4 = "either your getCredits() method isn't doing its job or you're not " +
			"setting your instance variables properly"; 
	String s5 = "either your getClassStanding() method isn't doing its job or you're not " +
			"setting your instance variables properly";
	String s6 = "The plus method shouldn't change the original vector";
	String s8 = "hasHigherAverage() isn't working properly";
	String s9 = "getClassStanding() isn't working properly";
	@Test
	public void testStudentInit() {
		Student s = new Student("Doug", "Shook", 111111);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getStudentID());
		//No credits, should be a FirstYear, no GPA
		assertEquals(0.0, s.getGPA());
		assertEquals(0, s.getCredits());
		assertEquals("FirstYear", s.getClassStanding());
		for (int i = 0; i < 20; ++i) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			int c = (int)(Math.random() * 5000);
			Student s3 = new Student("" + a, "" + b, c);
			assertEquals(s1, a + " " + b, s3.getName());
			assertEquals(s2, 0.0, s3.getGPA());
			assertEquals(s4, 0, s3.getCredits());
			assertEquals(s5, "FirstYear", s3.getClassStanding());
		}
	}

	@Test
	public void testGetClassStanding() {
		Student s = new Student("D", "S", 1);
		for (int i = 0; i < 29; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(s9, "FirstYear", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(s9, "Sophomore", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(s9, "Junior", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(s9, "Senior", s.getClassStanding());
		}

	}

	@Test
	public void testSubmitGrade() {
		Student s = new Student("D", "S", 1);
		int credits = 0;
		double gpatotal = 0;
		for (int i = 0; i < 100; i++) {
			int c = (int)(Math.random() * 3 + 1);//1 to 3 credits
			double g = Math.random() * 4;//0 to 4
			credits += c;
			gpatotal += g * c;
			s.submitGrade(g, c);
			assertEquals("GPA computed incorrectly", gpatotal / credits, s.getGPA(), 0.01);
			assertTrue("GPA not rounded", (s.getGPA() + "").length() < 6);
		}
	}

	


	@Test
	public void testStudentToString() {
		for (int i = 0; i < 100; i++) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			int c = (int)Math.random() * 500000;
			Student s = new Student("" + a, "" + b, c);
			assertTrue("student toString does not contain entire student name", s.toString().contains("" + a));
			assertTrue("student toString does not contain entire student name", s.toString().contains("" + b));
			assertTrue("student toString does not contain student ID", s.toString().contains("" + c));
		}
	}





	// TESTING COURSE CLASS HERE . . . FEEL FREE TO WRITE YOUR OWN, BUT DON'T CHANGE THIS ONE
	// once again, we are watching you

	


}


