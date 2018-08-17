package exercises7;

public class Orange {
	
	// Orange has a weight -double
	// Orange has a price($/pound) - double
	// Orange has a color- String
	
	// instance variables double weight, price
	private double weight;
	private double price;
	private String color;
	
	// constructor
	public Orange(double weight, double price, String color) {
		super();
		this.weight = weight;
		this.price = price;
		this.color = color;
	}

	/**
	 * acessor 
	 * @return price
	 */
	public double OPrice(double weight, double price) {
		return this.weight * this.price;
	}
	
	public String goodO(String color) {
		if(this.color != "Orange") {
			return "FALSE";
		}
		else {
			return "TRUE";
		}
	}
	
}
