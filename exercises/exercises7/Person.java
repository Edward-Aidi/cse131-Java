package exercises7;

/**
 * 
 * Identify the parts of this object:
 *      Constructor
 *      Instance variables
 *      Methods
 *         Accessors
 *         Mutators
 *         Other
 *
 */
public class Person {
	
	// instance variables: int height, age
	private int height, age;
	
	// constructor
	public Person(int height) {
		this.height = height;
		this.age    = 0;
	}
	
	
	/**
	 * Mutator
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * "other" -- ages the person by one year
	 */
	public void happyBirthday() {
		this.age = this.age + 1;
	}
	
	/**
	 * acessor 
	 * @return
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 *  accessor
	 * @return
	 */
	public int getAge() {
		return this.age;
	}
	

}
