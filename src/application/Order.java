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

	public Order(int orderID, List<Coffee> coffeeOrder) {
		this.orderID = orderID;
		this.coffeeOrder = coffeeOrder;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public List<Coffee> getCoffeeOrder() {
		return coffeeOrder;
	}

	public void setCoffeeOrder(List<Coffee> coffeeOrder) {
		this.coffeeOrder = coffeeOrder;
	}

}
