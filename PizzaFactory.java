package Test;

import java.util.Scanner;

public class PizzaFactory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PizzaService pizzaService = new PizzaService();
		PizzaService.addNewPizzaInventory("VEG", "DELUXE_VEGGIE", "REGULAR", 150);
		PizzaService.addNewPizzaInventory("VEG", "DELUXE_VEGGIE", "MEDIUM", 200);
		PizzaService.addNewPizzaInventory("VEG", "DELUXE_VEGGIE", "LARGE", 325);
		PizzaService.addNewPizzaInventory("VEG", "CHEESE_AND_CORN", "REGULAR", 175);
		PizzaService.addNewPizzaInventory("VEG", "CHEESE_AND_CORN", "MEDIUM", 375);
		PizzaService.addNewPizzaInventory("VEG", "CHEESE_AND_CORN", "LARGE", 475);
		PizzaService.addNewPizzaInventory("VEG", "PANEER_TIKKA", "REGULAR", 160);
		PizzaService.addNewPizzaInventory("VEG", "PANEER_TIKKA", "MEDIUM", 290);
		PizzaService.addNewPizzaInventory("VEG", "PANEER_TIKKA", "LARGE", 340);
		PizzaService.addNewPizzaInventory("NON VEG", "NON_VEG_SUPREME", "REGULAR", 190);
		PizzaService.addNewPizzaInventory("NON VEG", "NON_VEG_SUPREME", "MEDIUM", 325);
		PizzaService.addNewPizzaInventory("NON VEG", "NON_VEG_SUPREME", "LARGE", 425);
		PizzaService.addNewPizzaInventory("NON VEG", "CHICKEN_TIKKA", "REGULAR", 210);
		PizzaService.addNewPizzaInventory("NON VEG", "CHICKEN_TIKKA", "MEDIUM", 370);
		PizzaService.addNewPizzaInventory("NON VEG", "CHICKEN_TIKKA", "LARGE", 500);
		PizzaService.addNewPizzaInventory("NON VEG", "PEPPER_BARBECUE CHICKEN", "REGULAR", 220);
		PizzaService.addNewPizzaInventory("NON VEG", "PEPPER_BARBECUE CHICKEN", "MEDIUM", 380);
		PizzaService.addNewPizzaInventory("NON VEG", "PEPPER_BARBECUE CHICKEN", "LARGE", 525);

		pizzaService.addNewToppings("VEG", "Black_olive", 20, 30);
		pizzaService.addNewToppings("VEG", "Capsicum", 25, 30);
		pizzaService.addNewToppings("VEG", "Paneer", 35, 30);
		pizzaService.addNewToppings("VEG", "Mushroom", 30, 30);
		pizzaService.addNewToppings("VEG", "Fresh_Tomato", 10, 30);
		pizzaService.addNewToppings("VEG", "Extra_cheese", 35, 30);
		pizzaService.addNewToppings("NON VEG", "Chicken_Tikka", 35, 30);
		pizzaService.addNewToppings("NON VEG", "Barbeque_Chicken", 45, 30);
		pizzaService.addNewToppings("NON VEG", "Chicken_Tikka", 40, 30);
		pizzaService.addNewToppings("NON veg", "Extra_cheese", 35, 30);

		pizzaService.addNewSides("Cold_Drink", 55, 30);
		pizzaService.addNewSides("Mousse_Cake", 90, 20);

		try {
			boolean status = true;
			while (status) {
				System.out.println("*********SELECT USER*********");
				System.out.println("1:System Administrator\n2: Customer\n");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					boolean wantToContinue = true;
					while (wantToContinue) {
						System.out.println("**************CHOOSE OPTION*************");
						System.out.println("1: Add New Pizza");
						System.out.println("2: Add New Topping");
						System.out.println("3: Add New Side");
						System.out.println("4: Exit to main Menu\n");
						int mode = sc.nextInt();
						switch (mode) {
						case 1:
							System.out.println("Enter Pizza Type VEG or NON VEG\n");
							String pizzaType = sc.next();

							System.out.println("Enter Pizza Name\n");
							String pizzaName = sc.next();

							System.out.println("Enter Pizza Size REGULAR or MEDIUM or LARGE\n");
							String pizzaSize = sc.next();

							System.out.println("Enter Pizza Price\n");
							double pizzaPirce = sc.nextDouble();

							PizzaService.addNewPizzaInventory(pizzaType, pizzaName, pizzaSize, pizzaPirce);

							break;
						case 2:
							System.out.println("Enter Topping Type\n");
							String toppingType = sc.next();
							System.out.println("Enter Topping Name\n");
							String toppingName = sc.next();
							System.out.println("Enter Topping Price\n");
							double toppingPrice = sc.nextDouble();
							System.out.println("Enter Topping Stock Quantity\n");
							int toppingStockQuantity = sc.nextInt();

							pizzaService.addNewToppings(toppingType, toppingName, toppingPrice, toppingStockQuantity);

							break;
						case 3:
							System.out.println("Enter Side Name\n");
							String sideName = sc.next();
							System.out.println("Enter Side Price\n");
							double sidePrice = sc.nextDouble();
							System.out.println("Enter Side Stock Quantity\n");
							int sideStockQuantity = sc.nextInt();

							pizzaService.addNewSides(sideName, sidePrice, sideStockQuantity);

							break;
						default:
							System.out.println("INVALID OPTION SELECTED");
							wantToContinue = false;
							break;
						}
					}

				case 2:
					boolean wantToContinue1 = true;
					while (wantToContinue1) {
						System.out.println("*******SELECT MODE OF OPERATIONS*********");
						System.out.println("1: View Menu");
						System.out.println("2: Customize Order");
						System.out.println("3: Confirm Details And Place Order\n");

						int mode = sc.nextInt();
						switch (mode) {
						case 1:
							pizzaService.viewVegPizzas();
							pizzaService.viewNonVegPizzas();
							pizzaService.viewVegToppings();
							pizzaService.viewnonVegToppings();
							pizzaService.viewcrust();
							pizzaService.viewSide();
							break;

						case 2:
							System.out.println("SELECT PIZZA CATEGORY\n");
							System.out.println("1: VEG \n 2: NON_VEG");
							int category = sc.nextInt();

							if (category == 1) {

								String toppingName1;
								String toppingName2;
								String side;
								pizzaService.viewVegPizzas();
								System.out.println("Enter Pizza Name\n");
								String pizzaName = sc.next();
								System.out.println("Enter Pizza Quantiy \n");
								int pizzaQty = sc.nextInt();

								pizzaService.viewcrust();
								System.out.println("Select Crust");
								String crust = sc.next();

								pizzaService.viewSize();
								System.out.println("Select Size\n");
								String size = sc.next();

								if (size.equalsIgnoreCase("LARGE")) {
									System.out.println(
											"You Have Selected Large Size Pizza.You can add 2 Extra topping at no extra cost\n ");
									System.out.println("Wanna Add free Extra toppigs\n");
									System.out.println("1: YES\t\t 2: NO");
									int choice2 = sc.nextInt();

									if (choice2 == 1) {
										pizzaService.viewVegToppings();

										System.out.println("Enter Topping 1");
										toppingName1 = sc.next();
										System.out.println("Enter Topping 2");
										toppingName2 = sc.next();

									} else {
										toppingName1 = "";
										toppingName2 = "";
									}
								}

								else {

									System.out.println("Wanna Add Some Extra toppigs You can only one Topping\n");
									System.out.println("1: YES\t\t 2: NO");
									int choice3 = sc.nextInt();
									if (choice3 == 1) {
										pizzaService.viewVegToppings();
										System.out.println("Enter Topping Name");
										toppingName1 = sc.next();
										toppingName2 = "";

									} else {
										toppingName1 = "";
										toppingName2 = "";

									}

								}

								System.out.println(toppingName1 + " " + toppingName2);
								System.out.println("Wanna Add Sides you can Add only one side\n");
								System.out.println("1: YES\t\t 2: NO");
								int choice4 = sc.nextInt();
								if (choice4 == 1) {
									pizzaService.viewSide();
									System.out.println("Enter Side Name");
									side = sc.next();
								} else {
									side = "";
								}

								Order order = new Order("VEG", pizzaName, pizzaQty, size, toppingName1, toppingName2,
										crust, side);
								pizzaService.placeOrder(order);
								PizzaService.calculatBill();

							}

							// NON_VEG PIZZA
							else {
								String toppingName1;
								String toppingName2;
								String side;
								pizzaService.viewNonVegPizzas();
								System.out.println("Enter Pizza Name\n");
								String pizzaName = sc.next();
								System.out.println("Enter Pizza Quantiy \n");
								int pizzaQty = sc.nextInt();

								pizzaService.viewcrust();
								System.out.println("Select Crust");
								String crust = sc.next();

								pizzaService.viewSize();
								System.out.println("Select Size\n");
								String size = sc.next();

								if (size.equalsIgnoreCase("LARGE")) {
									System.out.println(
											"You Have Selected Large Size Pizza.You can add 2 Extra topping at no extra cost\n ");
									System.out.println("Wanna Add free Extra toppigs\n");
									System.out.println("1: YES\t\t 2: NO");
									int choice2 = sc.nextInt();

									if (choice2 == 1) {
										pizzaService.viewnonVegToppings();

										System.out.println("Enter Topping 1");
										toppingName1 = sc.next();
										System.out.println("Enter Topping 2");
										toppingName2 = sc.next();

									} else {
										toppingName1 = "";
										toppingName2 = "";
									}
								}

								else {

									System.out.println("Wanna Add Some Extra toppigs You can only one Topping\n");
									System.out.println("1: YES\t\t 2: NO");
									int choice3 = sc.nextInt();
									if (choice3 == 1) {
										pizzaService.viewnonVegToppings();
										System.out.println("Enter Topping Name");
										toppingName1 = sc.next();
										toppingName2 = "";

									} else {
										toppingName1 = "";
										toppingName2 = "";

									}

								}

								System.out.println(toppingName1 + " " + toppingName2);
								System.out.println("Wanna Add Sides you can Add only one side\n");
								System.out.println("1: YES\t\t 2: NO");
								int choice4 = sc.nextInt();
								if (choice4 == 1) {
									pizzaService.viewSide();
									System.out.println("Enter Side Name");
									side = sc.next();
								} else {
									side = "";
								}

								Order order = new Order("NON_VEG", pizzaName, pizzaQty, size, toppingName1,
										toppingName2, crust, side);
								pizzaService.placeOrder(order);
								PizzaService.calculatBill();

							}

							break;

						case 3:
							System.out.println("Your Order Details \n");
							pizzaService.viewOrder();

							System.out.println("Want To Place Order\n");
							System.out.println("1: YES \n 2: NO");
							int choice1 = sc.nextInt();
							if (choice1 == 1) {
								pizzaService.viewOrder();

							} else {

							}

						default:
							wantToContinue1 = false;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		sc.close();
	}
}
