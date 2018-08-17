package exercises8;

import java.util.HashSet;
import java.util.Set;

public class Stockholding implements Valuable{
	private final String code;
	private final String owner;
	private int numshares;
	private double ps; // price per share
	public Stockholding(String code, String owner, double ps) {
		super();
		this.code = code;
		this.owner = owner;
		this.ps = ps;
	}
	
	public int getCurrentValue() {
		return (int) (this.getNumshares() * this.getPs());
	}
	
	@Override
	public String toString() {
		return "Stockholding [code=" + code + ", owner=" + owner + ", shares=" + numshares + ", ps=" + ps + "]";
	}
	
	// hashCode and .equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stockholding other = (Stockholding) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	
	
	public String getCode() {
		return code;
	}
	public String getOwner() {
		return owner;
	}
	public int getNumshares() {
		return numshares;
	}
	public double getPs() {
		return ps;
	}
	
	
	public void setNumshares(int numshares) {
		this.numshares = numshares;
	}
	public void setPs(double ps) {
		this.ps = ps;
	}
	public static void main(String[] args) {
		Set<Stockholding> sh = new HashSet<Stockholding>();
		Stockholding s1 = new Stockholding("IBM", "Ron", 10);
		s1.setNumshares(100);
		sh.add(s1);
		s1.setNumshares(200);
		sh.add(s1);
		System.out.println(sh);
	}

	@Override
	public int getLiquidValue() {
		return this.getCurrentValue();
	}
	
}
