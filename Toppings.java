package Test;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Toppings {
	Map<String,Double>vegToppings=new LinkedHashMap<>();
	Map<String,Double>nonVegToppings=new LinkedHashMap<>();
	Map<String ,Integer> vegToppingStock=new LinkedHashMap<>();
	Map<String ,Integer> nonVegToppingStock=new LinkedHashMap<>();
	void addNewToppings(String toppingsType,String toppingName,double toppingPrice,int toppingStockQty);
	void viewVegToppings();
	void viewnonVegToppings();
	
	
}
