package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PizzaService implements Toppings, Sides {
	static List<Pizza> vegPizza = new ArrayList<>();
	static List<Pizza> nonVegPizza = new ArrayList<>();
	static List<Order> orderList = new ArrayList<>();

	public static void addNewPizzaInventory(String pizzaType, String pizzaName, String pizzaSize, double pizzaPrice) {
		Pizza pizza = new Pizza(pizzaName, pizzaSize, pizzaPrice);
		if (pizzaType.equalsIgnoreCase("VEG")) {
			vegPizza.add(pizza);
		} else {
			nonVegPizza.add(pizza);
		}

	}

	public void viewVegPizzas() {
		System.out.println("************VEG PIZZA************* \n\n");
		System.out.println("PIZZA NAME \t\t\t SIZE \t\t PRICE");
		for (Pizza p : vegPizza) {
			System.out.println(p.getPizzaName() + "\t\t\t" + p.getPizzaSize() + "\t\t" + p.getPizzaPrice());
		}
		System.out.println("\n");
	}

	public void viewNonVegPizzas() {
		System.out.println("***********NON-VEG PIZZA*********** \n\n");
		System.out.println("PIZZA NAME \t\t\t SIZE \t\t PRICE");
		for (Pizza p : nonVegPizza) {
			System.out.println(p.getPizzaName() + "\t\t\t" + p.getPizzaSize() + "\t\t" + p.getPizzaPrice());
		}
		System.out.println("\n");
	}

	@Override
	public void addNewSides(String sideName, double sidePrice, int sideStockQty) {
		sidesSet.put(sideName, sidePrice);
		sidesStocks.put(sideName, sideStockQty);

	}

	@Override
	public void viewSide() {
		System.out.println("**********SIDES************");
		Set<Map.Entry<String, Double>> entries = sidesSet.entrySet();
		for (Map.Entry<String, Double> e : entries) {
			System.out.println(e.getKey() + "\t" + e.getValue());
		}
	}

	@Override
	public void addNewToppings(String toppingsType, String toppingName, double toppingPrice, int toppingStockQty) {

		if (toppingsType.equalsIgnoreCase("VEG")) {
			vegToppings.put(toppingName, toppingPrice);
			vegToppingStock.put(toppingName, toppingStockQty);
		} else {
			nonVegToppings.put(toppingName, toppingPrice);
			nonVegToppingStock.put(toppingName, toppingStockQty);
		}

	}

	@Override
	public void viewVegToppings() {
		System.out.println("**********VEG-TOPPING************");
		Set<Map.Entry<String, Double>> vegEntries = vegToppings.entrySet();
		for (Map.Entry<String, Double> e : vegEntries) {
			System.out.println(e.getKey() + "\t" + e.getValue());
		}
	}

	@Override
	public void viewnonVegToppings() {
		System.out.println("**********NON-VEG-TOPPING************");
		Set<Map.Entry<String, Double>> nonVegEntries = nonVegToppings.entrySet();
		for (Map.Entry<String, Double> e : nonVegEntries) {
			System.out.println(e.getKey() + "\t" + e.getValue());
		}

	}

	public void viewcrust() {
		System.out.println("***********Crusts**************");
		Crust[] data = Crust.values();
		for (Crust c : data) {
			System.out.println(c);
		}
	}

	public void viewSize() {
		PizzaSize[] data = PizzaSize.values();
		for (PizzaSize s : data) {
			System.out.println(s);
		}
	}

	static double totalBill;

	public static void calculatBill() {

		for (Order o : orderList) {
			if (o.getType().equalsIgnoreCase("VEG")) {
				for (Pizza p : vegPizza) {
					if (o.getPizzaName().equalsIgnoreCase(p.getPizzaName())
							&& o.getSize().equalsIgnoreCase(p.getPizzaSize())) {
						// pizza price with Quantity done
						if (o.getTopping1().isBlank() && o.getSides().isBlank()) {
							totalBill = p.getPizzaPrice() * o.getQty();
						}
						// Pizza Price With Side done
						else if (o.getTopping1().isBlank()) {
							Set<Map.Entry<String, Integer>> sideStockEntries = sidesStocks.entrySet();
							for (Map.Entry<String, Integer> side : sideStockEntries) {
								if (side.getKey().equalsIgnoreCase(o.getSides())) {
									if (side.getValue() >= 1) {
										Set<Map.Entry<String, Double>> sidePriceEntries = sidesSet.entrySet();
										for (Map.Entry<String, Double> sidePrice : sidePriceEntries) {
											if (sidePrice.getKey().equalsIgnoreCase(o.getTopping1())) {
												totalBill = p.getPizzaPrice() * o.getQty() + sidePrice.getValue();

											}

										}
									}
								}

							}

						}
						// Pizza Price With extra topping
						else if (o.getSides().isBlank()) {
							Set<Map.Entry<String, Integer>> vegToppingStockEntries = vegToppingStock.entrySet();
							for (Map.Entry<String, Integer> stock : vegToppingStockEntries) {
								if (stock.getKey().equalsIgnoreCase(o.getTopping1())) {
									if (stock.getValue() >= 1) {

										Set<Map.Entry<String, Double>> vegToppingsEntries = vegToppings.entrySet();
										for (Map.Entry<String, Double> veg : vegToppingsEntries) {
											if (veg.getKey().equalsIgnoreCase(o.getTopping1())
													&& p.getPizzaSize().equalsIgnoreCase("LARGE")) {

												totalBill = p.getPizzaPrice() * o.getQty();
											} else if (veg.getKey().equalsIgnoreCase(o.getTopping1())) {

												totalBill = p.getPizzaPrice() * o.getQty() + veg.getValue();
											}
										}
									}
								}
							}
						}
						// Pizza Price With Side and extra topping
						else {

							Set<Map.Entry<String, Integer>> vegToppingStockEntries = vegToppingStock.entrySet();
							for (Map.Entry<String, Integer> stock : vegToppingStockEntries) {
								if (stock.getKey().equalsIgnoreCase(o.getTopping1())) {
									if (stock.getValue() >= 1) {
										Set<Map.Entry<String, Double>> vegToppingsEntries = vegToppings.entrySet();
										for (Map.Entry<String, Double> veg : vegToppingsEntries) {
											if (veg.getKey().equalsIgnoreCase(o.getTopping1())) {

												Set<Map.Entry<String, Integer>> sideStockEntries = sidesStocks
														.entrySet();
												for (Map.Entry<String, Integer> side : sideStockEntries) {
													if (side.getKey().equalsIgnoreCase(o.getSides())) {
														Set<Map.Entry<String, Double>> sidePriceEntries = sidesSet
																.entrySet();

														for (Map.Entry<String, Double> sidePrice : sidePriceEntries) {
															if (sidePrice.getKey().equalsIgnoreCase(o.getSides())
																	&& p.getPizzaSize().equalsIgnoreCase("LARGE")) {
																totalBill = p.getPizzaPrice() * o.getQty()
																		+ sidePrice.getValue();

															} else if (sidePrice.getKey()
																	.equalsIgnoreCase(o.getSides())) {
																totalBill = p.getPizzaPrice() * o.getQty()
																		+ veg.getValue() + sidePrice.getValue();
															}
														}
													}

												}
											}

										}
									}

									else {
										System.out.println("Sorry Not In Stock");
									}
								}
							}
						}

					}
				}
			} else if (o.getType().equalsIgnoreCase("NON_VEG")) {
				for (Pizza p : nonVegPizza) {
					if (o.getPizzaName().equalsIgnoreCase(p.getPizzaName())
							&& o.getSize().equalsIgnoreCase(p.getPizzaSize())) {
						// pizza price with Quantity done
						if (o.getTopping1().isBlank() && o.getSides().isBlank()) {
							totalBill = p.getPizzaPrice() * o.getQty();
						}
						// Pizza Price With Side done
						else if (o.getTopping1().isBlank()) {
							Set<Map.Entry<String, Integer>> sideStockEntries = sidesStocks.entrySet();
							for (Map.Entry<String, Integer> side : sideStockEntries) {
								if (side.getKey().equalsIgnoreCase(o.getSides())) {
									if (side.getValue() >= 1) {
										Set<Map.Entry<String, Double>> sidePriceEntries = sidesSet.entrySet();
										for (Map.Entry<String, Double> sidePrice : sidePriceEntries) {
											if (sidePrice.getKey().equalsIgnoreCase(o.getTopping1())) {
												totalBill = p.getPizzaPrice() * o.getQty() + sidePrice.getValue();

											}

										}
									}
								}

							}

						}
						// Pizza Price With extra topping
						else if (o.getSides().isBlank()) {
							Set<Map.Entry<String, Integer>> nonVegToppingStockEntries = nonVegToppingStock.entrySet();
							for (Map.Entry<String, Integer> stock : nonVegToppingStockEntries) {
								if (stock.getKey().equalsIgnoreCase(o.getTopping1())) {
									if (stock.getValue() >= 1) {

										Set<Map.Entry<String, Double>> nonVegToppingsEntries = nonVegToppings
												.entrySet();
										for (Map.Entry<String, Double> nonVeg : nonVegToppingsEntries) {
											if (nonVeg.getKey().equalsIgnoreCase(o.getTopping1())
													&& p.getPizzaSize().equalsIgnoreCase("LARGE")) {

												totalBill = p.getPizzaPrice() * o.getQty();
											} else if (nonVeg.getKey().equalsIgnoreCase(o.getTopping1())) {

												totalBill = p.getPizzaPrice() * o.getQty() + nonVeg.getValue();
											}
										}
									}
								}
							}
						}
						// Pizza Price With Side and extra topping
						else {

							Set<Map.Entry<String, Integer>> nonVegToppingStockEntries = nonVegToppingStock.entrySet();
							for (Map.Entry<String, Integer> stock : nonVegToppingStockEntries) {
								if (stock.getKey().equalsIgnoreCase(o.getTopping1())) {
									if (stock.getValue() >= 1) {
										Set<Map.Entry<String, Double>> nonVegToppingsEntries = nonVegToppings
												.entrySet();
										for (Map.Entry<String, Double> nonVeg : nonVegToppingsEntries) {
											if (nonVeg.getKey().equalsIgnoreCase(o.getTopping1())) {

												Set<Map.Entry<String, Integer>> sideStockEntries = sidesStocks
														.entrySet();
												for (Map.Entry<String, Integer> side : sideStockEntries) {
													if (side.getKey().equalsIgnoreCase(o.getSides())) {
														Set<Map.Entry<String, Double>> sidePriceEntries = sidesSet
																.entrySet();

														for (Map.Entry<String, Double> sidePrice : sidePriceEntries) {
															if (sidePrice.getKey().equalsIgnoreCase(o.getSides())
																	&& p.getPizzaSize().equalsIgnoreCase("LARGE")) {
																totalBill = p.getPizzaPrice() * o.getQty()
																		+ sidePrice.getValue();

															} else if (sidePrice.getKey()
																	.equalsIgnoreCase(o.getSides())) {
																totalBill = p.getPizzaPrice() * o.getQty()
																		+ nonVeg.getValue() + sidePrice.getValue();
															}
														}
													}

												}
											}

										}
									}

									else {
										System.out.println("Sorry Not In Stock");
									}
								}
							}
						}

					}
				}
			}

		}

	}

	public void viewOrder() {

		System.out.println("TYPE \t PIZZA NAME \t QUANTITY \t CRUST \t EXTRA TOPPINGS\t\t \t SIDES \tprice ");
		for (Order o : orderList) {
			System.out.println(o.getType() + "\t" + o.getPizzaName() + "\t" + o.getQty() + "\t" + o.getCrust() + "\t"
					+ o.getTopping1() + "  " + o.getTopping2() + "\t" + o.getSides() + "\t" + PizzaService.totalBill);
		}
	}

	public void placeOrder(Order order) {
		if (orderList.isEmpty()) {
			orderList.add(order);
		} else {
			orderList.removeAll(orderList);
			orderList.add(order);
		}

	}

}
