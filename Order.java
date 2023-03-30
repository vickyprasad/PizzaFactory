package Test;

public class Order {
	private String pizzaName;
	private int qty;

	private String crust;
	private String sides;
	private String size;
	private String type;
	private String topping1;
	private String topping2;
	
	public Order(String type,String pizzaName, int qty,String size,String topping1,String topping2, String crust, String sides) {
		super();
		this.pizzaName = pizzaName;
		this.qty = qty;
		this.topping1=topping1;
		this.topping2=topping2;
		this.crust = crust;
		this.sides = sides;
		this.size=size;
		this.type=type;
	}
	public String getTopping1() {
		return topping1;
	}
	public void setTopping1(String topping1) {
		this.topping1 = topping1;
	}
	public String getTopping2() {
		return topping2;
	}
	public void setTopping2(String topping2) {
		this.topping2 = topping2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	public String getSides() {
		return sides;
	}
	public void setSides(String sides) {
		this.sides = sides;
	}
	
}
