package application;

import java.util.List;

public class Order {

	private int orderID;
	private List<Coffee> coffeeOrder;

	public Order(int orderID, List<Coffee> coffeeOrder) {
		super();
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
