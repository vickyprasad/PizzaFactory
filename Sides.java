package Test;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Sides {
	Map<String ,Double> sidesSet=new LinkedHashMap<>();
	Map<String ,Integer> sidesStocks=new LinkedHashMap<>();
	void addNewSides(String sideName,double sidePrice, int sideStock);
	void viewSide();
}
