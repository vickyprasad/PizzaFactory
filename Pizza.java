package Test;

public class Pizza {
	private String pizzaName;
	private String pizzaSize;
	private double pizzaPrice;
	
	
	public Pizza(String pizzaName, String pizzaSize, double pizzaPrice) {
		super();
		this.pizzaName = pizzaName;
		this.pizzaSize = pizzaSize;
		this.pizzaPrice = pizzaPrice;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public double getPizzaPrice() {
		return pizzaPrice;
	}
	public void setPizzaPrice(double pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
	
	public String toString() {
		System.out.println("PIZZA NAME  \t SIZE \t PRICE\t");
	return getPizzaName()+"\t"+getPizzaSize()+"\t"+getPizzaPrice();
	}
	
}
