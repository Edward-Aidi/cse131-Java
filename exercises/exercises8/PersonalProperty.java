package exercises8;

public class PersonalProperty implements Valuable {

	private final int initialValue;
	private final int yearsOld;
	
	
	
	public PersonalProperty(int initialValue, int yearsOld) {
		super();
		this.initialValue = initialValue;
		this.yearsOld = yearsOld;
	}

	public int depreciatedValue() {
		return (int) (this.initialValue * 0.8 *this.yearsOld);
	}

	
	@Override
	public String toString() {
		return "PersonalProperty [initialValue=" + initialValue + ", yearsOld=" + yearsOld + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLiquidValue() {
		return this.depreciatedValue();
	}

}
