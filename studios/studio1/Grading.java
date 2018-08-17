package studio1;

import cse131.ArgsProcessor;

public class Grading {

	public static void main(String[] args) {
		// This program aims to tracking your final score for your CSE131.
		// First, you should input all the scores that you have got.
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		// Name
		String name = ap.nextString("Please enter your name before your socres:");
		
		// The number of participation points you received
		int participation = ap.nextInt("The number of participation points...");
		// Your average quiz score
		int quiz = ap.nextInt("Your average quiz score...");
		// The number of studio points you received
		int studio = ap.nextInt("The number of studio points...");
		// The number of lab points you received
		int lab = ap.nextInt("The number of lab points...");
		// The number of extension points you received
		int extension = ap.nextInt("The number of extension points...");
		// Your score on exam one
		int ex1 = ap.nextInt("Your score on exam one...");
		// Your score on exam two
		int ex2 = ap.nextInt("Your score on exam two...");
		// Your score on exam three
		int ex3 = ap.nextInt("Your score on exam three...");
		// Your final project score
		int finalpro = ap.nextInt("Your final project socre...");
		
		// Component				|	Weight
		// Quizzes				|	3%
		// Studios				|	7%
		// Labs					|	25%
		// Final Project			|	7%
		// Extensions			|	25%
		// Best 3 out of 4 Exams	|	30%
		// Participation			|	3%
		double fingrade = (double)quiz * 0.03 + (double)studio * 0.07 + (double)lab *0.25 
				+ (double)finalpro * 0.07 + (double)extension * 0.25 
				+ 0.1 * ((double)ex1 + (double)ex2 +(double)ex3) + (double)participation * 0.03;
		int grade = (int) (fingrade % 101);
		
		// Score		GradeOption		Pass/Fail Option
		// 93		A				Pass
		// 90		A-
		// 87		B+
		// 83		B
		// 80		B-
		// 77		C+
		// 73		C
		// 70		C-
		// 60		D				Fail
		// 0			F
		
		// boolean plus = (grade > 73 && grade < 77) || (grade > 83 && grade < 90);
		// boolean minus = (grade < 93 && grade >87) || (grade < 83 && grade > 80) ||(grade > 70 && grade < 73);
		
		boolean plus = (grade % 10 > 3) && (grade % 10 < 7);
		boolean minus = (grade % 10 < 3) && (grade % 10 > 0) || (grade % 10 > 7);
		
		char credit;
		if (grade >= 90) {
            credit = 'A';} 
		else if (grade >= 80) {
            credit = 'B';}
		else if (grade >= 70) {
            credit = 'C';}
		else if (grade >= 60) {
            credit = 'D';}
		else {
            credit = 'F';}
		
		System.out.println(name + ":\n" + "\t Total score: " 
		+ fingrade + "\n\t Grdae for this course: " + grade + "\n\t Final grade has a " + credit 
		+ "\n\t\t Plus: " + plus + "\n\t\t Minus: " + minus);
	}

}
