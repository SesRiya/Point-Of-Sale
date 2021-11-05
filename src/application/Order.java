package application;

import java.util.List;

/**
 * Class that contains the List of coffees per order and the order id per
 * transaction
 * 
 * @author POS group
 *
 */
public class Order {

	private int orderID;
	private List<Coffee> coffeeOrder;

	/**
	 * shows the order which employee entered in
	 * @param orderID order id
	 * @param coffeeOrder order of coffee
	 */
	public Order(int orderID, List<Coffee> coffeeOrder) {
		this.orderID = orderID;
		this.coffeeOrder = coffeeOrder;
	}

	/**
	 * 
	 * @return orders ID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * 
	 * @param orderID order id
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * 
	 * @return coffee orders
	 */
	public List<Coffee> getCoffeeOrder() {
		return coffeeOrder;
	}

	/**
	 * set coffee order
	 * @param coffeeOrder order of coffee
	 */
	public void setCoffeeOrder(List<Coffee> coffeeOrder) {
		this.coffeeOrder = coffeeOrder;
	}

}
