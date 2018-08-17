package lab7;

public class Student {

	private String firstName;
	private String lastName;
	private int studentID;
	private int credits;
	private double gpa;
	private String classStanding;
	
	/**
	 * 
	 * Student Constructor
	 * @param String firstName
	 * @param String lastName
	 * @param int studentID
	 */
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.credits = 0;
		this.gpa = 0.0;
		this.classStanding = "FirstYear";
	}

	// Generate a new constructor to deal with bb inside the constructor
	/**
	 * 
	 * new constructor for babystudent
	 * @param Student a
	 * @param Student bb
	 */
	public Student(Student a, Student bb) {
		this.firstName = a.getName();
		this.lastName = bb.getName();
		this.gpa = (a.gpa + bb.gpa) / 2.0;
		this.studentID = a.studentID + bb.studentID;
		this.credits = Math.max(a.getCredits(), bb.getCredits());
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public int getStudentID() {
		return this.studentID;
	}

	public int getCredits() {
		return this.credits;
	}
	
	public double getGPA() {
		return this.gpa;
	}
	
	public String getClassStanding() {
		if(this.credits < 30) {
			return "FirstYear";
		}
		else if(this.credits >= 30 && this.credits < 60) {
			return "Sophomore";
		}
		else if(this.credits >= 60 && this.credits < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}

	public void submitGrade(double grade, int credits) {
		double quality = grade * credits;
		this.gpa = (this.gpa * this.credits + quality) / (double)(this.credits + credits);
		this.credits = this.credits + credits;
		this.gpa = Math.round(this.gpa * 1000.0) / 1000.0; 
	}
	
	/**
	 * CreateLegacy
	 * @param Student otherParent
	 * @return Student bb
	 */
	public Student createLegacy(Student otherParent) {
		Student bb = new Student(this, otherParent); // Using this to call new constructor
		return bb;
	}
	
	/**
	 * 
	 * @return String Student name and ID combined
	 */
	public String toString() {
		return this.firstName + " " + this.lastName + this.studentID;
	}
	
}
