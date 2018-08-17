package lab7;

public class Course {

	private String name;
	private int credit;
	private int remainingSeats;
	private Student[] roaster;
	
	/**
	 * Course Contractor
	 * @param String name
	 * @param int credit
	 * @param int remainingSeats
	 */
	public Course(String name, int credit, int remainingSeats) {
		super();
		this.name = name;
		this.credit = credit;
		this.remainingSeats = remainingSeats;
		this.roaster = new Student[remainingSeats];
	}
	
	public String getName() {
		return name;
	}

	public int getCredit() {
		return credit;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	/**
	 * 
	 * @param s
	 * @return boolean
	 */
	public boolean addStudent(Student s) {
		int k = 0;
		for(int i=0; i < roaster.length; i++) {
		// first we have to check whether roaster[i] is null or not and also compare the whether they have the same name
			if(roaster[i] != null && s.getName().equals(roaster[i].getName()))
			k = k + 1;
		}
		// if the student is already in this class, return false
		if(k > 0) {
			return false;
		}
		// if the student is not in the class, then check whether the class has space for the student to enroll
		else {
			if(this.remainingSeats == 0) {
				return false;
			}
			else {
				roaster[this.remainingSeats - 1] = s;
				this.remainingSeats = this.remainingSeats - 1;
				return true;
			}
		}
	}
	
	/**
	 * 
	 * @return double average gpa
	 */
	public double averageGPA() {
		double[] g = new double[roaster.length];
		double sum = 0;
		int j = 0;
		for(int i = 0; i < roaster.length; i++) {
			if(roaster[i] != null) {
				g[i] = roaster[i].getGPA();
				sum = sum + g[i];
				j = j + 1;
			}
		}
		return sum / (double)j;
	}
	
	/**
	 * to String
	 * @return String Name and Credit combined
	 */
	public String toString() {
		return this.name + this.credit;
	}
	
}
